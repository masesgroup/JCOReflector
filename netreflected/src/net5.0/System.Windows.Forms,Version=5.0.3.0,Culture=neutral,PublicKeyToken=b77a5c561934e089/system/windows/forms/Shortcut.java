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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Forms.Shortcut, System.Windows.Forms, Version=5.0.3.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.Shortcut" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.Shortcut</a>
 */
public class Shortcut extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=5.0.3.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=5.0.3.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.Shortcut
     */
    public static final String className = "System.Windows.Forms.Shortcut";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
            JCOReflector.writeLog(e);
            return null;
        }
    }

    static JCEnum createEnum() {
        try {
            return bridge.GetEnum(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
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

    public Shortcut(Object instance) {
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

    public Shortcut() {
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

    final static Shortcut getFrom(JCEnum object, String value) {
        try {
            return new Shortcut(object.fromValue(value));
        } catch (JCException e) {
            return new Shortcut(object);
        }
    }

    // Enum fields section
    
    public static Shortcut None = getFrom(enumReflected, "None");
    public static Shortcut Ins = getFrom(enumReflected, "Ins");
    public static Shortcut Del = getFrom(enumReflected, "Del");
    public static Shortcut F1 = getFrom(enumReflected, "F1");
    public static Shortcut F2 = getFrom(enumReflected, "F2");
    public static Shortcut F3 = getFrom(enumReflected, "F3");
    public static Shortcut F4 = getFrom(enumReflected, "F4");
    public static Shortcut F5 = getFrom(enumReflected, "F5");
    public static Shortcut F6 = getFrom(enumReflected, "F6");
    public static Shortcut F7 = getFrom(enumReflected, "F7");
    public static Shortcut F8 = getFrom(enumReflected, "F8");
    public static Shortcut F9 = getFrom(enumReflected, "F9");
    public static Shortcut F10 = getFrom(enumReflected, "F10");
    public static Shortcut F11 = getFrom(enumReflected, "F11");
    public static Shortcut F12 = getFrom(enumReflected, "F12");
    public static Shortcut ShiftIns = getFrom(enumReflected, "ShiftIns");
    public static Shortcut ShiftDel = getFrom(enumReflected, "ShiftDel");
    public static Shortcut ShiftF1 = getFrom(enumReflected, "ShiftF1");
    public static Shortcut ShiftF2 = getFrom(enumReflected, "ShiftF2");
    public static Shortcut ShiftF3 = getFrom(enumReflected, "ShiftF3");
    public static Shortcut ShiftF4 = getFrom(enumReflected, "ShiftF4");
    public static Shortcut ShiftF5 = getFrom(enumReflected, "ShiftF5");
    public static Shortcut ShiftF6 = getFrom(enumReflected, "ShiftF6");
    public static Shortcut ShiftF7 = getFrom(enumReflected, "ShiftF7");
    public static Shortcut ShiftF8 = getFrom(enumReflected, "ShiftF8");
    public static Shortcut ShiftF9 = getFrom(enumReflected, "ShiftF9");
    public static Shortcut ShiftF10 = getFrom(enumReflected, "ShiftF10");
    public static Shortcut ShiftF11 = getFrom(enumReflected, "ShiftF11");
    public static Shortcut ShiftF12 = getFrom(enumReflected, "ShiftF12");
    public static Shortcut CtrlIns = getFrom(enumReflected, "CtrlIns");
    public static Shortcut CtrlDel = getFrom(enumReflected, "CtrlDel");
    public static Shortcut Ctrl0 = getFrom(enumReflected, "Ctrl0");
    public static Shortcut Ctrl1 = getFrom(enumReflected, "Ctrl1");
    public static Shortcut Ctrl2 = getFrom(enumReflected, "Ctrl2");
    public static Shortcut Ctrl3 = getFrom(enumReflected, "Ctrl3");
    public static Shortcut Ctrl4 = getFrom(enumReflected, "Ctrl4");
    public static Shortcut Ctrl5 = getFrom(enumReflected, "Ctrl5");
    public static Shortcut Ctrl6 = getFrom(enumReflected, "Ctrl6");
    public static Shortcut Ctrl7 = getFrom(enumReflected, "Ctrl7");
    public static Shortcut Ctrl8 = getFrom(enumReflected, "Ctrl8");
    public static Shortcut Ctrl9 = getFrom(enumReflected, "Ctrl9");
    public static Shortcut CtrlA = getFrom(enumReflected, "CtrlA");
    public static Shortcut CtrlB = getFrom(enumReflected, "CtrlB");
    public static Shortcut CtrlC = getFrom(enumReflected, "CtrlC");
    public static Shortcut CtrlD = getFrom(enumReflected, "CtrlD");
    public static Shortcut CtrlE = getFrom(enumReflected, "CtrlE");
    public static Shortcut CtrlF = getFrom(enumReflected, "CtrlF");
    public static Shortcut CtrlG = getFrom(enumReflected, "CtrlG");
    public static Shortcut CtrlH = getFrom(enumReflected, "CtrlH");
    public static Shortcut CtrlI = getFrom(enumReflected, "CtrlI");
    public static Shortcut CtrlJ = getFrom(enumReflected, "CtrlJ");
    public static Shortcut CtrlK = getFrom(enumReflected, "CtrlK");
    public static Shortcut CtrlL = getFrom(enumReflected, "CtrlL");
    public static Shortcut CtrlM = getFrom(enumReflected, "CtrlM");
    public static Shortcut CtrlN = getFrom(enumReflected, "CtrlN");
    public static Shortcut CtrlO = getFrom(enumReflected, "CtrlO");
    public static Shortcut CtrlP = getFrom(enumReflected, "CtrlP");
    public static Shortcut CtrlQ = getFrom(enumReflected, "CtrlQ");
    public static Shortcut CtrlR = getFrom(enumReflected, "CtrlR");
    public static Shortcut CtrlS = getFrom(enumReflected, "CtrlS");
    public static Shortcut CtrlT = getFrom(enumReflected, "CtrlT");
    public static Shortcut CtrlU = getFrom(enumReflected, "CtrlU");
    public static Shortcut CtrlV = getFrom(enumReflected, "CtrlV");
    public static Shortcut CtrlW = getFrom(enumReflected, "CtrlW");
    public static Shortcut CtrlX = getFrom(enumReflected, "CtrlX");
    public static Shortcut CtrlY = getFrom(enumReflected, "CtrlY");
    public static Shortcut CtrlZ = getFrom(enumReflected, "CtrlZ");
    public static Shortcut CtrlF1 = getFrom(enumReflected, "CtrlF1");
    public static Shortcut CtrlF2 = getFrom(enumReflected, "CtrlF2");
    public static Shortcut CtrlF3 = getFrom(enumReflected, "CtrlF3");
    public static Shortcut CtrlF4 = getFrom(enumReflected, "CtrlF4");
    public static Shortcut CtrlF5 = getFrom(enumReflected, "CtrlF5");
    public static Shortcut CtrlF6 = getFrom(enumReflected, "CtrlF6");
    public static Shortcut CtrlF7 = getFrom(enumReflected, "CtrlF7");
    public static Shortcut CtrlF8 = getFrom(enumReflected, "CtrlF8");
    public static Shortcut CtrlF9 = getFrom(enumReflected, "CtrlF9");
    public static Shortcut CtrlF10 = getFrom(enumReflected, "CtrlF10");
    public static Shortcut CtrlF11 = getFrom(enumReflected, "CtrlF11");
    public static Shortcut CtrlF12 = getFrom(enumReflected, "CtrlF12");
    public static Shortcut CtrlShift0 = getFrom(enumReflected, "CtrlShift0");
    public static Shortcut CtrlShift1 = getFrom(enumReflected, "CtrlShift1");
    public static Shortcut CtrlShift2 = getFrom(enumReflected, "CtrlShift2");
    public static Shortcut CtrlShift3 = getFrom(enumReflected, "CtrlShift3");
    public static Shortcut CtrlShift4 = getFrom(enumReflected, "CtrlShift4");
    public static Shortcut CtrlShift5 = getFrom(enumReflected, "CtrlShift5");
    public static Shortcut CtrlShift6 = getFrom(enumReflected, "CtrlShift6");
    public static Shortcut CtrlShift7 = getFrom(enumReflected, "CtrlShift7");
    public static Shortcut CtrlShift8 = getFrom(enumReflected, "CtrlShift8");
    public static Shortcut CtrlShift9 = getFrom(enumReflected, "CtrlShift9");
    public static Shortcut CtrlShiftA = getFrom(enumReflected, "CtrlShiftA");
    public static Shortcut CtrlShiftB = getFrom(enumReflected, "CtrlShiftB");
    public static Shortcut CtrlShiftC = getFrom(enumReflected, "CtrlShiftC");
    public static Shortcut CtrlShiftD = getFrom(enumReflected, "CtrlShiftD");
    public static Shortcut CtrlShiftE = getFrom(enumReflected, "CtrlShiftE");
    public static Shortcut CtrlShiftF = getFrom(enumReflected, "CtrlShiftF");
    public static Shortcut CtrlShiftG = getFrom(enumReflected, "CtrlShiftG");
    public static Shortcut CtrlShiftH = getFrom(enumReflected, "CtrlShiftH");
    public static Shortcut CtrlShiftI = getFrom(enumReflected, "CtrlShiftI");
    public static Shortcut CtrlShiftJ = getFrom(enumReflected, "CtrlShiftJ");
    public static Shortcut CtrlShiftK = getFrom(enumReflected, "CtrlShiftK");
    public static Shortcut CtrlShiftL = getFrom(enumReflected, "CtrlShiftL");
    public static Shortcut CtrlShiftM = getFrom(enumReflected, "CtrlShiftM");
    public static Shortcut CtrlShiftN = getFrom(enumReflected, "CtrlShiftN");
    public static Shortcut CtrlShiftO = getFrom(enumReflected, "CtrlShiftO");
    public static Shortcut CtrlShiftP = getFrom(enumReflected, "CtrlShiftP");
    public static Shortcut CtrlShiftQ = getFrom(enumReflected, "CtrlShiftQ");
    public static Shortcut CtrlShiftR = getFrom(enumReflected, "CtrlShiftR");
    public static Shortcut CtrlShiftS = getFrom(enumReflected, "CtrlShiftS");
    public static Shortcut CtrlShiftT = getFrom(enumReflected, "CtrlShiftT");
    public static Shortcut CtrlShiftU = getFrom(enumReflected, "CtrlShiftU");
    public static Shortcut CtrlShiftV = getFrom(enumReflected, "CtrlShiftV");
    public static Shortcut CtrlShiftW = getFrom(enumReflected, "CtrlShiftW");
    public static Shortcut CtrlShiftX = getFrom(enumReflected, "CtrlShiftX");
    public static Shortcut CtrlShiftY = getFrom(enumReflected, "CtrlShiftY");
    public static Shortcut CtrlShiftZ = getFrom(enumReflected, "CtrlShiftZ");
    public static Shortcut CtrlShiftF1 = getFrom(enumReflected, "CtrlShiftF1");
    public static Shortcut CtrlShiftF2 = getFrom(enumReflected, "CtrlShiftF2");
    public static Shortcut CtrlShiftF3 = getFrom(enumReflected, "CtrlShiftF3");
    public static Shortcut CtrlShiftF4 = getFrom(enumReflected, "CtrlShiftF4");
    public static Shortcut CtrlShiftF5 = getFrom(enumReflected, "CtrlShiftF5");
    public static Shortcut CtrlShiftF6 = getFrom(enumReflected, "CtrlShiftF6");
    public static Shortcut CtrlShiftF7 = getFrom(enumReflected, "CtrlShiftF7");
    public static Shortcut CtrlShiftF8 = getFrom(enumReflected, "CtrlShiftF8");
    public static Shortcut CtrlShiftF9 = getFrom(enumReflected, "CtrlShiftF9");
    public static Shortcut CtrlShiftF10 = getFrom(enumReflected, "CtrlShiftF10");
    public static Shortcut CtrlShiftF11 = getFrom(enumReflected, "CtrlShiftF11");
    public static Shortcut CtrlShiftF12 = getFrom(enumReflected, "CtrlShiftF12");
    public static Shortcut AltBksp = getFrom(enumReflected, "AltBksp");
    public static Shortcut AltLeftArrow = getFrom(enumReflected, "AltLeftArrow");
    public static Shortcut AltUpArrow = getFrom(enumReflected, "AltUpArrow");
    public static Shortcut AltRightArrow = getFrom(enumReflected, "AltRightArrow");
    public static Shortcut AltDownArrow = getFrom(enumReflected, "AltDownArrow");
    public static Shortcut Alt0 = getFrom(enumReflected, "Alt0");
    public static Shortcut Alt1 = getFrom(enumReflected, "Alt1");
    public static Shortcut Alt2 = getFrom(enumReflected, "Alt2");
    public static Shortcut Alt3 = getFrom(enumReflected, "Alt3");
    public static Shortcut Alt4 = getFrom(enumReflected, "Alt4");
    public static Shortcut Alt5 = getFrom(enumReflected, "Alt5");
    public static Shortcut Alt6 = getFrom(enumReflected, "Alt6");
    public static Shortcut Alt7 = getFrom(enumReflected, "Alt7");
    public static Shortcut Alt8 = getFrom(enumReflected, "Alt8");
    public static Shortcut Alt9 = getFrom(enumReflected, "Alt9");
    public static Shortcut AltF1 = getFrom(enumReflected, "AltF1");
    public static Shortcut AltF2 = getFrom(enumReflected, "AltF2");
    public static Shortcut AltF3 = getFrom(enumReflected, "AltF3");
    public static Shortcut AltF4 = getFrom(enumReflected, "AltF4");
    public static Shortcut AltF5 = getFrom(enumReflected, "AltF5");
    public static Shortcut AltF6 = getFrom(enumReflected, "AltF6");
    public static Shortcut AltF7 = getFrom(enumReflected, "AltF7");
    public static Shortcut AltF8 = getFrom(enumReflected, "AltF8");
    public static Shortcut AltF9 = getFrom(enumReflected, "AltF9");
    public static Shortcut AltF10 = getFrom(enumReflected, "AltF10");
    public static Shortcut AltF11 = getFrom(enumReflected, "AltF11");
    public static Shortcut AltF12 = getFrom(enumReflected, "AltF12");


    // Flags management section


}