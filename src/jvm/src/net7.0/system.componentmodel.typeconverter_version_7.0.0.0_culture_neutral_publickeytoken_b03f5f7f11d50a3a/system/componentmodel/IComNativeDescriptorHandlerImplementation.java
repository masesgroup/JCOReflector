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

package system.componentmodel;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.AttributeCollection;
import system.componentmodel.EventDescriptor;
import system.componentmodel.EventDescriptorCollection;
import system.Attribute;
import system.componentmodel.PropertyDescriptor;
import system.componentmodel.PropertyDescriptorCollection;
import system.componentmodel.TypeConverter;


/**
 * The base .NET class managing System.ComponentModel.IComNativeDescriptorHandler, System.ComponentModel.TypeConverter, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.IComNativeDescriptorHandler" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.IComNativeDescriptorHandler</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class IComNativeDescriptorHandlerImplementation extends NetObject implements IComNativeDescriptorHandler {
    /**
     * Fully assembly qualified name: System.ComponentModel.TypeConverter, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.ComponentModel.TypeConverter, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.ComponentModel.TypeConverter
     */
    public static final String assemblyShortName = "System.ComponentModel.TypeConverter";
    /**
     * Qualified class name: System.ComponentModel.IComNativeDescriptorHandler
     */
    public static final String className = "System.ComponentModel.IComNativeDescriptorHandler";
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
    public IComNativeDescriptorHandlerImplementation(java.lang.Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IComNativeDescriptorHandler}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IComNativeDescriptorHandler} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IComNativeDescriptorHandler ToIComNativeDescriptorHandler(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IComNativeDescriptorHandlerImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public AttributeCollection GetAttributes(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetAttributes = (JCObject)classInstance.Invoke("GetAttributes", component == null ? null : component.getJCOInstance());
            return new AttributeCollection(objGetAttributes);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventDescriptor GetDefaultEvent(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetDefaultEvent = (JCObject)classInstance.Invoke("GetDefaultEvent", component == null ? null : component.getJCOInstance());
            return new EventDescriptor(objGetDefaultEvent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventDescriptorCollection GetEvents(NetObject component, Attribute[] attributes) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetEvents = (JCObject)classInstance.Invoke("GetEvents", component == null ? null : component.getJCOInstance(), toObjectFromArray(attributes));
            return new EventDescriptorCollection(objGetEvents);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EventDescriptorCollection GetEvents(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetEvents = (JCObject)classInstance.Invoke("GetEvents", component == null ? null : component.getJCOInstance());
            return new EventDescriptorCollection(objGetEvents);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PropertyDescriptor GetDefaultProperty(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetDefaultProperty = (JCObject)classInstance.Invoke("GetDefaultProperty", component == null ? null : component.getJCOInstance());
            return new PropertyDescriptor(objGetDefaultProperty);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PropertyDescriptorCollection GetProperties(NetObject component, Attribute[] attributes) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetProperties = (JCObject)classInstance.Invoke("GetProperties", component == null ? null : component.getJCOInstance(), toObjectFromArray(attributes));
            return new PropertyDescriptorCollection(objGetProperties);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TypeConverter GetConverter(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetConverter = (JCObject)classInstance.Invoke("GetConverter", component == null ? null : component.getJCOInstance());
            return new TypeConverter(objGetConverter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetEditor(NetObject component, NetType baseEditorType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetEditor = (JCObject)classInstance.Invoke("GetEditor", component == null ? null : component.getJCOInstance(), baseEditorType == null ? null : baseEditorType.getJCOInstance());
            return new NetObject(objGetEditor);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetPropertyValue(NetObject component, int dispid, JCORefOut<java.util.concurrent.atomic.AtomicBoolean> success) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPropertyValue = (JCObject)classInstance.Invoke("GetPropertyValue", component == null ? null : component.getJCOInstance(), dispid, success.getJCRefOut());
            return new NetObject(objGetPropertyValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetPropertyValue(NetObject component, java.lang.String propertyName, JCORefOut<java.util.concurrent.atomic.AtomicBoolean> success) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPropertyValue = (JCObject)classInstance.Invoke("GetPropertyValue", component == null ? null : component.getJCOInstance(), propertyName, success.getJCRefOut());
            return new NetObject(objGetPropertyValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String GetClassName(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetClassName", component == null ? null : component.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String GetName(NetObject component) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetName", component == null ? null : component.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}