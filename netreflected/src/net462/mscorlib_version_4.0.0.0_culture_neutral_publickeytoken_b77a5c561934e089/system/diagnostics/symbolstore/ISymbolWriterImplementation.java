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

package system.diagnostics.symbolstore;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.diagnostics.symbolstore.ISymbolDocumentWriter;
import system.diagnostics.symbolstore.ISymbolDocumentWriterImplementation;
import system.Guid;
import system.diagnostics.symbolstore.SymbolToken;
import system.reflection.FieldAttributes;
import system.diagnostics.symbolstore.SymAddressKind;
import system.reflection.ParameterAttributes;


/**
 * The base .NET class managing System.Diagnostics.SymbolStore.ISymbolWriter, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.SymbolStore.ISymbolWriter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.SymbolStore.ISymbolWriter</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class ISymbolWriterImplementation extends NetObject implements ISymbolWriter {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Diagnostics.SymbolStore.ISymbolWriter
     */
    public static final String className = "System.Diagnostics.SymbolStore.ISymbolWriter";
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
    public ISymbolWriterImplementation(java.lang.Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ISymbolWriter}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ISymbolWriter} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ISymbolWriter ToISymbolWriter(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ISymbolWriterImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public int OpenScope(int startOffset) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("OpenScope", startOffset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISymbolDocumentWriter DefineDocument(java.lang.String url, Guid language, Guid languageVendor, Guid documentType) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDefineDocument = (JCObject)classInstance.Invoke("DefineDocument", url, language == null ? null : language.getJCOInstance(), languageVendor == null ? null : languageVendor.getJCOInstance(), documentType == null ? null : documentType.getJCOInstance());
            return new ISymbolDocumentWriterImplementation(objDefineDocument);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Close() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CloseMethod() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CloseMethod");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CloseNamespace() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CloseNamespace");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void CloseScope(int endOffset) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("CloseScope", endOffset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineField(SymbolToken parent, java.lang.String name, FieldAttributes attributes, byte[] signature, SymAddressKind addrKind, int addr1, int addr2, int addr3) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineField", parent == null ? null : parent.getJCOInstance(), name, attributes == null ? null : attributes.getJCOInstance(), signature, addrKind == null ? null : addrKind.getJCOInstance(), addr1, addr2, addr3);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineField(SymbolToken dupParam0, java.lang.String dupParam1, FieldAttributes dupParam2, JCORefOut dupParam3, SymAddressKind dupParam4, int dupParam5, int dupParam6, int dupParam7) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineField", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1, dupParam2 == null ? null : dupParam2.getJCOInstance(), dupParam3.getJCRefOut(), dupParam4 == null ? null : dupParam4.getJCOInstance(), dupParam5, dupParam6, dupParam7);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineGlobalVariable(java.lang.String name, FieldAttributes attributes, byte[] signature, SymAddressKind addrKind, int addr1, int addr2, int addr3) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineGlobalVariable", name, attributes == null ? null : attributes.getJCOInstance(), signature, addrKind == null ? null : addrKind.getJCOInstance(), addr1, addr2, addr3);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineGlobalVariable(java.lang.String dupParam0, FieldAttributes dupParam1, JCORefOut dupParam2, SymAddressKind dupParam3, int dupParam4, int dupParam5, int dupParam6) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineGlobalVariable", dupParam0, dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance(), dupParam4, dupParam5, dupParam6);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineLocalVariable(java.lang.String name, FieldAttributes attributes, byte[] signature, SymAddressKind addrKind, int addr1, int addr2, int addr3, int startOffset, int endOffset) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineLocalVariable", name, attributes == null ? null : attributes.getJCOInstance(), signature, addrKind == null ? null : addrKind.getJCOInstance(), addr1, addr2, addr3, startOffset, endOffset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineLocalVariable(java.lang.String dupParam0, FieldAttributes dupParam1, JCORefOut dupParam2, SymAddressKind dupParam3, int dupParam4, int dupParam5, int dupParam6, int dupParam7, int dupParam8) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineLocalVariable", dupParam0, dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2.getJCRefOut(), dupParam3 == null ? null : dupParam3.getJCOInstance(), dupParam4, dupParam5, dupParam6, dupParam7, dupParam8);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineParameter(java.lang.String name, ParameterAttributes attributes, int sequence, SymAddressKind addrKind, int addr1, int addr2, int addr3) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineParameter", name, attributes == null ? null : attributes.getJCOInstance(), sequence, addrKind == null ? null : addrKind.getJCOInstance(), addr1, addr2, addr3);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineSequencePoints(ISymbolDocumentWriter document, int[] offsets, int[] lines, int[] columns, int[] endLines, int[] endColumns) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineSequencePoints", document == null ? null : document.getJCOInstance(), offsets, lines, columns, endLines, endColumns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DefineSequencePoints(ISymbolDocumentWriter dupParam0, JCORefOut dupParam1, JCORefOut dupParam2, JCORefOut dupParam3, JCORefOut dupParam4, JCORefOut dupParam5) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DefineSequencePoints", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1.getJCRefOut(), dupParam2.getJCRefOut(), dupParam3.getJCRefOut(), dupParam4.getJCRefOut(), dupParam5.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OpenMethod(SymbolToken method) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OpenMethod", method == null ? null : method.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OpenNamespace(java.lang.String name) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OpenNamespace", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetMethodSourceRange(ISymbolDocumentWriter startDoc, int startLine, int startColumn, ISymbolDocumentWriter endDoc, int endLine, int endColumn) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetMethodSourceRange", startDoc == null ? null : startDoc.getJCOInstance(), startLine, startColumn, endDoc == null ? null : endDoc.getJCOInstance(), endLine, endColumn);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetScopeRange(int scopeID, int startOffset, int endOffset) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetScopeRange", scopeID, startOffset, endOffset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSymAttribute(SymbolToken parent, java.lang.String name, byte[] data) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSymAttribute", parent == null ? null : parent.getJCOInstance(), name, data);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSymAttribute(SymbolToken dupParam0, java.lang.String dupParam1, JCORefOut dupParam2) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSymAttribute", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1, dupParam2.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetUserEntryPoint(SymbolToken entryMethod) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetUserEntryPoint", entryMethod == null ? null : entryMethod.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void UsingNamespace(java.lang.String fullName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("UsingNamespace", fullName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}