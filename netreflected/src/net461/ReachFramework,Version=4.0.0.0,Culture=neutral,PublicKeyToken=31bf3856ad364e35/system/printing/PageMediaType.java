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

package system.printing;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Printing.PageMediaType, ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Printing.PageMediaType" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Printing.PageMediaType</a>
 */
public class PageMediaType extends NetObject  {
    /**
     * Fully assembly qualified name: ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: ReachFramework
     */
    public static final String assemblyShortName = "ReachFramework";
    /**
     * Qualified class name: System.Printing.PageMediaType
     */
    public static final String className = "System.Printing.PageMediaType";
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

    public PageMediaType(Object instance) {
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

    public PageMediaType() {
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

    final static PageMediaType getFrom(JCEnum object, String value) {
        try {
            return new PageMediaType(object.fromValue(value));
        } catch (JCException e) {
            return new PageMediaType(object);
        }
    }

    // Enum fields section
    
    public static PageMediaType Unknown = getFrom(enumReflected, "Unknown");
    public static PageMediaType AutoSelect = getFrom(enumReflected, "AutoSelect");
    public static PageMediaType Archival = getFrom(enumReflected, "Archival");
    public static PageMediaType BackPrintFilm = getFrom(enumReflected, "BackPrintFilm");
    public static PageMediaType Bond = getFrom(enumReflected, "Bond");
    public static PageMediaType CardStock = getFrom(enumReflected, "CardStock");
    public static PageMediaType Continuous = getFrom(enumReflected, "Continuous");
    public static PageMediaType EnvelopePlain = getFrom(enumReflected, "EnvelopePlain");
    public static PageMediaType EnvelopeWindow = getFrom(enumReflected, "EnvelopeWindow");
    public static PageMediaType Fabric = getFrom(enumReflected, "Fabric");
    public static PageMediaType HighResolution = getFrom(enumReflected, "HighResolution");
    public static PageMediaType Label = getFrom(enumReflected, "Label");
    public static PageMediaType MultiLayerForm = getFrom(enumReflected, "MultiLayerForm");
    public static PageMediaType MultiPartForm = getFrom(enumReflected, "MultiPartForm");
    public static PageMediaType Photographic = getFrom(enumReflected, "Photographic");
    public static PageMediaType PhotographicFilm = getFrom(enumReflected, "PhotographicFilm");
    public static PageMediaType PhotographicGlossy = getFrom(enumReflected, "PhotographicGlossy");
    public static PageMediaType PhotographicHighGloss = getFrom(enumReflected, "PhotographicHighGloss");
    public static PageMediaType PhotographicMatte = getFrom(enumReflected, "PhotographicMatte");
    public static PageMediaType PhotographicSatin = getFrom(enumReflected, "PhotographicSatin");
    public static PageMediaType PhotographicSemiGloss = getFrom(enumReflected, "PhotographicSemiGloss");
    public static PageMediaType Plain = getFrom(enumReflected, "Plain");
    public static PageMediaType Screen = getFrom(enumReflected, "Screen");
    public static PageMediaType ScreenPaged = getFrom(enumReflected, "ScreenPaged");
    public static PageMediaType Stationery = getFrom(enumReflected, "Stationery");
    public static PageMediaType TabStockFull = getFrom(enumReflected, "TabStockFull");
    public static PageMediaType TabStockPreCut = getFrom(enumReflected, "TabStockPreCut");
    public static PageMediaType Transparency = getFrom(enumReflected, "Transparency");
    public static PageMediaType TShirtTransfer = getFrom(enumReflected, "TShirtTransfer");
    public static PageMediaType None = getFrom(enumReflected, "None");


    // Flags management section


}