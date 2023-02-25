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

package system.windows.media;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.ValueType;
import system.windows.media.Matrix;
import system.IFormatProvider;
import system.IFormatProviderImplementation;
import system.windows.Point;
import system.windows.Vector;
import system.IFormattable;
import system.IFormattableImplementation;


/**
 * The base .NET class managing System.Windows.Media.Matrix, WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.Matrix" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.Matrix</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class Matrix extends ValueType implements system.IFormattable {
    /**
     * Fully assembly qualified name: WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: WindowsBase
     */
    public static final String assemblyShortName = "WindowsBase";
    /**
     * Qualified class name: System.Windows.Media.Matrix
     */
    public static final String className = "System.Windows.Media.Matrix";
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
    public Matrix(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Matrix}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Matrix} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Matrix cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Matrix(from.getJCOInstance());
    }

    // Constructors section
    
    public Matrix() throws Throwable {
    }

    public Matrix(double m11, double m12, double m21, double m22, double offsetX, double offsetY) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(m11, m12, m21, m22, offsetX, offsetY));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Equals(Matrix value) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Equals", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean Equals(Matrix matrix1, Matrix matrix2) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("Equals", matrix1 == null ? null : matrix1.getJCOInstance(), matrix2 == null ? null : matrix2.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(IFormatProvider provider) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Matrix Multiply(Matrix trans1, Matrix trans2) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objMultiply = (JCObject)classType.Invoke("Multiply", trans1 == null ? null : trans1.getJCOInstance(), trans2 == null ? null : trans2.getJCOInstance());
            return new Matrix(objMultiply);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Matrix Parse(java.lang.String source) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.NullReferenceException, system.FormatException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", source);
            return new Matrix(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Point Transform(Point point) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objTransform = (JCObject)classInstance.Invoke("Transform", point == null ? null : point.getJCOInstance());
            return new Point(objTransform);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Vector Transform(Vector vector) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objTransform = (JCObject)classInstance.Invoke("Transform", vector == null ? null : vector.getJCOInstance());
            return new Vector(objTransform);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Append(Matrix matrix) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Append", matrix == null ? null : matrix.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Invert() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Invert");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Prepend(Matrix matrix) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Prepend", matrix == null ? null : matrix.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Rotate(double angle) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Rotate", angle);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RotateAt(double angle, double centerX, double centerY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RotateAt", angle, centerX, centerY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RotateAtPrepend(double angle, double centerX, double centerY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RotateAtPrepend", angle, centerX, centerY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RotatePrepend(double angle) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RotatePrepend", angle);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Scale(double scaleX, double scaleY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Scale", scaleX, scaleY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ScaleAt(double scaleX, double scaleY, double centerX, double centerY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ScaleAt", scaleX, scaleY, centerX, centerY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ScaleAtPrepend(double scaleX, double scaleY, double centerX, double centerY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ScaleAtPrepend", scaleX, scaleY, centerX, centerY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ScalePrepend(double scaleX, double scaleY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ScalePrepend", scaleX, scaleY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetIdentity() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetIdentity");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Skew(double skewX, double skewY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Skew", skewX, skewY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SkewPrepend(double skewX, double skewY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SkewPrepend", skewX, skewY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Transform(Point[] points) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Transform", (java.lang.Object)toObjectFromArray(points));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Transform(Vector[] vectors) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Transform", (java.lang.Object)toObjectFromArray(vectors));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Translate(double offsetX, double offsetY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Translate", offsetX, offsetY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TranslatePrepend(double offsetX, double offsetY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TranslatePrepend", offsetX, offsetY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIFormattable method available in IFormattable to obtain an object with an invocable method
     */
    @Deprecated 
    public java.lang.String ToString(java.lang.String format, IFormatProvider formatProvider) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIFormattable to obtain the full interface.");
    }


    
    // Properties section
    
    public boolean getHasInverse() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasInverse");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsIdentity() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsIdentity");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getDeterminant() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("Determinant");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getM11() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("M11");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setM11(double M11) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("M11", M11);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getM12() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("M12");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setM12(double M12) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("M12", M12);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getM21() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("M21");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setM21(double M21) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("M21", M21);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getM22() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("M22");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setM22(double M22) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("M22", M22);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getOffsetX() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("OffsetX");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOffsetX(double OffsetX) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("OffsetX", OffsetX);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getOffsetY() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("OffsetY");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOffsetY(double OffsetY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("OffsetY", OffsetY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Matrix getIdentity() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Identity");
            return new Matrix(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}