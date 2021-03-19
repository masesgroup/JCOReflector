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

package system.windows.automation.peers;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Automation.Peers.AutomationControlType, PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Automation.Peers.AutomationControlType" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Automation.Peers.AutomationControlType</a>
 */
public class AutomationControlType extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Automation.Peers.AutomationControlType
     */
    public static final String className = "System.Windows.Automation.Peers.AutomationControlType";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

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

    static JCEnum createEnum() {
        try {
            String enumToCreate = className + ", "
                    + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Creating Enum %s", enumToCreate);
            JCEnum enumCreated = bridge.GetEnum(enumToCreate);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Created Enum: %s",
                        (enumCreated != null) ? enumCreated.toString() : "Returned null value");
            return enumCreated;
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

    public AutomationControlType(Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            try {
                String enumName = NetEnum.GetName(classType, (JCObject)instance);
                classInstance = enumReflected.fromValue(enumName);
            } catch (Throwable t) {
                JCOReflector.writeLog(t);
                classInstance = enumReflected;
            }
        } else if (instance instanceof JCEnum) {
            classInstance = (JCEnum)instance;
        }
    }

    public AutomationControlType() {
        super();
        // add reference to assemblyName.dll file
        try {
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
        } catch (Throwable jcne) {
            JCOReflector.writeLog(jcne);
        }
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

    final static AutomationControlType getFrom(JCEnum object, String value) {
        try {
            return new AutomationControlType(object.fromValue(value));
        } catch (JCException e) {
            return new AutomationControlType(object);
        }
    }

    // Enum fields section
    
    public static AutomationControlType Button = getFrom(enumReflected, "Button");
    public static AutomationControlType Calendar = getFrom(enumReflected, "Calendar");
    public static AutomationControlType CheckBox = getFrom(enumReflected, "CheckBox");
    public static AutomationControlType ComboBox = getFrom(enumReflected, "ComboBox");
    public static AutomationControlType Edit = getFrom(enumReflected, "Edit");
    public static AutomationControlType Hyperlink = getFrom(enumReflected, "Hyperlink");
    public static AutomationControlType Image = getFrom(enumReflected, "Image");
    public static AutomationControlType ListItem = getFrom(enumReflected, "ListItem");
    public static AutomationControlType List = getFrom(enumReflected, "List");
    public static AutomationControlType Menu = getFrom(enumReflected, "Menu");
    public static AutomationControlType MenuBar = getFrom(enumReflected, "MenuBar");
    public static AutomationControlType MenuItem = getFrom(enumReflected, "MenuItem");
    public static AutomationControlType ProgressBar = getFrom(enumReflected, "ProgressBar");
    public static AutomationControlType RadioButton = getFrom(enumReflected, "RadioButton");
    public static AutomationControlType ScrollBar = getFrom(enumReflected, "ScrollBar");
    public static AutomationControlType Slider = getFrom(enumReflected, "Slider");
    public static AutomationControlType Spinner = getFrom(enumReflected, "Spinner");
    public static AutomationControlType StatusBar = getFrom(enumReflected, "StatusBar");
    public static AutomationControlType Tab = getFrom(enumReflected, "Tab");
    public static AutomationControlType TabItem = getFrom(enumReflected, "TabItem");
    public static AutomationControlType Text = getFrom(enumReflected, "Text");
    public static AutomationControlType ToolBar = getFrom(enumReflected, "ToolBar");
    public static AutomationControlType ToolTip = getFrom(enumReflected, "ToolTip");
    public static AutomationControlType Tree = getFrom(enumReflected, "Tree");
    public static AutomationControlType TreeItem = getFrom(enumReflected, "TreeItem");
    public static AutomationControlType Custom = getFrom(enumReflected, "Custom");
    public static AutomationControlType Group = getFrom(enumReflected, "Group");
    public static AutomationControlType Thumb = getFrom(enumReflected, "Thumb");
    public static AutomationControlType DataGrid = getFrom(enumReflected, "DataGrid");
    public static AutomationControlType DataItem = getFrom(enumReflected, "DataItem");
    public static AutomationControlType Document = getFrom(enumReflected, "Document");
    public static AutomationControlType SplitButton = getFrom(enumReflected, "SplitButton");
    public static AutomationControlType Window = getFrom(enumReflected, "Window");
    public static AutomationControlType Pane = getFrom(enumReflected, "Pane");
    public static AutomationControlType Header = getFrom(enumReflected, "Header");
    public static AutomationControlType HeaderItem = getFrom(enumReflected, "HeaderItem");
    public static AutomationControlType Table = getFrom(enumReflected, "Table");
    public static AutomationControlType TitleBar = getFrom(enumReflected, "TitleBar");
    public static AutomationControlType Separator = getFrom(enumReflected, "Separator");


    // Flags management section


}