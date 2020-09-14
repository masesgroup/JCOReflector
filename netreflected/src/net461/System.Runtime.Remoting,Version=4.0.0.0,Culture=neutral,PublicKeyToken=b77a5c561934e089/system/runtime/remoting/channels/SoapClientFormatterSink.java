/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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
 * The base .NET class managing System.Runtime.Remoting.Channels.SoapClientFormatterSink, System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Remoting.Channels.SoapClientFormatterSink" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.Remoting.Channels.SoapClientFormatterSink</a>
 */
public class SoapClientFormatterSink extends NetObject  {
    /**
     * Fully assembly qualified name: System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Runtime.Remoting, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Runtime.Remoting
     */
    public static final String assemblyShortName = "System.Runtime.Remoting";
    /**
     * Qualified class name: System.Runtime.Remoting.Channels.SoapClientFormatterSink
     */
    public static final String className = "System.Runtime.Remoting.Channels.SoapClientFormatterSink";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
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

    public SoapClientFormatterSink(Object instance) throws Throwable {
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
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SoapClientFormatterSink}, a cast assert is made to check if types are compatible.
     */
    public static SoapClientFormatterSink cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SoapClientFormatterSink(from.getJCOInstance());
    }

    // Constructors section
    
    public SoapClientFormatterSink() throws Throwable {
    }

    public SoapClientFormatterSink(IClientChannelSink nextSink) throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
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

    public IMessage SyncProcessMessage(IMessage msg) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NotImplementedException, system.OutOfMemoryException, system.InvalidOperationException, system.IndexOutOfRangeException, system.NullReferenceException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.runtime.serialization.SerializationException, system.FormatException, system.runtime.remoting.RemotingException, system.security.SecurityException, system.RankException, system.runtime.remoting.ServerException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSyncProcessMessage = (JCObject)classInstance.Invoke("SyncProcessMessage", msg == null ? null : msg.getJCOInstance());
            return new IMessageImplementation(objSyncProcessMessage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IMessageCtrl AsyncProcessMessage(IMessage msg, IMessageSink replySink) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentException, system.ArgumentOutOfRangeException, system.NotImplementedException, system.OutOfMemoryException, system.InvalidOperationException, system.IndexOutOfRangeException, system.NullReferenceException, system.NotSupportedException, system.resources.MissingManifestResourceException, system.runtime.serialization.SerializationException, system.security.SecurityException {
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

    public void AsyncProcessResponse(IClientResponseChannelSinkStack sinkStack, NetObject state, ITransportHeaders headers, Stream stream) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.NotSupportedException, system.runtime.remoting.RemotingException, system.NullReferenceException, system.runtime.serialization.SerializationException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.security.SecurityException, system.RankException, system.runtime.remoting.ServerException, system.InvalidCastException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AsyncProcessResponse", sinkStack == null ? null : sinkStack.getJCOInstance(), state == null ? null : state.getJCOInstance(), headers == null ? null : headers.getJCOInstance(), stream == null ? null : stream.getJCOInstance());
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