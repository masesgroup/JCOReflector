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

package system.web.management;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.web.management.BufferedWebEventProvider;
import system.collections.specialized.NameValueCollection;
import system.web.management.WebBaseEvent;
import system.web.management.WebEventBufferFlushInfo;


/**
 * The base .NET class managing System.Web.Management.SqlWebEventProvider, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.Management.SqlWebEventProvider" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.Management.SqlWebEventProvider</a>
 */
public class SqlWebEventProvider extends BufferedWebEventProvider  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.Management.SqlWebEventProvider
     */
    public static final String className = "System.Web.Management.SqlWebEventProvider";
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

    public SqlWebEventProvider(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SqlWebEventProvider}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SqlWebEventProvider} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SqlWebEventProvider cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SqlWebEventProvider(from.getJCOInstance());
    }

    // Constructors section
    
    public SqlWebEventProvider() throws Throwable {
    }



    
    // Methods section
    
    public void Initialize(java.lang.String name, NameValueCollection config) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotSupportedException, system.configuration.ConfigurationErrorsException, system.web.HttpException, system.web.HttpRequestValidationException, system.configuration.ConfigurationException, system.IndexOutOfRangeException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Initialize", name, config == null ? null : config.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ProcessEvent(WebBaseEvent eventRaised) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ObjectDisposedException, system.resources.MissingManifestResourceException, system.web.HttpException, system.NullReferenceException, system.MemberAccessException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.io.PathTooLongException, system.configuration.provider.ProviderException, system.security.SecurityException, system.reflection.TargetParameterCountException, system.io.IOException, system.FormatException, system.web.management.SqlExecutionException, system.configuration.ConfigurationException, system.globalization.CultureNotFoundException, system.TypeInitializationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ProcessEvent", eventRaised == null ? null : eventRaised.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ProcessEventFlush(WebEventBufferFlushInfo flushInfo) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.NullReferenceException, system.MemberAccessException, system.IndexOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.ObjectDisposedException, system.io.PathTooLongException, system.configuration.provider.ProviderException, system.security.SecurityException, system.reflection.TargetParameterCountException, system.web.HttpException, system.io.IOException, system.FormatException, system.web.management.SqlExecutionException, system.configuration.ConfigurationException, system.globalization.CultureNotFoundException, system.TypeInitializationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ProcessEventFlush", flushInfo == null ? null : flushInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Shutdown() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Shutdown");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}