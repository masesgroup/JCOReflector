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

package system.windows.forms.visualstyles;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Forms.VisualStyles.TextMetricsCharacterSet, System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.VisualStyles.TextMetricsCharacterSet" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.VisualStyles.TextMetricsCharacterSet</a>
 */
public class TextMetricsCharacterSet extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.VisualStyles.TextMetricsCharacterSet
     */
    public static final String className = "System.Windows.Forms.VisualStyles.TextMetricsCharacterSet";
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

    public TextMetricsCharacterSet(Object instance) {
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

    public TextMetricsCharacterSet() {
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

    final static TextMetricsCharacterSet getFrom(JCEnum object, String value) {
        try {
            return new TextMetricsCharacterSet(object.fromValue(value));
        } catch (JCException e) {
            return new TextMetricsCharacterSet(object);
        }
    }

    // Enum fields section
    
    public static TextMetricsCharacterSet Ansi = getFrom(enumReflected, "Ansi");
    public static TextMetricsCharacterSet Default = getFrom(enumReflected, "Default");
    public static TextMetricsCharacterSet Symbol = getFrom(enumReflected, "Symbol");
    public static TextMetricsCharacterSet Mac = getFrom(enumReflected, "Mac");
    public static TextMetricsCharacterSet ShiftJis = getFrom(enumReflected, "ShiftJis");
    public static TextMetricsCharacterSet Hangul = getFrom(enumReflected, "Hangul");
    public static TextMetricsCharacterSet Johab = getFrom(enumReflected, "Johab");
    public static TextMetricsCharacterSet Gb2312 = getFrom(enumReflected, "Gb2312");
    public static TextMetricsCharacterSet ChineseBig5 = getFrom(enumReflected, "ChineseBig5");
    public static TextMetricsCharacterSet Greek = getFrom(enumReflected, "Greek");
    public static TextMetricsCharacterSet Turkish = getFrom(enumReflected, "Turkish");
    public static TextMetricsCharacterSet Vietnamese = getFrom(enumReflected, "Vietnamese");
    public static TextMetricsCharacterSet Hebrew = getFrom(enumReflected, "Hebrew");
    public static TextMetricsCharacterSet Arabic = getFrom(enumReflected, "Arabic");
    public static TextMetricsCharacterSet Baltic = getFrom(enumReflected, "Baltic");
    public static TextMetricsCharacterSet Russian = getFrom(enumReflected, "Russian");
    public static TextMetricsCharacterSet Thai = getFrom(enumReflected, "Thai");
    public static TextMetricsCharacterSet EastEurope = getFrom(enumReflected, "EastEurope");
    public static TextMetricsCharacterSet Oem = getFrom(enumReflected, "Oem");


    // Flags management section


}