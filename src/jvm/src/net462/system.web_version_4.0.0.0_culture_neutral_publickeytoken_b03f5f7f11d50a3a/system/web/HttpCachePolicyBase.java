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
import system.web.HttpCacheValidateHandler;
import system.web.HttpCacheability;
import system.DateTime;
import system.TimeSpan;
import system.web.HttpCacheRevalidation;
import system.web.HttpCacheVaryByContentEncodings;
import system.web.HttpCacheVaryByHeaders;
import system.web.HttpCacheVaryByParams;


/**
 * The base .NET class managing System.Web.HttpCachePolicyBase, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpCachePolicyBase" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpCachePolicyBase</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class HttpCachePolicyBase extends NetObject  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.HttpCachePolicyBase
     */
    public static final String className = "System.Web.HttpCachePolicyBase";
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
    public HttpCachePolicyBase(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HttpCachePolicyBase}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HttpCachePolicyBase} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HttpCachePolicyBase cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HttpCachePolicyBase(from.getJCOInstance());
    }

    // Constructors section
    
    public HttpCachePolicyBase() throws Throwable {
    }

    
    // Methods section
    
    public void AddValidationCallback(HttpCacheValidateHandler handler, NetObject data) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddValidationCallback", handler, data == null ? null : data.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AppendCacheExtension(java.lang.String extension) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AppendCacheExtension", extension);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetAllowResponseInBrowserHistory(boolean allow) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetAllowResponseInBrowserHistory", allow);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetCacheability(HttpCacheability cacheability) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetCacheability", cacheability == null ? null : cacheability.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetCacheability(HttpCacheability cacheability, java.lang.String field) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetCacheability", cacheability == null ? null : cacheability.getJCOInstance(), field);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetETag(java.lang.String etag) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetETag", etag);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetETagFromFileDependencies() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetETagFromFileDependencies");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetExpires(DateTime date) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetExpires", date == null ? null : date.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetLastModified(DateTime date) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetLastModified", date == null ? null : date.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetLastModifiedFromFileDependencies() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetLastModifiedFromFileDependencies");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetMaxAge(TimeSpan delta) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetMaxAge", delta == null ? null : delta.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetNoServerCaching() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetNoServerCaching");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetNoStore() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetNoStore");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetNoTransforms() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetNoTransforms");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetOmitVaryStar(boolean omit) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetOmitVaryStar", omit);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetProxyMaxAge(TimeSpan delta) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetProxyMaxAge", delta == null ? null : delta.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetRevalidation(HttpCacheRevalidation revalidation) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetRevalidation", revalidation == null ? null : revalidation.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSlidingExpiration(boolean slide) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSlidingExpiration", slide);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetValidUntilExpires(boolean validUntilExpires) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetValidUntilExpires", validUntilExpires);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetVaryByCustom(java.lang.String custom) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetVaryByCustom", custom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public HttpCacheVaryByContentEncodings getVaryByContentEncodings() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("VaryByContentEncodings");
            return new HttpCacheVaryByContentEncodings(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpCacheVaryByHeaders getVaryByHeaders() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("VaryByHeaders");
            return new HttpCacheVaryByHeaders(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HttpCacheVaryByParams getVaryByParams() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("VaryByParams");
            return new HttpCacheVaryByParams(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}