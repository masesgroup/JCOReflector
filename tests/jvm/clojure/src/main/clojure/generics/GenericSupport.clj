;;  MIT License
;;
;;  Copyright (c) 2020-2026 MASES s.r.l.
;;
;;  Permission is hereby granted, free of charge, to any person obtaining a copy
;;  of this software and associated documentation files (the "Software"), to deal
;;  in the Software without restriction, including without limitation the rights
;;  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
;;  copies of the Software, and to permit persons to whom the Software is
;;  furnished to do so, subject to the following conditions:
;;
;;  The above copyright notice and this permission notice shall be included in all
;;  copies or substantial portions of the Software.
;;
;;  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
;;  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
;;  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
;;  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
;;  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
;;  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
;;  SOFTWARE.

(ns generics.GenericSupport
  "Clojure cannot declare `new List_1<T>() {}`: proxy and gen-class do not write the generic
  Signature attribute of the superclass, which is what JCOReflector reads to learn the type
  arguments. This namespace generates, at runtime, the same kind of class javac produces for
  an anonymous generic subclass: a public no-arg subclass whose Signature is
  Super<TypeArg1, ...>. Methods named in `impls` are overridden and forwarded to Clojure fns."
  (:import [clojure.asm ClassWriter Opcodes Type]
           [clojure.lang DynamicClassLoader]
           [java.lang.reflect Method Modifier]))

(def ^:private cache (atom {}))
(def ^:private counter (atom 0))

(defn- internal-name ^String [^Class c]
  (.replace (.getName c) \. \/))

(defn- class-signature ^String [^Class super type-args]
  (str "L" (internal-name super)
       "<" (apply str (map #(str "L" (internal-name %) ";") type-args)) ">;"))

(defn- find-method
  "The overridable method called method-name in the superclass hierarchy."
  ^Method [^Class super ^String method-name]
  (let [candidates (->> (take-while some? (iterate #(.getSuperclass ^Class %) super))
                        (mapcat #(.getDeclaredMethods ^Class %))
                        (filter (fn [^Method m]
                                  (and (= method-name (.getName m))
                                       (not (Modifier/isStatic (.getModifiers m)))
                                       (not (Modifier/isFinal (.getModifiers m)))
                                       (or (Modifier/isPublic (.getModifiers m))
                                           (Modifier/isProtected (.getModifiers m)))))))
        real (remove (fn [^Method m] (or (.isBridge m) (.isSynthetic m))) candidates)]
    (or (first real) (first candidates)
        (throw (IllegalArgumentException.
                (str "No overridable method " method-name " in " (.getName super)))))))

(def ^:private box-owner
  {Type/BOOLEAN "java/lang/Boolean", Type/CHAR "java/lang/Character", Type/BYTE "java/lang/Byte",
   Type/SHORT "java/lang/Short", Type/INT "java/lang/Integer", Type/FLOAT "java/lang/Float",
   Type/LONG "java/lang/Long", Type/DOUBLE "java/lang/Double"})

(def ^:private number-method
  {Type/BYTE "byteValue", Type/SHORT "shortValue", Type/INT "intValue",
   Type/FLOAT "floatValue", Type/LONG "longValue", Type/DOUBLE "doubleValue"})

(defn- push-int [^clojure.asm.MethodVisitor mv n]
  (if (<= 0 n 5)
    (.visitInsn mv (+ Opcodes/ICONST_0 n))
    (.visitIntInsn mv Opcodes/BIPUSH n)))

(defn- emit-override [^ClassWriter cw ^String cname ^String method-name ^Method m]
  (let [arg-types (Type/getArgumentTypes m)
        ret (Type/getReturnType m)
        mv (.visitMethod cw Opcodes/ACC_PUBLIC method-name (Type/getMethodDescriptor m) nil nil)]
    (.visitCode mv)
    (.visitVarInsn mv Opcodes/ALOAD 0)
    (.visitFieldInsn mv Opcodes/GETFIELD cname "impl" "Lclojure/lang/IFn;")
    (.visitLdcInsn mv method-name)
    (push-int mv (count arg-types))
    (.visitTypeInsn mv Opcodes/ANEWARRAY "java/lang/Object")
    (loop [i 0 slot 1]
      (when (< i (count arg-types))
        (let [^Type t (nth arg-types i)
              sort (.getSort t)]
          (.visitInsn mv Opcodes/DUP)
          (push-int mv i)
          (.visitVarInsn mv (.getOpcode t Opcodes/ILOAD) slot)
          (when-let [owner (box-owner sort)]
            (.visitMethodInsn mv Opcodes/INVOKESTATIC owner "valueOf"
                              (str "(" (.getDescriptor t) ")L" owner ";") false))
          (.visitInsn mv Opcodes/AASTORE)
          (recur (inc i) (+ slot (.getSize t))))))
    (.visitMethodInsn mv Opcodes/INVOKEINTERFACE "clojure/lang/IFn" "invoke"
                      "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;" true)
    (let [sort (.getSort ret)]
      (cond
        (= sort Type/VOID)
        (do (.visitInsn mv Opcodes/POP)
            (.visitInsn mv Opcodes/RETURN))

        (or (= sort Type/BOOLEAN) (= sort Type/CHAR))
        (let [owner (box-owner sort)]
          (.visitTypeInsn mv Opcodes/CHECKCAST owner)
          (.visitMethodInsn mv Opcodes/INVOKEVIRTUAL owner
                            (if (= sort Type/BOOLEAN) "booleanValue" "charValue")
                            (str "()" (.getDescriptor ret)) false)
          (.visitInsn mv (.getOpcode ret Opcodes/IRETURN)))

        (number-method sort)
        (do (.visitTypeInsn mv Opcodes/CHECKCAST "java/lang/Number")
            (.visitMethodInsn mv Opcodes/INVOKEVIRTUAL "java/lang/Number" (number-method sort)
                              (str "()" (.getDescriptor ret)) false)
            (.visitInsn mv (.getOpcode ret Opcodes/IRETURN)))

        :else
        (do (when-not (= "java/lang/Object" (.getInternalName ret))
              (.visitTypeInsn mv Opcodes/CHECKCAST (.getInternalName ret)))
            (.visitInsn mv Opcodes/ARETURN))))
    (.visitMaxs mv 0 0)
    (.visitEnd mv)))

(defn- generate-class [^Class super type-args ^String cname method-names]
  (let [cw (ClassWriter. ClassWriter/COMPUTE_MAXS)]
    (.visit cw Opcodes/V1_8 (+ Opcodes/ACC_PUBLIC Opcodes/ACC_SUPER) cname
            (class-signature super type-args) (internal-name super) nil)
    (.visitEnd (.visitField cw Opcodes/ACC_PUBLIC "impl" "Lclojure/lang/IFn;" nil nil))
    (let [mv (.visitMethod cw Opcodes/ACC_PUBLIC "<init>" "()V" nil nil)]
      (.visitCode mv)
      (.visitVarInsn mv Opcodes/ALOAD 0)
      (.visitMethodInsn mv Opcodes/INVOKESPECIAL (internal-name super) "<init>" "()V" false)
      (.visitInsn mv Opcodes/RETURN)
      (.visitMaxs mv 0 0)
      (.visitEnd mv))
    (doseq [mname method-names]
      (emit-override cw cname mname (find-method super mname)))
    (.visitEnd cw)
    (.toByteArray cw)))

(defn- generic-class ^Class [^Class super type-args method-names]
  (let [k [super (vec type-args) (vec (sort method-names))]]
    (or (get @cache k)
        (let [cname (str "generics/support/Gen" (swap! counter inc))
              bytes (generate-class super type-args cname method-names)
              loader (DynamicClassLoader. (.getClassLoader super))
              cls (.defineClass loader (.replace cname \/ \.) bytes nil)]
          (swap! cache assoc k cls)
          cls))))

(defn new-generic
  "Creates an instance of an anonymous-like subclass of super parameterized with type-args
  (a vector of classes). impls maps a method name to the fn that implements it, e.g.
  {\"Invoke\" (fn [x y] 0)}; the fn receives the (boxed) arguments of the method."
  ([super type-args] (new-generic super type-args {}))
  ([^Class super type-args impls]
   (let [cls (generic-class super type-args (keys impls))
         obj (.newInstance (.getConstructor cls (into-array Class [])) (object-array 0))]
     (.set (.getField cls "impl") obj
           (fn [method-name args] (apply (get impls method-name) args)))
     obj)))
