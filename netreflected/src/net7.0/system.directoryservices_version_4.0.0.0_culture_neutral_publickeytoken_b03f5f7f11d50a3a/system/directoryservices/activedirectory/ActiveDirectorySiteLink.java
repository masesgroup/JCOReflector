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

package system.directoryservices.activedirectory;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.directoryservices.activedirectory.DirectoryContext;
import system.directoryservices.activedirectory.ActiveDirectoryTransportType;
import system.directoryservices.activedirectory.ActiveDirectorySchedule;
import system.directoryservices.activedirectory.ActiveDirectorySiteLink;
import system.directoryservices.DirectoryEntry;
import system.directoryservices.activedirectory.ActiveDirectorySiteCollection;
import system.TimeSpan;


/**
 * The base .NET class managing System.DirectoryServices.ActiveDirectory.ActiveDirectorySiteLink, System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.ActiveDirectory.ActiveDirectorySiteLink" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.DirectoryServices.ActiveDirectory.ActiveDirectorySiteLink</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class ActiveDirectorySiteLink extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.DirectoryServices, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.DirectoryServices
     */
    public static final String assemblyShortName = "System.DirectoryServices";
    /**
     * Qualified class name: System.DirectoryServices.ActiveDirectory.ActiveDirectorySiteLink
     */
    public static final String className = "System.DirectoryServices.ActiveDirectory.ActiveDirectorySiteLink";
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
    public ActiveDirectorySiteLink(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ActiveDirectorySiteLink}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ActiveDirectorySiteLink} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ActiveDirectorySiteLink cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ActiveDirectorySiteLink(from.getJCOInstance());
    }

    // Constructors section
    
    public ActiveDirectorySiteLink() throws Throwable {
    }

    public ActiveDirectorySiteLink(DirectoryContext context, java.lang.String siteLinkName, ActiveDirectoryTransportType transport, ActiveDirectorySchedule schedule) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.OutOfMemoryException, system.AccessViolationException, system.security.SecurityException, system.globalization.CultureNotFoundException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.FormatException, system.security.cryptography.CryptographicException, system.NullReferenceException, system.OverflowException, system.componentmodel.InvalidEnumArgumentException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.threading.SynchronizationLockException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(context == null ? null : context.getJCOInstance(), siteLinkName, transport == null ? null : transport.getJCOInstance(), schedule == null ? null : schedule.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActiveDirectorySiteLink(DirectoryContext context, java.lang.String siteLinkName, ActiveDirectoryTransportType transport) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.OutOfMemoryException, system.AccessViolationException, system.security.SecurityException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.FormatException, system.IndexOutOfRangeException, system.NullReferenceException, system.OverflowException, system.componentmodel.InvalidEnumArgumentException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.threading.SynchronizationLockException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(context == null ? null : context.getJCOInstance(), siteLinkName, transport == null ? null : transport.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActiveDirectorySiteLink(DirectoryContext context, java.lang.String siteLinkName) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.OutOfMemoryException, system.AccessViolationException, system.security.SecurityException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.FormatException, system.IndexOutOfRangeException, system.NullReferenceException, system.OverflowException, system.componentmodel.InvalidEnumArgumentException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.threading.SynchronizationLockException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(context == null ? null : context.getJCOInstance(), siteLinkName));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public static ActiveDirectorySiteLink FindByName(DirectoryContext context, java.lang.String siteLinkName, ActiveDirectoryTransportType transport) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.OutOfMemoryException, system.AccessViolationException, system.security.SecurityException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.FormatException, system.security.cryptography.CryptographicException, system.NullReferenceException, system.OverflowException, system.componentmodel.InvalidEnumArgumentException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFindByName = (JCObject)classType.Invoke("FindByName", context == null ? null : context.getJCOInstance(), siteLinkName, transport == null ? null : transport.getJCOInstance());
            return new ActiveDirectorySiteLink(objFindByName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ActiveDirectorySiteLink FindByName(DirectoryContext context, java.lang.String siteLinkName) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.OutOfMemoryException, system.AccessViolationException, system.security.SecurityException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.FormatException, system.NullReferenceException, system.OverflowException, system.componentmodel.InvalidEnumArgumentException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFindByName = (JCObject)classType.Invoke("FindByName", context == null ? null : context.getJCOInstance(), siteLinkName);
            return new ActiveDirectorySiteLink(objFindByName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DirectoryEntry GetDirectoryEntry() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.security.cryptography.CryptographicException, system.OutOfMemoryException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetDirectoryEntry = (JCObject)classInstance.Invoke("GetDirectoryEntry");
            return new DirectoryEntry(objGetDirectoryEntry);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Delete() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.security.cryptography.CryptographicException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Delete");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable, system.NotSupportedException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Save() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.OverflowException, system.FormatException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Save");
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
    
    public boolean getDataCompressionEnabled() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DataCompressionEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDataCompressionEnabled(boolean DataCompressionEnabled) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DataCompressionEnabled", DataCompressionEnabled);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getNotificationEnabled() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("NotificationEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setNotificationEnabled(boolean NotificationEnabled) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("NotificationEnabled", NotificationEnabled);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getReciprocalReplicationEnabled() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ReciprocalReplicationEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReciprocalReplicationEnabled(boolean ReciprocalReplicationEnabled) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ReciprocalReplicationEnabled", ReciprocalReplicationEnabled);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getCost() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Cost");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCost(int Cost) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Cost", Cost);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActiveDirectorySchedule getInterSiteReplicationSchedule() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.security.SecurityException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InterSiteReplicationSchedule");
            return new ActiveDirectorySchedule(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInterSiteReplicationSchedule(ActiveDirectorySchedule InterSiteReplicationSchedule) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InterSiteReplicationSchedule", InterSiteReplicationSchedule == null ? null : InterSiteReplicationSchedule.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActiveDirectorySiteCollection getSites() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.NotImplementedException, system.OutOfMemoryException, system.AccessViolationException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.directoryservices.activedirectory.ActiveDirectoryOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Sites");
            return new ActiveDirectorySiteCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ActiveDirectoryTransportType getTransportType() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TransportType");
            return new ActiveDirectoryTransportType(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getName() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Name");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TimeSpan getReplicationInterval() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ReplicationInterval");
            return new TimeSpan(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReplicationInterval(TimeSpan ReplicationInterval) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OverflowException, system.FormatException, system.threading.LockRecursionException, system.threading.SynchronizationLockException, system.directoryservices.activedirectory.ActiveDirectoryOperationException, system.componentmodel.InvalidEnumArgumentException, system.AccessViolationException, system.OutOfMemoryException, system.directoryservices.activedirectory.ActiveDirectoryObjectNotFoundException, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ReplicationInterval", ReplicationInterval == null ? null : ReplicationInterval.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}