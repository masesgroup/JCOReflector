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

package system.windows.xps.serialization;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.xps.serialization.BasePackagingPolicy;
import system.windows.xps.packaging.XpsDocument;
import system.windows.xps.packaging.PackageInterleavingOrder;
import system.windows.xps.serialization.XpsResourceStream;
import system.xml.XmlWriter;
import system.printing.PrintTicket;
import system.Uri;
import system.windows.xps.packaging.PackagingProgressEventHandler;


/**
 * The base .NET class managing System.Windows.Xps.Serialization.XpsPackagingPolicy, ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Xps.Serialization.XpsPackagingPolicy" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Xps.Serialization.XpsPackagingPolicy</a>
 */
public class XpsPackagingPolicy extends BasePackagingPolicy  {
    /**
     * Fully assembly qualified name: ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: ReachFramework
     */
    public static final String assemblyShortName = "ReachFramework";
    /**
     * Qualified class name: System.Windows.Xps.Serialization.XpsPackagingPolicy
     */
    public static final String className = "System.Windows.Xps.Serialization.XpsPackagingPolicy";
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

    public XpsPackagingPolicy(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link XpsPackagingPolicy}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link XpsPackagingPolicy} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static XpsPackagingPolicy cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new XpsPackagingPolicy(from.getJCOInstance());
    }

    // Constructors section
    
    public XpsPackagingPolicy() throws Throwable {
    }

    public XpsPackagingPolicy(XpsDocument xpsPackage) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.InvalidOperationException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(xpsPackage == null ? null : xpsPackage.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XpsPackagingPolicy(XpsDocument xpsPackage, PackageInterleavingOrder interleavingType) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.FormatException, system.InvalidOperationException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(xpsPackage == null ? null : xpsPackage.getJCOInstance(), interleavingType == null ? null : interleavingType.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public XpsResourceStream AcquireResourceStreamForXpsColorContext(java.lang.String resourceId) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.windows.xps.XpsSerializationException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireResourceStreamForXpsColorContext = (JCObject)classInstance.Invoke("AcquireResourceStreamForXpsColorContext", resourceId);
            return new XpsResourceStream(objAcquireResourceStreamForXpsColorContext);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XpsResourceStream AcquireResourceStreamForXpsFont() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.windows.xps.XpsSerializationException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireResourceStreamForXpsFont = (JCObject)classInstance.Invoke("AcquireResourceStreamForXpsFont");
            return new XpsResourceStream(objAcquireResourceStreamForXpsFont);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XpsResourceStream AcquireResourceStreamForXpsFont(java.lang.String resourceId) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.io.IOException, system.ArgumentException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireResourceStreamForXpsFont = (JCObject)classInstance.Invoke("AcquireResourceStreamForXpsFont", resourceId);
            return new XpsResourceStream(objAcquireResourceStreamForXpsFont);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XpsResourceStream AcquireResourceStreamForXpsImage(java.lang.String resourceId) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.windows.xps.XpsSerializationException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireResourceStreamForXpsImage = (JCObject)classInstance.Invoke("AcquireResourceStreamForXpsImage", resourceId);
            return new XpsResourceStream(objAcquireResourceStreamForXpsImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XpsResourceStream AcquireResourceStreamForXpsResourceDictionary(java.lang.String resourceId) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.windows.xps.XpsSerializationException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireResourceStreamForXpsResourceDictionary = (JCObject)classInstance.Invoke("AcquireResourceStreamForXpsResourceDictionary", resourceId);
            return new XpsResourceStream(objAcquireResourceStreamForXpsResourceDictionary);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlWriter AcquireXmlWriterForFixedDocument() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.windows.xps.XpsPackagingException, system.io.IOException, system.NotSupportedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireXmlWriterForFixedDocument = (JCObject)classInstance.Invoke("AcquireXmlWriterForFixedDocument");
            return new XmlWriter(objAcquireXmlWriterForFixedDocument);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlWriter AcquireXmlWriterForFixedDocumentSequence() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.windows.xps.XpsPackagingException, system.io.IOException, system.io.FileFormatException, system.xml.XmlException, system.io.InvalidDataException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.collections.generic.KeyNotFoundException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireXmlWriterForFixedDocumentSequence = (JCObject)classInstance.Invoke("AcquireXmlWriterForFixedDocumentSequence");
            return new XmlWriter(objAcquireXmlWriterForFixedDocumentSequence);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlWriter AcquireXmlWriterForFixedPage() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.windows.xps.XpsPackagingException, system.io.IOException, system.NotSupportedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireXmlWriterForFixedPage = (JCObject)classInstance.Invoke("AcquireXmlWriterForFixedPage");
            return new XmlWriter(objAcquireXmlWriterForFixedPage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlWriter AcquireXmlWriterForPage() throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireXmlWriterForPage = (JCObject)classInstance.Invoke("AcquireXmlWriterForPage");
            return new XmlWriter(objAcquireXmlWriterForPage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlWriter AcquireXmlWriterForResourceDictionary() throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAcquireXmlWriterForResourceDictionary = (JCObject)classInstance.Invoke("AcquireXmlWriterForResourceDictionary");
            return new XmlWriter(objAcquireXmlWriterForResourceDictionary);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PersistPrintTicket(PrintTicket printTicket) throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PersistPrintTicket", printTicket == null ? null : printTicket.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PreCommitCurrentPage() throws Throwable, system.InvalidOperationException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.ArgumentOutOfRangeException, system.io.IOException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PreCommitCurrentPage");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RelateResourceToCurrentPage(Uri targetUri, java.lang.String relationshipName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.security.SecurityException, system.UriFormatException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.io.IOException, system.io.FileFormatException, system.xml.XmlException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RelateResourceToCurrentPage", targetUri == null ? null : targetUri.getJCOInstance(), relationshipName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RelateRestrictedFontToCurrentDocument(Uri targetUri) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.io.IOException, system.ArgumentException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.FileFormatException, system.xml.XmlException, system.UriFormatException, system.OutOfMemoryException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RelateRestrictedFontToCurrentDocument", targetUri == null ? null : targetUri.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseResourceStreamForXpsColorContext() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseResourceStreamForXpsColorContext");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseResourceStreamForXpsFont() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseResourceStreamForXpsFont");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseResourceStreamForXpsFont(java.lang.String resourceId) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseResourceStreamForXpsFont", resourceId);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseResourceStreamForXpsImage() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseResourceStreamForXpsImage");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseResourceStreamForXpsResourceDictionary() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseResourceStreamForXpsResourceDictionary");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseXmlWriterForFixedDocument() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseXmlWriterForFixedDocument");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseXmlWriterForFixedDocumentSequence() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseXmlWriterForFixedDocumentSequence");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseXmlWriterForFixedPage() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.windows.xps.XpsPackagingException, system.NotSupportedException, system.io.IOException, system.IndexOutOfRangeException, system.UriFormatException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.windows.xps.XpsSerializationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseXmlWriterForFixedPage");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

    public void addPackagingProgressEvent(PackagingProgressEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("PackagingProgressEvent", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removePackagingProgressEvent(PackagingProgressEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("PackagingProgressEvent", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}