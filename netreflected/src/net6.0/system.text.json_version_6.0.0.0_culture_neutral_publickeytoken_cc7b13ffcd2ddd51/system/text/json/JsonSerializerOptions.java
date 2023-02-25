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

package system.text.json;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.text.json.JsonSerializerDefaults;
import system.text.json.JsonSerializerOptions;
import system.text.json.serialization.JsonConverter;
import system.text.encodings.web.JavaScriptEncoder;
import system.text.json.JsonCommentHandling;
import system.text.json.JsonNamingPolicy;
import system.text.json.serialization.JsonIgnoreCondition;
import system.text.json.serialization.JsonNumberHandling;
import system.text.json.serialization.JsonUnknownTypeHandling;
import system.text.json.serialization.ReferenceHandler;


/**
 * The base .NET class managing System.Text.Json.JsonSerializerOptions, System.Text.Json, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Text.Json.JsonSerializerOptions" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Text.Json.JsonSerializerOptions</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class JsonSerializerOptions extends NetObject  {
    /**
     * Fully assembly qualified name: System.Text.Json, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Text.Json, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Text.Json
     */
    public static final String assemblyShortName = "System.Text.Json";
    /**
     * Qualified class name: System.Text.Json.JsonSerializerOptions
     */
    public static final String className = "System.Text.Json.JsonSerializerOptions";
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
    public JsonSerializerOptions(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link JsonSerializerOptions}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link JsonSerializerOptions} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static JsonSerializerOptions cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new JsonSerializerOptions(from.getJCOInstance());
    }

    // Constructors section
    
    public JsonSerializerOptions() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonSerializerOptions(JsonSerializerDefaults defaults) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(defaults == null ? null : defaults.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonSerializerOptions(JsonSerializerOptions options) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(options == null ? null : options.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public JsonConverter GetConverter(NetType typeToConvert) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetConverter = (JCObject)classInstance.Invoke("GetConverter", typeToConvert == null ? null : typeToConvert.getJCOInstance());
            return new JsonConverter(objGetConverter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAllowTrailingCommas() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AllowTrailingCommas");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAllowTrailingCommas(boolean AllowTrailingCommas) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AllowTrailingCommas", AllowTrailingCommas);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIgnoreNullValues() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IgnoreNullValues");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIgnoreNullValues(boolean IgnoreNullValues) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IgnoreNullValues", IgnoreNullValues);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIgnoreReadOnlyFields() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IgnoreReadOnlyFields");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIgnoreReadOnlyFields(boolean IgnoreReadOnlyFields) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IgnoreReadOnlyFields", IgnoreReadOnlyFields);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIgnoreReadOnlyProperties() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IgnoreReadOnlyProperties");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIgnoreReadOnlyProperties(boolean IgnoreReadOnlyProperties) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IgnoreReadOnlyProperties", IgnoreReadOnlyProperties);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIncludeFields() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IncludeFields");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIncludeFields(boolean IncludeFields) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IncludeFields", IncludeFields);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getPropertyNameCaseInsensitive() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("PropertyNameCaseInsensitive");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPropertyNameCaseInsensitive(boolean PropertyNameCaseInsensitive) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("PropertyNameCaseInsensitive", PropertyNameCaseInsensitive);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getWriteIndented() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("WriteIndented");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWriteIndented(boolean WriteIndented) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("WriteIndented", WriteIndented);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getDefaultBufferSize() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("DefaultBufferSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDefaultBufferSize(int DefaultBufferSize) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DefaultBufferSize", DefaultBufferSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getMaxDepth() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("MaxDepth");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setMaxDepth(int MaxDepth) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("MaxDepth", MaxDepth);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JavaScriptEncoder getEncoder() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Encoder");
            return new JavaScriptEncoder(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEncoder(JavaScriptEncoder Encoder) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Encoder", Encoder == null ? null : Encoder.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonCommentHandling getReadCommentHandling() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ReadCommentHandling");
            return new JsonCommentHandling(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReadCommentHandling(JsonCommentHandling ReadCommentHandling) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ReadCommentHandling", ReadCommentHandling == null ? null : ReadCommentHandling.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonNamingPolicy getDictionaryKeyPolicy() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DictionaryKeyPolicy");
            return new JsonNamingPolicy(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDictionaryKeyPolicy(JsonNamingPolicy DictionaryKeyPolicy) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DictionaryKeyPolicy", DictionaryKeyPolicy == null ? null : DictionaryKeyPolicy.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonNamingPolicy getPropertyNamingPolicy() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("PropertyNamingPolicy");
            return new JsonNamingPolicy(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPropertyNamingPolicy(JsonNamingPolicy PropertyNamingPolicy) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("PropertyNamingPolicy", PropertyNamingPolicy == null ? null : PropertyNamingPolicy.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonIgnoreCondition getDefaultIgnoreCondition() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DefaultIgnoreCondition");
            return new JsonIgnoreCondition(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDefaultIgnoreCondition(JsonIgnoreCondition DefaultIgnoreCondition) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DefaultIgnoreCondition", DefaultIgnoreCondition == null ? null : DefaultIgnoreCondition.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonNumberHandling getNumberHandling() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("NumberHandling");
            return new JsonNumberHandling(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setNumberHandling(JsonNumberHandling NumberHandling) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("NumberHandling", NumberHandling == null ? null : NumberHandling.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public JsonUnknownTypeHandling getUnknownTypeHandling() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("UnknownTypeHandling");
            return new JsonUnknownTypeHandling(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setUnknownTypeHandling(JsonUnknownTypeHandling UnknownTypeHandling) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("UnknownTypeHandling", UnknownTypeHandling == null ? null : UnknownTypeHandling.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ReferenceHandler getReferenceHandler() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ReferenceHandler");
            return new ReferenceHandler(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setReferenceHandler(ReferenceHandler ReferenceHandler) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ReferenceHandler", ReferenceHandler == null ? null : ReferenceHandler.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}