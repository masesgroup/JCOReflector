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

package system;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.ValueType;
import system.UInt64;
import system.UInt128;
import system.globalization.NumberStyles;
import system.IFormatProvider;
import system.IFormatProviderImplementation;


/**
 * The base .NET class managing System.UInt128, System.Private.CoreLib, Version=7.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.UInt128" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.UInt128</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class UInt128 extends ValueType  {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=7.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=7.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.UInt128
     */
    public static final String className = "System.UInt128";
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
    public UInt128(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link UInt128}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link UInt128} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static UInt128 cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new UInt128(from.getJCOInstance());
    }

    // Constructors section
    
    public UInt128() throws Throwable {
    }

    public UInt128(UInt64 upper, UInt64 lower) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(upper == null ? null : upper.getJCOInstance(), lower == null ? null : lower.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Equals(UInt128 other) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Equals", other == null ? null : other.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsEvenInteger(UInt128 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsEvenInteger", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsOddInteger(UInt128 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsOddInteger", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsPow2(UInt128 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsPow2", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParse(java.lang.String s, NumberStyles style, IFormatProvider provider, JCORefOut<UInt128> result) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParse", s, style == null ? null : style.getJCOInstance(), provider == null ? null : provider.getJCOInstance(), result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParse(java.lang.String s, IFormatProvider provider, JCORefOut<UInt128> result) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParse", s, provider == null ? null : provider.getJCOInstance(), result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParse(java.lang.String s, JCORefOut<UInt128> result) throws Throwable, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.TypeInitializationException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParse", s, result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int CompareTo(NetObject value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.RankException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("CompareTo", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int CompareTo(UInt128 value) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("CompareTo", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int Sign(UInt128 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("Sign", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(IFormatProvider provider) throws Throwable, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(java.lang.String format, IFormatProvider provider) throws Throwable, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", format, provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(java.lang.String format) throws Throwable, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", format);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Clamp(UInt128 value, UInt128 min, UInt128 max) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objClamp = (JCObject)classType.Invoke("Clamp", value == null ? null : value.getJCOInstance(), min == null ? null : min.getJCOInstance(), max == null ? null : max.getJCOInstance());
            return new UInt128(objClamp);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 LeadingZeroCount(UInt128 value) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLeadingZeroCount = (JCObject)classType.Invoke("LeadingZeroCount", value == null ? null : value.getJCOInstance());
            return new UInt128(objLeadingZeroCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Log2(UInt128 value) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLog2 = (JCObject)classType.Invoke("Log2", value == null ? null : value.getJCOInstance());
            return new UInt128(objLog2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Max(UInt128 x, UInt128 y) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objMax = (JCObject)classType.Invoke("Max", x == null ? null : x.getJCOInstance(), y == null ? null : y.getJCOInstance());
            return new UInt128(objMax);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Min(UInt128 x, UInt128 y) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objMin = (JCObject)classType.Invoke("Min", x == null ? null : x.getJCOInstance(), y == null ? null : y.getJCOInstance());
            return new UInt128(objMin);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Parse(java.lang.String s, NumberStyles style, IFormatProvider provider) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", s, style == null ? null : style.getJCOInstance(), provider == null ? null : provider.getJCOInstance());
            return new UInt128(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Parse(java.lang.String s, NumberStyles style) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.TypeInitializationException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", s, style == null ? null : style.getJCOInstance());
            return new UInt128(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Parse(java.lang.String s, IFormatProvider provider) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", s, provider == null ? null : provider.getJCOInstance());
            return new UInt128(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 Parse(java.lang.String s) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.TypeInitializationException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", s);
            return new UInt128(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 PopCount(UInt128 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objPopCount = (JCObject)classType.Invoke("PopCount", value == null ? null : value.getJCOInstance());
            return new UInt128(objPopCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 RotateLeft(UInt128 value, int rotateAmount) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objRotateLeft = (JCObject)classType.Invoke("RotateLeft", value == null ? null : value.getJCOInstance(), rotateAmount);
            return new UInt128(objRotateLeft);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 RotateRight(UInt128 value, int rotateAmount) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objRotateRight = (JCObject)classType.Invoke("RotateRight", value == null ? null : value.getJCOInstance(), rotateAmount);
            return new UInt128(objRotateRight);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 TrailingZeroCount(UInt128 value) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objTrailingZeroCount = (JCObject)classType.Invoke("TrailingZeroCount", value == null ? null : value.getJCOInstance());
            return new UInt128(objTrailingZeroCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static UInt128 getMaxValue() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("MaxValue");
            return new UInt128(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 getMinValue() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("MinValue");
            return new UInt128(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 getOne() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("One");
            return new UInt128(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static UInt128 getZero() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Zero");
            return new UInt128(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}