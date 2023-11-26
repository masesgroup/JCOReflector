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

package system;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.WeakReference;
import system.GCNotificationStatus;
import system.GCCollectionMode;


/**
 * The base .NET class managing System.GC, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.GC" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.GC</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class GC extends NetObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.GC
     */
    public static final String className = "System.GC";
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
    public GC(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link GC}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link GC} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static GC cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new GC(from.getJCOInstance());
    }

    // Constructors section
    
    public GC() throws Throwable {
    }

    
    // Methods section
    
    public static boolean TryStartNoGCRegion(long totalSize) throws Throwable, system.ArgumentOutOfRangeException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryStartNoGCRegion", totalSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryStartNoGCRegion(long totalSize, boolean disallowFullBlockingGC) throws Throwable, system.ArgumentOutOfRangeException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryStartNoGCRegion", totalSize, disallowFullBlockingGC);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryStartNoGCRegion(long totalSize, long lohSize) throws Throwable, system.ArgumentOutOfRangeException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryStartNoGCRegion", totalSize, lohSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean TryStartNoGCRegion(long totalSize, long lohSize, boolean disallowFullBlockingGC) throws Throwable, system.ArgumentOutOfRangeException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("TryStartNoGCRegion", totalSize, lohSize, disallowFullBlockingGC);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int CollectionCount(int generation) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("CollectionCount", generation);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int GetGeneration(NetObject obj) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("GetGeneration", obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int GetGeneration(WeakReference wo) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("GetGeneration", wo == null ? null : wo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static long GetAllocatedBytesForCurrentThread() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (long)classType.Invoke("GetAllocatedBytesForCurrentThread");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static long GetTotalMemory(boolean forceFullCollection) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (long)classType.Invoke("GetTotalMemory", forceFullCollection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static GCNotificationStatus WaitForFullGCApproach() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objWaitForFullGCApproach = (JCObject)classType.Invoke("WaitForFullGCApproach");
            return new GCNotificationStatus(objWaitForFullGCApproach);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static GCNotificationStatus WaitForFullGCApproach(int millisecondsTimeout) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objWaitForFullGCApproach = (JCObject)classType.Invoke("WaitForFullGCApproach", millisecondsTimeout);
            return new GCNotificationStatus(objWaitForFullGCApproach);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static GCNotificationStatus WaitForFullGCComplete() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objWaitForFullGCComplete = (JCObject)classType.Invoke("WaitForFullGCComplete");
            return new GCNotificationStatus(objWaitForFullGCComplete);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static GCNotificationStatus WaitForFullGCComplete(int millisecondsTimeout) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objWaitForFullGCComplete = (JCObject)classType.Invoke("WaitForFullGCComplete", millisecondsTimeout);
            return new GCNotificationStatus(objWaitForFullGCComplete);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddMemoryPressure(long bytesAllocated) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddMemoryPressure", bytesAllocated);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void CancelFullGCNotification() throws Throwable, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("CancelFullGCNotification");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Collect() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Collect");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Collect(int generation) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Collect", generation);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Collect(int generation, GCCollectionMode mode) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Collect", generation, mode == null ? null : mode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Collect(int generation, GCCollectionMode mode, boolean blocking) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Collect", generation, mode == null ? null : mode.getJCOInstance(), blocking);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Collect(int generation, GCCollectionMode mode, boolean blocking, boolean compacting) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Collect", generation, mode == null ? null : mode.getJCOInstance(), blocking, compacting);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EndNoGCRegion() throws Throwable, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EndNoGCRegion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void KeepAlive(NetObject obj) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("KeepAlive", obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RegisterForFullGCNotification(int maxGenerationThreshold, int largeObjectHeapThreshold) throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RegisterForFullGCNotification", maxGenerationThreshold, largeObjectHeapThreshold);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemoveMemoryPressure(long bytesAllocated) throws Throwable, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemoveMemoryPressure", bytesAllocated);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ReRegisterForFinalize(NetObject obj) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ReRegisterForFinalize", obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SuppressFinalize(NetObject obj) throws Throwable, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SuppressFinalize", obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WaitForPendingFinalizers() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WaitForPendingFinalizers");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static int getMaxGeneration() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Get("MaxGeneration");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}