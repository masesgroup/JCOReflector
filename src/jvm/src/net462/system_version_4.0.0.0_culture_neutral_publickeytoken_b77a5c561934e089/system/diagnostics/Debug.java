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

package system.diagnostics;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.diagnostics.TraceListenerCollection;


/**
 * The base .NET class managing System.Diagnostics.Debug, System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.Debug" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.Debug</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class Debug extends NetObject  {
    /**
     * Fully assembly qualified name: System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System
     */
    public static final String assemblyShortName = "System";
    /**
     * Qualified class name: System.Diagnostics.Debug
     */
    public static final String className = "System.Diagnostics.Debug";
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
    public Debug(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Debug}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Debug} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Debug cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Debug(from.getJCOInstance());
    }

    // Constructors section
    
    public Debug() throws Throwable {
    }

    
    // Methods section
    
    public static void Assert(boolean condition) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Assert", condition);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Assert(boolean condition, java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Assert", condition, message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Assert(boolean condition, java.lang.String message, java.lang.String detailMessage) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Assert", condition, message, detailMessage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Assert(boolean condition, java.lang.String message, java.lang.String detailMessageFormat, NetObject... args) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentException, system.NotSupportedException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Assert", condition, message, detailMessageFormat, toObjectFromArray(args));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Close() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Fail(java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Fail", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Fail(java.lang.String message, java.lang.String detailMessage) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Fail", message, detailMessage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Flush() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Flush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Indent() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Indent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Print(java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Print", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Print(java.lang.String format, NetObject... args) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Print", format, toObjectFromArray(args));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Unindent() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Unindent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Write(NetObject value) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Write", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Write(NetObject value, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Write", value == null ? null : value.getJCOInstance(), category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Write(java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Write", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Write(java.lang.String message, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Write", message, category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteIf(boolean condition, NetObject value) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteIf", condition, value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteIf(boolean condition, NetObject value, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteIf", condition, value == null ? null : value.getJCOInstance(), category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteIf(boolean condition, java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteIf", condition, message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteIf(boolean condition, java.lang.String message, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteIf", condition, message, category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLine(NetObject value) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLine", value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLine(NetObject value, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLine", value == null ? null : value.getJCOInstance(), category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLine(java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLine", message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLine(java.lang.String format, NetObject... args) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.FormatException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLine", format, toObjectFromArray(args));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLine(java.lang.String message, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLine", message, category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLineIf(boolean condition, NetObject value) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLineIf", condition, value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLineIf(boolean condition, NetObject value, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLineIf", condition, value == null ? null : value.getJCOInstance(), category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLineIf(boolean condition, java.lang.String message) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLineIf", condition, message);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void WriteLineIf(boolean condition, java.lang.String message, java.lang.String category) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.NotSupportedException, system.configuration.ConfigurationException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationErrorsException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("WriteLineIf", condition, message, category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static boolean getAutoFlush() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Get("AutoFlush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setAutoFlush(boolean AutoFlush) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("AutoFlush", AutoFlush);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int getIndentLevel() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Get("IndentLevel");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setIndentLevel(int IndentLevel) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("IndentLevel", IndentLevel);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static int getIndentSize() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Get("IndentSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setIndentSize(int IndentSize) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("IndentSize", IndentSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static TraceListenerCollection getListeners() throws Throwable, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.IndexOutOfRangeException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.NotImplementedException, system.InvalidCastException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Listeners");
            return new TraceListenerCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}