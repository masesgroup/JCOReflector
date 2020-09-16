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

package system.diagnostics.eventing.reader;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.security.SecureString;
import system.diagnostics.eventing.reader.SessionAuthentication;
import system.diagnostics.eventing.reader.EventLogInformation;
import system.diagnostics.eventing.reader.PathType;
import system.globalization.CultureInfo;
import system.diagnostics.eventing.reader.EventLogSession;


/**
 * The base .NET class managing System.Diagnostics.Eventing.Reader.EventLogSession, System.Diagnostics.EventLog, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.Eventing.Reader.EventLogSession" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.Eventing.Reader.EventLogSession</a>
 */
public class EventLogSession extends NetObjectAutoCloseable  {
    /**
     * Fully assembly qualified name: System.Diagnostics.EventLog, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Diagnostics.EventLog, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Diagnostics.EventLog
     */
    public static final String assemblyShortName = "System.Diagnostics.EventLog";
    /**
     * Qualified class name: System.Diagnostics.Eventing.Reader.EventLogSession
     */
    public static final String className = "System.Diagnostics.Eventing.Reader.EventLogSession";
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

    public EventLogSession(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link EventLogSession}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link EventLogSession} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static EventLogSession cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new EventLogSession(from.getJCOInstance());
    }

    // Constructors section
    
    public EventLogSession() throws Throwable, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventLogSession(java.lang.String server, java.lang.String domain, java.lang.String user, SecureString password, SessionAuthentication logOnType) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(server, domain, user, password == null ? null : password.getJCOInstance(), logOnType == null ? null : logOnType.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventLogSession(java.lang.String server) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.security.cryptography.CryptographicException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(server));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public EventLogInformation GetLogInformation(java.lang.String logName, PathType pathType) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.ArrayTypeMismatchException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException, system.OutOfMemoryException, system.MissingMethodException, system.reflection.TargetInvocationException, system.AccessViolationException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetLogInformation = (JCObject)classInstance.Invoke("GetLogInformation", logName, pathType == null ? null : pathType.getJCOInstance());
            return new EventLogInformation(objGetLogInformation);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CancelCurrentOperations() throws Throwable, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CancelCurrentOperations");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ClearLog(java.lang.String logName, java.lang.String backupPath) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.ArrayTypeMismatchException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ClearLog", logName, backupPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ClearLog(java.lang.String logName) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ClearLog", logName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Dispose() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ExportLog(java.lang.String path, PathType pathType, java.lang.String query, java.lang.String targetFilePath, boolean tolerateQueryErrors) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.ArrayTypeMismatchException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ExportLog", path, pathType == null ? null : pathType.getJCOInstance(), query, targetFilePath, tolerateQueryErrors);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ExportLog(java.lang.String path, PathType pathType, java.lang.String query, java.lang.String targetFilePath) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ExportLog", path, pathType == null ? null : pathType.getJCOInstance(), query, targetFilePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ExportLogAndMessages(java.lang.String path, PathType pathType, java.lang.String query, java.lang.String targetFilePath, boolean tolerateQueryErrors, CultureInfo targetCultureInfo) throws Throwable, system.ArgumentNullException, system.IndexOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ExportLogAndMessages", path, pathType == null ? null : pathType.getJCOInstance(), query, targetFilePath, tolerateQueryErrors, targetCultureInfo == null ? null : targetCultureInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ExportLogAndMessages(java.lang.String path, PathType pathType, java.lang.String query, java.lang.String targetFilePath) throws Throwable, system.ArgumentNullException, system.IndexOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.diagnostics.eventing.reader.EventLogNotFoundException, system.diagnostics.eventing.reader.EventLogInvalidDataException, system.OperationCanceledException, system.diagnostics.eventing.reader.EventLogProviderDisabledException, system.UnauthorizedAccessException, system.diagnostics.eventing.reader.EventLogReadingException, system.diagnostics.eventing.reader.EventLogException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ExportLogAndMessages", path, pathType == null ? null : pathType.getJCOInstance(), query, targetFilePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static EventLogSession getGlobalSession() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("GlobalSession");
            return new EventLogSession(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}