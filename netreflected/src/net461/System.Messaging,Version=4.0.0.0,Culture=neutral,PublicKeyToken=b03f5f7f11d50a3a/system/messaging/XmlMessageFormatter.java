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

package system.messaging;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.messaging.Message;


/**
 * The base .NET class managing System.Messaging.XmlMessageFormatter, System.Messaging, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Messaging.XmlMessageFormatter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Messaging.XmlMessageFormatter</a>
 */
public class XmlMessageFormatter extends NetObject  {
    /**
     * Fully assembly qualified name: System.Messaging, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Messaging, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Messaging
     */
    public static final String assemblyShortName = "System.Messaging";
    /**
     * Qualified class name: System.Messaging.XmlMessageFormatter
     */
    public static final String className = "System.Messaging.XmlMessageFormatter";
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

    public XmlMessageFormatter(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link XmlMessageFormatter}, a cast assert is made to check if types are compatible.
     */
    public static XmlMessageFormatter cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new XmlMessageFormatter(from.getJCOInstance());
    }

    // Constructors section
    
    public XmlMessageFormatter() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlMessageFormatter(java.lang.String[] targetTypeNames) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject((Object)targetTypeNames));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlMessageFormatter(NetType[] targetTypes) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject((Object)toObjectFromArray(targetTypes)));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean CanRead(Message message) throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.ArgumentException, system.threading.ThreadAbortException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.security.SecurityException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.io.FileNotFoundException, system.collections.generic.KeyNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("CanRead", message == null ? null : message.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject Clone() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.threading.ThreadAbortException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.MissingMethodException, system.security.SecurityException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.RankException, system.io.FileNotFoundException, system.TypeLoadException, system.UnauthorizedAccessException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objClone = (JCObject)classInstance.Invoke("Clone");
            return new NetObject(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject Read(Message message) throws Throwable, system.ArgumentNullException, system.TypeLoadException, system.InvalidOperationException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.ArgumentException, system.threading.ThreadAbortException, system.configuration.ConfigurationException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.security.SecurityException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.io.FileNotFoundException, system.collections.generic.KeyNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.MulticastNotSupportedException, system.FormatException, system.OverflowException, system.MissingMethodException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objRead = (JCObject)classInstance.Invoke("Read", message == null ? null : message.getJCOInstance());
            return new NetObject(objRead);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Write(Message message, NetObject obj) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.ArgumentException, system.threading.ThreadAbortException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.security.SecurityException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.RankException, system.io.FileNotFoundException, system.TypeLoadException, system.UnauthorizedAccessException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Write", message == null ? null : message.getJCOInstance(), obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public java.lang.String[] getTargetTypeNames() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Object> resultingArrayList = new ArrayList<Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("TargetTypeNames");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexTargetTypeNames = 0; indexTargetTypeNames < resultingArrayList.size(); indexTargetTypeNames++ ) {
				resultingArray[indexTargetTypeNames] = (java.lang.String)resultingArrayList.get(indexTargetTypeNames);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTargetTypeNames(java.lang.String[] TargetTypeNames) throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TargetTypeNames", TargetTypeNames);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final NetType[] getTargetTypes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<NetType> resultingArrayList = new ArrayList<NetType>();
            JCObject resultingObjects = (JCObject)classInstance.Get("TargetTypes");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new NetType(resultingObject));
            }
            NetType[] resultingArray = new NetType[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTargetTypes(NetType[] TargetTypes) throws Throwable, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TargetTypes", toObjectFromArray(TargetTypes));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}