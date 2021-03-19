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

package system.web;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.TextWriter;
import system.web.IHttpHandler;
import system.web.IHttpHandlerImplementation;
import system.collections.specialized.NameValueCollection;


/**
 * The base .NET class managing System.Web.HttpServerUtilityBase, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpServerUtilityBase" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.HttpServerUtilityBase</a>
 */
public class HttpServerUtilityBase extends NetObject  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.HttpServerUtilityBase
     */
    public static final String className = "System.Web.HttpServerUtilityBase";
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

    public HttpServerUtilityBase(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HttpServerUtilityBase}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HttpServerUtilityBase} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HttpServerUtilityBase cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HttpServerUtilityBase(from.getJCOInstance());
    }

    // Constructors section
    
    public HttpServerUtilityBase() throws Throwable {
    }

    
    // Methods section
    
    public byte[] UrlTokenDecode(java.lang.String input) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("UrlTokenDecode", input);
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexUrlTokenDecode = 0; indexUrlTokenDecode < resultingArrayList.size(); indexUrlTokenDecode++ ) {
				resultingArray[indexUrlTokenDecode] = (byte)resultingArrayList.get(indexUrlTokenDecode);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetException GetLastError() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetLastError = (JCObject)classInstance.Invoke("GetLastError");
            return new NetException(objGetLastError);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject CreateObject(java.lang.String progID) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateObject = (JCObject)classInstance.Invoke("CreateObject", progID);
            return new NetObject(objCreateObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject CreateObject(NetType type) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateObject = (JCObject)classInstance.Invoke("CreateObject", type == null ? null : type.getJCOInstance());
            return new NetObject(objCreateObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject CreateObjectFromClsid(java.lang.String clsid) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCreateObjectFromClsid = (JCObject)classInstance.Invoke("CreateObjectFromClsid", clsid);
            return new NetObject(objCreateObjectFromClsid);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String HtmlDecode(java.lang.String s) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("HtmlDecode", s);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String HtmlEncode(java.lang.String s) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("HtmlEncode", s);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String MapPath(java.lang.String path) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("MapPath", path);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String UrlDecode(java.lang.String s) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("UrlDecode", s);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String UrlEncode(java.lang.String s) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("UrlEncode", s);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String UrlPathEncode(java.lang.String s) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("UrlPathEncode", s);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String UrlTokenEncode(byte[] input) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("UrlTokenEncode", (Object)input);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String UrlTokenEncode(JCORefOut dupParam0) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("UrlTokenEncode", (Object)dupParam0.getJCRefOut());
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

    public void Execute(java.lang.String path) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Execute", path);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Execute(java.lang.String path, boolean preserveForm) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Execute", path, preserveForm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Execute(java.lang.String path, TextWriter writer) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Execute", path, writer == null ? null : writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Execute(java.lang.String path, TextWriter writer, boolean preserveForm) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Execute", path, writer == null ? null : writer.getJCOInstance(), preserveForm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Execute(IHttpHandler handler, TextWriter writer, boolean preserveForm) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Execute", handler == null ? null : handler.getJCOInstance(), writer == null ? null : writer.getJCOInstance(), preserveForm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void HtmlDecode(java.lang.String s, TextWriter output) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("HtmlDecode", s, output == null ? null : output.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void HtmlEncode(java.lang.String s, TextWriter output) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("HtmlEncode", s, output == null ? null : output.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Transfer(java.lang.String path) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Transfer", path);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Transfer(java.lang.String path, boolean preserveForm) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Transfer", path, preserveForm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Transfer(IHttpHandler handler, boolean preserveForm) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Transfer", handler == null ? null : handler.getJCOInstance(), preserveForm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TransferRequest(java.lang.String path) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TransferRequest", path);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TransferRequest(java.lang.String path, boolean preserveForm) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TransferRequest", path, preserveForm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TransferRequest(java.lang.String path, boolean preserveForm, java.lang.String method, NameValueCollection headers) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TransferRequest", path, preserveForm, method, headers == null ? null : headers.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TransferRequest(java.lang.String path, boolean preserveForm, java.lang.String method, NameValueCollection headers, boolean preserveUser) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TransferRequest", path, preserveForm, method, headers == null ? null : headers.getJCOInstance(), preserveUser);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void UrlDecode(java.lang.String s, TextWriter output) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("UrlDecode", s, output == null ? null : output.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void UrlEncode(java.lang.String s, TextWriter output) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("UrlEncode", s, output == null ? null : output.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getScriptTimeout() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ScriptTimeout");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setScriptTimeout(int ScriptTimeout) throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ScriptTimeout", ScriptTimeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getMachineName() throws Throwable, system.NotImplementedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("MachineName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}