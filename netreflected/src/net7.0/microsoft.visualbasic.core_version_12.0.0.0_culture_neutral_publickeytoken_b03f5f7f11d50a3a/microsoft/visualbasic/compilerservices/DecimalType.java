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

package microsoft.visualbasic.compilerservices;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.Decimal;
import system.globalization.NumberFormatInfo;


/**
 * The base .NET class managing Microsoft.VisualBasic.CompilerServices.DecimalType, Microsoft.VisualBasic.Core, Version=12.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.VisualBasic.CompilerServices.DecimalType" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.VisualBasic.CompilerServices.DecimalType</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class DecimalType extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.VisualBasic.Core, Version=12.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.VisualBasic.Core, Version=12.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.VisualBasic.Core
     */
    public static final String assemblyShortName = "Microsoft.VisualBasic.Core";
    /**
     * Qualified class name: Microsoft.VisualBasic.CompilerServices.DecimalType
     */
    public static final String className = "Microsoft.VisualBasic.CompilerServices.DecimalType";
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
    public DecimalType(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DecimalType}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DecimalType} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DecimalType cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DecimalType(from.getJCOInstance());
    }

    // Constructors section
    
    public DecimalType() throws Throwable {
    }



    
    // Methods section
    
    public static Decimal FromBoolean(boolean Value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromBoolean = (JCObject)classType.Invoke("FromBoolean", Value);
            return new Decimal(objFromBoolean);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Decimal FromObject(NetObject Value, NumberFormatInfo NumberFormat) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.FormatException, system.OverflowException, system.ArgumentNullException, system.InvalidCastException, system.OutOfMemoryException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromObject = (JCObject)classType.Invoke("FromObject", Value == null ? null : Value.getJCOInstance(), NumberFormat == null ? null : NumberFormat.getJCOInstance());
            return new Decimal(objFromObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Decimal FromObject(NetObject Value) throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.OverflowException, system.InvalidCastException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromObject = (JCObject)classType.Invoke("FromObject", Value == null ? null : Value.getJCOInstance());
            return new Decimal(objFromObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Decimal FromString(java.lang.String Value, NumberFormatInfo NumberFormat) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.FormatException, system.OverflowException, system.ArgumentNullException, system.InvalidCastException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromString = (JCObject)classType.Invoke("FromString", Value, NumberFormat == null ? null : NumberFormat.getJCOInstance());
            return new Decimal(objFromString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Decimal FromString(java.lang.String Value) throws Throwable, system.NotSupportedException, system.ArgumentException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.FormatException, system.OverflowException, system.ArgumentNullException, system.InvalidCastException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromString = (JCObject)classType.Invoke("FromString", Value);
            return new Decimal(objFromString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Decimal Parse(java.lang.String Value, NumberFormatInfo NumberFormat) throws Throwable, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ArgumentException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", Value, NumberFormat == null ? null : NumberFormat.getJCOInstance());
            return new Decimal(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}