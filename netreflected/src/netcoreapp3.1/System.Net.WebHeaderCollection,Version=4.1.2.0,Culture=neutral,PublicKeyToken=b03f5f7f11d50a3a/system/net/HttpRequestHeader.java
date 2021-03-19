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

package system.net;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Net.HttpRequestHeader, System.Net.WebHeaderCollection, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Net.HttpRequestHeader" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Net.HttpRequestHeader</a>
 */
public class HttpRequestHeader extends NetObject  {
    /**
     * Fully assembly qualified name: System.Net.WebHeaderCollection, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Net.WebHeaderCollection, Version=4.1.2.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Net.WebHeaderCollection
     */
    public static final String assemblyShortName = "System.Net.WebHeaderCollection";
    /**
     * Qualified class name: System.Net.HttpRequestHeader
     */
    public static final String className = "System.Net.HttpRequestHeader";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

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

    static JCEnum createEnum() {
        try {
            String enumToCreate = className + ", "
                    + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Creating Enum %s", enumToCreate);
            JCEnum enumCreated = bridge.GetEnum(enumToCreate);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Created Enum: %s",
                        (enumCreated != null) ? enumCreated.toString() : "Returned null value");
            return enumCreated;
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

    public HttpRequestHeader(Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            try {
                String enumName = NetEnum.GetName(classType, (JCObject)instance);
                classInstance = enumReflected.fromValue(enumName);
            } catch (Throwable t) {
                JCOReflector.writeLog(t);
                classInstance = enumReflected;
            }
        } else if (instance instanceof JCEnum) {
            classInstance = (JCEnum)instance;
        }
    }

    public HttpRequestHeader() {
        super();
        // add reference to assemblyName.dll file
        try {
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
        } catch (Throwable jcne) {
            JCOReflector.writeLog(jcne);
        }
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

    public JCType getJCOType() {
        return classType;
    }

    final static HttpRequestHeader getFrom(JCEnum object, String value) {
        try {
            return new HttpRequestHeader(object.fromValue(value));
        } catch (JCException e) {
            return new HttpRequestHeader(object);
        }
    }

    // Enum fields section
    
    public static HttpRequestHeader CacheControl = getFrom(enumReflected, "CacheControl");
    public static HttpRequestHeader Connection = getFrom(enumReflected, "Connection");
    public static HttpRequestHeader Date = getFrom(enumReflected, "Date");
    public static HttpRequestHeader KeepAlive = getFrom(enumReflected, "KeepAlive");
    public static HttpRequestHeader Pragma = getFrom(enumReflected, "Pragma");
    public static HttpRequestHeader Trailer = getFrom(enumReflected, "Trailer");
    public static HttpRequestHeader TransferEncoding = getFrom(enumReflected, "TransferEncoding");
    public static HttpRequestHeader Upgrade = getFrom(enumReflected, "Upgrade");
    public static HttpRequestHeader Via = getFrom(enumReflected, "Via");
    public static HttpRequestHeader Warning = getFrom(enumReflected, "Warning");
    public static HttpRequestHeader Allow = getFrom(enumReflected, "Allow");
    public static HttpRequestHeader ContentLength = getFrom(enumReflected, "ContentLength");
    public static HttpRequestHeader ContentType = getFrom(enumReflected, "ContentType");
    public static HttpRequestHeader ContentEncoding = getFrom(enumReflected, "ContentEncoding");
    public static HttpRequestHeader ContentLanguage = getFrom(enumReflected, "ContentLanguage");
    public static HttpRequestHeader ContentLocation = getFrom(enumReflected, "ContentLocation");
    public static HttpRequestHeader ContentMd5 = getFrom(enumReflected, "ContentMd5");
    public static HttpRequestHeader ContentRange = getFrom(enumReflected, "ContentRange");
    public static HttpRequestHeader Expires = getFrom(enumReflected, "Expires");
    public static HttpRequestHeader LastModified = getFrom(enumReflected, "LastModified");
    public static HttpRequestHeader Accept = getFrom(enumReflected, "Accept");
    public static HttpRequestHeader AcceptCharset = getFrom(enumReflected, "AcceptCharset");
    public static HttpRequestHeader AcceptEncoding = getFrom(enumReflected, "AcceptEncoding");
    public static HttpRequestHeader AcceptLanguage = getFrom(enumReflected, "AcceptLanguage");
    public static HttpRequestHeader Authorization = getFrom(enumReflected, "Authorization");
    public static HttpRequestHeader Cookie = getFrom(enumReflected, "Cookie");
    public static HttpRequestHeader Expect = getFrom(enumReflected, "Expect");
    public static HttpRequestHeader From = getFrom(enumReflected, "From");
    public static HttpRequestHeader Host = getFrom(enumReflected, "Host");
    public static HttpRequestHeader IfMatch = getFrom(enumReflected, "IfMatch");
    public static HttpRequestHeader IfModifiedSince = getFrom(enumReflected, "IfModifiedSince");
    public static HttpRequestHeader IfNoneMatch = getFrom(enumReflected, "IfNoneMatch");
    public static HttpRequestHeader IfRange = getFrom(enumReflected, "IfRange");
    public static HttpRequestHeader IfUnmodifiedSince = getFrom(enumReflected, "IfUnmodifiedSince");
    public static HttpRequestHeader MaxForwards = getFrom(enumReflected, "MaxForwards");
    public static HttpRequestHeader ProxyAuthorization = getFrom(enumReflected, "ProxyAuthorization");
    public static HttpRequestHeader Referer = getFrom(enumReflected, "Referer");
    public static HttpRequestHeader Range = getFrom(enumReflected, "Range");
    public static HttpRequestHeader Te = getFrom(enumReflected, "Te");
    public static HttpRequestHeader Translate = getFrom(enumReflected, "Translate");
    public static HttpRequestHeader UserAgent = getFrom(enumReflected, "UserAgent");


    // Flags management section


}