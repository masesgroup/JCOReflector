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

package system.configuration;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.configuration.ProtectedConfigurationProvider;
import system.xml.XmlNode;
import system.collections.specialized.NameValueCollection;
import system.security.cryptography.RSAParameters;


/**
 * The base .NET class managing System.Configuration.RsaProtectedConfigurationProvider, System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link ProtectedConfigurationProvider}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.RsaProtectedConfigurationProvider" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Configuration.RsaProtectedConfigurationProvider</a>
 */
public class RsaProtectedConfigurationProvider extends ProtectedConfigurationProvider  {
    /**
     * Fully assembly qualified name: System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Configuration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Configuration
     */
    public static final String assemblyShortName = "System.Configuration";
    /**
     * Qualified class name: System.Configuration.RsaProtectedConfigurationProvider
     */
    public static final String className = "System.Configuration.RsaProtectedConfigurationProvider";
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

    public RsaProtectedConfigurationProvider(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link RsaProtectedConfigurationProvider}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link RsaProtectedConfigurationProvider} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static RsaProtectedConfigurationProvider cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new RsaProtectedConfigurationProvider(from.getJCOInstance());
    }

    // Constructors section
    
    public RsaProtectedConfigurationProvider() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public XmlNode Decrypt(XmlNode encryptedNode) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.security.SecurityException, system.io.IOException, system.xml.schema.XmlSchemaException, system.xml.XmlException, system.NullReferenceException, system.xml.xpath.XPathException, system.MissingMethodException, system.reflection.TargetInvocationException, system.threading.ThreadAbortException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDecrypt = (JCObject)classInstance.Invoke("Decrypt", encryptedNode == null ? null : encryptedNode.getJCOInstance());
            return new XmlNode(objDecrypt);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlNode Encrypt(XmlNode node) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.security.SecurityException, system.io.IOException, system.xml.schema.XmlSchemaException, system.xml.XmlException, system.NullReferenceException, system.PlatformNotSupportedException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objEncrypt = (JCObject)classInstance.Invoke("Encrypt", node == null ? null : node.getJCOInstance());
            return new XmlNode(objEncrypt);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddKey(int keySize, boolean exportable) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddKey", keySize, exportable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeleteKey() throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeleteKey");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ExportKey(java.lang.String xmlFileName, boolean includePrivateParameters) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.io.PathTooLongException, system.NullReferenceException, system.security.SecurityException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ExportKey", xmlFileName, includePrivateParameters);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ImportKey(java.lang.String xmlFileName, boolean exportable) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NullReferenceException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ImportKey", xmlFileName, exportable);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Initialize(java.lang.String name, NameValueCollection configurationValues) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.NotSupportedException, system.IndexOutOfRangeException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Initialize", name, configurationValues == null ? null : configurationValues.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getUseFIPS() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("UseFIPS");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getUseMachineContainer() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("UseMachineContainer");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getUseOAEP() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("UseOAEP");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RSAParameters getRsaPublicKey() throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.UnauthorizedAccessException, system.security.accesscontrol.PrivilegeNotHeldException, system.NotSupportedException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RsaPublicKey");
            return new RSAParameters(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getCspProviderName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("CspProviderName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getKeyContainerName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("KeyContainerName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}