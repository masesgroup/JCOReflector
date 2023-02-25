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
 * The base .NET class managing System.Web.HttpContextBase, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpContextBase" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpContextBase</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class HttpContextBase extends NetObject  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.HttpContextBase
     */
    public static final String className = "System.Web.HttpContextBase";
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
    public HttpContextBase(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HttpContextBase}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HttpContextBase} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HttpContextBase cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HttpContextBase(from.getJCOInstance());
    }

    // Constructors section
    
    public HttpContextBase() throws Throwable {
    }

    
    // Methods section
    
    public NetObject GetGlobalResourceObject(java.lang.String classKey, java.lang.String resourceKey) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetGlobalResourceObject = (JCObject)classInstance.Invoke("GetGlobalResourceObject", classKey, resourceKey);
            return new NetObject(objGetGlobalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetGlobalResourceObject(java.lang.String classKey, java.lang.String resourceKey, CultureInfo culture) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetGlobalResourceObject = (JCObject)classInstance.Invoke("GetGlobalResourceObject", classKey, resourceKey, culture == null ? null : culture.getJCOInstance());
            return new NetObject(objGetGlobalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetLocalResourceObject(java.lang.String virtualPath, java.lang.String resourceKey) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetLocalResourceObject = (JCObject)classInstance.Invoke("GetLocalResourceObject", virtualPath, resourceKey);
            return new NetObject(objGetLocalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetLocalResourceObject(java.lang.String virtualPath, java.lang.String resourceKey, CultureInfo culture) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetLocalResourceObject = (JCObject)classInstance.Invoke("GetLocalResourceObject", virtualPath, resourceKey, culture == null ? null : culture.getJCOInstance());
            return new NetObject(objGetLocalResourceObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetSection(java.lang.String sectionName) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSection = (JCObject)classInstance.Invoke("GetSection", sectionName);
            return new NetObject(objGetSection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetService(NetType serviceType) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetService = (JCObject)classInstance.Invoke("GetService", serviceType == null ? null : serviceType.getJCOInstance());
            return new NetObject(objGetService);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISubscriptionToken DisposeOnPipelineCompleted(IDisposable target) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDisposeOnPipelineCompleted = (JCObject)classInstance.Invoke("DisposeOnPipelineCompleted", target == null ? null : target.getJCOInstance());
            return new ISubscriptionTokenImplementation(objDisposeOnPipelineCompleted);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddError(NetException errorInfo) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddError", errorInfo == null ? null : errorInfo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ClearError() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ClearError");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemapHandler(IHttpHandler handler) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemapHandler", handler == null ? null : handler.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String path) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", path);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String path, boolean rebaseClientPath) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", path, rebaseClientPath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String filePath, java.lang.String pathInfo, java.lang.String queryString) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", filePath, pathInfo, queryString);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RewritePath(java.lang.String filePath, java.lang.String pathInfo, java.lang.String queryString, boolean setClientFilePath) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RewritePath", filePath, pathInfo, queryString, setClientFilePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSessionStateBehavior(SessionStateBehavior sessionStateBehavior) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSessionStateBehavior", sessionStateBehavior == null ? null : sessionStateBehavior.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAllowAsyncDuringSyncStages() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AllowAsyncDuringSyncStages");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAllowAsyncDuringSyncStages(boolean AllowAsyncDuringSyncStages) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AllowAsyncDuringSyncStages", AllowAsyncDuringSyncStages);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsCustomErrorEnabled() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsCustomErrorEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsDebuggingEnabled() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsDebuggingEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsPostNotification() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsPostNotification");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsWebSocketRequest() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsWebSocketRequest");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsWebSocketRequestUpgrading() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsWebSocketRequestUpgrading");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSkipAuthorization() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SkipAuthorization");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSkipAuthorization(boolean SkipAuthorization) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SkipAuthorization", SkipAuthorization);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getThreadAbortOnTimeout() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ThreadAbortOnTimeout");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setThreadAbortOnTimeout(boolean ThreadAbortOnTimeout) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ThreadAbortOnTimeout", ThreadAbortOnTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IDictionary getItems() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Items");
            return new IDictionaryImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DateTime getTimestamp() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Timestamp");
            return new DateTime(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetException getError() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Error");
            return new NetException(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final NetException[] getAllErrors() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetException> resultingArrayList = new ArrayList<NetException>();
            JCObject resultingObjects = (JCObject)classInstance.Get("AllErrors");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetException(resultingObject));
            }
            NetException[] resultingArray = new NetException[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPrincipal getUser() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("User");
            return new IPrincipalImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setUser(IPrincipal User) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("User", User == null ? null : User.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getWebSocketNegotiatedProtocol() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("WebSocketNegotiatedProtocol");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Cache getCache() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Cache");
            return new Cache(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public AsyncPreloadModeFlags getAsyncPreloadMode() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("AsyncPreloadMode");
            return new AsyncPreloadModeFlags(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAsyncPreloadMode(AsyncPreloadModeFlags AsyncPreloadMode) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AsyncPreloadMode", AsyncPreloadMode == null ? null : AsyncPreloadMode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpApplication getApplicationInstance() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ApplicationInstance");
            return new HttpApplication(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setApplicationInstance(HttpApplication ApplicationInstance) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ApplicationInstance", ApplicationInstance == null ? null : ApplicationInstance.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpApplicationStateBase getApplication() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Application");
            return new HttpApplicationStateBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpRequestBase getRequest() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Request");
            return new HttpRequestBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpResponseBase getResponse() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Response");
            return new HttpResponseBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpServerUtilityBase getServer() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Server");
            return new HttpServerUtilityBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpSessionStateBase getSession() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Session");
            return new HttpSessionStateBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IHttpHandler getCurrentHandler() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CurrentHandler");
            return new IHttpHandlerImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IHttpHandler getHandler() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Handler");
            return new IHttpHandlerImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setHandler(IHttpHandler Handler) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Handler", Handler == null ? null : Handler.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IHttpHandler getPreviousHandler() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("PreviousHandler");
            return new IHttpHandlerImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PageInstrumentationService getPageInstrumentation() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("PageInstrumentation");
            return new PageInstrumentationService(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ProfileBase getProfile() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Profile");
            return new ProfileBase(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RequestNotification getCurrentNotification() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CurrentNotification");
            return new RequestNotification(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TraceContext getTrace() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Trace");
            return new TraceContext(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}