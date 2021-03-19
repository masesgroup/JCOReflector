/*
 *  MIT License
 *
 *  Copyright (c) 2021 MASES s.r.l.
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

package system.io;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.MarshalByRefObject;
import system.runtime.serialization.SerializationInfo;
import system.runtime.serialization.StreamingContext;
import system.DateTime;
import system.io.FileAttributes;


/**
 * The base .NET class managing System.IO.FileSystemInfo, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.FileSystemInfo" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.FileSystemInfo</a>
 */
public class FileSystemInfo extends MarshalByRefObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.IO.FileSystemInfo
     */
    public static final String className = "System.IO.FileSystemInfo";
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

    public FileSystemInfo(Object instance) throws Throwable {
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

    public Object getJCOInstance() {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link FileSystemInfo}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link FileSystemInfo} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static FileSystemInfo cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new FileSystemInfo(from.getJCOInstance());
    }

    // Constructors section
    
    public FileSystemInfo() throws Throwable {
    }

    
    // Methods section
    
    public void Delete() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Delete");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void GetObjectData(SerializationInfo info, StreamingContext context) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.NotSupportedException, system.runtime.serialization.SerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetObjectData", info == null ? null : info.getJCOInstance(), context == null ? null : context.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Refresh() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Refresh");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getExists() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Exists");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getCreationTime() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.InvalidTimeZoneException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CreationTime");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCreationTime(DateTime CreationTime) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.security.SecurityException, system.io.IOException, system.InvalidOperationException, system.NotSupportedException, system.OverflowException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.DriveNotFoundException, system.OperationCanceledException, system.IndexOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CreationTime", CreationTime == null ? null : CreationTime.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getCreationTimeUtc() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CreationTimeUtc");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCreationTimeUtc(DateTime CreationTimeUtc) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.io.PathTooLongException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OverflowException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CreationTimeUtc", CreationTimeUtc == null ? null : CreationTimeUtc.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getLastAccessTime() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.InvalidTimeZoneException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LastAccessTime");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLastAccessTime(DateTime LastAccessTime) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.security.SecurityException, system.io.IOException, system.InvalidOperationException, system.NotSupportedException, system.OverflowException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.DriveNotFoundException, system.OperationCanceledException, system.IndexOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LastAccessTime", LastAccessTime == null ? null : LastAccessTime.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getLastAccessTimeUtc() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LastAccessTimeUtc");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLastAccessTimeUtc(DateTime LastAccessTimeUtc) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.io.PathTooLongException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OverflowException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LastAccessTimeUtc", LastAccessTimeUtc == null ? null : LastAccessTimeUtc.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getLastWriteTime() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.InvalidTimeZoneException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LastWriteTime");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLastWriteTime(DateTime LastWriteTime) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidTimeZoneException, system.security.SecurityException, system.io.IOException, system.InvalidOperationException, system.NotSupportedException, system.OverflowException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.DriveNotFoundException, system.OperationCanceledException, system.IndexOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LastWriteTime", LastWriteTime == null ? null : LastWriteTime.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getLastWriteTimeUtc() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LastWriteTimeUtc");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setLastWriteTimeUtc(DateTime LastWriteTimeUtc) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.io.PathTooLongException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OverflowException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("LastWriteTimeUtc", LastWriteTimeUtc == null ? null : LastWriteTimeUtc.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FileAttributes getAttributes() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Attributes");
            return new FileAttributes(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAttributes(FileAttributes Attributes) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Attributes", Attributes == null ? null : Attributes.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getExtension() throws Throwable, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Extension");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getFullName() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("FullName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Name");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}