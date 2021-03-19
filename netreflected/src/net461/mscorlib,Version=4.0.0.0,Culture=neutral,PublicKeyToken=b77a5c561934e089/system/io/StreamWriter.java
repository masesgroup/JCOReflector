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

package system.io;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.TextWriter;
import system.io.Stream;
import system.text.Encoding;
import system.threading.tasks.Task;


/**
 * The base .NET class managing System.IO.StreamWriter, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.StreamWriter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.StreamWriter</a>
 */
public class StreamWriter extends TextWriter  {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.IO.StreamWriter
     */
    public static final String className = "System.IO.StreamWriter";
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

    public StreamWriter(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link StreamWriter}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link StreamWriter} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static StreamWriter cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new StreamWriter(from.getJCOInstance());
    }

    // Constructors section
    
    public StreamWriter() throws Throwable {
    }

    public StreamWriter(Stream stream) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.security.SecurityException, system.NotSupportedException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.FormatException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(Stream stream, Encoding encoding) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.security.SecurityException, system.NotSupportedException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.FormatException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance(), encoding == null ? null : encoding.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(Stream stream, Encoding encoding, int bufferSize) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.security.SecurityException, system.NotSupportedException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.FormatException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance(), encoding == null ? null : encoding.getJCOInstance(), bufferSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(Stream stream, Encoding encoding, int bufferSize, boolean leaveOpen) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.security.SecurityException, system.TypeLoadException, system.NotSupportedException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance(), encoding == null ? null : encoding.getJCOInstance(), bufferSize, leaveOpen));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(java.lang.String path) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(path));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(java.lang.String path, boolean append) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(path, append));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(java.lang.String path, boolean append, Encoding encoding) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.io.PathTooLongException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.DriveNotFoundException, system.OperationCanceledException, system.NotSupportedException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(path, append, encoding == null ? null : encoding.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StreamWriter(java.lang.String path, boolean append, Encoding encoding, int bufferSize) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.io.PathTooLongException, system.IndexOutOfRangeException, system.NotSupportedException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.io.IOException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(path, append, encoding == null ? null : encoding.getJCOInstance(), bufferSize));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public Task FlushAsync() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objFlushAsync = (JCObject)classInstance.Invoke("FlushAsync");
            return new Task(objFlushAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteAsync(char value) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteAsync = (JCObject)classInstance.Invoke("WriteAsync", value);
            return new Task(objWriteAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteAsync(char[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteAsync = (JCObject)classInstance.Invoke("WriteAsync", buffer, index, count);
            return new Task(objWriteAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteAsync(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteAsync = (JCObject)classInstance.Invoke("WriteAsync", dupParam0.getJCRefOut(), dupParam1, dupParam2);
            return new Task(objWriteAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteAsync(java.lang.String value) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteAsync = (JCObject)classInstance.Invoke("WriteAsync", value);
            return new Task(objWriteAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteLineAsync() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.threading.tasks.TaskSchedulerException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteLineAsync = (JCObject)classInstance.Invoke("WriteLineAsync");
            return new Task(objWriteLineAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteLineAsync(char value) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteLineAsync = (JCObject)classInstance.Invoke("WriteLineAsync", value);
            return new Task(objWriteLineAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteLineAsync(char[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteLineAsync = (JCObject)classInstance.Invoke("WriteLineAsync", buffer, index, count);
            return new Task(objWriteLineAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteLineAsync(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteLineAsync = (JCObject)classInstance.Invoke("WriteLineAsync", dupParam0.getJCRefOut(), dupParam1, dupParam2);
            return new Task(objWriteLineAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Task WriteLineAsync(java.lang.String value) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.tasks.TaskSchedulerException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.security.SecurityException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objWriteLineAsync = (JCObject)classInstance.Invoke("WriteLineAsync", value);
            return new Task(objWriteLineAsync);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Close() throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Flush() throws Throwable, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Flush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(char value) throws Throwable, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(char[] buffer) throws Throwable, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", (Object)buffer);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(JCORefOut dupParam0) throws Throwable, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", (Object)dupParam0.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(char[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", dupParam0.getJCRefOut(), dupParam1, dupParam2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(java.lang.String value) throws Throwable, system.InvalidOperationException, system.ObjectDisposedException, system.ArgumentNullException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAutoFlush() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AutoFlush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAutoFlush(boolean AutoFlush) throws Throwable, system.InvalidOperationException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AutoFlush", AutoFlush);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Stream getBaseStream() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("BaseStream");
            return new Stream(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}