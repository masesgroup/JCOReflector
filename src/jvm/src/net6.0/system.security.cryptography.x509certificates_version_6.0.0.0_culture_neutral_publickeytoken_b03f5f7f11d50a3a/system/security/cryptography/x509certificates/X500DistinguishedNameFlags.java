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

package system.security.cryptography.x509certificates;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Security.Cryptography.X509Certificates.X500DistinguishedNameFlags, System.Security.Cryptography.X509Certificates, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.X509Certificates.X500DistinguishedNameFlags" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Security.Cryptography.X509Certificates.X500DistinguishedNameFlags</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class X500DistinguishedNameFlags extends NetObject  {
    /**
     * Fully assembly qualified name: System.Security.Cryptography.X509Certificates, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Security.Cryptography.X509Certificates, Version=6.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Security.Cryptography.X509Certificates
     */
    public static final String assemblyShortName = "System.Security.Cryptography.X509Certificates";
    /**
     * Qualified class name: System.Security.Cryptography.X509Certificates.X500DistinguishedNameFlags
     */
    public static final String className = "System.Security.Cryptography.X509Certificates.X500DistinguishedNameFlags";
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
    public X500DistinguishedNameFlags(java.lang.Object instance) {
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

    public X500DistinguishedNameFlags() {
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

    final static X500DistinguishedNameFlags getFrom(JCEnum object, String value) {
        try {
            return new X500DistinguishedNameFlags(object.fromValue(value));
        } catch (JCException e) {
            return new X500DistinguishedNameFlags(object);
        }
    }

    // Enum fields section
    
    public static X500DistinguishedNameFlags None = getFrom(enumReflected, "None");
    public static X500DistinguishedNameFlags Reversed = getFrom(enumReflected, "Reversed");
    public static X500DistinguishedNameFlags UseSemicolons = getFrom(enumReflected, "UseSemicolons");
    public static X500DistinguishedNameFlags DoNotUsePlusSign = getFrom(enumReflected, "DoNotUsePlusSign");
    public static X500DistinguishedNameFlags DoNotUseQuotes = getFrom(enumReflected, "DoNotUseQuotes");
    public static X500DistinguishedNameFlags UseCommas = getFrom(enumReflected, "UseCommas");
    public static X500DistinguishedNameFlags UseNewLines = getFrom(enumReflected, "UseNewLines");
    public static X500DistinguishedNameFlags UseUTF8Encoding = getFrom(enumReflected, "UseUTF8Encoding");
    public static X500DistinguishedNameFlags UseT61Encoding = getFrom(enumReflected, "UseT61Encoding");
    public static X500DistinguishedNameFlags ForceUTF8Encoding = getFrom(enumReflected, "ForceUTF8Encoding");


    // Flags management section

    public final X500DistinguishedNameFlags add(X500DistinguishedNameFlags val) throws Throwable {
        return new X500DistinguishedNameFlags(NetEnum.add(classInstance, val.classInstance));
    }

    public final X500DistinguishedNameFlags remove(X500DistinguishedNameFlags val) throws Throwable {
        return new X500DistinguishedNameFlags(NetEnum.remove(classInstance, val.classInstance));
    }

    public final boolean is(X500DistinguishedNameFlags val) throws Throwable {
        return NetEnum.is(classInstance, val.classInstance);
    }

    public final boolean has(X500DistinguishedNameFlags val) throws Throwable {
        return NetEnum.has(classInstance, val.classInstance);
    }
}