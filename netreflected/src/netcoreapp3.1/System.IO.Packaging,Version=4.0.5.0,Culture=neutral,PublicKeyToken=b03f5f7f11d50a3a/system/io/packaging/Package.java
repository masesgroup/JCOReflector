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
import system.Uri;
import system.io.packaging.Package;
import system.io.Stream;
import system.io.FileMode;
import system.io.FileAccess;
import system.io.FileShare;
import system.io.packaging.PackagePart;
import system.io.packaging.CompressionOption;
import system.io.packaging.PackagePartCollection;
import system.io.packaging.PackageRelationship;
import system.io.packaging.TargetMode;
import system.io.packaging.PackageRelationshipCollection;
import system.io.packaging.PackageProperties;


/**
 * The base .NET class managing System.IO.Packaging.Package, System.IO.Packaging, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.Packaging.Package" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.Packaging.Package</a>
 */
public class Package extends NetObject  {
    /**
     * Fully assembly qualified name: System.IO.Packaging, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.IO.Packaging, Version=4.0.5.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.IO.Packaging
     */
    public static final String assemblyShortName = "System.IO.Packaging";
    /**
     * Qualified class name: System.IO.Packaging.Package
     */
    public static final String className = "System.IO.Packaging.Package";
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

    public Package(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Package}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Package} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Package cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Package(from.getJCOInstance());
    }

    // Constructors section
    
    public Package() throws Throwable {
    }

    
    // Methods section
    
    public boolean PartExists(Uri partUri) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.UriFormatException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("PartExists", partUri == null ? null : partUri.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean RelationshipExists(java.lang.String id) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.IOException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.xml.XmlException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("RelationshipExists", id);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(Stream stream) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.io.FileFormatException, system.io.IOException, system.io.InvalidDataException, system.xml.XmlException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", stream == null ? null : stream.getJCOInstance());
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(Stream stream, FileMode packageMode) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.io.FileFormatException, system.io.IOException, system.io.InvalidDataException, system.xml.XmlException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", stream == null ? null : stream.getJCOInstance(), packageMode == null ? null : packageMode.getJCOInstance());
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(Stream stream, FileMode packageMode, FileAccess packageAccess) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.io.FileFormatException, system.io.IOException, system.io.InvalidDataException, system.FormatException, system.xml.XmlException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", stream == null ? null : stream.getJCOInstance(), packageMode == null ? null : packageMode.getJCOInstance(), packageAccess == null ? null : packageAccess.getJCOInstance());
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(java.lang.String path) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.runtime.serialization.SerializationException, system.io.IOException, system.io.InvalidDataException, system.xml.XmlException, system.io.FileFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", path);
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(java.lang.String path, FileMode packageMode) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.runtime.serialization.SerializationException, system.io.IOException, system.io.InvalidDataException, system.xml.XmlException, system.io.FileFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", path, packageMode == null ? null : packageMode.getJCOInstance());
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(java.lang.String path, FileMode packageMode, FileAccess packageAccess) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.runtime.serialization.SerializationException, system.io.IOException, system.io.InvalidDataException, system.xml.XmlException, system.io.FileFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", path, packageMode == null ? null : packageMode.getJCOInstance(), packageAccess == null ? null : packageAccess.getJCOInstance());
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Package Open(java.lang.String path, FileMode packageMode, FileAccess packageAccess, FileShare packageShare) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.runtime.serialization.SerializationException, system.io.IOException, system.io.InvalidDataException, system.xml.XmlException, system.io.FileFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", path, packageMode == null ? null : packageMode.getJCOInstance(), packageAccess == null ? null : packageAccess.getJCOInstance(), packageShare == null ? null : packageShare.getJCOInstance());
            return new Package(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackagePart CreatePart(Uri partUri, java.lang.String contentType) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.IOException, system.ArgumentOutOfRangeException, system.UriFormatException, system.FormatException, system.PlatformNotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreatePart = (JCObject)classInstance.Invoke("CreatePart", partUri == null ? null : partUri.getJCOInstance(), contentType);
            return new PackagePart(objCreatePart);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackagePart CreatePart(Uri partUri, java.lang.String contentType, CompressionOption compressionOption) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.UriFormatException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreatePart = (JCObject)classInstance.Invoke("CreatePart", partUri == null ? null : partUri.getJCOInstance(), contentType, compressionOption == null ? null : compressionOption.getJCOInstance());
            return new PackagePart(objCreatePart);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackagePart GetPart(Uri partUri) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.IOException, system.ArgumentOutOfRangeException, system.UriFormatException, system.FormatException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPart = (JCObject)classInstance.Invoke("GetPart", partUri == null ? null : partUri.getJCOInstance());
            return new PackagePart(objGetPart);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackagePartCollection GetParts() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.io.FileFormatException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetParts = (JCObject)classInstance.Invoke("GetParts");
            return new PackagePartCollection(objGetParts);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackageRelationship CreateRelationship(Uri targetUri, TargetMode targetMode, java.lang.String relationshipType) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.IOException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException, system.xml.XmlException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateRelationship = (JCObject)classInstance.Invoke("CreateRelationship", targetUri == null ? null : targetUri.getJCOInstance(), targetMode == null ? null : targetMode.getJCOInstance(), relationshipType);
            return new PackageRelationship(objCreateRelationship);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackageRelationship CreateRelationship(Uri targetUri, TargetMode targetMode, java.lang.String relationshipType, java.lang.String id) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException, system.xml.XmlException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateRelationship = (JCObject)classInstance.Invoke("CreateRelationship", targetUri == null ? null : targetUri.getJCOInstance(), targetMode == null ? null : targetMode.getJCOInstance(), relationshipType, id);
            return new PackageRelationship(objCreateRelationship);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackageRelationship GetRelationship(java.lang.String id) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.IOException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.xml.XmlException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRelationship = (JCObject)classInstance.Invoke("GetRelationship", id);
            return new PackageRelationship(objGetRelationship);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackageRelationshipCollection GetRelationships() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.IOException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException, system.xml.XmlException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRelationships = (JCObject)classInstance.Invoke("GetRelationships");
            return new PackageRelationshipCollection(objGetRelationships);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackageRelationshipCollection GetRelationshipsByType(java.lang.String relationshipType) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException, system.xml.XmlException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRelationshipsByType = (JCObject)classInstance.Invoke("GetRelationshipsByType", relationshipType);
            return new PackageRelationshipCollection(objGetRelationshipsByType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Close() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeletePart(Uri partUri) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.UriFormatException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.OutOfMemoryException, system.collections.generic.KeyNotFoundException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeletePart", partUri == null ? null : partUri.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeleteRelationship(java.lang.String id) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.PlatformNotSupportedException, system.xml.XmlException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeleteRelationship", id);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Flush() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.io.FileFormatException, system.IndexOutOfRangeException, system.collections.generic.KeyNotFoundException, system.FormatException, system.PlatformNotSupportedException, system.xml.XmlException, system.NotSupportedException, system.ArrayTypeMismatchException, system.security.SecurityException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Flush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public FileAccess getFileOpenAccess() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FileOpenAccess");
            return new FileAccess(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackageProperties getPackageProperties() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.io.IOException, system.io.FileFormatException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.xml.XmlException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("PackageProperties");
            return new PackageProperties(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}