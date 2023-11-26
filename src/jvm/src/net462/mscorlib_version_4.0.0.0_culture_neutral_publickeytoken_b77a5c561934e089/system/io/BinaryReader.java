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

package system.io;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.Stream;
import system.text.Encoding;
import system.SByte;
import system.Single;
import system.Decimal;
import system.UInt16;
import system.UInt32;
import system.UInt64;


/**
 * The base .NET class managing System.IO.BinaryReader, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IO.BinaryReader" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IO.BinaryReader</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class BinaryReader extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.IO.BinaryReader
     */
    public static final String className = "System.IO.BinaryReader";
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
    public BinaryReader(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link BinaryReader}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link BinaryReader} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static BinaryReader cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new BinaryReader(from.getJCOInstance());
    }

    // Constructors section
    
    public BinaryReader() throws Throwable {
    }

    public BinaryReader(Stream input) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(input == null ? null : input.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public BinaryReader(Stream input, Encoding encoding) throws Throwable, system.ArgumentNullException, system.ArgumentException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(input == null ? null : input.getJCOInstance(), encoding == null ? null : encoding.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public BinaryReader(Stream input, Encoding encoding, boolean leaveOpen) throws Throwable, system.ArgumentNullException, system.ArgumentException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(input == null ? null : input.getJCOInstance(), encoding == null ? null : encoding.getJCOInstance(), leaveOpen));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean ReadBoolean() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("ReadBoolean");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte ReadByte() throws Throwable, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (byte)classInstance.Invoke("ReadByte");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte[] ReadBytes(int count) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("ReadBytes", count);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            byte[] resultingArray = new byte[resultingArrayList.size()];
            for(int indexReadBytes = 0; indexReadBytes < resultingArrayList.size(); indexReadBytes++ ) {
				resultingArray[indexReadBytes] = (byte)resultingArrayList.get(indexReadBytes);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public char ReadChar() throws Throwable, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (char)classInstance.Invoke("ReadChar");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public char[] ReadChars(int count) throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("ReadChars", count);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            char[] resultingArray = new char[resultingArrayList.size()];
            for(int indexReadChars = 0; indexReadChars < resultingArrayList.size(); indexReadChars++ ) {
				resultingArray[indexReadChars] = (char)resultingArrayList.get(indexReadChars);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double ReadDouble() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Invoke("ReadDouble");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public short ReadInt16() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (short)classInstance.Invoke("ReadInt16");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int PeekChar() throws Throwable, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("PeekChar");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int Read() throws Throwable, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("Read");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int Read(byte[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("Read", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int Read(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("Read", dupParam0.getJCRefOut(), dupParam1, dupParam2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int Read(char[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("Read", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int ReadInt32() throws Throwable, system.ObjectDisposedException, system.io.EndOfStreamException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("ReadInt32");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public long ReadInt64() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (long)classInstance.Invoke("ReadInt64");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SByte ReadSByte() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objReadSByte = (JCObject)classInstance.Invoke("ReadSByte");
            return new SByte(objReadSByte);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Single ReadSingle() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objReadSingle = (JCObject)classInstance.Invoke("ReadSingle");
            return new Single(objReadSingle);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Decimal ReadDecimal() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException, system.ArgumentException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objReadDecimal = (JCObject)classInstance.Invoke("ReadDecimal");
            return new Decimal(objReadDecimal);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ReadString() throws Throwable, system.ObjectDisposedException, system.FormatException, system.io.EndOfStreamException, system.ArgumentNullException, system.TypeLoadException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.io.IOException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ReadString");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UInt16 ReadUInt16() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objReadUInt16 = (JCObject)classInstance.Invoke("ReadUInt16");
            return new UInt16(objReadUInt16);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UInt32 ReadUInt32() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objReadUInt32 = (JCObject)classInstance.Invoke("ReadUInt32");
            return new UInt32(objReadUInt32);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public UInt64 ReadUInt64() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.io.EndOfStreamException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objReadUInt64 = (JCObject)classInstance.Invoke("ReadUInt64");
            return new UInt64(objReadUInt64);
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

    public void Dispose() throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void close() throws Exception {
        try {
            if (classInstance == null)
                throw new UnsupportedOperationException("classInstance is null.");
            try {
                classInstance.Invoke("Dispose");
            }
            catch (JCNativeException jcne) {
                throw translateException(jcne);
            }
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }
    
    // Properties section
    
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