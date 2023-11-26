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

package system.data.objects;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.data.entityclient.EntityConnection;
import system.data.EntityKey;
import system.data.objects.ObjectParameter;
import system.data.objects.SaveOptions;
import system.data.objects.dataclasses.IEntityWithKey;
import system.data.objects.dataclasses.IEntityWithKeyImplementation;
import system.data.objects.MergeOption;
import system.data.objects.RefreshMode;
import system.data.common.DbConnection;
import system.data.metadata.edm.MetadataWorkspace;
import system.data.objects.ObjectContextOptions;
import system.data.objects.ObjectStateManager;
import system.data.objects.ObjectMaterializedEventHandler;
import system.EventHandler;


/**
 * The base .NET class managing System.Data.Objects.ObjectContext, System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Data.Objects.ObjectContext" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Data.Objects.ObjectContext</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ObjectContext extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Data.Entity
     */
    public static final String assemblyShortName = "System.Data.Entity";
    /**
     * Qualified class name: System.Data.Objects.ObjectContext
     */
    public static final String className = "System.Data.Objects.ObjectContext";
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
    public ObjectContext(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ObjectContext}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ObjectContext} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ObjectContext cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ObjectContext(from.getJCOInstance());
    }

    // Constructors section
    
    public ObjectContext() throws Throwable {
    }

    public ObjectContext(EntityConnection connection) throws Throwable, system.ArgumentNullException, system.MulticastNotSupportedException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.data.MetadataException, system.ArgumentOutOfRangeException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(connection == null ? null : connection.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ObjectContext(java.lang.String connectionString) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException, system.data.ProviderIncompatibleException, system.data.EntityException, system.MulticastNotSupportedException, system.data.MetadataException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.globalization.CultureNotFoundException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(connectionString));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean DatabaseExists() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.data.MetadataException, system.ArgumentOutOfRangeException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.data.ProviderIncompatibleException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("DatabaseExists");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean TryGetObjectByKey(EntityKey key, JCORefOut<NetObject> value) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.collections.generic.KeyNotFoundException, system.InvalidOperationException, system.IndexOutOfRangeException, system.data.MappingException, system.data.MetadataException, system.threading.SynchronizationLockException, system.ObjectDisposedException, system.threading.LockRecursionException, system.NotImplementedException, system.NotSupportedException, system.FormatException, system.data.ProviderIncompatibleException, system.data.EntityCommandExecutionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("TryGetObjectByKey", key == null ? null : key.getJCOInstance(), value.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int ExecuteFunction(java.lang.String functionName, ObjectParameter... parameters) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.data.MappingException, system.data.MetadataException, system.threading.SynchronizationLockException, system.NotSupportedException, system.MulticastNotSupportedException, system.io.FileNotFoundException, system.PlatformNotSupportedException, system.transactions.TransactionException, system.transactions.TransactionManagerCommunicationException, system.data.EntityCommandExecutionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("ExecuteFunction", functionName, toObjectFromArray(parameters));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int ExecuteStoreCommand(java.lang.String commandText, NetObject... parameters) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.data.MappingException, system.data.MetadataException, system.threading.SynchronizationLockException, system.io.FileNotFoundException, system.NotSupportedException, system.PlatformNotSupportedException, system.transactions.TransactionException, system.transactions.TransactionManagerCommunicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("ExecuteStoreCommand", commandText, toObjectFromArray(parameters));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int SaveChanges() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.resources.MissingManifestResourceException, system.data.MetadataException, system.data.EntityException, system.collections.generic.KeyNotFoundException, system.ObjectDisposedException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("SaveChanges");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int SaveChanges(boolean acceptChangesDuringSave) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.resources.MissingManifestResourceException, system.data.MetadataException, system.data.EntityException, system.collections.generic.KeyNotFoundException, system.ObjectDisposedException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("SaveChanges", acceptChangesDuringSave);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int SaveChanges(SaveOptions options) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.data.MetadataException, system.resources.MissingManifestResourceException, system.NotSupportedException, system.data.EntityException, system.NotImplementedException, system.NullReferenceException, system.collections.generic.KeyNotFoundException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.globalization.CultureNotFoundException, system.io.FileNotFoundException, system.PlatformNotSupportedException, system.transactions.TransactionException, system.transactions.TransactionManagerCommunicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("SaveChanges", options == null ? null : options.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EntityKey CreateEntityKey(java.lang.String entitySetName, NetObject entity) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.data.MappingException, system.data.MetadataException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateEntityKey = (JCObject)classInstance.Invoke("CreateEntityKey", entitySetName, entity == null ? null : entity.getJCOInstance());
            return new EntityKey(objCreateEntityKey);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetObjectByKey(EntityKey key) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.data.MappingException, system.data.MetadataException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.NotSupportedException, system.collections.generic.KeyNotFoundException, system.FormatException, system.OutOfMemoryException, system.data.ProviderIncompatibleException, system.data.EntityCommandExecutionException, system.data.ObjectNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetObjectByKey = (JCObject)classInstance.Invoke("GetObjectByKey", key == null ? null : key.getJCOInstance());
            return new NetObject(objGetObjectByKey);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String CreateDatabaseScript() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.data.MetadataException, system.ArgumentOutOfRangeException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.data.ProviderIncompatibleException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("CreateDatabaseScript");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetType GetObjectType(NetType type) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetObjectType = (JCObject)classType.Invoke("GetObjectType", type == null ? null : type.getJCOInstance());
            return new NetType(objGetObjectType);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AcceptAllChanges() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AcceptAllChanges");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddObject(java.lang.String entitySetName, NetObject entity) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.data.MappingException, system.data.MetadataException, system.NotSupportedException, system.OutOfMemoryException, system.TypeLoadException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddObject", entitySetName, entity == null ? null : entity.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ApplyPropertyChanges(java.lang.String entitySetName, NetObject changed) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.threading.SynchronizationLockException, system.data.MappingException, system.data.MetadataException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ApplyPropertyChanges", entitySetName, changed == null ? null : changed.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Attach(IEntityWithKey entity) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.data.MappingException, system.data.MetadataException, system.NotSupportedException, system.NullReferenceException, system.threading.LockRecursionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Attach", entity == null ? null : entity.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AttachTo(java.lang.String entitySetName, NetObject entity) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.data.MappingException, system.data.MetadataException, system.NotSupportedException, system.NullReferenceException, system.OutOfMemoryException, system.TypeLoadException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AttachTo", entitySetName, entity == null ? null : entity.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CreateDatabase() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.data.MetadataException, system.ArgumentOutOfRangeException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.data.ProviderIncompatibleException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CreateDatabase");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeleteDatabase() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.data.MetadataException, system.ArgumentOutOfRangeException, system.threading.SynchronizationLockException, system.threading.LockRecursionException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.data.ProviderIncompatibleException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeleteDatabase");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DeleteObject(NetObject entity) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DeleteObject", entity == null ? null : entity.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Detach(NetObject entity) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.NullReferenceException, system.data.MetadataException, system.threading.SynchronizationLockException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Detach", entity == null ? null : entity.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DetectChanges() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.data.MetadataException, system.resources.MissingManifestResourceException, system.NotSupportedException, system.data.EntityException, system.NotImplementedException, system.NullReferenceException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DetectChanges");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable, system.ArgumentNullException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LoadProperty(NetObject entity, java.lang.String navigationProperty) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.IndexOutOfRangeException, system.data.MappingException, system.data.MetadataException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LoadProperty", entity == null ? null : entity.getJCOInstance(), navigationProperty);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void LoadProperty(NetObject entity, java.lang.String navigationProperty, MergeOption mergeOption) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.IndexOutOfRangeException, system.data.MappingException, system.data.MetadataException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("LoadProperty", entity == null ? null : entity.getJCOInstance(), navigationProperty, mergeOption == null ? null : mergeOption.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Refresh(RefreshMode refreshMode, IEnumerable collection) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.threading.SynchronizationLockException, system.data.MappingException, system.data.MetadataException, system.NullReferenceException, system.NotSupportedException, system.collections.generic.KeyNotFoundException, system.data.ProviderIncompatibleException, system.data.EntityCommandCompilationException, system.data.EntityCommandExecutionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Refresh", refreshMode == null ? null : refreshMode.getJCOInstance(), collection == null ? null : collection.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Refresh(RefreshMode refreshMode, NetObject entity) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.threading.SynchronizationLockException, system.data.MappingException, system.data.MetadataException, system.NullReferenceException, system.NotSupportedException, system.collections.generic.KeyNotFoundException, system.data.ProviderIncompatibleException, system.data.EntityCommandCompilationException, system.data.EntityCommandExecutionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Refresh", refreshMode == null ? null : refreshMode.getJCOInstance(), entity == null ? null : entity.getJCOInstance());
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
    
    public DbConnection getConnection() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Connection");
            return new DbConnection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public MetadataWorkspace getMetadataWorkspace() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("MetadataWorkspace");
            return new MetadataWorkspace(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ObjectContextOptions getContextOptions() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ContextOptions");
            return new ObjectContextOptions(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ObjectStateManager getObjectStateManager() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ObjectStateManager");
            return new ObjectStateManager(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDefaultContainerName() throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DefaultContainerName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDefaultContainerName(java.lang.String DefaultContainerName) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.data.MappingException, system.InvalidOperationException, system.data.MetadataException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DefaultContainerName", DefaultContainerName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

    public void addObjectMaterialized(ObjectMaterializedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("ObjectMaterialized", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeObjectMaterialized(ObjectMaterializedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("ObjectMaterialized", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addSavingChanges(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("SavingChanges", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeSavingChanges(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("SavingChanges", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}