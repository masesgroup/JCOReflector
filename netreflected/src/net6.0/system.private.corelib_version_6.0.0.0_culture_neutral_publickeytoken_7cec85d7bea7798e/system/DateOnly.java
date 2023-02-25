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
import system.globalization.Calendar;
import system.DateOnly;
import system.IFormatProvider;
import system.IFormatProviderImplementation;
import system.globalization.DateTimeStyles;
import system.DateTime;
import system.TimeOnly;
import system.DateTimeKind;
import system.DayOfWeek;


/**
 * The base .NET class managing System.DateOnly, System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.DateOnly" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.DateOnly</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class DateOnly extends ValueType  {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.DateOnly
     */
    public static final String className = "System.DateOnly";
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
    public DateOnly(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DateOnly}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DateOnly} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DateOnly cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DateOnly(from.getJCOInstance());
    }

    // Constructors section
    
    public DateOnly() throws Throwable {
    }

    public DateOnly(int year, int month, int day, Calendar calendar) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(year, month, day, calendar == null ? null : calendar.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateOnly(int year, int month, int day) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(year, month, day));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Equals(DateOnly value) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Equals", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParse(java.lang.String s, JCORefOut<DateOnly> result) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParse", s, result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParse(java.lang.String s, IFormatProvider provider, DateTimeStyles style, JCORefOut<DateOnly> result) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParse", s, provider == null ? null : provider.getJCOInstance(), style == null ? null : style.getJCOInstance(), result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParseExact(java.lang.String s, java.lang.String format, JCORefOut<DateOnly> result) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.TypeInitializationException, system.OverflowException, system.InvalidOperationException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParseExact", s, format, result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParseExact(java.lang.String s, java.lang.String format, IFormatProvider provider, DateTimeStyles style, JCORefOut<DateOnly> result) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.TypeInitializationException, system.OverflowException, system.FormatException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParseExact", s, format, provider == null ? null : provider.getJCOInstance(), style == null ? null : style.getJCOInstance(), result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParseExact(java.lang.String s, java.lang.String[] formats, JCORefOut<DateOnly> result) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.OverflowException, system.InvalidOperationException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParseExact", s, formats, result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryParseExact(java.lang.String s, java.lang.String[] formats, IFormatProvider provider, DateTimeStyles style, JCORefOut<DateOnly> result) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryParseExact", s, formats, provider == null ? null : provider.getJCOInstance(), style == null ? null : style.getJCOInstance(), result.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int CompareTo(DateOnly value) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("CompareTo", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int CompareTo(NetObject value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.RankException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("CompareTo", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateOnly AddDays(int value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAddDays = (JCObject)classInstance.Invoke("AddDays", value);
            return new DateOnly(objAddDays);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateOnly AddMonths(int value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAddMonths = (JCObject)classInstance.Invoke("AddMonths", value);
            return new DateOnly(objAddMonths);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateOnly AddYears(int value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAddYears = (JCObject)classInstance.Invoke("AddYears", value);
            return new DateOnly(objAddYears);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly FromDateTime(DateTime dateTime) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromDateTime = (JCObject)classType.Invoke("FromDateTime", dateTime == null ? null : dateTime.getJCOInstance());
            return new DateOnly(objFromDateTime);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly FromDayNumber(int dayNumber) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromDayNumber = (JCObject)classType.Invoke("FromDayNumber", dayNumber);
            return new DateOnly(objFromDayNumber);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly Parse(java.lang.String s, IFormatProvider provider, DateTimeStyles style) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.RankException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", s, provider == null ? null : provider.getJCOInstance(), style == null ? null : style.getJCOInstance());
            return new DateOnly(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly Parse(java.lang.String s) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParse = (JCObject)classType.Invoke("Parse", s);
            return new DateOnly(objParse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly ParseExact(java.lang.String s, java.lang.String format, IFormatProvider provider, DateTimeStyles style) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.RankException, system.TypeInitializationException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParseExact = (JCObject)classType.Invoke("ParseExact", s, format, provider == null ? null : provider.getJCOInstance(), style == null ? null : style.getJCOInstance());
            return new DateOnly(objParseExact);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly ParseExact(java.lang.String s, java.lang.String format) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.TypeInitializationException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParseExact = (JCObject)classType.Invoke("ParseExact", s, format);
            return new DateOnly(objParseExact);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly ParseExact(java.lang.String s, java.lang.String[] formats, IFormatProvider provider, DateTimeStyles style) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.RankException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParseExact = (JCObject)classType.Invoke("ParseExact", s, formats, provider == null ? null : provider.getJCOInstance(), style == null ? null : style.getJCOInstance());
            return new DateOnly(objParseExact);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly ParseExact(java.lang.String dupParam0, JCORefOut dupParam1, IFormatProvider dupParam2, DateTimeStyles dupParam3) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.RankException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParseExact = (JCObject)classType.Invoke("ParseExact", dupParam0, dupParam1.getJCRefOut(), dupParam2 == null ? null : dupParam2.getJCOInstance(), dupParam3 == null ? null : dupParam3.getJCOInstance());
            return new DateOnly(objParseExact);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly ParseExact(java.lang.String s, java.lang.String[] formats) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParseExact = (JCObject)classType.Invoke("ParseExact", s, formats);
            return new DateOnly(objParseExact);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly ParseExact(java.lang.String dupParam0, JCORefOut dupParam1) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.OverflowException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objParseExact = (JCObject)classType.Invoke("ParseExact", dupParam0, dupParam1.getJCRefOut());
            return new DateOnly(objParseExact);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime ToDateTime(TimeOnly time, DateTimeKind kind) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objToDateTime = (JCObject)classInstance.Invoke("ToDateTime", time == null ? null : time.getJCOInstance(), kind == null ? null : kind.getJCOInstance());
            return new DateTime(objToDateTime);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime ToDateTime(TimeOnly time) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objToDateTime = (JCObject)classInstance.Invoke("ToDateTime", time == null ? null : time.getJCOInstance());
            return new DateTime(objToDateTime);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToLongDateString() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToLongDateString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToShortDateString() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToShortDateString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(IFormatProvider provider) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(java.lang.String format, IFormatProvider provider) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.security.SecurityException, system.OverflowException, system.FormatException, system.OutOfMemoryException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", format, provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(java.lang.String format) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", format);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getDay() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Day");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getDayNumber() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("DayNumber");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getDayOfYear() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("DayOfYear");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getMonth() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Month");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getYear() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Year");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly getMaxValue() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("MaxValue");
            return new DateOnly(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateOnly getMinValue() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("MinValue");
            return new DateOnly(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DayOfWeek getDayOfWeek() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DayOfWeek");
            return new DayOfWeek(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}