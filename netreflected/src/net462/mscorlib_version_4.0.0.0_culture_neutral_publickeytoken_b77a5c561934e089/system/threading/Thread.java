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

package system.threading;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.runtime.constrainedexecution.CriticalFinalizerObject;
import system.threading.ParameterizedThreadStart;
import system.threading.ThreadStart;
import system.TimeSpan;
import system.threading.ApartmentState;
import system.AppDomain;
import system.LocalDataStoreSlot;
import system.threading.CompressedStack;
import system.SByte;
import system.Single;
import system.UInt16;
import system.UInt32;
import system.UInt64;
import system.Guid;
import system.globalization.CultureInfo;
import system.runtime.remoting.contexts.Context;
import system.security.principal.IPrincipal;
import system.security.principal.IPrincipalImplementation;
import system.threading.ExecutionContext;
import system.threading.Thread;
import system.threading.ThreadPriority;
import system.threading.ThreadState;


/**
 * The base .NET class managing System.Threading.Thread, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Threading.Thread" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Threading.Thread</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class Thread extends CriticalFinalizerObject  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Threading.Thread
     */
    public static final String className = "System.Threading.Thread";
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
    public Thread(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Thread}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Thread} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Thread cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Thread(from.getJCOInstance());
    }

    // Constructors section
    
    public Thread() throws Throwable {
    }

    public Thread(ParameterizedThreadStart start) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(start));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Thread(ParameterizedThreadStart start, int maxStackSize) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(start, maxStackSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Thread(ThreadStart start) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(start));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Thread(ThreadStart start, int maxStackSize) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.SecurityException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(start, maxStackSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Join(int millisecondsTimeout) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Join", millisecondsTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Join(TimeSpan timeout) throws Throwable, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Join", timeout == null ? null : timeout.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean TrySetApartmentState(ApartmentState state) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("TrySetApartmentState", state == null ? null : state.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean Yield() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("Yield");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int GetDomainID() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("GetDomainID");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static AppDomain GetDomain() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetDomain = (JCObject)classType.Invoke("GetDomain");
            return new AppDomain(objGetDomain);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static LocalDataStoreSlot AllocateDataSlot() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAllocateDataSlot = (JCObject)classType.Invoke("AllocateDataSlot");
            return new LocalDataStoreSlot(objAllocateDataSlot);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static LocalDataStoreSlot AllocateNamedDataSlot(java.lang.String name) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAllocateNamedDataSlot = (JCObject)classType.Invoke("AllocateNamedDataSlot", name);
            return new LocalDataStoreSlot(objAllocateNamedDataSlot);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static LocalDataStoreSlot GetNamedDataSlot(java.lang.String name) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetNamedDataSlot = (JCObject)classType.Invoke("GetNamedDataSlot", name);
            return new LocalDataStoreSlot(objGetNamedDataSlot);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetData(LocalDataStoreSlot slot) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetData = (JCObject)classType.Invoke("GetData", slot == null ? null : slot.getJCOInstance());
            return new NetObject(objGetData);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ApartmentState GetApartmentState() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetApartmentState = (JCObject)classInstance.Invoke("GetApartmentState");
            return new ApartmentState(objGetApartmentState);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompressedStack GetCompressedStack() throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetCompressedStack = (JCObject)classInstance.Invoke("GetCompressedStack");
            return new CompressedStack(objGetCompressedStack);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Abort() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Abort");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Abort(NetObject stateInfo) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Abort", stateInfo == null ? null : stateInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void BeginCriticalRegion() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("BeginCriticalRegion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void BeginThreadAffinity() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("BeginThreadAffinity");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DisableComObjectEagerCleanup() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DisableComObjectEagerCleanup");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EndCriticalRegion() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EndCriticalRegion");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void EndThreadAffinity() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("EndThreadAffinity");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void FreeNamedDataSlot(java.lang.String name) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("FreeNamedDataSlot", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Interrupt() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Interrupt");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Join() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Join");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void MemoryBarrier() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("MemoryBarrier");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ResetAbort() throws Throwable, system.threading.ThreadStateException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ResetAbort");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Resume() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Resume");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetApartmentState(ApartmentState state) throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetApartmentState", state == null ? null : state.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetCompressedStack(CompressedStack stack) throws Throwable, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetCompressedStack", stack == null ? null : stack.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetData(LocalDataStoreSlot slot, NetObject data) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetData", slot == null ? null : slot.getJCOInstance(), data == null ? null : data.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Sleep(int millisecondsTimeout) throws Throwable, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Sleep", millisecondsTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Sleep(TimeSpan timeout) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Sleep", timeout == null ? null : timeout.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SpinWait(int iterations) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SpinWait", iterations);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Start() throws Throwable, system.security.SecurityException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Start");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Start(NetObject parameter) throws Throwable, system.InvalidOperationException, system.security.SecurityException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Start", parameter == null ? null : parameter.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Suspend() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Suspend");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<java.util.concurrent.atomic.AtomicReference<java.lang.Byte>> address, byte value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<java.util.concurrent.atomic.AtomicReference<java.lang.Double>> address, double value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<java.util.concurrent.atomic.AtomicReference<java.lang.Short>> address, short value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<java.util.concurrent.atomic.AtomicInteger> address, int value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<java.util.concurrent.atomic.AtomicLong> address, long value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<SByte> address, SByte value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<Single> address, Single value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<NetObject> address, NetObject value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<UInt16> address, UInt16 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<UInt32> address, UInt32 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void VolatileWrite(JCORefOut<UInt64> address, UInt64 value) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("VolatileWrite", address.getJCRefOut(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static To_Thread method available in _Thread to obtain an object with an invocable method
     */
    @Deprecated 
    public void GetTypeInfoCount(JCORefOut<UInt32> pcTInfo) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use To_Thread to obtain the full interface.");
    }


    
    // Properties section
    
    public boolean getIsAlive() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsAlive");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsBackground() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsBackground");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIsBackground(boolean IsBackground) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IsBackground", IsBackground);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsThreadPoolThread() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsThreadPoolThread");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getManagedThreadId() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ManagedThreadId");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CultureInfo getCurrentCulture() throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.InvalidOperationException, system.ArgumentException, system.security.SecurityException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CurrentCulture");
            return new CultureInfo(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCurrentCulture(CultureInfo CurrentCulture) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.security.SecurityException, system.ArgumentOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CurrentCulture", CurrentCulture == null ? null : CurrentCulture.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CultureInfo getCurrentUICulture() throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.InvalidOperationException, system.ArgumentException, system.security.SecurityException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CurrentUICulture");
            return new CultureInfo(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCurrentUICulture(CultureInfo CurrentUICulture) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CurrentUICulture", CurrentUICulture == null ? null : CurrentUICulture.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Context getCurrentContext() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("CurrentContext");
            return new Context(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IPrincipal getCurrentPrincipal() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.security.SecurityException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("CurrentPrincipal");
            return new IPrincipalImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setCurrentPrincipal(IPrincipal CurrentPrincipal) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.security.SecurityException, system.ArgumentOutOfRangeException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("CurrentPrincipal", CurrentPrincipal == null ? null : CurrentPrincipal.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Name");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setName(java.lang.String Name) throws Throwable, system.ArgumentException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Name", Name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ApartmentState getApartmentState() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ApartmentState");
            return new ApartmentState(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setApartmentState(ApartmentState ApartmentState) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ApartmentState", ApartmentState == null ? null : ApartmentState.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ExecutionContext getExecutionContext() throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.security.SecurityException, system.ArgumentOutOfRangeException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ExecutionContext");
            return new ExecutionContext(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Thread getCurrentThread() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("CurrentThread");
            return new Thread(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ThreadPriority getPriority() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Priority");
            return new ThreadPriority(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPriority(ThreadPriority Priority) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Priority", Priority == null ? null : Priority.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ThreadState getThreadState() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ThreadState");
            return new ThreadState(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}