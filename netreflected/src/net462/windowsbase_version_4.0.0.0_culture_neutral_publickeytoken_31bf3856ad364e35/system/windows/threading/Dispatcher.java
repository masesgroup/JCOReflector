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

package system.windows.threading;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.threading.DispatcherPriority;
import system.TimeSpan;
import system.windows.threading.Dispatcher;
import system.threading.Thread;
import system.windows.threading.DispatcherOperation;
import system.Action;
import system.threading.CancellationToken;
import system.windows.threading.DispatcherPriorityAwaitable;
import system.windows.threading.DispatcherProcessingDisabled;
import system.windows.threading.DispatcherFrame;
import system.windows.threading.DispatcherHooks;
import system.EventHandler;
import system.windows.threading.DispatcherUnhandledExceptionEventHandler;
import system.windows.threading.DispatcherUnhandledExceptionFilterEventHandler;


/**
 * The base .NET class managing System.Windows.Threading.Dispatcher, WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Threading.Dispatcher" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Threading.Dispatcher</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class Dispatcher extends NetObject  {
    /**
     * Fully assembly qualified name: WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "WindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: WindowsBase
     */
    public static final String assemblyShortName = "WindowsBase";
    /**
     * Qualified class name: System.Windows.Threading.Dispatcher
     */
    public static final String className = "System.Windows.Threading.Dispatcher";
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
    public Dispatcher(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Dispatcher}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Dispatcher} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Dispatcher cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Dispatcher(from.getJCOInstance());
    }

    // Constructors section
    
    public Dispatcher() throws Throwable {
    }



    
    // Methods section
    
    public boolean CheckAccess() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("CheckAccess");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Dispatcher FromThread(Thread thread) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromThread = (JCObject)classType.Invoke("FromThread", thread == null ? null : thread.getJCOInstance());
            return new Dispatcher(objFromThread);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DispatcherOperation InvokeAsync(Action callback) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException, system.InvalidCastException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objInvokeAsync = (JCObject)classInstance.Invoke("InvokeAsync", callback);
            return new DispatcherOperation(objInvokeAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DispatcherOperation InvokeAsync(Action callback, DispatcherPriority priority) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException, system.InvalidCastException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objInvokeAsync = (JCObject)classInstance.Invoke("InvokeAsync", callback, priority == null ? null : priority.getJCOInstance());
            return new DispatcherOperation(objInvokeAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DispatcherOperation InvokeAsync(Action callback, DispatcherPriority priority, CancellationToken cancellationToken) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotImplementedException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.NullReferenceException, system.NotSupportedException, system.OverflowException, system.componentmodel.Win32Exception, system.InvalidCastException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objInvokeAsync = (JCObject)classInstance.Invoke("InvokeAsync", callback, priority == null ? null : priority.getJCOInstance(), cancellationToken == null ? null : cancellationToken.getJCOInstance());
            return new DispatcherOperation(objInvokeAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DispatcherPriorityAwaitable Yield() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objYield = (JCObject)classType.Invoke("Yield");
            return new DispatcherPriorityAwaitable(objYield);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static DispatcherPriorityAwaitable Yield(DispatcherPriority priority) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotImplementedException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objYield = (JCObject)classType.Invoke("Yield", priority == null ? null : priority.getJCOInstance());
            return new DispatcherPriorityAwaitable(objYield);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DispatcherProcessingDisabled DisableProcessing() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDisableProcessing = (JCObject)classInstance.Invoke("DisableProcessing");
            return new DispatcherProcessingDisabled(objDisableProcessing);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void BeginInvokeShutdown(DispatcherPriority priority) throws Throwable, system.ArgumentException, system.NullReferenceException, system.ArgumentNullException, system.componentmodel.Win32Exception, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("BeginInvokeShutdown", priority == null ? null : priority.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ExitAllFrames() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.OverflowException, system.TimeoutException, system.security.SecurityException, system.InvalidCastException, system.PlatformNotSupportedException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ExitAllFrames");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Invoke(Action callback) throws Throwable, system.ArgumentException, system.OverflowException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.security.SecurityException, system.NullReferenceException, system.componentmodel.Win32Exception, system.InvalidCastException, system.MulticastNotSupportedException, system.threading.WaitHandleCannotBeOpenedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.TimeoutException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Invoke", callback);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Invoke(Action callback, DispatcherPriority priority) throws Throwable, system.ArgumentException, system.OverflowException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.security.SecurityException, system.NullReferenceException, system.componentmodel.Win32Exception, system.InvalidCastException, system.MulticastNotSupportedException, system.threading.WaitHandleCannotBeOpenedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.TimeoutException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Invoke", callback, priority == null ? null : priority.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Invoke(Action callback, DispatcherPriority priority, CancellationToken cancellationToken) throws Throwable, system.ArgumentException, system.OverflowException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.security.SecurityException, system.NullReferenceException, system.componentmodel.Win32Exception, system.InvalidCastException, system.MulticastNotSupportedException, system.threading.WaitHandleCannotBeOpenedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.threading.AbandonedMutexException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.TimeoutException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Invoke", callback, priority == null ? null : priority.getJCOInstance(), cancellationToken == null ? null : cancellationToken.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Invoke(Action callback, DispatcherPriority priority, CancellationToken cancellationToken, TimeSpan timeout) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotImplementedException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.OverflowException, system.security.SecurityException, system.NullReferenceException, system.componentmodel.Win32Exception, system.NotSupportedException, system.InvalidCastException, system.MulticastNotSupportedException, system.threading.WaitHandleCannotBeOpenedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.threading.ThreadAbortException, system.threading.tasks.TaskSchedulerException, system.threading.tasks.TaskCanceledException, system.AggregateException, system.TimeoutException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Invoke", callback, priority == null ? null : priority.getJCOInstance(), cancellationToken == null ? null : cancellationToken.getJCOInstance(), timeout == null ? null : timeout.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void InvokeShutdown() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.componentmodel.Win32Exception, system.InvalidOperationException, system.OverflowException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.MissingMethodException, system.reflection.TargetInvocationException, system.TimeoutException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("InvokeShutdown");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void PushFrame(DispatcherFrame frame) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.OutOfMemoryException, system.OverflowException, system.TimeoutException, system.security.SecurityException, system.InvalidCastException, system.PlatformNotSupportedException, system.NotSupportedException, system.UnauthorizedAccessException, system.io.IOException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("PushFrame", frame == null ? null : frame.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Run() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.componentmodel.Win32Exception, system.security.SecurityException, system.NotSupportedException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NullReferenceException, system.ObjectDisposedException, system.UnauthorizedAccessException, system.io.IOException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Run");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ValidatePriority(DispatcherPriority priority, java.lang.String parameterName) throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ValidatePriority", priority == null ? null : priority.getJCOInstance(), parameterName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void VerifyAccess() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("VerifyAccess");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getHasShutdownFinished() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasShutdownFinished");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getHasShutdownStarted() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasShutdownStarted");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Thread getThread() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Thread");
            return new Thread(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Dispatcher getCurrentDispatcher() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.OverflowException, system.TimeoutException, system.security.SecurityException, system.PlatformNotSupportedException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("CurrentDispatcher");
            return new Dispatcher(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DispatcherHooks getHooks() throws Throwable, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Hooks");
            return new DispatcherHooks(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

    public void addShutdownFinished(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("ShutdownFinished", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeShutdownFinished(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("ShutdownFinished", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addShutdownStarted(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("ShutdownStarted", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeShutdownStarted(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("ShutdownStarted", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addUnhandledException(DispatcherUnhandledExceptionEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("UnhandledException", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeUnhandledException(DispatcherUnhandledExceptionEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("UnhandledException", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addUnhandledExceptionFilter(DispatcherUnhandledExceptionFilterEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("UnhandledExceptionFilter", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeUnhandledExceptionFilter(DispatcherUnhandledExceptionFilterEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("UnhandledExceptionFilter", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}