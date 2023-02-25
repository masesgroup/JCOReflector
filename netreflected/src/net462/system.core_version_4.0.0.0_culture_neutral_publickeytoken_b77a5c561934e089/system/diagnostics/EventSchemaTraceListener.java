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

package system.diagnostics;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.diagnostics.TextWriterTraceListener;
import system.diagnostics.TraceLogRetentionOption;
import system.diagnostics.TraceEventCache;
import system.diagnostics.TraceEventType;
import system.Guid;
import system.io.TextWriter;


/**
 * The base .NET class managing System.Diagnostics.EventSchemaTraceListener, System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.EventSchemaTraceListener" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.EventSchemaTraceListener</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class EventSchemaTraceListener extends TextWriterTraceListener  {
    /**
     * Fully assembly qualified name: System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Core, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Core
     */
    public static final String assemblyShortName = "System.Core";
    /**
     * Qualified class name: System.Diagnostics.EventSchemaTraceListener
     */
    public static final String className = "System.Diagnostics.EventSchemaTraceListener";
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
    public EventSchemaTraceListener(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link EventSchemaTraceListener}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link EventSchemaTraceListener} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static EventSchemaTraceListener cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new EventSchemaTraceListener(from.getJCOInstance());
    }

    // Constructors section
    
    public EventSchemaTraceListener() throws Throwable {
    }

    public EventSchemaTraceListener(java.lang.String fileName) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.MemberAccessException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventSchemaTraceListener(java.lang.String fileName, java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.MemberAccessException, system.io.PathTooLongException, system.NotSupportedException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, name));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventSchemaTraceListener(java.lang.String fileName, java.lang.String name, int bufferSize) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, name, bufferSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventSchemaTraceListener(java.lang.String fileName, java.lang.String name, int bufferSize, TraceLogRetentionOption logRetentionOption) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.io.PathTooLongException, system.MemberAccessException, system.NotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, name, bufferSize, logRetentionOption == null ? null : logRetentionOption.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventSchemaTraceListener(java.lang.String fileName, java.lang.String name, int bufferSize, TraceLogRetentionOption logRetentionOption, long maximumFileSize) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, name, bufferSize, logRetentionOption == null ? null : logRetentionOption.getJCOInstance(), maximumFileSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventSchemaTraceListener(java.lang.String fileName, java.lang.String name, int bufferSize, TraceLogRetentionOption logRetentionOption, long maximumFileSize, int maximumNumberOfFiles) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.io.PathTooLongException, system.MemberAccessException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, name, bufferSize, logRetentionOption == null ? null : logRetentionOption.getJCOInstance(), maximumFileSize, maximumNumberOfFiles));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public void Close() throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Fail(java.lang.String message, java.lang.String detailMessage) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.NotImplementedException, system.NotSupportedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.componentmodel.Win32Exception, system.OverflowException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Fail", message, detailMessage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Flush() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.FormatException, system.OverflowException, system.NotSupportedException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Flush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceData(TraceEventCache eventCache, java.lang.String source, TraceEventType eventType, int id, NetObject data) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OverflowException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.security.SecurityException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceData", eventCache == null ? null : eventCache.getJCOInstance(), source, eventType == null ? null : eventType.getJCOInstance(), id, data == null ? null : data.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceData(TraceEventCache eventCache, java.lang.String source, TraceEventType eventType, int id, NetObject... data) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OverflowException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.security.SecurityException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceData", eventCache == null ? null : eventCache.getJCOInstance(), source, eventType == null ? null : eventType.getJCOInstance(), id, toObjectFromArray(data));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceEvent(TraceEventCache eventCache, java.lang.String source, TraceEventType eventType, int id, java.lang.String message) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OverflowException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.security.SecurityException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceEvent", eventCache == null ? null : eventCache.getJCOInstance(), source, eventType == null ? null : eventType.getJCOInstance(), id, message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceEvent(TraceEventCache eventCache, java.lang.String source, TraceEventType eventType, int id, java.lang.String format, NetObject... args) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OverflowException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.security.SecurityException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceEvent", eventCache == null ? null : eventCache.getJCOInstance(), source, eventType == null ? null : eventType.getJCOInstance(), id, format, toObjectFromArray(args));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceTransfer(TraceEventCache eventCache, java.lang.String source, int id, java.lang.String message, Guid relatedActivityId) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.InvalidOperationException, system.IndexOutOfRangeException, system.OverflowException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.security.SecurityException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceTransfer", eventCache == null ? null : eventCache.getJCOInstance(), source, id, message, relatedActivityId == null ? null : relatedActivityId.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(java.lang.String message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteLine(java.lang.String message) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.FormatException, system.PlatformNotSupportedException, system.componentmodel.Win32Exception, system.OverflowException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteLine", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getBufferSize() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.OverflowException, system.NotImplementedException, system.resources.MissingManifestResourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("BufferSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getMaximumNumberOfFiles() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.OverflowException, system.NotImplementedException, system.resources.MissingManifestResourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("MaximumNumberOfFiles");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getMaximumFileSize() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.OverflowException, system.NotImplementedException, system.resources.MissingManifestResourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("MaximumFileSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TraceLogRetentionOption getTraceLogRetentionOption() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.OverflowException, system.NotImplementedException, system.resources.MissingManifestResourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TraceLogRetentionOption");
            return new TraceLogRetentionOption(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextWriter getWriter() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.InvalidOperationException, system.FormatException, system.OverflowException, system.NotSupportedException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Writer");
            return new TextWriter(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWriter(TextWriter Writer) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Writer", Writer == null ? null : Writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}