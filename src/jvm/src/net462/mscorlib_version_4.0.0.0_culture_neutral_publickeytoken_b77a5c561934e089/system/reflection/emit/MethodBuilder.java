/*
 *  MIT License
 *
 *  Copyright (c) 2023 MASES s.r.l.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

/**************************************************************************************
 * <auto-generated>
 *      This code was generated from a template using JCOReflector
 * 
 *      Manual changes to this file may cause unexpected behavior in your application.
 *      Manual changes to this file will be overwritten if the code is regenerated.
 * </auto-generated>
 *************************************************************************************/

package system.reflection.emit;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.reflection.MethodInfo;
import system.reflection.BindingFlags;
import system.reflection.Binder;
import system.globalization.CultureInfo;
import system.reflection.emit.GenericTypeParameterBuilder;
import system.reflection.emit.ILGenerator;
import system.reflection.emit.MethodToken;
import system.reflection.emit.ParameterBuilder;
import system.reflection.ParameterAttributes;
import system.reflection.MethodImplAttributes;
import system.reflection.Module;
import system.reflection.ParameterInfo;
import system.security.permissions.SecurityAction;
import system.security.PermissionSet;
import system.reflection.ConstructorInfo;
import system.reflection.emit.CustomAttributeBuilder;
import system.reflection.emit.UnmanagedMarshal;
import system.Guid;
import system.UInt32;
import system.reflection.CallingConventions;
import system.reflection.ICustomAttributeProvider;
import system.reflection.ICustomAttributeProviderImplementation;
import system.reflection.MethodAttributes;
import system.RuntimeMethodHandle;


/**
 * The base .NET class managing System.Reflection.Emit.MethodBuilder, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.Emit.MethodBuilder" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Reflection.Emit.MethodBuilder</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class MethodBuilder extends MethodInfo  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Reflection.Emit.MethodBuilder
     */
    public static final String className = "System.Reflection.Emit.MethodBuilder";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            String classToCreate = className + ", "
                    + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Creating %s", classToCreate);
            JCType typeCreated = bridge.GetType(classToCreate);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Created: %s",
                        (typeCreated != null) ? typeCreated.toString() : "Returned null value");
            return typeCreated;
        } catch (JCException e) {
            JCOReflector.writeLog(e);
            return null;
        }
    }

    void addReference(String ref) throws Throwable {
        try {
            bridge.AddReference(ref);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }
    /**
     * Internal constructor. Use with caution 
     */
    public MethodBuilder(java.lang.Object instance) throws Throwable {
        super(instance);
        if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new Exception("Cannot manage object, it is not a JCObject");
    }

    public String getJCOAssemblyName() {
        return assemblyFullName;
    }

    public String getJCOClassName() {
        return className;
    }

    public String getJCOObjectName() {
        return className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    public java.lang.Object getJCOInstance() {
        return classInstance;
    }

    public void setJCOInstance(JCObject instance) {
        classInstance = instance;
        super.setJCOInstance(classInstance);
    }

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link MethodBuilder}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link MethodBuilder} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static MethodBuilder cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new MethodBuilder(from.getJCOInstance());
    }

    // Constructors section
    
    public MethodBuilder() throws Throwable {
    }



    
    // Methods section
    
    public boolean IsDefined(NetType attributeType, boolean inherit) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsDefined", attributeType == null ? null : attributeType.getJCOInstance(), inherit);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject Invoke(NetObject obj, BindingFlags invokeAttr, Binder binder, NetObject[] parameters, CultureInfo culture) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objInvoke = (JCObject)classInstance.Invoke("Invoke", obj == null ? null : obj.getJCOInstance(), invokeAttr == null ? null : invokeAttr.getJCOInstance(), binder == null ? null : binder.getJCOInstance(), toObjectFromArray(parameters), culture == null ? null : culture.getJCOInstance());
            return new NetObject(objInvoke);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject[] GetCustomAttributes(boolean inherit) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetObject> resultingArrayList = new ArrayList<NetObject>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetCustomAttributes", inherit);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetObject(resultingObject));
            }
            NetObject[] resultingArray = new NetObject[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject[] GetCustomAttributes(NetType attributeType, boolean inherit) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetObject> resultingArrayList = new ArrayList<NetObject>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetCustomAttributes", attributeType == null ? null : attributeType.getJCOInstance(), inherit);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetObject(resultingObject));
            }
            NetObject[] resultingArray = new NetObject[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public GenericTypeParameterBuilder[] DefineGenericParameters(java.lang.String... names) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<GenericTypeParameterBuilder> resultingArrayList = new ArrayList<GenericTypeParameterBuilder>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("DefineGenericParameters", (java.lang.Object)names);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new GenericTypeParameterBuilder(resultingObject));
            }
            GenericTypeParameterBuilder[] resultingArray = new GenericTypeParameterBuilder[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public GenericTypeParameterBuilder[] DefineGenericParameters(JCORefOut dupParam0) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<GenericTypeParameterBuilder> resultingArrayList = new ArrayList<GenericTypeParameterBuilder>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("DefineGenericParameters", (java.lang.Object)dupParam0.getJCRefOut());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new GenericTypeParameterBuilder(resultingObject));
            }
            GenericTypeParameterBuilder[] resultingArray = new GenericTypeParameterBuilder[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ILGenerator GetILGenerator() throws Throwable, system.InvalidOperationException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetILGenerator = (JCObject)classInstance.Invoke("GetILGenerator");
            return new ILGenerator(objGetILGenerator);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ILGenerator GetILGenerator(int size) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetILGenerator = (JCObject)classInstance.Invoke("GetILGenerator", size);
            return new ILGenerator(objGetILGenerator);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public MethodToken GetToken() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetToken = (JCObject)classInstance.Invoke("GetToken");
            return new MethodToken(objGetToken);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ParameterBuilder DefineParameter(int position, ParameterAttributes attributes, java.lang.String strParamName) throws Throwable, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDefineParameter = (JCObject)classInstance.Invoke("DefineParameter", position, attributes == null ? null : attributes.getJCOInstance(), strParamName);
            return new ParameterBuilder(objDefineParameter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public MethodImplAttributes GetMethodImplementationFlags() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetMethodImplementationFlags = (JCObject)classInstance.Invoke("GetMethodImplementationFlags");
            return new MethodImplAttributes(objGetMethodImplementationFlags);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public MethodInfo GetBaseDefinition() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetBaseDefinition = (JCObject)classInstance.Invoke("GetBaseDefinition");
            return new MethodInfo(objGetBaseDefinition);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public MethodInfo GetGenericMethodDefinition() throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetGenericMethodDefinition = (JCObject)classInstance.Invoke("GetGenericMethodDefinition");
            return new MethodInfo(objGetGenericMethodDefinition);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public MethodInfo MakeGenericMethod(NetType... typeArguments) throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objMakeGenericMethod = (JCObject)classInstance.Invoke("MakeGenericMethod", (java.lang.Object)toObjectFromArray(typeArguments));
            return new MethodInfo(objMakeGenericMethod);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Module GetModule() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetModule = (JCObject)classInstance.Invoke("GetModule");
            return new Module(objGetModule);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ParameterInfo[] GetParameters() throws Throwable, system.NotSupportedException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ParameterInfo> resultingArrayList = new ArrayList<ParameterInfo>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetParameters");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ParameterInfo(resultingObject));
            }
            ParameterInfo[] resultingArray = new ParameterInfo[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetType[] GetGenericArguments() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetType> resultingArrayList = new ArrayList<NetType>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetGenericArguments");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetType(resultingObject));
            }
            NetType[] resultingArray = new NetType[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddDeclarativeSecurity(SecurityAction action, PermissionSet pset) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.NotSupportedException, system.NullReferenceException, system.security.SecurityException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddDeclarativeSecurity", action == null ? null : action.getJCOInstance(), pset == null ? null : pset.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CreateMethodBody(byte[] il, int count) throws Throwable, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CreateMethodBody", il, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CreateMethodBody(JCORefOut dupParam0, int dupParam1) throws Throwable, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CreateMethodBody", dupParam0.getJCRefOut(), dupParam1);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetCustomAttribute(ConstructorInfo con, byte[] binaryAttribute) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetCustomAttribute", con == null ? null : con.getJCOInstance(), binaryAttribute);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetCustomAttribute(ConstructorInfo dupParam0, JCORefOut dupParam1) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetCustomAttribute", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetCustomAttribute(CustomAttributeBuilder customBuilder) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetCustomAttribute", customBuilder == null ? null : customBuilder.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetImplementationFlags(MethodImplAttributes attributes) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetImplementationFlags", attributes == null ? null : attributes.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetMarshal(UnmanagedMarshal unmanagedMarshal) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.NotSupportedException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetMarshal", unmanagedMarshal == null ? null : unmanagedMarshal.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetParameters(NetType... parameterTypes) throws Throwable, system.NotImplementedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetParameters", (java.lang.Object)toObjectFromArray(parameterTypes));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetReturnType(NetType returnType) throws Throwable, system.NotImplementedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetReturnType", returnType == null ? null : returnType.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSymCustomAttribute(java.lang.String name, byte[] data) throws Throwable, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSymCustomAttribute", name, data);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSymCustomAttribute(java.lang.String dupParam0, JCORefOut dupParam1) throws Throwable, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSymCustomAttribute", dupParam0, dupParam1.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static To_MethodBuilder method available in _MethodBuilder to obtain an object with an invocable method
     */
    @Deprecated 
    public void GetTypeInfoCount(JCORefOut<UInt32> pcTInfo) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use To_MethodBuilder to obtain the full interface.");
    }


    
    // Properties section
    
    public boolean getInitLocals() throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("InitLocals");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInitLocals(boolean InitLocals) throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InitLocals", InitLocals);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSignature() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Signature");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}