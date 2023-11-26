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

package system.drawing.drawing2d;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Drawing.Drawing2D.HatchStyle, System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Drawing2D.HatchStyle" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Drawing2D.HatchStyle</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class HatchStyle extends NetObject  {
    /**
     * Fully assembly qualified name: System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Drawing
     */
    public static final String assemblyShortName = "System.Drawing";
    /**
     * Qualified class name: System.Drawing.Drawing2D.HatchStyle
     */
    public static final String className = "System.Drawing.Drawing2D.HatchStyle";
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
    public HatchStyle(java.lang.Object instance) {
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

    public HatchStyle() {
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

    final static HatchStyle getFrom(JCEnum object, String value) {
        try {
            return new HatchStyle(object.fromValue(value));
        } catch (JCException e) {
            return new HatchStyle(object);
        }
    }

    // Enum fields section
    
    public static HatchStyle Horizontal = getFrom(enumReflected, "Horizontal");
    public static HatchStyle Min = getFrom(enumReflected, "Min");
    public static HatchStyle Vertical = getFrom(enumReflected, "Vertical");
    public static HatchStyle ForwardDiagonal = getFrom(enumReflected, "ForwardDiagonal");
    public static HatchStyle BackwardDiagonal = getFrom(enumReflected, "BackwardDiagonal");
    public static HatchStyle Cross = getFrom(enumReflected, "Cross");
    public static HatchStyle LargeGrid = getFrom(enumReflected, "LargeGrid");
    public static HatchStyle Max = getFrom(enumReflected, "Max");
    public static HatchStyle DiagonalCross = getFrom(enumReflected, "DiagonalCross");
    public static HatchStyle Percent05 = getFrom(enumReflected, "Percent05");
    public static HatchStyle Percent10 = getFrom(enumReflected, "Percent10");
    public static HatchStyle Percent20 = getFrom(enumReflected, "Percent20");
    public static HatchStyle Percent25 = getFrom(enumReflected, "Percent25");
    public static HatchStyle Percent30 = getFrom(enumReflected, "Percent30");
    public static HatchStyle Percent40 = getFrom(enumReflected, "Percent40");
    public static HatchStyle Percent50 = getFrom(enumReflected, "Percent50");
    public static HatchStyle Percent60 = getFrom(enumReflected, "Percent60");
    public static HatchStyle Percent70 = getFrom(enumReflected, "Percent70");
    public static HatchStyle Percent75 = getFrom(enumReflected, "Percent75");
    public static HatchStyle Percent80 = getFrom(enumReflected, "Percent80");
    public static HatchStyle Percent90 = getFrom(enumReflected, "Percent90");
    public static HatchStyle LightDownwardDiagonal = getFrom(enumReflected, "LightDownwardDiagonal");
    public static HatchStyle LightUpwardDiagonal = getFrom(enumReflected, "LightUpwardDiagonal");
    public static HatchStyle DarkDownwardDiagonal = getFrom(enumReflected, "DarkDownwardDiagonal");
    public static HatchStyle DarkUpwardDiagonal = getFrom(enumReflected, "DarkUpwardDiagonal");
    public static HatchStyle WideDownwardDiagonal = getFrom(enumReflected, "WideDownwardDiagonal");
    public static HatchStyle WideUpwardDiagonal = getFrom(enumReflected, "WideUpwardDiagonal");
    public static HatchStyle LightVertical = getFrom(enumReflected, "LightVertical");
    public static HatchStyle LightHorizontal = getFrom(enumReflected, "LightHorizontal");
    public static HatchStyle NarrowVertical = getFrom(enumReflected, "NarrowVertical");
    public static HatchStyle NarrowHorizontal = getFrom(enumReflected, "NarrowHorizontal");
    public static HatchStyle DarkVertical = getFrom(enumReflected, "DarkVertical");
    public static HatchStyle DarkHorizontal = getFrom(enumReflected, "DarkHorizontal");
    public static HatchStyle DashedDownwardDiagonal = getFrom(enumReflected, "DashedDownwardDiagonal");
    public static HatchStyle DashedUpwardDiagonal = getFrom(enumReflected, "DashedUpwardDiagonal");
    public static HatchStyle DashedHorizontal = getFrom(enumReflected, "DashedHorizontal");
    public static HatchStyle DashedVertical = getFrom(enumReflected, "DashedVertical");
    public static HatchStyle SmallConfetti = getFrom(enumReflected, "SmallConfetti");
    public static HatchStyle LargeConfetti = getFrom(enumReflected, "LargeConfetti");
    public static HatchStyle ZigZag = getFrom(enumReflected, "ZigZag");
    public static HatchStyle Wave = getFrom(enumReflected, "Wave");
    public static HatchStyle DiagonalBrick = getFrom(enumReflected, "DiagonalBrick");
    public static HatchStyle HorizontalBrick = getFrom(enumReflected, "HorizontalBrick");
    public static HatchStyle Weave = getFrom(enumReflected, "Weave");
    public static HatchStyle Plaid = getFrom(enumReflected, "Plaid");
    public static HatchStyle Divot = getFrom(enumReflected, "Divot");
    public static HatchStyle DottedGrid = getFrom(enumReflected, "DottedGrid");
    public static HatchStyle DottedDiamond = getFrom(enumReflected, "DottedDiamond");
    public static HatchStyle Shingle = getFrom(enumReflected, "Shingle");
    public static HatchStyle Trellis = getFrom(enumReflected, "Trellis");
    public static HatchStyle Sphere = getFrom(enumReflected, "Sphere");
    public static HatchStyle SmallGrid = getFrom(enumReflected, "SmallGrid");
    public static HatchStyle SmallCheckerBoard = getFrom(enumReflected, "SmallCheckerBoard");
    public static HatchStyle LargeCheckerBoard = getFrom(enumReflected, "LargeCheckerBoard");
    public static HatchStyle OutlinedDiamond = getFrom(enumReflected, "OutlinedDiamond");
    public static HatchStyle SolidDiamond = getFrom(enumReflected, "SolidDiamond");


    // Flags management section


}