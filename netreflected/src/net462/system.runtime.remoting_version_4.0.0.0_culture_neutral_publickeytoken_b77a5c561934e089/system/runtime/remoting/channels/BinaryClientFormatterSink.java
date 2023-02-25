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

package system.runtime.remoting.channels;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.runtime.remoting.channels.IClientChannelSink;
import system.runtime.remoting.channels.IClientChannelSinkImplementation;
import system.io.Stream;
import system.runtime.remoting.messaging.IMessage;
import system.runtime.remoting.messaging.IMessageImplementation;
import system.runtime.remoting.channels.ITransportHeaders;
import system.runtime.remoting.channels.ITransportHeadersImplementation;
import system.runtime.remoting.messaging.IMessageCtrl;
import system.runtime.remoting.messaging.IMessageCtrlImplementation;
import system.runtime.remoting.messaging.IMessageSink;
import system.runtime.remoting.messaging.IMessageSinkImplementation;
import system.runtime.remoting.channels.IClientChannelSinkStack;
import system.runtime.remoting.channels.IClientChannelSinkStackImplementation;
import system.runtime.remoting.channels.IClientResponseChannelSinkStack;
import system.runtime.remoting.channels.IClientResponseChannelSinkStackImplementation;
import system.collections.IDictionary;
import system.collections.IDictionaryImplementation;


/**
 * The base .NET class managing System.Runtime.Remoting.Channels.BinaryClientFormatterSink, System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Remoting.Channels.BinaryClientFormatterSink" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Remoting.Channels.BinaryClientFormatterSink</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class BinaryClientFormatterSink extends NetObject  {
    /**
     * Fully assembly qualified name: System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Runtime.Remoting
     */
    public static final String assemblyShortName = "System.Runtime.Remoting";
    /**
     * Qualified class name: System.Runtime.Remoting.Channels.BinaryClientFormatterSink
     */
    public static final String className = "System.Runtime.Remoting.Channels.BinaryClientFormatterSink";
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
    public BinaryClientFormatterSink(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link BinaryClientFormatterSink}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link BinaryClientFormatterSink} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static BinaryClientFormatterSink cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new BinaryClientFormatterSink(from.getJCOInstance());
    }

    // Constructors section
    
    public BinaryClientFormatterSink() throws Throwable {
    }

    public BinaryClientFormatterSink(IClientChannelSink nextSink) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(nextSink == null ? null : nextSink.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public Stream GetRequestStream(IMessage msg, ITransportHeaders headers) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRequestStream = (JCObject)classInstance.Invoke("GetRequestStream", msg == null ? null : msg.getJCOInstance(), headers == null ? null : headers.getJCOInstance());
            return new Stream(objGetRequestStream);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IMessage SyncProcessMessage(IMessage msg) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException, system.runtime.serialization.SerializationException, system.InvalidOperationException, system.security.SecurityException, system.NullReferenceException, system.IndexOutOfRangeException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSyncProcessMessage = (JCObject)classInstance.Invoke("SyncProcessMessage", msg == null ? null : msg.getJCOInstance());
            return new IMessageImplementation(objSyncProcessMessage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IMessageCtrl AsyncProcessMessage(IMessage msg, IMessageSink replySink) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.ArgumentException, system.NotSupportedException, system.runtime.serialization.SerializationException, system.InvalidOperationException, system.security.SecurityException, system.NullReferenceException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objAsyncProcessMessage = (JCObject)classInstance.Invoke("AsyncProcessMessage", msg == null ? null : msg.getJCOInstance(), replySink == null ? null : replySink.getJCOInstance());
            return new IMessageCtrlImplementation(objAsyncProcessMessage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AsyncProcessRequest(IClientChannelSinkStack sinkStack, IMessage msg, ITransportHeaders headers, Stream stream) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AsyncProcessRequest", sinkStack == null ? null : sinkStack.getJCOInstance(), msg == null ? null : msg.getJCOInstance(), headers == null ? null : headers.getJCOInstance(), stream == null ? null : stream.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AsyncProcessResponse(IClientResponseChannelSinkStack sinkStack, NetObject state, ITransportHeaders headers, Stream stream) throws Throwable, system.ArgumentNullException, system.FormatException, system.runtime.serialization.SerializationException, system.ArgumentException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AsyncProcessResponse", sinkStack == null ? null : sinkStack.getJCOInstance(), state == null ? null : state.getJCOInstance(), headers == null ? null : headers.getJCOInstance(), stream == null ? null : stream.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ProcessMessage(IMessage msg, ITransportHeaders requestHeaders, Stream requestStream, JCORefOut<ITransportHeaders> responseHeaders, JCORefOut<Stream> responseStream) throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ProcessMessage", msg == null ? null : msg.getJCOInstance(), requestHeaders == null ? null : requestHeaders.getJCOInstance(), requestStream == null ? null : requestStream.getJCOInstance(), responseHeaders.getJCRefOut(), responseStream.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public IDictionary getProperties() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Properties");
            return new IDictionaryImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IClientChannelSink getNextChannelSink() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("NextChannelSink");
            return new IClientChannelSinkImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IMessageSink getNextSink() throws Throwable, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("NextSink");
            return new IMessageSinkImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}