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

// Import section
import system.diagnostics.symbolstore.SymbolToken;
import system.diagnostics.symbolstore.ISymbolDocument;
import system.diagnostics.symbolstore.ISymbolDocumentImplementation;
import system.Guid;
import system.diagnostics.symbolstore.ISymbolMethod;
import system.diagnostics.symbolstore.ISymbolMethodImplementation;
import system.diagnostics.symbolstore.ISymbolNamespace;
import system.diagnostics.symbolstore.ISymbolNamespaceImplementation;
import system.diagnostics.symbolstore.ISymbolVariable;
import system.diagnostics.symbolstore.ISymbolVariableImplementation;


/**
 * The base .NET class managing System.Diagnostics.SymbolStore.ISymbolReader, System.Diagnostics.StackTrace, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.SymbolStore.ISymbolReader" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.SymbolStore.ISymbolReader</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public interface ISymbolReader extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.Diagnostics.StackTrace, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Diagnostics.StackTrace, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Diagnostics.StackTrace
     */
    public static final String assemblyShortName = "System.Diagnostics.StackTrace";
    /**
     * Qualified class name: System.Diagnostics.SymbolStore.ISymbolReader
     */
    public static final String className = "System.Diagnostics.SymbolStore.ISymbolReader";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ISymbolReader}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ISymbolReader} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ISymbolReader ToISymbolReader(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Diagnostics.StackTrace, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new ISymbolReaderImplementation(from.getJCOInstance());
    }

    /**
     * Returns the reflected Assembly name
     * 
     * @return A {@link String} representing the Fullname of reflected Assembly
     */
    public String getJCOAssemblyName();

    /**
     * Returns the reflected Class name
     * 
     * @return A {@link String} representing the Fullname of reflected Class
     */
    public String getJCOClassName();

    /**
     * Returns the reflected Class name used to build the object
     * 
     * @return A {@link String} representing the name used to allocated the object
     *         in CLR context
     */
    public String getJCOObjectName();

    /**
     * Returns the instantiated class
     * 
     * @return An {@link java.lang.Object} representing the instance of the instantiated Class
     */
    public java.lang.Object getJCOInstance();

    /**
     * Returns the instantiated class Type
     * 
     * @return A {@link JCType} representing the Type of the instantiated Class
     */
    public JCType getJCOType();

    // Methods section
    
    public byte[] GetSymAttribute(SymbolToken parent, java.lang.String name) throws Throwable;

    public ISymbolDocument GetDocument(java.lang.String url, Guid language, Guid languageVendor, Guid documentType) throws Throwable;

    public ISymbolDocument[] GetDocuments() throws Throwable;

    public ISymbolMethod GetMethod(SymbolToken method, int version) throws Throwable;

    public ISymbolMethod GetMethod(SymbolToken method) throws Throwable;

    public ISymbolMethod GetMethodFromDocumentPosition(ISymbolDocument document, int line, int column) throws Throwable;

    public ISymbolNamespace[] GetNamespaces() throws Throwable;

    public ISymbolVariable[] GetGlobalVariables() throws Throwable;

    public ISymbolVariable[] GetVariables(SymbolToken parent) throws Throwable;


    
    // Properties section
    
    public SymbolToken getUserEntryPoint() throws Throwable;



    // Instance Events section
    

}