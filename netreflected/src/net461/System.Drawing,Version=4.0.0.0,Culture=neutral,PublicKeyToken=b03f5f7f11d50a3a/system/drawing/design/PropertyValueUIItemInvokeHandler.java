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

package system.drawing.design;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.ITypeDescriptorContext;
import system.componentmodel.ITypeDescriptorContextImplementation;
import system.componentmodel.PropertyDescriptor;
import system.drawing.design.PropertyValueUIItem;
import system.drawing.design.IPropertyValueUIItemInvokeHandler;
/**
 * The base .NET class managing System.Drawing.Design.PropertyValueUIItemInvokeHandler, System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link JCVoidDelegate}. Implements {@link IJCVoidEventEmit}, {@link IJCOBridgeReflected}
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Design.PropertyValueUIItemInvokeHandler" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Design.PropertyValueUIItemInvokeHandler</a>
 */
public class PropertyValueUIItemInvokeHandler extends JCVoidDelegate implements IJCVoidEventEmit, IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Drawing
     */
    public static final String assemblyShortName = "System.Drawing";
    /**
     * Qualified class name: System.Drawing.Design.PropertyValueUIItemInvokeHandler
     */
    public static final String className = "System.Drawing.Design.PropertyValueUIItemInvokeHandler";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    JCObject classInstance = null;
    IPropertyValueUIItemInvokeHandler callerInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
            return null;
        }
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
        return this;
    }

    public JCType getJCOType() {
        return classType;
    }

    public final void EventRaised(Object... argsFromJCOBridge) {
        try
        {
            ITypeDescriptorContextImplementation context = argsFromJCOBridge[0] == null ? null : new ITypeDescriptorContextImplementation(argsFromJCOBridge[0]);
            PropertyDescriptor descriptor = argsFromJCOBridge[1] == null ? null : new PropertyDescriptor(argsFromJCOBridge[1]);
            PropertyValueUIItem invokedItem = argsFromJCOBridge[2] == null ? null : new PropertyValueUIItem(argsFromJCOBridge[2]);


            if (callerInstance != null)	{
                callerInstance.Invoke(context, descriptor, invokedItem);
            } else {
                Invoke(context, descriptor, invokedItem);
            }
        }
        catch (Throwable throwableFromJCEvent)
        {
            if (JCOBridgeInstance.getDebug())
                throwableFromJCEvent.printStackTrace();
        }
    }

    public final void DelegateInvoked(Object... argsFromJCOBridge) {
        try
        {
            ITypeDescriptorContextImplementation context = argsFromJCOBridge[0] == null ? null : new ITypeDescriptorContextImplementation(argsFromJCOBridge[0]);
            PropertyDescriptor descriptor = argsFromJCOBridge[1] == null ? null : new PropertyDescriptor(argsFromJCOBridge[1]);
            PropertyValueUIItem invokedItem = argsFromJCOBridge[2] == null ? null : new PropertyValueUIItem(argsFromJCOBridge[2]);


            if (callerInstance != null)	{
                callerInstance.Invoke(context, descriptor, invokedItem);
            } else {
                Invoke(context, descriptor, invokedItem);
            }
        }
        catch (Throwable throwableFromJCEvent)
        {
            if (JCOBridgeInstance.getDebug())
                throwableFromJCEvent.printStackTrace();
        }
    }

    public PropertyValueUIItemInvokeHandler() {
        super(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
    }

    public PropertyValueUIItemInvokeHandler(IPropertyValueUIItemInvokeHandler instance) {
        super(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        callerInstance = instance;
    }

    public PropertyValueUIItemInvokeHandler(Object instance) throws Throwable {
        super(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        if (instance == null) throw new IllegalArgumentException("Instance cannot be null");
        if (instance instanceof IPropertyValueUIItemInvokeHandler) {
            callerInstance = (IPropertyValueUIItemInvokeHandler) instance;
        } else if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new UnsupportedOperationException(
                    String.format("Class %s is not supported.", instance.getClass().getTypeName()));
    }

    protected final static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    public void METHOD_JAVA_NAME(ITypeDescriptorContext context, PropertyDescriptor descriptor, PropertyValueUIItem invokedItem) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DynamicInvoke", context == null ? null : context.getJCOInstance(), descriptor == null ? null : descriptor.getJCOInstance(), invokedItem == null ? null : invokedItem.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * Methods invoked in JVM when an event is raised in CLR 
     */
    public void Invoke(ITypeDescriptorContext context, PropertyDescriptor descriptor, PropertyValueUIItem invokedItem) {
    }
}