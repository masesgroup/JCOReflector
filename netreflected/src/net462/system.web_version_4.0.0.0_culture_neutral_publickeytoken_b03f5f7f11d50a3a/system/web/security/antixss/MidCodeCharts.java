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

package system.web.security.antixss;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Web.Security.AntiXss.MidCodeCharts, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.Security.AntiXss.MidCodeCharts" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.Security.AntiXss.MidCodeCharts</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class MidCodeCharts extends NetObject  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.Security.AntiXss.MidCodeCharts
     */
    public static final String className = "System.Web.Security.AntiXss.MidCodeCharts";
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
    public MidCodeCharts(java.lang.Object instance) {
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

    public MidCodeCharts() {
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

    final static MidCodeCharts getFrom(JCEnum object, String value) {
        try {
            return new MidCodeCharts(object.fromValue(value));
        } catch (JCException e) {
            return new MidCodeCharts(object);
        }
    }

    // Enum fields section
    
    public static MidCodeCharts None = getFrom(enumReflected, "None");
    public static MidCodeCharts GreekExtended = getFrom(enumReflected, "GreekExtended");
    public static MidCodeCharts GeneralPunctuation = getFrom(enumReflected, "GeneralPunctuation");
    public static MidCodeCharts SuperscriptsAndSubscripts = getFrom(enumReflected, "SuperscriptsAndSubscripts");
    public static MidCodeCharts CurrencySymbols = getFrom(enumReflected, "CurrencySymbols");
    public static MidCodeCharts CombiningDiacriticalMarksForSymbols = getFrom(enumReflected, "CombiningDiacriticalMarksForSymbols");
    public static MidCodeCharts LetterlikeSymbols = getFrom(enumReflected, "LetterlikeSymbols");
    public static MidCodeCharts NumberForms = getFrom(enumReflected, "NumberForms");
    public static MidCodeCharts Arrows = getFrom(enumReflected, "Arrows");
    public static MidCodeCharts MathematicalOperators = getFrom(enumReflected, "MathematicalOperators");
    public static MidCodeCharts MiscellaneousTechnical = getFrom(enumReflected, "MiscellaneousTechnical");
    public static MidCodeCharts ControlPictures = getFrom(enumReflected, "ControlPictures");
    public static MidCodeCharts OpticalCharacterRecognition = getFrom(enumReflected, "OpticalCharacterRecognition");
    public static MidCodeCharts EnclosedAlphanumerics = getFrom(enumReflected, "EnclosedAlphanumerics");
    public static MidCodeCharts BoxDrawing = getFrom(enumReflected, "BoxDrawing");
    public static MidCodeCharts BlockElements = getFrom(enumReflected, "BlockElements");
    public static MidCodeCharts EthiopicExtended = getFrom(enumReflected, "EthiopicExtended");
    public static MidCodeCharts GeometricShapes = getFrom(enumReflected, "GeometricShapes");
    public static MidCodeCharts MiscellaneousSymbols = getFrom(enumReflected, "MiscellaneousSymbols");
    public static MidCodeCharts Dingbats = getFrom(enumReflected, "Dingbats");
    public static MidCodeCharts MiscellaneousMathematicalSymbolsA = getFrom(enumReflected, "MiscellaneousMathematicalSymbolsA");
    public static MidCodeCharts SupplementalArrowsA = getFrom(enumReflected, "SupplementalArrowsA");
    public static MidCodeCharts BraillePatterns = getFrom(enumReflected, "BraillePatterns");
    public static MidCodeCharts SupplementalArrowsB = getFrom(enumReflected, "SupplementalArrowsB");
    public static MidCodeCharts MiscellaneousMathematicalSymbolsB = getFrom(enumReflected, "MiscellaneousMathematicalSymbolsB");
    public static MidCodeCharts SupplementalMathematicalOperators = getFrom(enumReflected, "SupplementalMathematicalOperators");
    public static MidCodeCharts MiscellaneousSymbolsAndArrows = getFrom(enumReflected, "MiscellaneousSymbolsAndArrows");
    public static MidCodeCharts Glagolitic = getFrom(enumReflected, "Glagolitic");
    public static MidCodeCharts LatinExtendedC = getFrom(enumReflected, "LatinExtendedC");
    public static MidCodeCharts Coptic = getFrom(enumReflected, "Coptic");
    public static MidCodeCharts GeorgianSupplement = getFrom(enumReflected, "GeorgianSupplement");
    public static MidCodeCharts Tifinagh = getFrom(enumReflected, "Tifinagh");


    // Flags management section

    public final MidCodeCharts add(MidCodeCharts val) throws Throwable {
        return new MidCodeCharts(NetEnum.add(classInstance, val.classInstance));
    }

    public final MidCodeCharts remove(MidCodeCharts val) throws Throwable {
        return new MidCodeCharts(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(MidCodeCharts val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(MidCodeCharts val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}