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

package system.servicemodel;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.Uri;
import system.servicemodel.channels.AddressHeader;
import system.servicemodel.EndpointIdentity;
import system.servicemodel.channels.AddressHeaderCollection;
import system.xml.XmlDictionaryReader;
import system.servicemodel.EndpointAddress;
import system.servicemodel.channels.AddressingVersion;
import system.xml.XmlDictionaryString;
import system.xml.XmlReader;
import system.servicemodel.channels.Message;
import system.xml.XmlDictionaryWriter;
import system.xml.XmlWriter;


/**
 * The base .NET class managing System.ServiceModel.EndpointAddress, System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.EndpointAddress" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.EndpointAddress</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class EndpointAddress extends NetObject  {
    /**
     * Fully assembly qualified name: System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.ServiceModel
     */
    public static final String assemblyShortName = "System.ServiceModel";
    /**
     * Qualified class name: System.ServiceModel.EndpointAddress
     */
    public static final String className = "System.ServiceModel.EndpointAddress";
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
    public EndpointAddress(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link EndpointAddress}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link EndpointAddress} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static EndpointAddress cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new EndpointAddress(from.getJCOInstance());
    }

    // Constructors section
    
    public EndpointAddress() throws Throwable {
    }

    public EndpointAddress(java.lang.String uri) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.configuration.ConfigurationException, system.UriFormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(uri));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EndpointAddress(Uri uri, AddressHeader... addressHeaders) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(uri == null ? null : uri.getJCOInstance(), toObjectFromArray(addressHeaders)));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EndpointAddress(Uri uri, EndpointIdentity identity, AddressHeader... addressHeaders) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(uri == null ? null : uri.getJCOInstance(), identity == null ? null : identity.getJCOInstance(), toObjectFromArray(addressHeaders)));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EndpointAddress(Uri uri, EndpointIdentity identity, AddressHeaderCollection headers) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.UriFormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(uri == null ? null : uri.getJCOInstance(), identity == null ? null : identity.getJCOInstance(), headers == null ? null : headers.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EndpointAddress(Uri uri, EndpointIdentity identity, AddressHeaderCollection headers, XmlDictionaryReader metadataReader, XmlDictionaryReader extensionReader) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.AccessViolationException, system.security.cryptography.CryptographicException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(uri == null ? null : uri.getJCOInstance(), identity == null ? null : identity.getJCOInstance(), headers == null ? null : headers.getJCOInstance(), metadataReader == null ? null : metadataReader.getJCOInstance(), extensionReader == null ? null : extensionReader.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public static EndpointAddress ReadFrom(AddressingVersion addressingVersion, XmlDictionaryReader reader) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.security.SecurityException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objReadFrom = (JCObject)classType.Invoke("ReadFrom", addressingVersion == null ? null : addressingVersion.getJCOInstance(), reader == null ? null : reader.getJCOInstance());
            return new EndpointAddress(objReadFrom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static EndpointAddress ReadFrom(AddressingVersion addressingVersion, XmlDictionaryReader reader, XmlDictionaryString localName, XmlDictionaryString ns) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.security.SecurityException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objReadFrom = (JCObject)classType.Invoke("ReadFrom", addressingVersion == null ? null : addressingVersion.getJCOInstance(), reader == null ? null : reader.getJCOInstance(), localName == null ? null : localName.getJCOInstance(), ns == null ? null : ns.getJCOInstance());
            return new EndpointAddress(objReadFrom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static EndpointAddress ReadFrom(AddressingVersion addressingVersion, XmlReader reader) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objReadFrom = (JCObject)classType.Invoke("ReadFrom", addressingVersion == null ? null : addressingVersion.getJCOInstance(), reader == null ? null : reader.getJCOInstance());
            return new EndpointAddress(objReadFrom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static EndpointAddress ReadFrom(AddressingVersion addressingVersion, XmlReader reader, java.lang.String localName, java.lang.String ns) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.security.SecurityException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objReadFrom = (JCObject)classType.Invoke("ReadFrom", addressingVersion == null ? null : addressingVersion.getJCOInstance(), reader == null ? null : reader.getJCOInstance(), localName, ns);
            return new EndpointAddress(objReadFrom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static EndpointAddress ReadFrom(XmlDictionaryReader reader) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objReadFrom = (JCObject)classType.Invoke("ReadFrom", reader == null ? null : reader.getJCOInstance());
            return new EndpointAddress(objReadFrom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static EndpointAddress ReadFrom(XmlDictionaryReader reader, XmlDictionaryString localName, XmlDictionaryString ns) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.UriFormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objReadFrom = (JCObject)classType.Invoke("ReadFrom", reader == null ? null : reader.getJCOInstance(), localName == null ? null : localName.getJCOInstance(), ns == null ? null : ns.getJCOInstance());
            return new EndpointAddress(objReadFrom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlDictionaryReader GetReaderAtExtensions() throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetReaderAtExtensions = (JCObject)classInstance.Invoke("GetReaderAtExtensions");
            return new XmlDictionaryReader(objGetReaderAtExtensions);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlDictionaryReader GetReaderAtMetadata() throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetReaderAtMetadata = (JCObject)classInstance.Invoke("GetReaderAtMetadata");
            return new XmlDictionaryReader(objGetReaderAtMetadata);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ApplyTo(Message message) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.xml.XmlException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ApplyTo", message == null ? null : message.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteContentsTo(AddressingVersion addressingVersion, XmlDictionaryWriter writer) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteContentsTo", addressingVersion == null ? null : addressingVersion.getJCOInstance(), writer == null ? null : writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteContentsTo(AddressingVersion addressingVersion, XmlWriter writer) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.MulticastNotSupportedException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteContentsTo", addressingVersion == null ? null : addressingVersion.getJCOInstance(), writer == null ? null : writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteTo(AddressingVersion addressingVersion, XmlDictionaryWriter writer) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.MulticastNotSupportedException, system.InvalidOperationException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteTo", addressingVersion == null ? null : addressingVersion.getJCOInstance(), writer == null ? null : writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteTo(AddressingVersion addressingVersion, XmlDictionaryWriter writer, XmlDictionaryString localName, XmlDictionaryString ns) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteTo", addressingVersion == null ? null : addressingVersion.getJCOInstance(), writer == null ? null : writer.getJCOInstance(), localName == null ? null : localName.getJCOInstance(), ns == null ? null : ns.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteTo(AddressingVersion addressingVersion, XmlWriter writer) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.MulticastNotSupportedException, system.InvalidOperationException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteTo", addressingVersion == null ? null : addressingVersion.getJCOInstance(), writer == null ? null : writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteTo(AddressingVersion addressingVersion, XmlWriter writer, java.lang.String localName, java.lang.String ns) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OverflowException, system.OutOfMemoryException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteTo", addressingVersion == null ? null : addressingVersion.getJCOInstance(), writer == null ? null : writer.getJCOInstance(), localName, ns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getIsAnonymous() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsAnonymous");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsNone() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsNone");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AddressHeaderCollection getHeaders() throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Headers");
            return new AddressHeaderCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EndpointIdentity getIdentity() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Identity");
            return new EndpointIdentity(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Uri getAnonymousUri() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.configuration.ConfigurationException, system.UriFormatException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("AnonymousUri");
            return new Uri(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Uri getNoneUri() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.configuration.ConfigurationException, system.UriFormatException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("NoneUri");
            return new Uri(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Uri getUri() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Uri");
            return new Uri(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}