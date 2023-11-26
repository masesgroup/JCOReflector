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

package system.net;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.IAsyncResult;
import system.IAsyncResultImplementation;
import system.AsyncCallback;
import system.security.cryptography.x509certificates.X509Certificate2;
import system.collections.specialized.NameValueCollection;
import system.Guid;
import system.io.Stream;
import system.net.CookieCollection;
import system.net.IPEndPoint;
import system.net.TransportContext;
import system.text.Encoding;
import system.Uri;
import system.Version;


/**
 * The base .NET class managing System.Net.HttpListenerRequest, System.Net.HttpListener, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.HttpListenerRequest" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.HttpListenerRequest</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class HttpListenerRequest extends NetObject  {
    /**
     * Fully assembly qualified name: System.Net.HttpListener, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Net.HttpListener, Version=8.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Net.HttpListener
     */
    public static final String assemblyShortName = "System.Net.HttpListener";
    /**
     * Qualified class name: System.Net.HttpListenerRequest
     */
    public static final String className = "System.Net.HttpListenerRequest";
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
    public HttpListenerRequest(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link HttpListenerRequest}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link HttpListenerRequest} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static HttpListenerRequest cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new HttpListenerRequest(from.getJCOInstance());
    }

    // Constructors section
    
    public HttpListenerRequest() throws Throwable {
    }



    
    // Methods section
    
    public IAsyncResult BeginGetClientCertificate(AsyncCallback requestCallback, NetObject state) throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.ApplicationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ObjectDisposedException, system.net.HttpListenerException, system.security.cryptography.CryptographicException, system.io.IOException, system.threading.tasks.TaskSchedulerException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objBeginGetClientCertificate = (JCObject)classInstance.Invoke("BeginGetClientCertificate", requestCallback, state == null ? null : state.getJCOInstance());
            return new IAsyncResultImplementation(objBeginGetClientCertificate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public X509Certificate2 EndGetClientCertificate(IAsyncResult asyncResult) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.threading.WaitHandleCannotBeOpenedException, system.IndexOutOfRangeException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objEndGetClientCertificate = (JCObject)classInstance.Invoke("EndGetClientCertificate", asyncResult == null ? null : asyncResult.getJCOInstance());
            return new X509Certificate2(objEndGetClientCertificate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public X509Certificate2 GetClientCertificate() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.NotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.security.cryptography.CryptographicException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetClientCertificate = (JCObject)classInstance.Invoke("GetClientCertificate");
            return new X509Certificate2(objGetClientCertificate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getHasEntityBody() throws Throwable, system.ObjectDisposedException, system.ArgumentException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasEntityBody");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsAuthenticated() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsAuthenticated");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsLocal() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsLocal");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsSecureConnection() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsSecureConnection");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsWebSocketRequest() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsWebSocketRequest");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getKeepAlive() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("KeepAlive");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getClientCertificateError() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.NotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ClientCertificateError");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long getContentLength64() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Get("ContentLength64");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NameValueCollection getHeaders() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Headers");
            return new NameValueCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NameValueCollection getQueryString() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.PlatformNotSupportedException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.NotSupportedException, system.diagnostics.tracing.EventSourceException, system.InvalidOperationException, system.diagnostics.UnreachableException, system.UriFormatException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("QueryString");
            return new NameValueCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Guid getRequestTraceIdentifier() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RequestTraceIdentifier");
            return new Guid(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Stream getInputStream() throws Throwable, system.ObjectDisposedException, system.ArgumentException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.OutOfMemoryException, system.PlatformNotSupportedException, system.FormatException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InputStream");
            return new Stream(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CookieCollection getCookies() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.OverflowException, system.net.CookieException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Cookies");
            return new CookieCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPEndPoint getLocalEndPoint() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("LocalEndPoint");
            return new IPEndPoint(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IPEndPoint getRemoteEndPoint() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RemoteEndPoint");
            return new IPEndPoint(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TransportContext getTransportContext() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TransportContext");
            return new TransportContext(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getContentType() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ContentType");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getHttpMethod() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentNullException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("HttpMethod");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getRawUrl() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("RawUrl");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getServiceName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ServiceName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setServiceName(java.lang.String ServiceName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ServiceName", ServiceName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getUserAgent() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("UserAgent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getUserHostAddress() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.IndexOutOfRangeException, system.ArgumentException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("UserHostAddress");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getUserHostName() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("UserHostName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String[] getAcceptTypes() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("AcceptTypes");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexAcceptTypes = 0; indexAcceptTypes < resultingArrayList.size(); indexAcceptTypes++ ) {
				resultingArray[indexAcceptTypes] = (java.lang.String)resultingArrayList.get(indexAcceptTypes);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String[] getUserLanguages() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("UserLanguages");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexUserLanguages = 0; indexUserLanguages < resultingArrayList.size(); indexUserLanguages++ ) {
				resultingArray[indexUserLanguages] = (java.lang.String)resultingArrayList.get(indexUserLanguages);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Encoding getContentEncoding() throws Throwable, system.ObjectDisposedException, system.ArgumentException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.runtime.interopservices.ExternalException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ContentEncoding");
            return new Encoding(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Uri getUrl() throws Throwable, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.InvalidOperationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Url");
            return new Uri(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Uri getUrlReferrer() throws Throwable, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.OutOfMemoryException, system.FormatException, system.diagnostics.tracing.EventSourceException, system.diagnostics.UnreachableException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("UrlReferrer");
            return new Uri(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Version getProtocolVersion() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ProtocolVersion");
            return new Version(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}