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

package system.windows.input;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Input.Key, WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.Key" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.Key</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class Key extends NetObject  {
    /**
     * Fully assembly qualified name: WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: WindowsBase
     */
    public static final String assemblyShortName = "WindowsBase";
    /**
     * Qualified class name: System.Windows.Input.Key
     */
    public static final String className = "System.Windows.Input.Key";
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
    public Key(java.lang.Object instance) {
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

    public Key() {
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

    final static Key getFrom(JCEnum object, String value) {
        try {
            return new Key(object.fromValue(value));
        } catch (JCException e) {
            return new Key(object);
        }
    }

    // Enum fields section
    
    public static Key None = getFrom(enumReflected, "None");
    public static Key Cancel = getFrom(enumReflected, "Cancel");
    public static Key Back = getFrom(enumReflected, "Back");
    public static Key Tab = getFrom(enumReflected, "Tab");
    public static Key LineFeed = getFrom(enumReflected, "LineFeed");
    public static Key Clear = getFrom(enumReflected, "Clear");
    public static Key Return = getFrom(enumReflected, "Return");
    public static Key Enter = getFrom(enumReflected, "Enter");
    public static Key Pause = getFrom(enumReflected, "Pause");
    public static Key Capital = getFrom(enumReflected, "Capital");
    public static Key CapsLock = getFrom(enumReflected, "CapsLock");
    public static Key KanaMode = getFrom(enumReflected, "KanaMode");
    public static Key HangulMode = getFrom(enumReflected, "HangulMode");
    public static Key JunjaMode = getFrom(enumReflected, "JunjaMode");
    public static Key FinalMode = getFrom(enumReflected, "FinalMode");
    public static Key HanjaMode = getFrom(enumReflected, "HanjaMode");
    public static Key KanjiMode = getFrom(enumReflected, "KanjiMode");
    public static Key Escape = getFrom(enumReflected, "Escape");
    public static Key ImeConvert = getFrom(enumReflected, "ImeConvert");
    public static Key ImeNonConvert = getFrom(enumReflected, "ImeNonConvert");
    public static Key ImeAccept = getFrom(enumReflected, "ImeAccept");
    public static Key ImeModeChange = getFrom(enumReflected, "ImeModeChange");
    public static Key Space = getFrom(enumReflected, "Space");
    public static Key Prior = getFrom(enumReflected, "Prior");
    public static Key PageUp = getFrom(enumReflected, "PageUp");
    public static Key Next = getFrom(enumReflected, "Next");
    public static Key PageDown = getFrom(enumReflected, "PageDown");
    public static Key End = getFrom(enumReflected, "End");
    public static Key Home = getFrom(enumReflected, "Home");
    public static Key Left = getFrom(enumReflected, "Left");
    public static Key Up = getFrom(enumReflected, "Up");
    public static Key Right = getFrom(enumReflected, "Right");
    public static Key Down = getFrom(enumReflected, "Down");
    public static Key Select = getFrom(enumReflected, "Select");
    public static Key Print = getFrom(enumReflected, "Print");
    public static Key Execute = getFrom(enumReflected, "Execute");
    public static Key Snapshot = getFrom(enumReflected, "Snapshot");
    public static Key PrintScreen = getFrom(enumReflected, "PrintScreen");
    public static Key Insert = getFrom(enumReflected, "Insert");
    public static Key Delete = getFrom(enumReflected, "Delete");
    public static Key Help = getFrom(enumReflected, "Help");
    public static Key D0 = getFrom(enumReflected, "D0");
    public static Key D1 = getFrom(enumReflected, "D1");
    public static Key D2 = getFrom(enumReflected, "D2");
    public static Key D3 = getFrom(enumReflected, "D3");
    public static Key D4 = getFrom(enumReflected, "D4");
    public static Key D5 = getFrom(enumReflected, "D5");
    public static Key D6 = getFrom(enumReflected, "D6");
    public static Key D7 = getFrom(enumReflected, "D7");
    public static Key D8 = getFrom(enumReflected, "D8");
    public static Key D9 = getFrom(enumReflected, "D9");
    public static Key A = getFrom(enumReflected, "A");
    public static Key B = getFrom(enumReflected, "B");
    public static Key C = getFrom(enumReflected, "C");
    public static Key D = getFrom(enumReflected, "D");
    public static Key E = getFrom(enumReflected, "E");
    public static Key F = getFrom(enumReflected, "F");
    public static Key G = getFrom(enumReflected, "G");
    public static Key H = getFrom(enumReflected, "H");
    public static Key I = getFrom(enumReflected, "I");
    public static Key J = getFrom(enumReflected, "J");
    public static Key K = getFrom(enumReflected, "K");
    public static Key L = getFrom(enumReflected, "L");
    public static Key M = getFrom(enumReflected, "M");
    public static Key N = getFrom(enumReflected, "N");
    public static Key O = getFrom(enumReflected, "O");
    public static Key P = getFrom(enumReflected, "P");
    public static Key Q = getFrom(enumReflected, "Q");
    public static Key R = getFrom(enumReflected, "R");
    public static Key S = getFrom(enumReflected, "S");
    public static Key T = getFrom(enumReflected, "T");
    public static Key U = getFrom(enumReflected, "U");
    public static Key V = getFrom(enumReflected, "V");
    public static Key W = getFrom(enumReflected, "W");
    public static Key X = getFrom(enumReflected, "X");
    public static Key Y = getFrom(enumReflected, "Y");
    public static Key Z = getFrom(enumReflected, "Z");
    public static Key LWin = getFrom(enumReflected, "LWin");
    public static Key RWin = getFrom(enumReflected, "RWin");
    public static Key Apps = getFrom(enumReflected, "Apps");
    public static Key Sleep = getFrom(enumReflected, "Sleep");
    public static Key NumPad0 = getFrom(enumReflected, "NumPad0");
    public static Key NumPad1 = getFrom(enumReflected, "NumPad1");
    public static Key NumPad2 = getFrom(enumReflected, "NumPad2");
    public static Key NumPad3 = getFrom(enumReflected, "NumPad3");
    public static Key NumPad4 = getFrom(enumReflected, "NumPad4");
    public static Key NumPad5 = getFrom(enumReflected, "NumPad5");
    public static Key NumPad6 = getFrom(enumReflected, "NumPad6");
    public static Key NumPad7 = getFrom(enumReflected, "NumPad7");
    public static Key NumPad8 = getFrom(enumReflected, "NumPad8");
    public static Key NumPad9 = getFrom(enumReflected, "NumPad9");
    public static Key Multiply = getFrom(enumReflected, "Multiply");
    public static Key Add = getFrom(enumReflected, "Add");
    public static Key Separator = getFrom(enumReflected, "Separator");
    public static Key Subtract = getFrom(enumReflected, "Subtract");
    public static Key Decimal = getFrom(enumReflected, "Decimal");
    public static Key Divide = getFrom(enumReflected, "Divide");
    public static Key F1 = getFrom(enumReflected, "F1");
    public static Key F2 = getFrom(enumReflected, "F2");
    public static Key F3 = getFrom(enumReflected, "F3");
    public static Key F4 = getFrom(enumReflected, "F4");
    public static Key F5 = getFrom(enumReflected, "F5");
    public static Key F6 = getFrom(enumReflected, "F6");
    public static Key F7 = getFrom(enumReflected, "F7");
    public static Key F8 = getFrom(enumReflected, "F8");
    public static Key F9 = getFrom(enumReflected, "F9");
    public static Key F10 = getFrom(enumReflected, "F10");
    public static Key F11 = getFrom(enumReflected, "F11");
    public static Key F12 = getFrom(enumReflected, "F12");
    public static Key F13 = getFrom(enumReflected, "F13");
    public static Key F14 = getFrom(enumReflected, "F14");
    public static Key F15 = getFrom(enumReflected, "F15");
    public static Key F16 = getFrom(enumReflected, "F16");
    public static Key F17 = getFrom(enumReflected, "F17");
    public static Key F18 = getFrom(enumReflected, "F18");
    public static Key F19 = getFrom(enumReflected, "F19");
    public static Key F20 = getFrom(enumReflected, "F20");
    public static Key F21 = getFrom(enumReflected, "F21");
    public static Key F22 = getFrom(enumReflected, "F22");
    public static Key F23 = getFrom(enumReflected, "F23");
    public static Key F24 = getFrom(enumReflected, "F24");
    public static Key NumLock = getFrom(enumReflected, "NumLock");
    public static Key Scroll = getFrom(enumReflected, "Scroll");
    public static Key LeftShift = getFrom(enumReflected, "LeftShift");
    public static Key RightShift = getFrom(enumReflected, "RightShift");
    public static Key LeftCtrl = getFrom(enumReflected, "LeftCtrl");
    public static Key RightCtrl = getFrom(enumReflected, "RightCtrl");
    public static Key LeftAlt = getFrom(enumReflected, "LeftAlt");
    public static Key RightAlt = getFrom(enumReflected, "RightAlt");
    public static Key BrowserBack = getFrom(enumReflected, "BrowserBack");
    public static Key BrowserForward = getFrom(enumReflected, "BrowserForward");
    public static Key BrowserRefresh = getFrom(enumReflected, "BrowserRefresh");
    public static Key BrowserStop = getFrom(enumReflected, "BrowserStop");
    public static Key BrowserSearch = getFrom(enumReflected, "BrowserSearch");
    public static Key BrowserFavorites = getFrom(enumReflected, "BrowserFavorites");
    public static Key BrowserHome = getFrom(enumReflected, "BrowserHome");
    public static Key VolumeMute = getFrom(enumReflected, "VolumeMute");
    public static Key VolumeDown = getFrom(enumReflected, "VolumeDown");
    public static Key VolumeUp = getFrom(enumReflected, "VolumeUp");
    public static Key MediaNextTrack = getFrom(enumReflected, "MediaNextTrack");
    public static Key MediaPreviousTrack = getFrom(enumReflected, "MediaPreviousTrack");
    public static Key MediaStop = getFrom(enumReflected, "MediaStop");
    public static Key MediaPlayPause = getFrom(enumReflected, "MediaPlayPause");
    public static Key LaunchMail = getFrom(enumReflected, "LaunchMail");
    public static Key SelectMedia = getFrom(enumReflected, "SelectMedia");
    public static Key LaunchApplication1 = getFrom(enumReflected, "LaunchApplication1");
    public static Key LaunchApplication2 = getFrom(enumReflected, "LaunchApplication2");
    public static Key Oem1 = getFrom(enumReflected, "Oem1");
    public static Key OemSemicolon = getFrom(enumReflected, "OemSemicolon");
    public static Key OemPlus = getFrom(enumReflected, "OemPlus");
    public static Key OemComma = getFrom(enumReflected, "OemComma");
    public static Key OemMinus = getFrom(enumReflected, "OemMinus");
    public static Key OemPeriod = getFrom(enumReflected, "OemPeriod");
    public static Key Oem2 = getFrom(enumReflected, "Oem2");
    public static Key OemQuestion = getFrom(enumReflected, "OemQuestion");
    public static Key Oem3 = getFrom(enumReflected, "Oem3");
    public static Key OemTilde = getFrom(enumReflected, "OemTilde");
    public static Key AbntC1 = getFrom(enumReflected, "AbntC1");
    public static Key AbntC2 = getFrom(enumReflected, "AbntC2");
    public static Key Oem4 = getFrom(enumReflected, "Oem4");
    public static Key OemOpenBrackets = getFrom(enumReflected, "OemOpenBrackets");
    public static Key Oem5 = getFrom(enumReflected, "Oem5");
    public static Key OemPipe = getFrom(enumReflected, "OemPipe");
    public static Key Oem6 = getFrom(enumReflected, "Oem6");
    public static Key OemCloseBrackets = getFrom(enumReflected, "OemCloseBrackets");
    public static Key Oem7 = getFrom(enumReflected, "Oem7");
    public static Key OemQuotes = getFrom(enumReflected, "OemQuotes");
    public static Key Oem8 = getFrom(enumReflected, "Oem8");
    public static Key Oem102 = getFrom(enumReflected, "Oem102");
    public static Key OemBackslash = getFrom(enumReflected, "OemBackslash");
    public static Key ImeProcessed = getFrom(enumReflected, "ImeProcessed");
    public static Key System = getFrom(enumReflected, "System");
    public static Key OemAttn = getFrom(enumReflected, "OemAttn");
    public static Key DbeAlphanumeric = getFrom(enumReflected, "DbeAlphanumeric");
    public static Key OemFinish = getFrom(enumReflected, "OemFinish");
    public static Key DbeKatakana = getFrom(enumReflected, "DbeKatakana");
    public static Key OemCopy = getFrom(enumReflected, "OemCopy");
    public static Key DbeHiragana = getFrom(enumReflected, "DbeHiragana");
    public static Key OemAuto = getFrom(enumReflected, "OemAuto");
    public static Key DbeSbcsChar = getFrom(enumReflected, "DbeSbcsChar");
    public static Key OemEnlw = getFrom(enumReflected, "OemEnlw");
    public static Key DbeDbcsChar = getFrom(enumReflected, "DbeDbcsChar");
    public static Key OemBackTab = getFrom(enumReflected, "OemBackTab");
    public static Key DbeRoman = getFrom(enumReflected, "DbeRoman");
    public static Key Attn = getFrom(enumReflected, "Attn");
    public static Key DbeNoRoman = getFrom(enumReflected, "DbeNoRoman");
    public static Key CrSel = getFrom(enumReflected, "CrSel");
    public static Key DbeEnterWordRegisterMode = getFrom(enumReflected, "DbeEnterWordRegisterMode");
    public static Key ExSel = getFrom(enumReflected, "ExSel");
    public static Key DbeEnterImeConfigureMode = getFrom(enumReflected, "DbeEnterImeConfigureMode");
    public static Key EraseEof = getFrom(enumReflected, "EraseEof");
    public static Key DbeFlushString = getFrom(enumReflected, "DbeFlushString");
    public static Key Play = getFrom(enumReflected, "Play");
    public static Key DbeCodeInput = getFrom(enumReflected, "DbeCodeInput");
    public static Key Zoom = getFrom(enumReflected, "Zoom");
    public static Key DbeNoCodeInput = getFrom(enumReflected, "DbeNoCodeInput");
    public static Key NoName = getFrom(enumReflected, "NoName");
    public static Key DbeDetermineString = getFrom(enumReflected, "DbeDetermineString");
    public static Key Pa1 = getFrom(enumReflected, "Pa1");
    public static Key DbeEnterDialogConversionMode = getFrom(enumReflected, "DbeEnterDialogConversionMode");
    public static Key OemClear = getFrom(enumReflected, "OemClear");
    public static Key DeadCharProcessed = getFrom(enumReflected, "DeadCharProcessed");


    // Flags management section


}