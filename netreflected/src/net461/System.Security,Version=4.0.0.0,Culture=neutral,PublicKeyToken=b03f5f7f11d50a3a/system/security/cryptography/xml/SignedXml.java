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

package system.security.cryptography.xml;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.xml.XmlDocument;
import system.xml.XmlElement;
import system.security.cryptography.AsymmetricAlgorithm;
import system.security.cryptography.KeyedHashAlgorithm;
import system.security.cryptography.x509certificates.X509Certificate2;
import system.security.cryptography.xml.DataObject;
import system.security.cryptography.xml.Reference;
import system.security.cryptography.xml.EncryptedXml;
import system.security.cryptography.xml.KeyInfo;
import system.security.cryptography.xml.Signature;
import system.security.cryptography.xml.SignedInfo;
import system.xml.XmlResolver;


/**
 * The base .NET class managing System.Security.Cryptography.Xml.SignedXml, System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.Xml.SignedXml" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.Xml.SignedXml</a>
 */
public class SignedXml extends NetObject  {
    /**
     * Fully assembly qualified name: System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Security, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Security
     */
    public static final String assemblyShortName = "System.Security";
    /**
     * Qualified class name: System.Security.Cryptography.Xml.SignedXml
     */
    public static final String className = "System.Security.Cryptography.Xml.SignedXml";
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

    public SignedXml(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SignedXml}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SignedXml} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SignedXml cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SignedXml(from.getJCOInstance());
    }

    // Constructors section
    
    public SignedXml() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.InvalidOperationException, system.ApplicationException, system.NotSupportedException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.FormatException, system.NotImplementedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SignedXml(XmlDocument document) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.InvalidOperationException, system.ApplicationException, system.NotSupportedException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.FormatException, system.NotImplementedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(document == null ? null : document.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SignedXml(XmlElement elem) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.InvalidOperationException, system.ApplicationException, system.NotSupportedException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.FormatException, system.NotImplementedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(elem == null ? null : elem.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean CheckSignature() throws Throwable, system.ArgumentException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.InvalidCastException, system.NotImplementedException, system.NotSupportedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.security.cryptography.CryptographicException, system.threading.ThreadAbortException, system.MissingMethodException, system.OutOfMemoryException, system.security.SecurityException, system.RankException, system.ObjectDisposedException, system.UnauthorizedAccessException, system.io.IOException, system.ApplicationException, system.security.cryptography.CryptographicUnexpectedOperationException, system.xml.XmlException, system.NullReferenceException, system.FormatException, system.xml.xpath.XPathException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("CheckSignature");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean CheckSignature(AsymmetricAlgorithm key) throws Throwable, system.ArgumentException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.InvalidCastException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ApplicationException, system.security.cryptography.CryptographicException, system.FormatException, system.NullReferenceException, system.UriFormatException, system.xml.XmlException, system.security.cryptography.CryptographicUnexpectedOperationException, system.OutOfMemoryException, system.MissingMethodException, system.reflection.TargetInvocationException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.xml.xpath.XPathException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("CheckSignature", key == null ? null : key.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean CheckSignature(KeyedHashAlgorithm macAlg) throws Throwable, system.ArgumentException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.InvalidCastException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.security.cryptography.CryptographicException, system.FormatException, system.NullReferenceException, system.UriFormatException, system.xml.XmlException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.security.cryptography.CryptographicUnexpectedOperationException, system.OutOfMemoryException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.security.SecurityException, system.xml.xpath.XPathException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("CheckSignature", macAlg == null ? null : macAlg.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean CheckSignature(X509Certificate2 certificate, boolean verifySignatureOnly) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.security.SecurityException, system.ApplicationException, system.NotSupportedException, system.io.IOException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.OverflowException, system.FormatException, system.AccessViolationException, system.RankException, system.threading.ThreadAbortException, system.xml.XmlException, system.security.cryptography.CryptographicUnexpectedOperationException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.xml.xpath.XPathException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("CheckSignature", certificate == null ? null : certificate.getJCOInstance(), verifySignatureOnly);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlElement GetIdElement(XmlDocument document, java.lang.String idValue) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ArgumentException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.security.cryptography.CryptographicException, system.xml.xpath.XPathException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetIdElement = (JCObject)classInstance.Invoke("GetIdElement", document == null ? null : document.getJCOInstance(), idValue);
            return new XmlElement(objGetIdElement);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlElement GetXml() throws Throwable, system.ArgumentOutOfRangeException, system.NullReferenceException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentException, system.xml.XmlException, system.ObjectDisposedException, system.RankException, system.security.cryptography.CryptographicException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ApplicationException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.cryptography.CryptographicUnexpectedOperationException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetXml = (JCObject)classInstance.Invoke("GetXml");
            return new XmlElement(objGetXml);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddObject(DataObject dataObject) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddObject", dataObject == null ? null : dataObject.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddReference(Reference reference) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddReference", reference == null ? null : reference.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ComputeSignature() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.ArgumentOutOfRangeException, system.OverflowException, system.FormatException, system.NotImplementedException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.RankException, system.InvalidOperationException, system.xml.XmlException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ApplicationException, system.security.cryptography.CryptographicException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.xml.xpath.XPathException, system.OutOfMemoryException, system.InvalidCastException, system.globalization.CultureNotFoundException, system.MissingMethodException, system.security.cryptography.CryptographicUnexpectedOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ComputeSignature");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ComputeSignature(KeyedHashAlgorithm macAlg) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.TypeLoadException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.security.cryptography.CryptographicException, system.FormatException, system.OverflowException, system.RankException, system.NullReferenceException, system.xml.XmlException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.InvalidCastException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.ApplicationException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.xml.xpath.XPathException, system.OutOfMemoryException, system.security.cryptography.CryptographicUnexpectedOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ComputeSignature", macAlg == null ? null : macAlg.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LoadXml(XmlElement value) throws Throwable, system.ArgumentNullException, system.NullReferenceException, system.ArgumentException, system.TypeLoadException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.security.cryptography.CryptographicException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.xpath.XPathException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LoadXml", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public byte[] getSignatureValue() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("SignatureValue");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
			for(int indexSignatureValue = 0; indexSignatureValue < resultingArrayList.size(); indexSignatureValue++ ) {
				resultingArray[indexSignatureValue] = (byte)resultingArrayList.get(indexSignatureValue);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AsymmetricAlgorithm getSigningKey() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SigningKey");
            return new AsymmetricAlgorithm(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSigningKey(AsymmetricAlgorithm SigningKey) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SigningKey", SigningKey == null ? null : SigningKey.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EncryptedXml getEncryptedXml() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("EncryptedXml");
            return new EncryptedXml(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEncryptedXml(EncryptedXml EncryptedXml) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EncryptedXml", EncryptedXml == null ? null : EncryptedXml.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public KeyInfo getKeyInfo() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("KeyInfo");
            return new KeyInfo(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setKeyInfo(KeyInfo KeyInfo) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("KeyInfo", KeyInfo == null ? null : KeyInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Signature getSignature() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Signature");
            return new Signature(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SignedInfo getSignedInfo() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SignedInfo");
            return new SignedInfo(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSignatureLength() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("SignatureLength");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSignatureMethod() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("SignatureMethod");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSigningKeyName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("SigningKeyName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSigningKeyName(java.lang.String SigningKeyName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SigningKeyName", SigningKeyName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setResolver(XmlResolver Resolver) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Resolver", Resolver == null ? null : Resolver.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}