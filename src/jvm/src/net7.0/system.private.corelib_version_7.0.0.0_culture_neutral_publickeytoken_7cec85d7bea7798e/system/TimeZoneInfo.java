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
import system.TimeZoneInfo;
import system.DateTime;
import system.DateTimeOffset;
import system.TimeSpan;
import system.runtime.serialization.SerializationInfo;
import system.runtime.serialization.StreamingContext;
import system.runtime.serialization.ISerializable;
import system.runtime.serialization.ISerializableImplementation;
import system.runtime.serialization.IDeserializationCallback;
import system.runtime.serialization.IDeserializationCallbackImplementation;


/**
 * The base .NET class managing System.TimeZoneInfo, System.Private.CoreLib, Version=7.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.TimeZoneInfo" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.TimeZoneInfo</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class TimeZoneInfo extends NetObject implements system.runtime.serialization.ISerializable, system.runtime.serialization.IDeserializationCallback {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=7.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=7.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.TimeZoneInfo
     */
    public static final String className = "System.TimeZoneInfo";
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
    public TimeZoneInfo(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link TimeZoneInfo}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link TimeZoneInfo} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static TimeZoneInfo cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new TimeZoneInfo(from.getJCOInstance());
    }

    // Constructors section
    
    public TimeZoneInfo() throws Throwable {
    }



    
    // Methods section
    
    public boolean Equals(TimeZoneInfo other) throws Throwable, system.NotSupportedException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Equals", other == null ? null : other.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean HasSameRules(TimeZoneInfo other) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("HasSameRules", other == null ? null : other.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsAmbiguousTime(DateTime dateTime) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.OverflowException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsAmbiguousTime", dateTime == null ? null : dateTime.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsAmbiguousTime(DateTimeOffset dateTimeOffset) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.OverflowException, system.InvalidTimeZoneException, system.UnauthorizedAccessException, system.io.IOException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsAmbiguousTime", dateTimeOffset == null ? null : dateTimeOffset.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsDaylightSavingTime(DateTime dateTime) throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ObjectDisposedException, system.OverflowException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsDaylightSavingTime", dateTime == null ? null : dateTime.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsDaylightSavingTime(DateTimeOffset dateTimeOffset) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsDaylightSavingTime", dateTimeOffset == null ? null : dateTimeOffset.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsInvalidTime(DateTime dateTime) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsInvalidTime", dateTime == null ? null : dateTime.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryConvertIanaIdToWindowsId(java.lang.String ianaId, JCORefOut windowsId) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryConvertIanaIdToWindowsId", ianaId, windowsId.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryConvertWindowsIdToIanaId(java.lang.String windowsId, JCORefOut ianaId) throws Throwable, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryConvertWindowsIdToIanaId", windowsId, ianaId.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryConvertWindowsIdToIanaId(java.lang.String windowsId, java.lang.String region, JCORefOut ianaId) throws Throwable, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryConvertWindowsIdToIanaId", windowsId, region, ianaId.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTime(DateTime dateTime, TimeZoneInfo sourceTimeZone, TimeZoneInfo destinationTimeZone) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTime = (JCObject)classType.Invoke("ConvertTime", dateTime == null ? null : dateTime.getJCOInstance(), sourceTimeZone == null ? null : sourceTimeZone.getJCOInstance(), destinationTimeZone == null ? null : destinationTimeZone.getJCOInstance());
            return new DateTime(objConvertTime);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTime(DateTime dateTime, TimeZoneInfo destinationTimeZone) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.security.SecurityException, system.io.IOException, system.UnauthorizedAccessException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTime = (JCObject)classType.Invoke("ConvertTime", dateTime == null ? null : dateTime.getJCOInstance(), destinationTimeZone == null ? null : destinationTimeZone.getJCOInstance());
            return new DateTime(objConvertTime);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTimeBySystemTimeZoneId(DateTime dateTime, java.lang.String sourceTimeZoneId, java.lang.String destinationTimeZoneId) throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ObjectDisposedException, system.TimeZoneNotFoundException, system.OverflowException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTimeBySystemTimeZoneId = (JCObject)classType.Invoke("ConvertTimeBySystemTimeZoneId", dateTime == null ? null : dateTime.getJCOInstance(), sourceTimeZoneId, destinationTimeZoneId);
            return new DateTime(objConvertTimeBySystemTimeZoneId);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTimeBySystemTimeZoneId(DateTime dateTime, java.lang.String destinationTimeZoneId) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.TimeZoneNotFoundException, system.InvalidTimeZoneException, system.ObjectDisposedException, system.security.SecurityException, system.io.IOException, system.IndexOutOfRangeException, system.UnauthorizedAccessException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTimeBySystemTimeZoneId = (JCObject)classType.Invoke("ConvertTimeBySystemTimeZoneId", dateTime == null ? null : dateTime.getJCOInstance(), destinationTimeZoneId);
            return new DateTime(objConvertTimeBySystemTimeZoneId);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTimeFromUtc(DateTime dateTime, TimeZoneInfo destinationTimeZone) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTimeFromUtc = (JCObject)classType.Invoke("ConvertTimeFromUtc", dateTime == null ? null : dateTime.getJCOInstance(), destinationTimeZone == null ? null : destinationTimeZone.getJCOInstance());
            return new DateTime(objConvertTimeFromUtc);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTimeToUtc(DateTime dateTime, TimeZoneInfo sourceTimeZone) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTimeToUtc = (JCObject)classType.Invoke("ConvertTimeToUtc", dateTime == null ? null : dateTime.getJCOInstance(), sourceTimeZone == null ? null : sourceTimeZone.getJCOInstance());
            return new DateTime(objConvertTimeToUtc);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTime ConvertTimeToUtc(DateTime dateTime) throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.IndexOutOfRangeException, system.security.SecurityException, system.io.IOException, system.UnauthorizedAccessException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTimeToUtc = (JCObject)classType.Invoke("ConvertTimeToUtc", dateTime == null ? null : dateTime.getJCOInstance());
            return new DateTime(objConvertTimeToUtc);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTimeOffset ConvertTime(DateTimeOffset dateTimeOffset, TimeZoneInfo destinationTimeZone) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.OverflowException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTime = (JCObject)classType.Invoke("ConvertTime", dateTimeOffset == null ? null : dateTimeOffset.getJCOInstance(), destinationTimeZone == null ? null : destinationTimeZone.getJCOInstance());
            return new DateTimeOffset(objConvertTime);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DateTimeOffset ConvertTimeBySystemTimeZoneId(DateTimeOffset dateTimeOffset, java.lang.String destinationTimeZoneId) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.TimeZoneNotFoundException, system.InvalidTimeZoneException, system.ObjectDisposedException, system.security.SecurityException, system.io.IOException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objConvertTimeBySystemTimeZoneId = (JCObject)classType.Invoke("ConvertTimeBySystemTimeZoneId", dateTimeOffset == null ? null : dateTimeOffset.getJCOInstance(), destinationTimeZoneId);
            return new DateTimeOffset(objConvertTimeBySystemTimeZoneId);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToSerializedString() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToSerializedString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan GetUtcOffset(DateTime dateTime) throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ObjectDisposedException, system.OverflowException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetUtcOffset = (JCObject)classInstance.Invoke("GetUtcOffset", dateTime == null ? null : dateTime.getJCOInstance());
            return new TimeSpan(objGetUtcOffset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan GetUtcOffset(DateTimeOffset dateTimeOffset) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetUtcOffset = (JCObject)classInstance.Invoke("GetUtcOffset", dateTimeOffset == null ? null : dateTimeOffset.getJCOInstance());
            return new TimeSpan(objGetUtcOffset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan[] GetAmbiguousTimeOffsets(DateTime dateTime) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.RankException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidTimeZoneException, system.security.SecurityException, system.io.IOException, system.UnauthorizedAccessException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<TimeSpan> resultingArrayList = new ArrayList<TimeSpan>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetAmbiguousTimeOffsets", dateTime == null ? null : dateTime.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new TimeSpan(resultingObject));
            }
            TimeSpan[] resultingArray = new TimeSpan[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan[] GetAmbiguousTimeOffsets(DateTimeOffset dateTimeOffset) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.RankException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<TimeSpan> resultingArrayList = new ArrayList<TimeSpan>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetAmbiguousTimeOffsets", dateTimeOffset == null ? null : dateTimeOffset.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new TimeSpan(resultingObject));
            }
            TimeSpan[] resultingArray = new TimeSpan[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static TimeZoneInfo CreateCustomTimeZone(java.lang.String id, TimeSpan baseUtcOffset, java.lang.String displayName, java.lang.String standardDisplayName) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.OverflowException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateCustomTimeZone = (JCObject)classType.Invoke("CreateCustomTimeZone", id, baseUtcOffset == null ? null : baseUtcOffset.getJCOInstance(), displayName, standardDisplayName);
            return new TimeZoneInfo(objCreateCustomTimeZone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static TimeZoneInfo FindSystemTimeZoneById(java.lang.String id) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.TimeZoneNotFoundException, system.InvalidTimeZoneException, system.OverflowException, system.security.SecurityException, system.io.IOException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFindSystemTimeZoneById = (JCObject)classType.Invoke("FindSystemTimeZoneById", id);
            return new TimeZoneInfo(objFindSystemTimeZoneById);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static TimeZoneInfo FromSerializedString(java.lang.String source) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.runtime.serialization.SerializationException, system.OverflowException, system.InvalidTimeZoneException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromSerializedString = (JCObject)classType.Invoke("FromSerializedString", source);
            return new TimeZoneInfo(objFromSerializedString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ClearCachedData() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ClearCachedData");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToISerializable method available in ISerializable to obtain an object with an invocable method
     */
    @Deprecated 
    public void GetObjectData(SerializationInfo info, StreamingContext context) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToISerializable to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIDeserializationCallback method available in IDeserializationCallback to obtain an object with an invocable method
     */
    @Deprecated 
    public void OnDeserialization(NetObject sender) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIDeserializationCallback to obtain the full interface.");
    }


    
    // Properties section
    
    public boolean getHasIanaId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasIanaId");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSupportsDaylightSavingTime() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SupportsDaylightSavingTime");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDaylightName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DaylightName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDisplayName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DisplayName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Id");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getStandardName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("StandardName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan getBaseUtcOffset() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("BaseUtcOffset");
            return new TimeSpan(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static TimeZoneInfo getLocal() throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.IndexOutOfRangeException, system.security.SecurityException, system.io.IOException, system.UnauthorizedAccessException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Local");
            return new TimeZoneInfo(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static TimeZoneInfo getUtc() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Utc");
            return new TimeZoneInfo(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}