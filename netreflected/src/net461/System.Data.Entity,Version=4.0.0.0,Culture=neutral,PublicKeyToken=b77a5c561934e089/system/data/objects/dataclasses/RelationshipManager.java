/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

package system.data.objects.dataclasses;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.data.objects.dataclasses.IRelatedEnd;
import system.data.objects.dataclasses.IRelatedEndImplementation;
import system.data.objects.dataclasses.RelationshipManager;
import system.data.objects.dataclasses.IEntityWithRelationships;
import system.data.objects.dataclasses.IEntityWithRelationshipsImplementation;
import system.runtime.serialization.StreamingContext;


/**
 * The base .NET class managing System.Data.Objects.DataClasses.RelationshipManager, System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Data.Objects.DataClasses.RelationshipManager" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Data.Objects.DataClasses.RelationshipManager</a>
 */
public class RelationshipManager extends NetObject  {
    /**
     * Fully assembly qualified name: System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Data.Entity
     */
    public static final String assemblyShortName = "System.Data.Entity";
    /**
     * Qualified class name: System.Data.Objects.DataClasses.RelationshipManager
     */
    public static final String className = "System.Data.Objects.DataClasses.RelationshipManager";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
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

    public RelationshipManager(Object instance) throws Throwable {
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
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link RelationshipManager}, a cast assert is made to check if types are compatible.
     */
    public static RelationshipManager cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new RelationshipManager(from.getJCOInstance());
    }

    // Constructors section
    
    public RelationshipManager() throws Throwable {
    }



    
    // Methods section
    
    public IRelatedEnd GetRelatedEnd(java.lang.String relationshipName, java.lang.String targetRoleName) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.data.MappingException, system.data.MetadataException, system.NotImplementedException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRelatedEnd = (JCObject)classInstance.Invoke("GetRelatedEnd", relationshipName, targetRoleName);
            return new IRelatedEndImplementation(objGetRelatedEnd);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static RelationshipManager Create(IEntityWithRelationships owner) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", owner == null ? null : owner.getJCOInstance());
            return new RelationshipManager(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OnDeserialized(StreamingContext context) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.threading.SynchronizationLockException, system.threading.LockRecursionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OnDeserialized", context == null ? null : context.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OnSerializing(StreamingContext context) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.threading.LockRecursionException, system.ArgumentNullException, system.threading.SynchronizationLockException, system.ArgumentException, system.InvalidOperationException, system.IndexOutOfRangeException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.FormatException, system.NullReferenceException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OnSerializing", context == null ? null : context.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}