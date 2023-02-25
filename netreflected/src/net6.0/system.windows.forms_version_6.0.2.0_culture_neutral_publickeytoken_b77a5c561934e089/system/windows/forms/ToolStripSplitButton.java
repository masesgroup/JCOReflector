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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.forms.ToolStripDropDownItem;
import system.drawing.Image;
import system.EventHandler;
import system.windows.forms.ToolStripItem;
import system.drawing.Size;
import system.EventArgs;
import system.drawing.Rectangle;


/**
 * The base .NET class managing System.Windows.Forms.ToolStripSplitButton, System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.ToolStripSplitButton" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.ToolStripSplitButton</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class ToolStripSplitButton extends ToolStripDropDownItem  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=6.0.2.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.ToolStripSplitButton
     */
    public static final String className = "System.Windows.Forms.ToolStripSplitButton";
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
    public ToolStripSplitButton(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ToolStripSplitButton}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ToolStripSplitButton} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ToolStripSplitButton cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ToolStripSplitButton(from.getJCOInstance());
    }

    // Constructors section
    
    public ToolStripSplitButton() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.IndexOutOfRangeException, system.RankException, system.ArgumentOutOfRangeException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.componentmodel.Win32Exception, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripSplitButton(Image image) throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ApplicationException, system.OverflowException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(image == null ? null : image.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripSplitButton(java.lang.String text, Image image, EventHandler onClick, java.lang.String name) throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.IndexOutOfRangeException, system.RankException, system.ArgumentOutOfRangeException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ObjectDisposedException, system.OverflowException, system.componentmodel.InvalidAsynchronousStateException, system.ApplicationException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(text, image == null ? null : image.getJCOInstance(), onClick, name));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripSplitButton(java.lang.String text, Image image, EventHandler onClick) throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ApplicationException, system.OverflowException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(text, image == null ? null : image.getJCOInstance(), onClick));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripSplitButton(java.lang.String text, Image image, ToolStripItem... dropDownItems) throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.MulticastNotSupportedException, system.NotSupportedException, system.RankException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(text, image == null ? null : image.getJCOInstance(), toObjectFromArray(dropDownItems)));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripSplitButton(java.lang.String text, Image image) throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ApplicationException, system.OverflowException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(text, image == null ? null : image.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripSplitButton(java.lang.String text) throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.ApplicationException, system.OverflowException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(text));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public Size GetPreferredSize(Size constrainingSize) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.componentmodel.InvalidEnumArgumentException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.PlatformNotSupportedException, system.FormatException, system.OverflowException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPreferredSize = (JCObject)classInstance.Invoke("GetPreferredSize", constrainingSize == null ? null : constrainingSize.getJCOInstance());
            return new Size(objGetPreferredSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OnButtonDoubleClick(EventArgs e) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.componentmodel.InvalidAsynchronousStateException, system.PlatformNotSupportedException, system.OverflowException, system.ApplicationException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.componentmodel.Win32Exception, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OnButtonDoubleClick", e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PerformButtonClick() throws Throwable, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.ApplicationException, system.OverflowException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.componentmodel.Win32Exception, system.MulticastNotSupportedException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PerformButtonClick");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ResetDropDownButtonWidth() throws Throwable, system.PlatformNotSupportedException, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ResetDropDownButtonWidth");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAutoToolTip() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AutoToolTip");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAutoToolTip(boolean AutoToolTip) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AutoToolTip", AutoToolTip);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getButtonPressed() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.FormatException, system.ObjectDisposedException, system.AccessViolationException, system.OverflowException, system.IndexOutOfRangeException, system.componentmodel.InvalidAsynchronousStateException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ButtonPressed");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getButtonSelected() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.FormatException, system.ObjectDisposedException, system.AccessViolationException, system.OverflowException, system.IndexOutOfRangeException, system.componentmodel.InvalidAsynchronousStateException, system.ApplicationException, system.componentmodel.Win32Exception, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ButtonSelected");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDropDownButtonPressed() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.componentmodel.Win32Exception, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DropDownButtonPressed");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDropDownButtonSelected() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DropDownButtonSelected");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getDropDownButtonWidth() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("DropDownButtonWidth");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDropDownButtonWidth(int DropDownButtonWidth) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.OverflowException, system.PlatformNotSupportedException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DropDownButtonWidth", DropDownButtonWidth);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle getButtonBounds() throws Throwable, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentException, system.componentmodel.InvalidEnumArgumentException, system.InvalidOperationException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.FormatException, system.ObjectDisposedException, system.AccessViolationException, system.OverflowException, system.IndexOutOfRangeException, system.componentmodel.InvalidAsynchronousStateException, system.ApplicationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ButtonBounds");
            return new Rectangle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle getDropDownButtonBounds() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DropDownButtonBounds");
            return new Rectangle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle getSplitterBounds() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SplitterBounds");
            return new Rectangle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ToolStripItem getDefaultItem() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DefaultItem");
            return new ToolStripItem(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDefaultItem(ToolStripItem DefaultItem) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.InvalidOperationException, system.PlatformNotSupportedException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DefaultItem", DefaultItem == null ? null : DefaultItem.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

    public void addButtonClick(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("ButtonClick", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeButtonClick(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("ButtonClick", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addButtonDoubleClick(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("ButtonDoubleClick", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeButtonDoubleClick(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("ButtonDoubleClick", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addDefaultItemChanged(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("DefaultItemChanged", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeDefaultItemChanged(EventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("DefaultItemChanged", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}