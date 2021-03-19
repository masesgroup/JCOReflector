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

package system.threading;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.threading.CancellationToken;
import system.TimeSpan;
import system.threading.WaitHandle;


/**
 * The base .NET class managing System.Threading.CountdownEvent, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Threading.CountdownEvent" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Threading.CountdownEvent</a>
 */
public class CountdownEvent extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Threading.CountdownEvent
     */
    public static final String className = "System.Threading.CountdownEvent";
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

    public CountdownEvent(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link CountdownEvent}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link CountdownEvent} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static CountdownEvent cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new CountdownEvent(from.getJCOInstance());
    }

    // Constructors section
    
    public CountdownEvent() throws Throwable {
    }

    public CountdownEvent(int initialCount) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(initialCount));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Signal() throws Throwable, system.ObjectDisposedException, system.InvalidOperationException, system.threading.AbandonedMutexException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Signal");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Signal(int signalCount) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.diagnostics.tracing.EventSourceException, system.ArgumentNullException, system.OutOfMemoryException, system.ArgumentException, system.NotSupportedException, system.threading.AbandonedMutexException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Signal", signalCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean TryAddCount() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.InvalidOperationException, system.diagnostics.tracing.EventSourceException, system.ArgumentNullException, system.OutOfMemoryException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("TryAddCount");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean TryAddCount(int signalCount) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.diagnostics.tracing.EventSourceException, system.ArgumentNullException, system.OutOfMemoryException, system.ArgumentException, system.NotSupportedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("TryAddCount", signalCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Wait(int millisecondsTimeout) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.NullReferenceException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Wait", millisecondsTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Wait(int millisecondsTimeout, CancellationToken cancellationToken) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.security.SecurityException, system.NullReferenceException, system.OutOfMemoryException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Wait", millisecondsTimeout, cancellationToken == null ? null : cancellationToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Wait(TimeSpan timeout) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.NullReferenceException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Wait", timeout == null ? null : timeout.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Wait(TimeSpan timeout, CancellationToken cancellationToken) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.NullReferenceException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Wait", timeout == null ? null : timeout.getJCOInstance(), cancellationToken == null ? null : cancellationToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddCount() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.InvalidOperationException, system.diagnostics.tracing.EventSourceException, system.ArgumentNullException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddCount");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddCount(int signalCount) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.InvalidOperationException, system.diagnostics.tracing.EventSourceException, system.ArgumentNullException, system.OutOfMemoryException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddCount", signalCount);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable, system.ArgumentException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Reset() throws Throwable, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.threading.AbandonedMutexException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Reset");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Reset(int count) throws Throwable, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.threading.AbandonedMutexException, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Reset", count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Wait() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.NullReferenceException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Wait");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Wait(CancellationToken cancellationToken) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.NullReferenceException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Wait", cancellationToken == null ? null : cancellationToken.getJCOInstance());
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
    
    public boolean getIsSet() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsSet");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getCurrentCount() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("CurrentCount");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getInitialCount() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("InitialCount");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WaitHandle getWaitHandle() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.threading.WaitHandleCannotBeOpenedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("WaitHandle");
            return new WaitHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}