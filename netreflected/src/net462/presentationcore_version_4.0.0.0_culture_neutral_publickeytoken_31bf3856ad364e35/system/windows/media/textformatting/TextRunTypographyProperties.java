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

package system.windows.media.textformatting;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.FontCapitals;
import system.windows.FontEastAsianLanguage;
import system.windows.FontEastAsianWidths;
import system.windows.FontFraction;
import system.windows.FontNumeralAlignment;
import system.windows.FontNumeralStyle;
import system.windows.FontVariants;


/**
 * The base .NET class managing System.Windows.Media.TextFormatting.TextRunTypographyProperties, PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.TextFormatting.TextRunTypographyProperties" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.TextFormatting.TextRunTypographyProperties</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class TextRunTypographyProperties extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Media.TextFormatting.TextRunTypographyProperties
     */
    public static final String className = "System.Windows.Media.TextFormatting.TextRunTypographyProperties";
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
    public TextRunTypographyProperties(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link TextRunTypographyProperties}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link TextRunTypographyProperties} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static TextRunTypographyProperties cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new TextRunTypographyProperties(from.getJCOInstance());
    }

    // Constructors section
    
    public TextRunTypographyProperties() throws Throwable {
    }

    
    // Methods section
    

    
    // Properties section
    
    public boolean getCapitalSpacing() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("CapitalSpacing");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getCaseSensitiveForms() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("CaseSensitiveForms");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getContextualAlternates() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ContextualAlternates");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getContextualLigatures() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ContextualLigatures");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDiscretionaryLigatures() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DiscretionaryLigatures");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getEastAsianExpertForms() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("EastAsianExpertForms");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getHistoricalForms() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HistoricalForms");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getHistoricalLigatures() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HistoricalLigatures");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getKerning() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Kerning");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getMathematicalGreek() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("MathematicalGreek");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSlashedZero() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SlashedZero");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStandardLigatures() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StandardLigatures");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet1() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet1");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet10() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet10");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet11() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet11");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet12() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet12");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet13() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet13");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet14() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet14");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet15() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet15");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet16() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet16");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet17() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet17");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet18() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet18");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet19() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet19");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet2() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet2");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet20() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet20");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet3() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet3");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet4() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet4");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet5() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet5");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet6() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet6");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet7() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet7");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet8() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet8");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getStylisticSet9() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("StylisticSet9");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getAnnotationAlternates() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("AnnotationAlternates");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getContextualSwashes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ContextualSwashes");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getStandardSwashes() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("StandardSwashes");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getStylisticAlternates() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("StylisticAlternates");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontCapitals getCapitals() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Capitals");
            return new FontCapitals(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontEastAsianLanguage getEastAsianLanguage() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("EastAsianLanguage");
            return new FontEastAsianLanguage(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontEastAsianWidths getEastAsianWidths() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("EastAsianWidths");
            return new FontEastAsianWidths(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontFraction getFraction() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Fraction");
            return new FontFraction(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontNumeralAlignment getNumeralAlignment() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("NumeralAlignment");
            return new FontNumeralAlignment(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontNumeralStyle getNumeralStyle() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("NumeralStyle");
            return new FontNumeralStyle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontVariants getVariants() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Variants");
            return new FontVariants(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}