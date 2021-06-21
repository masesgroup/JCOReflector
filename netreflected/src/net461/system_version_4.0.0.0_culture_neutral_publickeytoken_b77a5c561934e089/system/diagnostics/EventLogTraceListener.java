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

package system.diagnostics;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.diagnostics.TraceListener;
import system.diagnostics.EventLog;
import system.diagnostics.TraceEventCache;
import system.diagnostics.TraceEventType;


/**
 * The base .NET class managing System.Diagnostics.EventLogTraceListener, System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link TraceListener}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.EventLogTraceListener" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.EventLogTraceListener</a>
 */
public class EventLogTraceListener extends TraceListener  {
    /**
     * Fully assembly qualified name: System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System
     */
    public static final String assemblyShortName = "System";
    /**
     * Qualified class name: System.Diagnostics.EventLogTraceListener
     */
    public static final String className = "System.Diagnostics.EventLogTraceListener";
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

    public EventLogTraceListener(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link EventLogTraceListener}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link EventLogTraceListener} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static EventLogTraceListener cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new EventLogTraceListener(from.getJCOInstance());
    }

    // Constructors section
    
    public EventLogTraceListener() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventLogTraceListener(EventLog eventLog) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.NullReferenceException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(eventLog == null ? null : eventLog.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventLogTraceListener(java.lang.String source) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NullReferenceException, system.ArgumentOutOfRangeException, system.FormatException, system.PlatformNotSupportedException, system.security.SecurityException, system.componentmodel.Win32Exception, system.threading.WaitHandleCannotBeOpenedException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.RankException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(source));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public void Close() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.IndexOutOfRangeException, system.NullReferenceException, system.ObjectDisposedException, system.security.SecurityException, system.componentmodel.Win32Exception, system.PlatformNotSupportedException, system.RankException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceData(TraceEventCache eventCache, java.lang.String source, TraceEventType severity, int id, NetObject data) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.NullReferenceException, system.PlatformNotSupportedException, system.security.SecurityException, system.OutOfMemoryException, system.SystemException, system.threading.WaitHandleCannotBeOpenedException, system.io.IOException, system.ApplicationException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceData", eventCache == null ? null : eventCache.getJCOInstance(), source, severity == null ? null : severity.getJCOInstance(), id, data == null ? null : data.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceData(TraceEventCache eventCache, java.lang.String source, TraceEventType severity, int id, NetObject... data) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.NullReferenceException, system.PlatformNotSupportedException, system.security.SecurityException, system.OutOfMemoryException, system.SystemException, system.threading.WaitHandleCannotBeOpenedException, system.io.IOException, system.ApplicationException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceData", eventCache == null ? null : eventCache.getJCOInstance(), source, severity == null ? null : severity.getJCOInstance(), id, toObjectFromArray(data));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceEvent(TraceEventCache eventCache, java.lang.String source, TraceEventType severity, int id, java.lang.String message) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.NullReferenceException, system.PlatformNotSupportedException, system.security.SecurityException, system.OutOfMemoryException, system.SystemException, system.threading.WaitHandleCannotBeOpenedException, system.io.IOException, system.ApplicationException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceEvent", eventCache == null ? null : eventCache.getJCOInstance(), source, severity == null ? null : severity.getJCOInstance(), id, message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TraceEvent(TraceEventCache eventCache, java.lang.String source, TraceEventType severity, int id, java.lang.String format, NetObject... args) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.NotSupportedException, system.InvalidOperationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.componentmodel.InvalidEnumArgumentException, system.NullReferenceException, system.PlatformNotSupportedException, system.security.SecurityException, system.OutOfMemoryException, system.SystemException, system.threading.WaitHandleCannotBeOpenedException, system.io.IOException, system.ApplicationException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TraceEvent", eventCache == null ? null : eventCache.getJCOInstance(), source, severity == null ? null : severity.getJCOInstance(), id, format, toObjectFromArray(args));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(java.lang.String message) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.NullReferenceException, system.NotSupportedException, system.componentmodel.InvalidEnumArgumentException, system.PlatformNotSupportedException, system.security.SecurityException, system.OutOfMemoryException, system.SystemException, system.threading.WaitHandleCannotBeOpenedException, system.io.IOException, system.ApplicationException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteLine(java.lang.String message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteLine", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public EventLog getEventLog() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("EventLog");
            return new EventLog(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEventLog(EventLog EventLog) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EventLog", EventLog == null ? null : EventLog.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}