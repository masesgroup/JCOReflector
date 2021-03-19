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

package system.codedom.compiler;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.codedom.compiler.CompilerResults;
import system.codedom.compiler.CompilerParameters;
import system.codedom.CodeCompileUnit;


/**
 * The base .NET class managing System.CodeDom.Compiler.ICodeCompiler, System.CodeDom, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.CodeDom.Compiler.ICodeCompiler" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.CodeDom.Compiler.ICodeCompiler</a>
 */
public class ICodeCompilerImplementation extends NetObject implements ICodeCompiler {
    /**
     * Fully assembly qualified name: System.CodeDom, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.CodeDom, Version=4.0.3.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.CodeDom
     */
    public static final String assemblyShortName = "System.CodeDom";
    /**
     * Qualified class name: System.CodeDom.Compiler.ICodeCompiler
     */
    public static final String className = "System.CodeDom.Compiler.ICodeCompiler";
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

    public ICodeCompilerImplementation(Object instance) throws Throwable {
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

    public Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ICodeCompiler}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ICodeCompiler} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ICodeCompiler ToICodeCompiler(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ICodeCompilerImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public CompilerResults CompileAssemblyFromDom(CompilerParameters options, CodeCompileUnit compilationUnit) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromDom = (JCObject)classInstance.Invoke("CompileAssemblyFromDom", options == null ? null : options.getJCOInstance(), compilationUnit == null ? null : compilationUnit.getJCOInstance());
            return new CompilerResults(objCompileAssemblyFromDom);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromDomBatch(CompilerParameters options, CodeCompileUnit[] compilationUnits) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromDomBatch = (JCObject)classInstance.Invoke("CompileAssemblyFromDomBatch", options == null ? null : options.getJCOInstance(), toObjectFromArray(compilationUnits));
            return new CompilerResults(objCompileAssemblyFromDomBatch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromFile(CompilerParameters options, java.lang.String fileName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromFile = (JCObject)classInstance.Invoke("CompileAssemblyFromFile", options == null ? null : options.getJCOInstance(), fileName);
            return new CompilerResults(objCompileAssemblyFromFile);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromFileBatch(CompilerParameters options, java.lang.String[] fileNames) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromFileBatch = (JCObject)classInstance.Invoke("CompileAssemblyFromFileBatch", options == null ? null : options.getJCOInstance(), fileNames);
            return new CompilerResults(objCompileAssemblyFromFileBatch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromFileBatch(CompilerParameters dupParam0, JCORefOut dupParam1) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromFileBatch = (JCObject)classInstance.Invoke("CompileAssemblyFromFileBatch", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1.getJCRefOut());
            return new CompilerResults(objCompileAssemblyFromFileBatch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromSource(CompilerParameters options, java.lang.String source) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromSource = (JCObject)classInstance.Invoke("CompileAssemblyFromSource", options == null ? null : options.getJCOInstance(), source);
            return new CompilerResults(objCompileAssemblyFromSource);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromSourceBatch(CompilerParameters options, java.lang.String[] sources) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromSourceBatch = (JCObject)classInstance.Invoke("CompileAssemblyFromSourceBatch", options == null ? null : options.getJCOInstance(), sources);
            return new CompilerResults(objCompileAssemblyFromSourceBatch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public CompilerResults CompileAssemblyFromSourceBatch(CompilerParameters dupParam0, JCORefOut dupParam1) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objCompileAssemblyFromSourceBatch = (JCObject)classInstance.Invoke("CompileAssemblyFromSourceBatch", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1.getJCRefOut());
            return new CompilerResults(objCompileAssemblyFromSourceBatch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}