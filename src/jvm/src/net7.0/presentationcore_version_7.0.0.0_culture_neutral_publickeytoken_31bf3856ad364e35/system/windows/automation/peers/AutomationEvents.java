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

package system.windows.automation.peers;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Automation.Peers.AutomationEvents, PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Automation.Peers.AutomationEvents" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Automation.Peers.AutomationEvents</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class AutomationEvents extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Automation.Peers.AutomationEvents
     */
    public static final String className = "System.Windows.Automation.Peers.AutomationEvents";
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
    /**
     * Internal constructor. Use with caution 
     */
    public AutomationEvents(java.lang.Object instance) {
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

    public AutomationEvents() {
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

    public java.lang.Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    final static AutomationEvents getFrom(JCEnum object, String value) {
        try {
            return new AutomationEvents(object.fromValue(value));
        } catch (JCException e) {
            return new AutomationEvents(object);
        }
    }

    // Enum fields section
    
    public static AutomationEvents ToolTipOpened = getFrom(enumReflected, "ToolTipOpened");
    public static AutomationEvents ToolTipClosed = getFrom(enumReflected, "ToolTipClosed");
    public static AutomationEvents MenuOpened = getFrom(enumReflected, "MenuOpened");
    public static AutomationEvents MenuClosed = getFrom(enumReflected, "MenuClosed");
    public static AutomationEvents AutomationFocusChanged = getFrom(enumReflected, "AutomationFocusChanged");
    public static AutomationEvents InvokePatternOnInvoked = getFrom(enumReflected, "InvokePatternOnInvoked");
    public static AutomationEvents SelectionItemPatternOnElementAddedToSelection = getFrom(enumReflected, "SelectionItemPatternOnElementAddedToSelection");
    public static AutomationEvents SelectionItemPatternOnElementRemovedFromSelection = getFrom(enumReflected, "SelectionItemPatternOnElementRemovedFromSelection");
    public static AutomationEvents SelectionItemPatternOnElementSelected = getFrom(enumReflected, "SelectionItemPatternOnElementSelected");
    public static AutomationEvents SelectionPatternOnInvalidated = getFrom(enumReflected, "SelectionPatternOnInvalidated");
    public static AutomationEvents TextPatternOnTextSelectionChanged = getFrom(enumReflected, "TextPatternOnTextSelectionChanged");
    public static AutomationEvents TextPatternOnTextChanged = getFrom(enumReflected, "TextPatternOnTextChanged");
    public static AutomationEvents AsyncContentLoaded = getFrom(enumReflected, "AsyncContentLoaded");
    public static AutomationEvents PropertyChanged = getFrom(enumReflected, "PropertyChanged");
    public static AutomationEvents StructureChanged = getFrom(enumReflected, "StructureChanged");
    public static AutomationEvents InputReachedTarget = getFrom(enumReflected, "InputReachedTarget");
    public static AutomationEvents InputReachedOtherElement = getFrom(enumReflected, "InputReachedOtherElement");
    public static AutomationEvents InputDiscarded = getFrom(enumReflected, "InputDiscarded");
    public static AutomationEvents LiveRegionChanged = getFrom(enumReflected, "LiveRegionChanged");
    public static AutomationEvents Notification = getFrom(enumReflected, "Notification");
    public static AutomationEvents ActiveTextPositionChanged = getFrom(enumReflected, "ActiveTextPositionChanged");


    // Flags management section


}