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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.drawing.Image;
import system.windows.forms.ToolStripArrowRenderEventArgs;
import system.windows.forms.ToolStripItemRenderEventArgs;
import system.windows.forms.ToolStripGripRenderEventArgs;
import system.windows.forms.ToolStripRenderEventArgs;
import system.windows.forms.ToolStripItemImageRenderEventArgs;
import system.windows.forms.ToolStripItemTextRenderEventArgs;
import system.windows.forms.ToolStripSeparatorRenderEventArgs;
import system.windows.forms.ToolStripContentPanelRenderEventArgs;
import system.windows.forms.ToolStripPanelRenderEventArgs;
import system.windows.forms.ToolStripArrowRenderEventHandler;
import system.windows.forms.ToolStripContentPanelRenderEventHandler;
import system.windows.forms.ToolStripGripRenderEventHandler;
import system.windows.forms.ToolStripItemImageRenderEventHandler;
import system.windows.forms.ToolStripItemRenderEventHandler;
import system.windows.forms.ToolStripItemTextRenderEventHandler;
import system.windows.forms.ToolStripPanelRenderEventHandler;
import system.windows.forms.ToolStripRenderEventHandler;
import system.windows.forms.ToolStripSeparatorRenderEventHandler;


/**
 * The base .NET class managing System.Windows.Forms.ToolStripRenderer, System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.ToolStripRenderer" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.ToolStripRenderer</a>
 */
public class ToolStripRenderer extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.ToolStripRenderer
     */
    public static final String className = "System.Windows.Forms.ToolStripRenderer";
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

    public ToolStripRenderer(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ToolStripRenderer}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ToolStripRenderer} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ToolStripRenderer cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ToolStripRenderer(from.getJCOInstance());
    }

    // Constructors section
    
    public ToolStripRenderer() throws Throwable {
    }

    
    // Methods section
    
    public static Image CreateDisabledImage(Image normalImage) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateDisabledImage = (JCObject)classType.Invoke("CreateDisabledImage", normalImage == null ? null : normalImage.getJCOInstance());
            return new Image(objCreateDisabledImage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawArrow(ToolStripArrowRenderEventArgs e) throws Throwable, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.FormatException, system.ArgumentOutOfRangeException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawArrow", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawButtonBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawButtonBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawDropDownButtonBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawDropDownButtonBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawGrip(ToolStripGripRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawGrip", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawImageMargin(ToolStripRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawImageMargin", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawItemBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawItemBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawItemCheck(ToolStripItemImageRenderEventArgs e) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawItemCheck", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawItemImage(ToolStripItemImageRenderEventArgs e) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.PlatformNotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawItemImage", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawItemText(ToolStripItemTextRenderEventArgs e) throws Throwable, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.PlatformNotSupportedException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.OutOfMemoryException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawItemText", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawLabelBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawLabelBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawMenuItemBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawMenuItemBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawOverflowButtonBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawOverflowButtonBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawSeparator(ToolStripSeparatorRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawSeparator", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawSplitButton(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawSplitButton", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawStatusStripSizingGrip(ToolStripRenderEventArgs e) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.FormatException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawStatusStripSizingGrip", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawToolStripBackground(ToolStripRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawToolStripBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawToolStripBorder(ToolStripRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawToolStripBorder", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawToolStripContentPanelBackground(ToolStripContentPanelRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawToolStripContentPanelBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawToolStripPanelBackground(ToolStripPanelRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawToolStripPanelBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawToolStripStatusLabelBackground(ToolStripItemRenderEventArgs e) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawToolStripStatusLabelBackground", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

    public void addRenderArrow(ToolStripArrowRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderArrow", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderArrow(ToolStripArrowRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderArrow", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderToolStripContentPanelBackground(ToolStripContentPanelRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderToolStripContentPanelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderToolStripContentPanelBackground(ToolStripContentPanelRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderToolStripContentPanelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderGrip(ToolStripGripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderGrip", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderGrip(ToolStripGripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderGrip", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderItemCheck(ToolStripItemImageRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderItemCheck", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderItemCheck(ToolStripItemImageRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderItemCheck", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderItemImage(ToolStripItemImageRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderItemImage", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderItemImage(ToolStripItemImageRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderItemImage", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderDropDownButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderDropDownButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderDropDownButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderDropDownButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderItemBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderItemBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderItemBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderItemBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderLabelBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderLabelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderLabelBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderLabelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderMenuItemBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderMenuItemBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderMenuItemBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderMenuItemBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderOverflowButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderOverflowButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderOverflowButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderOverflowButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderSplitButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderSplitButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderSplitButtonBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderSplitButtonBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderToolStripStatusLabelBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderToolStripStatusLabelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderToolStripStatusLabelBackground(ToolStripItemRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderToolStripStatusLabelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderItemText(ToolStripItemTextRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderItemText", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderItemText(ToolStripItemTextRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderItemText", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderToolStripPanelBackground(ToolStripPanelRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderToolStripPanelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderToolStripPanelBackground(ToolStripPanelRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderToolStripPanelBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderImageMargin(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderImageMargin", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderImageMargin(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderImageMargin", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderStatusStripSizingGrip(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderStatusStripSizingGrip", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderStatusStripSizingGrip(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderStatusStripSizingGrip", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderToolStripBackground(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderToolStripBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderToolStripBackground(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderToolStripBackground", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderToolStripBorder(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderToolStripBorder", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderToolStripBorder(ToolStripRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderToolStripBorder", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addRenderSeparator(ToolStripSeparatorRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("RenderSeparator", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeRenderSeparator(ToolStripSeparatorRenderEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("RenderSeparator", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}