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

package system.io.packaging;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.packaging.VerifyResult;
import system.security.cryptography.x509certificates.X509Certificate;
import system.DateTime;
import system.io.packaging.CertificateEmbeddingOption;
import system.io.packaging.PackagePart;
import system.security.cryptography.xml.Signature;


/**
 * The base .NET class managing System.IO.Packaging.PackageDigitalSignature, WindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.Packaging.PackageDigitalSignature" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.Packaging.PackageDigitalSignature</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class PackageDigitalSignature extends NetObject  {
    /**
     * Fully assembly qualified name: WindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "WindowsBase, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: WindowsBase
     */
    public static final String assemblyShortName = "WindowsBase";
    /**
     * Qualified class name: System.IO.Packaging.PackageDigitalSignature
     */
    public static final String className = "System.IO.Packaging.PackageDigitalSignature";
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
    public PackageDigitalSignature(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link PackageDigitalSignature}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link PackageDigitalSignature} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static PackageDigitalSignature cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new PackageDigitalSignature(from.getJCOInstance());
    }

    // Constructors section
    
    public PackageDigitalSignature() throws Throwable {
    }



    
    // Methods section
    
    public VerifyResult Verify() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.io.IOException, system.io.FileFormatException, system.xml.XmlException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.security.cryptography.CryptographicException, system.xml.schema.XmlSchemaException, system.RankException, system.ArrayTypeMismatchException, system.xml.xpath.XPathException, system.FormatException, system.OverflowException, system.TypeLoadException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objVerify = (JCObject)classInstance.Invoke("Verify");
            return new VerifyResult(objVerify);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public VerifyResult Verify(X509Certificate signingCertificate) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.io.IOException, system.NotSupportedException, system.io.FileFormatException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.xml.xpath.XPathException, system.OverflowException, system.FormatException, system.TypeLoadException, system.security.cryptography.CryptographicUnexpectedOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objVerify = (JCObject)classInstance.Invoke("Verify", signingCertificate == null ? null : signingCertificate.getJCOInstance());
            return new VerifyResult(objVerify);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public byte[] getSignatureValue() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.FormatException, system.io.IOException, system.RankException, system.ArrayTypeMismatchException, system.NotSupportedException, system.security.SecurityException, system.io.FileFormatException, system.xml.schema.XmlSchemaException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.xml.xpath.XPathException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("SignatureValue");
            for (java.lang.Object resultingObject : resultingObjects) {
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

    public DateTime getSigningTime() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.io.IOException, system.NotSupportedException, system.io.FileFormatException, system.xml.schema.XmlSchemaException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.IndexOutOfRangeException, system.xml.xpath.XPathException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SigningTime");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CertificateEmbeddingOption getCertificateEmbeddingOption() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.io.IOException, system.ArgumentOutOfRangeException, system.collections.generic.KeyNotFoundException, system.io.FileFormatException, system.xml.XmlException, system.UriFormatException, system.NotSupportedException, system.security.cryptography.CryptographicException, system.xml.schema.XmlSchemaException, system.xml.xpath.XPathException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CertificateEmbeddingOption");
            return new CertificateEmbeddingOption(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PackagePart getSignaturePart() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SignaturePart");
            return new PackagePart(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public X509Certificate getSigner() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.io.IOException, system.io.FileFormatException, system.xml.XmlException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.security.cryptography.CryptographicException, system.FormatException, system.xml.schema.XmlSchemaException, system.xml.xpath.XPathException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Signer");
            return new X509Certificate(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Signature getSignature() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.FormatException, system.io.IOException, system.RankException, system.ArrayTypeMismatchException, system.NotSupportedException, system.security.SecurityException, system.io.FileFormatException, system.xml.schema.XmlSchemaException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.xml.xpath.XPathException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Signature");
            return new Signature(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSignature(Signature Signature) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.io.IOException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.NotSupportedException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.security.cryptography.CryptographicUnexpectedOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Signature", Signature == null ? null : Signature.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSignatureType() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("SignatureType");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTimeFormat() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.io.IOException, system.NotSupportedException, system.io.FileFormatException, system.xml.schema.XmlSchemaException, system.xml.XmlException, system.security.cryptography.CryptographicException, system.IndexOutOfRangeException, system.xml.xpath.XPathException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("TimeFormat");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}