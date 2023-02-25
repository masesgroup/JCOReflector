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

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Forms.AccessibleStates, System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.AccessibleStates" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.AccessibleStates</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class AccessibleStates extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.AccessibleStates
     */
    public static final String className = "System.Windows.Forms.AccessibleStates";
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
    public AccessibleStates(java.lang.Object instance) {
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

    public AccessibleStates() {
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

    final static AccessibleStates getFrom(JCEnum object, String value) {
        try {
            return new AccessibleStates(object.fromValue(value));
        } catch (JCException e) {
            return new AccessibleStates(object);
        }
    }

    // Enum fields section
    
    public static AccessibleStates None = getFrom(enumReflected, "None");
    public static AccessibleStates Unavailable = getFrom(enumReflected, "Unavailable");
    public static AccessibleStates Selected = getFrom(enumReflected, "Selected");
    public static AccessibleStates Focused = getFrom(enumReflected, "Focused");
    public static AccessibleStates Pressed = getFrom(enumReflected, "Pressed");
    public static AccessibleStates Checked = getFrom(enumReflected, "Checked");
    public static AccessibleStates Indeterminate = getFrom(enumReflected, "Indeterminate");
    public static AccessibleStates Mixed = getFrom(enumReflected, "Mixed");
    public static AccessibleStates ReadOnly = getFrom(enumReflected, "ReadOnly");
    public static AccessibleStates HotTracked = getFrom(enumReflected, "HotTracked");
    public static AccessibleStates Default = getFrom(enumReflected, "Default");
    public static AccessibleStates Expanded = getFrom(enumReflected, "Expanded");
    public static AccessibleStates Collapsed = getFrom(enumReflected, "Collapsed");
    public static AccessibleStates Busy = getFrom(enumReflected, "Busy");
    public static AccessibleStates Floating = getFrom(enumReflected, "Floating");
    public static AccessibleStates Marqueed = getFrom(enumReflected, "Marqueed");
    public static AccessibleStates Animated = getFrom(enumReflected, "Animated");
    public static AccessibleStates Invisible = getFrom(enumReflected, "Invisible");
    public static AccessibleStates Offscreen = getFrom(enumReflected, "Offscreen");
    public static AccessibleStates Sizeable = getFrom(enumReflected, "Sizeable");
    public static AccessibleStates Moveable = getFrom(enumReflected, "Moveable");
    public static AccessibleStates SelfVoicing = getFrom(enumReflected, "SelfVoicing");
    public static AccessibleStates Focusable = getFrom(enumReflected, "Focusable");
    public static AccessibleStates Selectable = getFrom(enumReflected, "Selectable");
    public static AccessibleStates Linked = getFrom(enumReflected, "Linked");
    public static AccessibleStates Traversed = getFrom(enumReflected, "Traversed");
    public static AccessibleStates MultiSelectable = getFrom(enumReflected, "MultiSelectable");
    public static AccessibleStates ExtSelectable = getFrom(enumReflected, "ExtSelectable");
    public static AccessibleStates AlertLow = getFrom(enumReflected, "AlertLow");
    public static AccessibleStates AlertMedium = getFrom(enumReflected, "AlertMedium");
    public static AccessibleStates AlertHigh = getFrom(enumReflected, "AlertHigh");
    public static AccessibleStates Protected = getFrom(enumReflected, "Protected");
    public static AccessibleStates Valid = getFrom(enumReflected, "Valid");
    public static AccessibleStates HasPopup = getFrom(enumReflected, "HasPopup");


    // Flags management section

    public final AccessibleStates add(AccessibleStates val) throws Throwable {
        return new AccessibleStates(NetEnum.add(classInstance, val.classInstance));
    }

    public final AccessibleStates remove(AccessibleStates val) throws Throwable {
        return new AccessibleStates(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(AccessibleStates val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(AccessibleStates val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}