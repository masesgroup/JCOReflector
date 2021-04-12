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

package system.io.packaging;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.packaging.StorageInfo;
import system.io.packaging.StreamInfo;
import system.io.packaging.CompressionOption;
import system.io.packaging.EncryptionOption;


/**
 * The base .NET class managing System.IO.Packaging.StorageInfo, WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.Packaging.StorageInfo" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.Packaging.StorageInfo</a>
 */
public class StorageInfo extends NetObject  {
    /**
     * Fully assembly qualified name: WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: WindowsBase
     */
    public static final String assemblyShortName = "WindowsBase";
    /**
     * Qualified class name: System.IO.Packaging.StorageInfo
     */
    public static final String className = "System.IO.Packaging.StorageInfo";
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

    public StorageInfo(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link StorageInfo}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link StorageInfo} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static StorageInfo cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new StorageInfo(from.getJCOInstance());
    }

    // Constructors section
    
    public StorageInfo() throws Throwable {
    }



    
    // Methods section
    
    public boolean StreamExists(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.IOException, system.io.FileFormatException, system.ArgumentOutOfRangeException, system.io.DirectoryNotFoundException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("StreamExists", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean SubStorageExists(java.lang.String name) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.FormatException, system.io.DirectoryNotFoundException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("SubStorageExists", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StorageInfo CreateSubStorage(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.DirectoryNotFoundException, system.io.IOException, system.ArgumentOutOfRangeException, system.security.SecurityException, system.UnauthorizedAccessException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateSubStorage = (JCObject)classInstance.Invoke("CreateSubStorage", name);
            return new StorageInfo(objCreateSubStorage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StorageInfo GetSubStorageInfo(java.lang.String name) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.FormatException, system.io.DirectoryNotFoundException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSubStorageInfo = (JCObject)classInstance.Invoke("GetSubStorageInfo", name);
            return new StorageInfo(objGetSubStorageInfo);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StorageInfo[] GetSubStorages() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.IOException, system.io.DirectoryNotFoundException, system.ArgumentOutOfRangeException, system.io.FileFormatException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<StorageInfo> resultingArrayList = new ArrayList<StorageInfo>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetSubStorages");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new StorageInfo(resultingObject));
            }
            StorageInfo[] resultingArray = new StorageInfo[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamInfo CreateStream(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.ArrayTypeMismatchException, system.io.IOException, system.io.FileFormatException, system.io.DirectoryNotFoundException, system.NotSupportedException, system.UnauthorizedAccessException, system.SystemException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateStream = (JCObject)classInstance.Invoke("CreateStream", name);
            return new StreamInfo(objCreateStream);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamInfo CreateStream(java.lang.String name, CompressionOption compressionOption, EncryptionOption encryptionOption) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArrayTypeMismatchException, system.io.IOException, system.io.FileFormatException, system.RankException, system.NotSupportedException, system.SystemException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateStream = (JCObject)classInstance.Invoke("CreateStream", name, compressionOption == null ? null : compressionOption.getJCOInstance(), encryptionOption == null ? null : encryptionOption.getJCOInstance());
            return new StreamInfo(objCreateStream);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamInfo GetStreamInfo(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.IOException, system.io.FileFormatException, system.ArgumentOutOfRangeException, system.io.DirectoryNotFoundException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetStreamInfo = (JCObject)classInstance.Invoke("GetStreamInfo", name);
            return new StreamInfo(objGetStreamInfo);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamInfo[] GetStreams() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.IOException, system.io.DirectoryNotFoundException, system.ArgumentOutOfRangeException, system.io.FileFormatException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<StreamInfo> resultingArrayList = new ArrayList<StreamInfo>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetStreams");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new StreamInfo(resultingObject));
            }
            StreamInfo[] resultingArray = new StreamInfo[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeleteStream(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.IOException, system.io.FileFormatException, system.ArgumentOutOfRangeException, system.io.DirectoryNotFoundException, system.NotSupportedException, system.UnauthorizedAccessException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeleteStream", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeleteSubStorage(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.io.DirectoryNotFoundException, system.io.IOException, system.UnauthorizedAccessException, system.NotSupportedException, system.io.FileFormatException, system.ArgumentOutOfRangeException, system.RankException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeleteSubStorage", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public java.lang.String getName() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.PlatformNotSupportedException {
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