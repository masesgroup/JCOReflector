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

package system.web;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.web.HttpContextBase;
import system.web.HttpContext;
import system.globalization.CultureInfo;
import system.web.ISubscriptionToken;
import system.web.ISubscriptionTokenImplementation;
import system.IDisposable;
import system.IDisposableImplementation;
import system.web.IHttpHandler;
import system.web.IHttpHandlerImplementation;
import system.web.sessionstate.SessionStateBehavior;
import system.collections.IDictionary;
import system.collections.IDictionaryImplementation;
import system.DateTime;
import system.security.principal.IPrincipal;
import system.security.principal.IPrincipalImplementation;
import system.web.caching.Cache;
import system.web.configuration.AsyncPreloadModeFlags;
import system.web.HttpApplication;
import system.web.HttpApplicationStateBase;
import system.web.HttpRequestBase;
import system.web.HttpResponseBase;
import system.web.HttpServerUtilityBase;
import system.web.HttpSessionStateBase;
import system.web.instrumentation.PageInstrumentationService;
import system.web.profile.ProfileBase;
import system.web.RequestNotification;
import system.web.TraceContext;


/**
 * The base .NET class managing System.Web.HttpContextWrapper, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpContextWrapper" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpContextWrapper</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class HttpContextWrapper extends HttpContextBase  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.HttpContextWrapper
     */
    public static final String className = "System.Web.HttpContextWrapper";
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
    public HttpContextWrapper(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HttpContextWrapper}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HttpContextWrapper} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HttpContextWrapper cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HttpContextWrapper(from.getJCOInstance());
    }

    // Constructors section
    
    public HttpContextWrapper() throws Throwable {
    }

    public HttpContextWrapper(HttpContext httpContext) throws Throwable, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(httpContext == null ? null : httpContext.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public NetObject GetGlobalResourceObject(java.lang.String classKey, java.lang.String resourceKey) throws Throwable, system.IndexOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationException, system.configuration.provider.ProviderException, system.NotSupportedException, system.NullReferenceException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetGlobalResourceObject = (JCObject)classInstance.Invoke("GetGlobalResourceObject", classKey, resourceKey);
            return new NetObject(objGetGlobalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetGlobalResourceObject(java.lang.String classKey, java.lang.String resourceKey, CultureInfo culture) throws Throwable, system.IndexOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.web.HttpException, system.configuration.ConfigurationException, system.configuration.provider.ProviderException, system.NotSupportedException, system.NullReferenceException, system.configuration.ConfigurationErrorsException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetGlobalResourceObject = (JCObject)classInstance.Invoke("GetGlobalResourceObject", classKey, resourceKey, culture == null ? null : culture.getJCOInstance());
            return new NetObject(objGetGlobalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetLocalResourceObject(java.lang.String virtualPath, java.lang.String resourceKey) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.web.HttpException, system.OutOfMemoryException, system.configuration.ConfigurationException, system.configuration.provider.ProviderException, system.NotSupportedException, system.NullReferenceException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetLocalResourceObject = (JCObject)classInstance.Invoke("GetLocalResourceObject", virtualPath, resourceKey);
            return new NetObject(objGetLocalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetLocalResourceObject(java.lang.String virtualPath, java.lang.String resourceKey, CultureInfo culture) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException, system.NotSupportedException, system.configuration.ConfigurationException, system.configuration.provider.ProviderException, system.configuration.ConfigurationErrorsException, system.NullReferenceException, system.MemberAccessException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetLocalResourceObject = (JCObject)classInstance.Invoke("GetLocalResourceObject", virtualPath, resourceKey, culture == null ? null : culture.getJCOInstance());
            return new NetObject(objGetLocalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetSection(java.lang.String sectionName) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.web.HttpException, system.web.HttpRequestValidationException, system.configuration.provider.ProviderException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSection = (JCObject)classInstance.Invoke("GetSection", sectionName);
            return new NetObject(objGetSection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetService(NetType serviceType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetService = (JCObject)classInstance.Invoke("GetService", serviceType == null ? null : serviceType.getJCOInstance());
            return new NetObject(objGetService);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISubscriptionToken DisposeOnPipelineCompleted(IDisposable target) throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDisposeOnPipelineCompleted = (JCObject)classInstance.Invoke("DisposeOnPipelineCompleted", target == null ? null : target.getJCOInstance());
            return new ISubscriptionTokenImplementation(objDisposeOnPipelineCompleted);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddError(NetException errorInfo) throws Throwable, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddError", errorInfo == null ? null : errorInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ClearError() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ClearError");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemapHandler(IHttpHandler handler) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemapHandler", handler == null ? null : handler.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String path) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.web.HttpException, system.OutOfMemoryException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", path);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String path, boolean rebaseClientPath) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.FormatException, system.web.HttpException, system.OutOfMemoryException, system.configuration.provider.ProviderException, system.configuration.ConfigurationErrorsException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", path, rebaseClientPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String filePath, java.lang.String pathInfo, java.lang.String queryString) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException, system.NotSupportedException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", filePath, pathInfo, queryString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String filePath, java.lang.String pathInfo, java.lang.String queryString, boolean setClientFilePath) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.web.HttpException, system.OutOfMemoryException, system.NotSupportedException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", filePath, pathInfo, queryString, setClientFilePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSessionStateBehavior(SessionStateBehavior sessionStateBehavior) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSessionStateBehavior", sessionStateBehavior == null ? null : sessionStateBehavior.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}