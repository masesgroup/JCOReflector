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

package system.resources.tools;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.codedom.CodeCompileUnit;
import system.collections.IDictionary;
import system.collections.IDictionaryImplementation;
import system.codedom.compiler.CodeDomProvider;


/**
 * The base .NET class managing System.Resources.Tools.StronglyTypedResourceBuilder, System.Windows.Forms.Design, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Resources.Tools.StronglyTypedResourceBuilder" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Resources.Tools.StronglyTypedResourceBuilder</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class StronglyTypedResourceBuilder extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms.Design, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms.Design, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms.Design
     */
    public static final String assemblyShortName = "System.Windows.Forms.Design";
    /**
     * Qualified class name: System.Resources.Tools.StronglyTypedResourceBuilder
     */
    public static final String className = "System.Resources.Tools.StronglyTypedResourceBuilder";
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
    public StronglyTypedResourceBuilder(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link StronglyTypedResourceBuilder}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link StronglyTypedResourceBuilder} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static StronglyTypedResourceBuilder cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new StronglyTypedResourceBuilder(from.getJCOInstance());
    }

    // Constructors section
    
    public StronglyTypedResourceBuilder() throws Throwable {
    }

    
    // Methods section
    
    public static CodeCompileUnit Create(IDictionary resourceList, java.lang.String baseName, java.lang.String generatedCodeNamespace, CodeDomProvider codeProvider, boolean internalClass, JCORefOut unmatchable) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.IndexOutOfRangeException, system.TypeLoadException, system.OutOfMemoryException, system.NotImplementedException, system.io.FileLoadException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", resourceList == null ? null : resourceList.getJCOInstance(), baseName, generatedCodeNamespace, codeProvider == null ? null : codeProvider.getJCOInstance(), internalClass, unmatchable.getJCRefOut());
            return new CodeCompileUnit(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CodeCompileUnit Create(IDictionary resourceList, java.lang.String baseName, java.lang.String generatedCodeNamespace, java.lang.String resourcesNamespace, CodeDomProvider codeProvider, boolean internalClass, JCORefOut unmatchable) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.TypeLoadException, system.OutOfMemoryException, system.NotImplementedException, system.io.FileLoadException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", resourceList == null ? null : resourceList.getJCOInstance(), baseName, generatedCodeNamespace, resourcesNamespace, codeProvider == null ? null : codeProvider.getJCOInstance(), internalClass, unmatchable.getJCRefOut());
            return new CodeCompileUnit(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CodeCompileUnit Create(java.lang.String resxFile, java.lang.String baseName, java.lang.String generatedCodeNamespace, CodeDomProvider codeProvider, boolean internalClass, JCORefOut unmatchable) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.xml.XmlException, system.globalization.CultureNotFoundException, system.security.SecurityException, system.TypeLoadException, system.runtime.serialization.SerializationException, system.reflection.TargetInvocationException, system.IndexOutOfRangeException, system.NotImplementedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", resxFile, baseName, generatedCodeNamespace, codeProvider == null ? null : codeProvider.getJCOInstance(), internalClass, unmatchable.getJCRefOut());
            return new CodeCompileUnit(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static CodeCompileUnit Create(java.lang.String resxFile, java.lang.String baseName, java.lang.String generatedCodeNamespace, java.lang.String resourcesNamespace, CodeDomProvider codeProvider, boolean internalClass, JCORefOut unmatchable) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.runtime.serialization.SerializationException, system.xml.XmlException, system.globalization.CultureNotFoundException, system.security.SecurityException, system.TypeLoadException, system.FormatException, system.reflection.TargetInvocationException, system.OutOfMemoryException, system.NotImplementedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreate = (JCObject)classType.Invoke("Create", resxFile, baseName, generatedCodeNamespace, resourcesNamespace, codeProvider == null ? null : codeProvider.getJCOInstance(), internalClass, unmatchable.getJCRefOut());
            return new CodeCompileUnit(objCreate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String VerifyResourceName(java.lang.String key, CodeDomProvider provider) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("VerifyResourceName", key, provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}