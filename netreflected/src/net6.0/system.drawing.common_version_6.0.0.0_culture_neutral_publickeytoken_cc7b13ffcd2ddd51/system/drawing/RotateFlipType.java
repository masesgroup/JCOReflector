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

package system.drawing;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Drawing.RotateFlipType, System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.RotateFlipType" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.RotateFlipType</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class RotateFlipType extends NetObject  {
    /**
     * Fully assembly qualified name: System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Drawing.Common, Version=6.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Drawing.Common
     */
    public static final String assemblyShortName = "System.Drawing.Common";
    /**
     * Qualified class name: System.Drawing.RotateFlipType
     */
    public static final String className = "System.Drawing.RotateFlipType";
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
    public RotateFlipType(java.lang.Object instance) {
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

    public RotateFlipType() {
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

    final static RotateFlipType getFrom(JCEnum object, String value) {
        try {
            return new RotateFlipType(object.fromValue(value));
        } catch (JCException e) {
            return new RotateFlipType(object);
        }
    }

    // Enum fields section
    
    public static RotateFlipType Rotate180FlipXY = getFrom(enumReflected, "Rotate180FlipXY");
    public static RotateFlipType RotateNoneFlipNone = getFrom(enumReflected, "RotateNoneFlipNone");
    public static RotateFlipType Rotate90FlipNone = getFrom(enumReflected, "Rotate90FlipNone");
    public static RotateFlipType Rotate270FlipXY = getFrom(enumReflected, "Rotate270FlipXY");
    public static RotateFlipType Rotate180FlipNone = getFrom(enumReflected, "Rotate180FlipNone");
    public static RotateFlipType RotateNoneFlipXY = getFrom(enumReflected, "RotateNoneFlipXY");
    public static RotateFlipType Rotate270FlipNone = getFrom(enumReflected, "Rotate270FlipNone");
    public static RotateFlipType Rotate90FlipXY = getFrom(enumReflected, "Rotate90FlipXY");
    public static RotateFlipType RotateNoneFlipX = getFrom(enumReflected, "RotateNoneFlipX");
    public static RotateFlipType Rotate180FlipY = getFrom(enumReflected, "Rotate180FlipY");
    public static RotateFlipType Rotate90FlipX = getFrom(enumReflected, "Rotate90FlipX");
    public static RotateFlipType Rotate270FlipY = getFrom(enumReflected, "Rotate270FlipY");
    public static RotateFlipType Rotate180FlipX = getFrom(enumReflected, "Rotate180FlipX");
    public static RotateFlipType RotateNoneFlipY = getFrom(enumReflected, "RotateNoneFlipY");
    public static RotateFlipType Rotate270FlipX = getFrom(enumReflected, "Rotate270FlipX");
    public static RotateFlipType Rotate90FlipY = getFrom(enumReflected, "Rotate90FlipY");


    // Flags management section


}