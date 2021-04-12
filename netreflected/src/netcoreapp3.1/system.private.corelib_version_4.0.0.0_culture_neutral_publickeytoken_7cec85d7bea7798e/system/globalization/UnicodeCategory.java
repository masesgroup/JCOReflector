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

package system.globalization;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Globalization.UnicodeCategory, System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Globalization.UnicodeCategory" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Globalization.UnicodeCategory</a>
 */
public class UnicodeCategory extends NetObject  {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.Globalization.UnicodeCategory
     */
    public static final String className = "System.Globalization.UnicodeCategory";
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

    public UnicodeCategory(Object instance) {
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

    public UnicodeCategory() {
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

    final static UnicodeCategory getFrom(JCEnum object, String value) {
        try {
            return new UnicodeCategory(object.fromValue(value));
        } catch (JCException e) {
            return new UnicodeCategory(object);
        }
    }

    // Enum fields section
    
    public static UnicodeCategory UppercaseLetter = getFrom(enumReflected, "UppercaseLetter");
    public static UnicodeCategory LowercaseLetter = getFrom(enumReflected, "LowercaseLetter");
    public static UnicodeCategory TitlecaseLetter = getFrom(enumReflected, "TitlecaseLetter");
    public static UnicodeCategory ModifierLetter = getFrom(enumReflected, "ModifierLetter");
    public static UnicodeCategory OtherLetter = getFrom(enumReflected, "OtherLetter");
    public static UnicodeCategory NonSpacingMark = getFrom(enumReflected, "NonSpacingMark");
    public static UnicodeCategory SpacingCombiningMark = getFrom(enumReflected, "SpacingCombiningMark");
    public static UnicodeCategory EnclosingMark = getFrom(enumReflected, "EnclosingMark");
    public static UnicodeCategory DecimalDigitNumber = getFrom(enumReflected, "DecimalDigitNumber");
    public static UnicodeCategory LetterNumber = getFrom(enumReflected, "LetterNumber");
    public static UnicodeCategory OtherNumber = getFrom(enumReflected, "OtherNumber");
    public static UnicodeCategory SpaceSeparator = getFrom(enumReflected, "SpaceSeparator");
    public static UnicodeCategory LineSeparator = getFrom(enumReflected, "LineSeparator");
    public static UnicodeCategory ParagraphSeparator = getFrom(enumReflected, "ParagraphSeparator");
    public static UnicodeCategory Control = getFrom(enumReflected, "Control");
    public static UnicodeCategory Format = getFrom(enumReflected, "Format");
    public static UnicodeCategory Surrogate = getFrom(enumReflected, "Surrogate");
    public static UnicodeCategory PrivateUse = getFrom(enumReflected, "PrivateUse");
    public static UnicodeCategory ConnectorPunctuation = getFrom(enumReflected, "ConnectorPunctuation");
    public static UnicodeCategory DashPunctuation = getFrom(enumReflected, "DashPunctuation");
    public static UnicodeCategory OpenPunctuation = getFrom(enumReflected, "OpenPunctuation");
    public static UnicodeCategory ClosePunctuation = getFrom(enumReflected, "ClosePunctuation");
    public static UnicodeCategory InitialQuotePunctuation = getFrom(enumReflected, "InitialQuotePunctuation");
    public static UnicodeCategory FinalQuotePunctuation = getFrom(enumReflected, "FinalQuotePunctuation");
    public static UnicodeCategory OtherPunctuation = getFrom(enumReflected, "OtherPunctuation");
    public static UnicodeCategory MathSymbol = getFrom(enumReflected, "MathSymbol");
    public static UnicodeCategory CurrencySymbol = getFrom(enumReflected, "CurrencySymbol");
    public static UnicodeCategory ModifierSymbol = getFrom(enumReflected, "ModifierSymbol");
    public static UnicodeCategory OtherSymbol = getFrom(enumReflected, "OtherSymbol");
    public static UnicodeCategory OtherNotAssigned = getFrom(enumReflected, "OtherNotAssigned");


    // Flags management section


}