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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Forms.TextFormatFlags, System.Windows.Forms, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.TextFormatFlags" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.TextFormatFlags</a>
 */
public class TextFormatFlags extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.TextFormatFlags
     */
    public static final String className = "System.Windows.Forms.TextFormatFlags";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
            return null;
        }
    }

    static JCEnum createEnum() {
        try {
            return bridge.GetEnum(className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
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

    public TextFormatFlags(Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            try {
                String enumName = NetEnum.GetName(classType, (JCObject)instance);
                classInstance = enumReflected.fromValue(enumName);
            } catch (Throwable t) {
                if (JCOBridgeInstance.getDebug())
                    t.printStackTrace();
                classInstance = enumReflected;
            }
        } else if (instance instanceof JCEnum) {
            classInstance = (JCEnum)instance;
        }
    }

    public TextFormatFlags() {
        super();
        // add reference to assemblyName.dll file
        try {
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
        } catch (Throwable jcne) {
            if (JCOBridgeInstance.getDebug())
                jcne.printStackTrace();
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
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    final static TextFormatFlags getFrom(JCEnum object, String value) {
        try {
            return new TextFormatFlags(object.fromValue(value));
        } catch (JCException e) {
            return new TextFormatFlags(object);
        }
    }

    // Enum fields section
    
    public static TextFormatFlags GlyphOverhangPadding = getFrom(enumReflected, "GlyphOverhangPadding");
    public static TextFormatFlags Left = getFrom(enumReflected, "Left");
    public static TextFormatFlags Default = getFrom(enumReflected, "Default");
    public static TextFormatFlags Top = getFrom(enumReflected, "Top");
    public static TextFormatFlags HorizontalCenter = getFrom(enumReflected, "HorizontalCenter");
    public static TextFormatFlags Right = getFrom(enumReflected, "Right");
    public static TextFormatFlags VerticalCenter = getFrom(enumReflected, "VerticalCenter");
    public static TextFormatFlags Bottom = getFrom(enumReflected, "Bottom");
    public static TextFormatFlags WordBreak = getFrom(enumReflected, "WordBreak");
    public static TextFormatFlags SingleLine = getFrom(enumReflected, "SingleLine");
    public static TextFormatFlags ExpandTabs = getFrom(enumReflected, "ExpandTabs");
    public static TextFormatFlags NoClipping = getFrom(enumReflected, "NoClipping");
    public static TextFormatFlags ExternalLeading = getFrom(enumReflected, "ExternalLeading");
    public static TextFormatFlags NoPrefix = getFrom(enumReflected, "NoPrefix");
    public static TextFormatFlags Internal = getFrom(enumReflected, "Internal");
    public static TextFormatFlags TextBoxControl = getFrom(enumReflected, "TextBoxControl");
    public static TextFormatFlags PathEllipsis = getFrom(enumReflected, "PathEllipsis");
    public static TextFormatFlags EndEllipsis = getFrom(enumReflected, "EndEllipsis");
    public static TextFormatFlags ModifyString = getFrom(enumReflected, "ModifyString");
    public static TextFormatFlags RightToLeft = getFrom(enumReflected, "RightToLeft");
    public static TextFormatFlags WordEllipsis = getFrom(enumReflected, "WordEllipsis");
    public static TextFormatFlags NoFullWidthCharacterBreak = getFrom(enumReflected, "NoFullWidthCharacterBreak");
    public static TextFormatFlags HidePrefix = getFrom(enumReflected, "HidePrefix");
    public static TextFormatFlags PrefixOnly = getFrom(enumReflected, "PrefixOnly");
    public static TextFormatFlags PreserveGraphicsClipping = getFrom(enumReflected, "PreserveGraphicsClipping");
    public static TextFormatFlags PreserveGraphicsTranslateTransform = getFrom(enumReflected, "PreserveGraphicsTranslateTransform");
    public static TextFormatFlags NoPadding = getFrom(enumReflected, "NoPadding");
    public static TextFormatFlags LeftAndRightPadding = getFrom(enumReflected, "LeftAndRightPadding");


    // Flags management section

    public final TextFormatFlags add(TextFormatFlags val) throws Throwable {
        return new TextFormatFlags(NetEnum.add(classInstance, val.classInstance));
    }

    public final TextFormatFlags remove(TextFormatFlags val) throws Throwable {
        return new TextFormatFlags(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(TextFormatFlags val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(TextFormatFlags val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}