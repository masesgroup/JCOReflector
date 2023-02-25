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

package system.io.pipes;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.pipes.PipeStream;
import system.io.pipes.PipeDirection;
import microsoft.win32.safehandles.SafePipeHandle;
import system.io.HandleInheritability;
import system.io.pipes.PipeTransmissionMode;


/**
 * The base .NET class managing System.IO.Pipes.AnonymousPipeServerStream, System.IO.Pipes, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.Pipes.AnonymousPipeServerStream" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.Pipes.AnonymousPipeServerStream</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class AnonymousPipeServerStream extends PipeStream  {
    /**
     * Fully assembly qualified name: System.IO.Pipes, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.IO.Pipes, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.IO.Pipes
     */
    public static final String assemblyShortName = "System.IO.Pipes";
    /**
     * Qualified class name: System.IO.Pipes.AnonymousPipeServerStream
     */
    public static final String className = "System.IO.Pipes.AnonymousPipeServerStream";
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
    public AnonymousPipeServerStream(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link AnonymousPipeServerStream}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link AnonymousPipeServerStream} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static AnonymousPipeServerStream cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new AnonymousPipeServerStream(from.getJCOInstance());
    }

    // Constructors section
    
    public AnonymousPipeServerStream() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.threading.SynchronizationLockException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ObjectDisposedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AnonymousPipeServerStream(PipeDirection direction, SafePipeHandle serverSafePipeHandle, SafePipeHandle clientSafePipeHandle) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.NotSupportedException, system.io.IOException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(direction == null ? null : direction.getJCOInstance(), serverSafePipeHandle == null ? null : serverSafePipeHandle.getJCOInstance(), clientSafePipeHandle == null ? null : clientSafePipeHandle.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AnonymousPipeServerStream(PipeDirection direction, HandleInheritability inheritability, int bufferSize) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.NotSupportedException, system.threading.LockRecursionException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.threading.SynchronizationLockException, system.ApplicationException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(direction == null ? null : direction.getJCOInstance(), inheritability == null ? null : inheritability.getJCOInstance(), bufferSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AnonymousPipeServerStream(PipeDirection direction, HandleInheritability inheritability) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.threading.SynchronizationLockException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ObjectDisposedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(direction == null ? null : direction.getJCOInstance(), inheritability == null ? null : inheritability.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AnonymousPipeServerStream(PipeDirection direction) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.threading.SynchronizationLockException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ObjectDisposedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(direction == null ? null : direction.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public java.lang.String GetClientHandleAsString() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetClientHandleAsString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DisposeLocalCopyOfClientHandle() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DisposeLocalCopyOfClientHandle");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public SafePipeHandle getClientSafePipeHandle() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ClientSafePipeHandle");
            return new SafePipeHandle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}