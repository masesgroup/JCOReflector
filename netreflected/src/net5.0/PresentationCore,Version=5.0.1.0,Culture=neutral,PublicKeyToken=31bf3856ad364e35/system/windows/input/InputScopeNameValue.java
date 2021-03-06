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

package system.windows.input;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Windows.Input.InputScopeNameValue, PresentationCore, Version=5.0.1.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.InputScopeNameValue" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.InputScopeNameValue</a>
 */
public class InputScopeNameValue extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=5.0.1.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=5.0.1.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Input.InputScopeNameValue
     */
    public static final String className = "System.Windows.Input.InputScopeNameValue";
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

    public InputScopeNameValue(Object instance) {
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

    public InputScopeNameValue() {
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

    final static InputScopeNameValue getFrom(JCEnum object, String value) {
        try {
            return new InputScopeNameValue(object.fromValue(value));
        } catch (JCException e) {
            return new InputScopeNameValue(object);
        }
    }

    // Enum fields section
    
    public static InputScopeNameValue Default = getFrom(enumReflected, "Default");
    public static InputScopeNameValue Url = getFrom(enumReflected, "Url");
    public static InputScopeNameValue FullFilePath = getFrom(enumReflected, "FullFilePath");
    public static InputScopeNameValue FileName = getFrom(enumReflected, "FileName");
    public static InputScopeNameValue EmailUserName = getFrom(enumReflected, "EmailUserName");
    public static InputScopeNameValue EmailSmtpAddress = getFrom(enumReflected, "EmailSmtpAddress");
    public static InputScopeNameValue LogOnName = getFrom(enumReflected, "LogOnName");
    public static InputScopeNameValue PersonalFullName = getFrom(enumReflected, "PersonalFullName");
    public static InputScopeNameValue PersonalNamePrefix = getFrom(enumReflected, "PersonalNamePrefix");
    public static InputScopeNameValue PersonalGivenName = getFrom(enumReflected, "PersonalGivenName");
    public static InputScopeNameValue PersonalMiddleName = getFrom(enumReflected, "PersonalMiddleName");
    public static InputScopeNameValue PersonalSurname = getFrom(enumReflected, "PersonalSurname");
    public static InputScopeNameValue PersonalNameSuffix = getFrom(enumReflected, "PersonalNameSuffix");
    public static InputScopeNameValue PostalAddress = getFrom(enumReflected, "PostalAddress");
    public static InputScopeNameValue PostalCode = getFrom(enumReflected, "PostalCode");
    public static InputScopeNameValue AddressStreet = getFrom(enumReflected, "AddressStreet");
    public static InputScopeNameValue AddressStateOrProvince = getFrom(enumReflected, "AddressStateOrProvince");
    public static InputScopeNameValue AddressCity = getFrom(enumReflected, "AddressCity");
    public static InputScopeNameValue AddressCountryName = getFrom(enumReflected, "AddressCountryName");
    public static InputScopeNameValue AddressCountryShortName = getFrom(enumReflected, "AddressCountryShortName");
    public static InputScopeNameValue CurrencyAmountAndSymbol = getFrom(enumReflected, "CurrencyAmountAndSymbol");
    public static InputScopeNameValue CurrencyAmount = getFrom(enumReflected, "CurrencyAmount");
    public static InputScopeNameValue Date = getFrom(enumReflected, "Date");
    public static InputScopeNameValue DateMonth = getFrom(enumReflected, "DateMonth");
    public static InputScopeNameValue DateDay = getFrom(enumReflected, "DateDay");
    public static InputScopeNameValue DateYear = getFrom(enumReflected, "DateYear");
    public static InputScopeNameValue DateMonthName = getFrom(enumReflected, "DateMonthName");
    public static InputScopeNameValue DateDayName = getFrom(enumReflected, "DateDayName");
    public static InputScopeNameValue Digits = getFrom(enumReflected, "Digits");
    public static InputScopeNameValue Number = getFrom(enumReflected, "Number");
    public static InputScopeNameValue OneChar = getFrom(enumReflected, "OneChar");
    public static InputScopeNameValue Password = getFrom(enumReflected, "Password");
    public static InputScopeNameValue TelephoneNumber = getFrom(enumReflected, "TelephoneNumber");
    public static InputScopeNameValue TelephoneCountryCode = getFrom(enumReflected, "TelephoneCountryCode");
    public static InputScopeNameValue TelephoneAreaCode = getFrom(enumReflected, "TelephoneAreaCode");
    public static InputScopeNameValue TelephoneLocalNumber = getFrom(enumReflected, "TelephoneLocalNumber");
    public static InputScopeNameValue Time = getFrom(enumReflected, "Time");
    public static InputScopeNameValue TimeHour = getFrom(enumReflected, "TimeHour");
    public static InputScopeNameValue TimeMinorSec = getFrom(enumReflected, "TimeMinorSec");
    public static InputScopeNameValue NumberFullWidth = getFrom(enumReflected, "NumberFullWidth");
    public static InputScopeNameValue AlphanumericHalfWidth = getFrom(enumReflected, "AlphanumericHalfWidth");
    public static InputScopeNameValue AlphanumericFullWidth = getFrom(enumReflected, "AlphanumericFullWidth");
    public static InputScopeNameValue CurrencyChinese = getFrom(enumReflected, "CurrencyChinese");
    public static InputScopeNameValue Bopomofo = getFrom(enumReflected, "Bopomofo");
    public static InputScopeNameValue Hiragana = getFrom(enumReflected, "Hiragana");
    public static InputScopeNameValue KatakanaHalfWidth = getFrom(enumReflected, "KatakanaHalfWidth");
    public static InputScopeNameValue KatakanaFullWidth = getFrom(enumReflected, "KatakanaFullWidth");
    public static InputScopeNameValue Hanja = getFrom(enumReflected, "Hanja");
    public static InputScopeNameValue Xml = getFrom(enumReflected, "Xml");
    public static InputScopeNameValue Srgs = getFrom(enumReflected, "Srgs");
    public static InputScopeNameValue RegularExpression = getFrom(enumReflected, "RegularExpression");
    public static InputScopeNameValue PhraseList = getFrom(enumReflected, "PhraseList");


    // Flags management section


}