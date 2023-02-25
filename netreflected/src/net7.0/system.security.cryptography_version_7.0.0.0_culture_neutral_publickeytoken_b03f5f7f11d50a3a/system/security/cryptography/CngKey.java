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

package system.security.cryptography;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.cryptography.CngProvider;
import system.security.cryptography.CngKeyOpenOptions;
import system.security.cryptography.CngPropertyOptions;
import system.security.cryptography.CngKeyBlobFormat;
import system.security.cryptography.CngKey;
import system.security.cryptography.CngAlgorithm;
import system.security.cryptography.CngKeyCreationParameters;
import microsoft.win32.safehandles.SafeNCryptKeyHandle;
import system.security.cryptography.CngKeyHandleOpenOptions;
import system.security.cryptography.CngProperty;
import microsoft.win32.safehandles.SafeNCryptProviderHandle;
import system.security.cryptography.CngAlgorithmGroup;
import system.security.cryptography.CngExportPolicies;
import system.security.cryptography.CngKeyUsages;
import system.security.cryptography.CngUIPolicy;


/**
 * The base .NET class managing System.Security.Cryptography.CngKey, System.Security.Cryptography, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.CngKey" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.CngKey</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class CngKey extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: System.Security.Cryptography, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Security.Cryptography, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Security.Cryptography
     */
    public static final String assemblyShortName = "System.Security.Cryptography";
    /**
     * Qualified class name: System.Security.Cryptography.CngKey
     */
    public static final String className = "System.Security.Cryptography.CngKey";
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
    public CngKey(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link CngKey}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link CngKey} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static CngKey cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new CngKey(from.getJCOInstance());
    }

    // Constructors section
    
    public CngKey() throws Throwable {
    }



    
    // Methods section
    
    public static boolean Exists(java.lang.String keyName, CngProvider provider, CngKeyOpenOptions options) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("Exists", keyName, provider == null ? null : provider.getJCOInstance(), options == null ? null : options.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean Exists(java.lang.String keyName, CngProvider provider) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("Exists", keyName, provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean Exists(java.lang.String keyName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("Exists", keyName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean HasProperty(java.lang.String name, CngPropertyOptions options) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("HasProperty", name, options == null ? null : options.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] Export(CngKeyBlobFormat format) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("Export", format == null ? null : format.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexExport = 0; indexExport < resultingArrayList.size(); indexExport++ ) {
				resultingArray[indexExport] = (byte)resultingArrayList.get(indexExport);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Create(CngAlgorithm algorithm, java.lang.String keyName, CngKeyCreationParameters creationParameters) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", algorithm == null ? null : algorithm.getJCOInstance(), keyName, creationParameters == null ? null : creationParameters.getJCOInstance());
            return new CngKey(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Create(CngAlgorithm algorithm, java.lang.String keyName) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", algorithm == null ? null : algorithm.getJCOInstance(), keyName);
            return new CngKey(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Create(CngAlgorithm algorithm) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", algorithm == null ? null : algorithm.getJCOInstance());
            return new CngKey(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Import(byte[] keyBlob, CngKeyBlobFormat format, CngProvider provider) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.OutOfMemoryException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objImport = (JCObject)classType.Invoke("Import", keyBlob, format == null ? null : format.getJCOInstance(), provider == null ? null : provider.getJCOInstance());
            return new CngKey(objImport);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Import(JCORefOut dupParam0, CngKeyBlobFormat dupParam1, CngProvider dupParam2) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.OutOfMemoryException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objImport = (JCObject)classType.Invoke("Import", dupParam0.getJCRefOut(), dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2 == null ? null : dupParam2.getJCOInstance());
            return new CngKey(objImport);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Import(byte[] keyBlob, CngKeyBlobFormat format) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objImport = (JCObject)classType.Invoke("Import", keyBlob, format == null ? null : format.getJCOInstance());
            return new CngKey(objImport);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Import(JCORefOut dupParam0, CngKeyBlobFormat dupParam1) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objImport = (JCObject)classType.Invoke("Import", dupParam0.getJCRefOut(), dupParam1 == null ? null : dupParam1.getJCOInstance());
            return new CngKey(objImport);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Open(SafeNCryptKeyHandle keyHandle, CngKeyHandleOpenOptions keyHandleOpenOptions) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", keyHandle == null ? null : keyHandle.getJCOInstance(), keyHandleOpenOptions == null ? null : keyHandleOpenOptions.getJCOInstance());
            return new CngKey(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Open(java.lang.String keyName, CngProvider provider, CngKeyOpenOptions openOptions) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", keyName, provider == null ? null : provider.getJCOInstance(), openOptions == null ? null : openOptions.getJCOInstance());
            return new CngKey(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Open(java.lang.String keyName, CngProvider provider) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", keyName, provider == null ? null : provider.getJCOInstance());
            return new CngKey(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CngKey Open(java.lang.String keyName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objOpen = (JCObject)classType.Invoke("Open", keyName);
            return new CngKey(objOpen);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngProperty GetProperty(java.lang.String name, CngPropertyOptions options) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetProperty = (JCObject)classInstance.Invoke("GetProperty", name, options == null ? null : options.getJCOInstance());
            return new CngProperty(objGetProperty);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Delete() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Delete");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetProperty(CngProperty property) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.security.cryptography.CryptographicException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetProperty", property == null ? null : property.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void close() throws Exception {
        try {
            if (classInstance == null)
                throw new UnsupportedOperationException("classInstance is null.");
            try {
                classInstance.Invoke("Dispose");
            }
            catch (JCNativeException jcne) {
                throw translateException(jcne);
            }
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }
    
    // Properties section
    
    public boolean getIsEphemeral() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsEphemeral");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIsEphemeral(boolean IsEphemeral) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IsEphemeral", IsEphemeral);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsMachineKey() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsMachineKey");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getKeySize() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("KeySize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SafeNCryptKeyHandle getHandle() throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.ArgumentNullException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Handle");
            return new SafeNCryptKeyHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SafeNCryptProviderHandle getProviderHandle() throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.ArgumentNullException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ProviderHandle");
            return new SafeNCryptProviderHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngAlgorithm getAlgorithm() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Algorithm");
            return new CngAlgorithm(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngAlgorithmGroup getAlgorithmGroup() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("AlgorithmGroup");
            return new CngAlgorithmGroup(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngExportPolicies getExportPolicy() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ExportPolicy");
            return new CngExportPolicies(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExportPolicy(CngExportPolicies ExportPolicy) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ExportPolicy", ExportPolicy == null ? null : ExportPolicy.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngKeyUsages getKeyUsage() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("KeyUsage");
            return new CngKeyUsages(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngProvider getProvider() throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Provider");
            return new CngProvider(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CngUIPolicy getUIPolicy() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("UIPolicy");
            return new CngUIPolicy(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getKeyName() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("KeyName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getUniqueName() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.security.cryptography.CryptographicException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("UniqueName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}