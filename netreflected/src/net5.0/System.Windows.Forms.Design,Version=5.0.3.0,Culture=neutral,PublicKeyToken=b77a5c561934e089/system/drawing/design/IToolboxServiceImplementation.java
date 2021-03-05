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

package system.drawing.design;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.collections.ICollection;
import system.collections.ICollectionImplementation;
import system.componentmodel.design.IDesignerHost;
import system.componentmodel.design.IDesignerHostImplementation;
import system.drawing.design.ToolboxItem;
import system.drawing.design.ToolboxItemCollection;
import system.drawing.design.ToolboxItemCreatorCallback;
import system.drawing.design.CategoryNameCollection;


/**
 * The base .NET class managing System.Drawing.Design.IToolboxService, System.Windows.Forms.Design, Version=5.0.3.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Design.IToolboxService" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Design.IToolboxService</a>
 */
public class IToolboxServiceImplementation extends NetObject implements IToolboxService {
    /**
     * Fully assembly qualified name: System.Windows.Forms.Design, Version=5.0.3.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms.Design, Version=5.0.3.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms.Design
     */
    public static final String assemblyShortName = "System.Windows.Forms.Design";
    /**
     * Qualified class name: System.Drawing.Design.IToolboxService
     */
    public static final String className = "System.Drawing.Design.IToolboxService";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
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

    public IToolboxServiceImplementation(Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IToolboxService}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IToolboxService} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IToolboxService ToIToolboxService(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IToolboxServiceImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public boolean IsSupported(NetObject serializedObject, ICollection filterAttributes) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsSupported", serializedObject == null ? null : serializedObject.getJCOInstance(), filterAttributes == null ? null : filterAttributes.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsSupported(NetObject serializedObject, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsSupported", serializedObject == null ? null : serializedObject.getJCOInstance(), host == null ? null : host.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsToolboxItem(NetObject serializedObject) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsToolboxItem", serializedObject == null ? null : serializedObject.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsToolboxItem(NetObject serializedObject, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsToolboxItem", serializedObject == null ? null : serializedObject.getJCOInstance(), host == null ? null : host.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean SetCursor() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("SetCursor");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItem DeserializeToolboxItem(NetObject serializedObject) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDeserializeToolboxItem = (JCObject)classInstance.Invoke("DeserializeToolboxItem", serializedObject == null ? null : serializedObject.getJCOInstance());
            return new ToolboxItem(objDeserializeToolboxItem);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItem DeserializeToolboxItem(NetObject serializedObject, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDeserializeToolboxItem = (JCObject)classInstance.Invoke("DeserializeToolboxItem", serializedObject == null ? null : serializedObject.getJCOInstance(), host == null ? null : host.getJCOInstance());
            return new ToolboxItem(objDeserializeToolboxItem);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItem GetSelectedToolboxItem() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSelectedToolboxItem = (JCObject)classInstance.Invoke("GetSelectedToolboxItem");
            return new ToolboxItem(objGetSelectedToolboxItem);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItem GetSelectedToolboxItem(IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetSelectedToolboxItem = (JCObject)classInstance.Invoke("GetSelectedToolboxItem", host == null ? null : host.getJCOInstance());
            return new ToolboxItem(objGetSelectedToolboxItem);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItemCollection GetToolboxItems() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetToolboxItems = (JCObject)classInstance.Invoke("GetToolboxItems");
            return new ToolboxItemCollection(objGetToolboxItems);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItemCollection GetToolboxItems(IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetToolboxItems = (JCObject)classInstance.Invoke("GetToolboxItems", host == null ? null : host.getJCOInstance());
            return new ToolboxItemCollection(objGetToolboxItems);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItemCollection GetToolboxItems(java.lang.String category) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetToolboxItems = (JCObject)classInstance.Invoke("GetToolboxItems", category);
            return new ToolboxItemCollection(objGetToolboxItems);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolboxItemCollection GetToolboxItems(java.lang.String category, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetToolboxItems = (JCObject)classInstance.Invoke("GetToolboxItems", category, host == null ? null : host.getJCOInstance());
            return new ToolboxItemCollection(objGetToolboxItems);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject SerializeToolboxItem(ToolboxItem toolboxItem) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objSerializeToolboxItem = (JCObject)classInstance.Invoke("SerializeToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance());
            return new NetObject(objSerializeToolboxItem);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddCreator(ToolboxItemCreatorCallback creator, java.lang.String format) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddCreator", creator, format);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddCreator(ToolboxItemCreatorCallback creator, java.lang.String format, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddCreator", creator, format, host == null ? null : host.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddLinkedToolboxItem(ToolboxItem toolboxItem, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddLinkedToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance(), host == null ? null : host.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddLinkedToolboxItem(ToolboxItem toolboxItem, java.lang.String category, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddLinkedToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance(), category, host == null ? null : host.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddToolboxItem(ToolboxItem toolboxItem) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddToolboxItem(ToolboxItem toolboxItem, java.lang.String category) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance(), category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Refresh() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Refresh");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveCreator(java.lang.String format) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveCreator", format);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveCreator(java.lang.String format, IDesignerHost host) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveCreator", format, host == null ? null : host.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveToolboxItem(ToolboxItem toolboxItem) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveToolboxItem(ToolboxItem toolboxItem, java.lang.String category) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemoveToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance(), category);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SelectedToolboxItemUsed() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SelectedToolboxItemUsed");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSelectedToolboxItem(ToolboxItem toolboxItem) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSelectedToolboxItem", toolboxItem == null ? null : toolboxItem.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public CategoryNameCollection getCategoryNames() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CategoryNames");
            return new CategoryNameCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getSelectedCategory() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("SelectedCategory");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSelectedCategory(java.lang.String SelectedCategory) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SelectedCategory", SelectedCategory);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}