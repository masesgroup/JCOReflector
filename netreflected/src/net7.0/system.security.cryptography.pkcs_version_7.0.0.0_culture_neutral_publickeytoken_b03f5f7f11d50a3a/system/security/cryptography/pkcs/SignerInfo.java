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

package system.security.cryptography.pkcs;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.cryptography.AsnEncodedData;
import system.security.cryptography.x509certificates.X509Certificate2Collection;
import system.security.cryptography.pkcs.CmsSigner;
import system.security.cryptography.pkcs.SignerInfo;
import system.security.cryptography.CryptographicAttributeObjectCollection;
import system.security.cryptography.Oid;
import system.security.cryptography.pkcs.SignerInfoCollection;
import system.security.cryptography.pkcs.SubjectIdentifier;
import system.security.cryptography.x509certificates.X509Certificate2;


/**
 * The base .NET class managing System.Security.Cryptography.Pkcs.SignerInfo, System.Security.Cryptography.Pkcs, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.Pkcs.SignerInfo" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.Pkcs.SignerInfo</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class SignerInfo extends NetObject  {
    /**
     * Fully assembly qualified name: System.Security.Cryptography.Pkcs, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Security.Cryptography.Pkcs, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Security.Cryptography.Pkcs
     */
    public static final String assemblyShortName = "System.Security.Cryptography.Pkcs";
    /**
     * Qualified class name: System.Security.Cryptography.Pkcs.SignerInfo
     */
    public static final String className = "System.Security.Cryptography.Pkcs.SignerInfo";
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
    public SignerInfo(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SignerInfo}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SignerInfo} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SignerInfo cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SignerInfo(from.getJCOInstance());
    }

    // Constructors section
    
    public SignerInfo() throws Throwable {
    }



    
    // Methods section
    
    public byte[] GetSignature() throws Throwable, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetSignature");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexGetSignature = 0; indexGetSignature < resultingArrayList.size(); indexGetSignature++ ) {
				resultingArray[indexGetSignature] = (byte)resultingArrayList.get(indexGetSignature);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddUnsignedAttribute(AsnEncodedData unsignedAttribute) throws Throwable, system.PlatformNotSupportedException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.ArgumentException, system.security.cryptography.CryptographicException, system.formats.asn1.AsnContentException, system.RankException, system.NotSupportedException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddUnsignedAttribute", unsignedAttribute == null ? null : unsignedAttribute.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CheckHash() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.security.cryptography.CryptographicException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ObjectDisposedException, system.formats.asn1.AsnContentException, system.ArrayTypeMismatchException, system.OverflowException, system.ArgumentNullException, system.OutOfMemoryException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CheckHash");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CheckSignature(boolean verifySignatureOnly) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.OutOfMemoryException, system.security.cryptography.CryptographicException, system.io.IOException, system.collections.generic.KeyNotFoundException, system.formats.asn1.AsnContentException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CheckSignature", verifySignatureOnly);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CheckSignature(X509Certificate2Collection extraStore, boolean verifySignatureOnly) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException, system.security.cryptography.CryptographicException, system.io.IOException, system.collections.generic.KeyNotFoundException, system.formats.asn1.AsnContentException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CheckSignature", extraStore == null ? null : extraStore.getJCOInstance(), verifySignatureOnly);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ComputeCounterSignature() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ComputeCounterSignature");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ComputeCounterSignature(CmsSigner signer) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.formats.asn1.AsnContentException, system.OverflowException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.io.IOException, system.RankException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ComputeCounterSignature", signer == null ? null : signer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveCounterSignature(int index) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.formats.asn1.AsnContentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveCounterSignature", index);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveCounterSignature(SignerInfo counterSignerInfo) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.formats.asn1.AsnContentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveCounterSignature", counterSignerInfo == null ? null : counterSignerInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveUnsignedAttribute(AsnEncodedData unsignedAttribute) throws Throwable, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.formats.asn1.AsnContentException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveUnsignedAttribute", unsignedAttribute == null ? null : unsignedAttribute.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getVersion() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Version");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CryptographicAttributeObjectCollection getSignedAttributes() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SignedAttributes");
            return new CryptographicAttributeObjectCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CryptographicAttributeObjectCollection getUnsignedAttributes() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("UnsignedAttributes");
            return new CryptographicAttributeObjectCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Oid getDigestAlgorithm() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DigestAlgorithm");
            return new Oid(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Oid getSignatureAlgorithm() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SignatureAlgorithm");
            return new Oid(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SignerInfoCollection getCounterSignerInfos() throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.formats.asn1.AsnContentException, system.ArgumentException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CounterSignerInfos");
            return new SignerInfoCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SubjectIdentifier getSignerIdentifier() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SignerIdentifier");
            return new SubjectIdentifier(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public X509Certificate2 getCertificate() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.security.cryptography.CryptographicException, system.ObjectDisposedException, system.io.IOException, system.ArgumentNullException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Certificate");
            return new X509Certificate2(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}