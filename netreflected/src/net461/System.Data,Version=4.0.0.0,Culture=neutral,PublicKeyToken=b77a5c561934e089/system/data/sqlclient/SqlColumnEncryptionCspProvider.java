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

package system.data.sqlclient;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.data.sqlclient.SqlColumnEncryptionKeyStoreProvider;


/**
 * The base .NET class managing System.Data.SqlClient.SqlColumnEncryptionCspProvider, System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Data.SqlClient.SqlColumnEncryptionCspProvider" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Data.SqlClient.SqlColumnEncryptionCspProvider</a>
 */
public class SqlColumnEncryptionCspProvider extends SqlColumnEncryptionKeyStoreProvider  {
    /**
     * Fully assembly qualified name: System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Data, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Data
     */
    public static final String assemblyShortName = "System.Data";
    /**
     * Qualified class name: System.Data.SqlClient.SqlColumnEncryptionCspProvider
     */
    public static final String className = "System.Data.SqlClient.SqlColumnEncryptionCspProvider";
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

    public SqlColumnEncryptionCspProvider(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SqlColumnEncryptionCspProvider}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SqlColumnEncryptionCspProvider} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SqlColumnEncryptionCspProvider cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SqlColumnEncryptionCspProvider(from.getJCOInstance());
    }

    // Constructors section
    
    public SqlColumnEncryptionCspProvider() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean VerifyColumnMasterKeyMetadata(java.lang.String masterKeyPath, boolean allowEnclaveComputations, byte[] signature) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("VerifyColumnMasterKeyMetadata", masterKeyPath, allowEnclaveComputations, signature);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean VerifyColumnMasterKeyMetadata(java.lang.String dupParam0, boolean dupParam1, JCORefOut dupParam2) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("VerifyColumnMasterKeyMetadata", dupParam0, dupParam1, dupParam2.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] DecryptColumnEncryptionKey(java.lang.String masterKeyPath, java.lang.String encryptionAlgorithm, byte[] encryptedColumnEncryptionKey) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.FormatException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.security.accesscontrol.PrivilegeNotHeldException, system.NullReferenceException, system.PlatformNotSupportedException, system.collections.generic.KeyNotFoundException, system.security.cryptography.CryptographicUnexpectedOperationException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("DecryptColumnEncryptionKey", masterKeyPath, encryptionAlgorithm, encryptedColumnEncryptionKey);
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexDecryptColumnEncryptionKey = 0; indexDecryptColumnEncryptionKey < resultingArrayList.size(); indexDecryptColumnEncryptionKey++ ) {
				resultingArray[indexDecryptColumnEncryptionKey] = (byte)resultingArrayList.get(indexDecryptColumnEncryptionKey);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] DecryptColumnEncryptionKey(java.lang.String dupParam0, java.lang.String dupParam1, JCORefOut dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.FormatException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.security.accesscontrol.PrivilegeNotHeldException, system.NullReferenceException, system.PlatformNotSupportedException, system.collections.generic.KeyNotFoundException, system.security.cryptography.CryptographicUnexpectedOperationException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("DecryptColumnEncryptionKey", dupParam0, dupParam1, dupParam2.getJCRefOut());
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexDecryptColumnEncryptionKey = 0; indexDecryptColumnEncryptionKey < resultingArrayList.size(); indexDecryptColumnEncryptionKey++ ) {
				resultingArray[indexDecryptColumnEncryptionKey] = (byte)resultingArrayList.get(indexDecryptColumnEncryptionKey);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] EncryptColumnEncryptionKey(java.lang.String masterKeyPath, java.lang.String encryptionAlgorithm, byte[] columnEncryptionKey) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.FormatException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.security.accesscontrol.PrivilegeNotHeldException, system.NullReferenceException, system.PlatformNotSupportedException, system.collections.generic.KeyNotFoundException, system.security.cryptography.CryptographicUnexpectedOperationException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("EncryptColumnEncryptionKey", masterKeyPath, encryptionAlgorithm, columnEncryptionKey);
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexEncryptColumnEncryptionKey = 0; indexEncryptColumnEncryptionKey < resultingArrayList.size(); indexEncryptColumnEncryptionKey++ ) {
				resultingArray[indexEncryptColumnEncryptionKey] = (byte)resultingArrayList.get(indexEncryptColumnEncryptionKey);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] EncryptColumnEncryptionKey(java.lang.String dupParam0, java.lang.String dupParam1, JCORefOut dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.FormatException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.security.cryptography.CryptographicException, system.RankException, system.OutOfMemoryException, system.security.accesscontrol.PrivilegeNotHeldException, system.NullReferenceException, system.PlatformNotSupportedException, system.collections.generic.KeyNotFoundException, system.security.cryptography.CryptographicUnexpectedOperationException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("EncryptColumnEncryptionKey", dupParam0, dupParam1, dupParam2.getJCRefOut());
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexEncryptColumnEncryptionKey = 0; indexEncryptColumnEncryptionKey < resultingArrayList.size(); indexEncryptColumnEncryptionKey++ ) {
				resultingArray[indexEncryptColumnEncryptionKey] = (byte)resultingArrayList.get(indexEncryptColumnEncryptionKey);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] SignColumnMasterKeyMetadata(java.lang.String masterKeyPath, boolean allowEnclaveComputations) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("SignColumnMasterKeyMetadata", masterKeyPath, allowEnclaveComputations);
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexSignColumnMasterKeyMetadata = 0; indexSignColumnMasterKeyMetadata < resultingArrayList.size(); indexSignColumnMasterKeyMetadata++ ) {
				resultingArray[indexSignColumnMasterKeyMetadata] = (byte)resultingArrayList.get(indexSignColumnMasterKeyMetadata);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}