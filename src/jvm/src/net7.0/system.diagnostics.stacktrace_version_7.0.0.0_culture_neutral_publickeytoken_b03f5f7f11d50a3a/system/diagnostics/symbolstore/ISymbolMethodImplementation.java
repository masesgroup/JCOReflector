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
import system.diagnostics.symbolstore.ISymbolDocument;
import system.diagnostics.symbolstore.ISymbolDocumentImplementation;
import system.diagnostics.symbolstore.ISymbolNamespace;
import system.diagnostics.symbolstore.ISymbolNamespaceImplementation;
import system.diagnostics.symbolstore.ISymbolScope;
import system.diagnostics.symbolstore.ISymbolScopeImplementation;
import system.diagnostics.symbolstore.ISymbolVariable;
import system.diagnostics.symbolstore.ISymbolVariableImplementation;
import system.diagnostics.symbolstore.SymbolToken;


/**
 * The base .NET class managing System.Diagnostics.SymbolStore.ISymbolMethod, System.Diagnostics.StackTrace, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.SymbolStore.ISymbolMethod" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Diagnostics.SymbolStore.ISymbolMethod</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ISymbolMethodImplementation extends NetObject implements ISymbolMethod {
    /**
     * Fully assembly qualified name: System.Diagnostics.StackTrace, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Diagnostics.StackTrace, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Diagnostics.StackTrace
     */
    public static final String assemblyShortName = "System.Diagnostics.StackTrace";
    /**
     * Qualified class name: System.Diagnostics.SymbolStore.ISymbolMethod
     */
    public static final String className = "System.Diagnostics.SymbolStore.ISymbolMethod";
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
    public ISymbolMethodImplementation(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ISymbolMethod}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ISymbolMethod} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ISymbolMethod ToISymbolMethod(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ISymbolMethodImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public boolean GetSourceStartEnd(ISymbolDocument[] docs, int[] lines, int[] columns) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("GetSourceStartEnd", toObjectFromArray(docs), lines, columns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean GetSourceStartEnd(ISymbolDocument[] dupParam0, JCORefOut dupParam1, JCORefOut dupParam2) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("GetSourceStartEnd", toObjectFromArray(dupParam0), dupParam1.getJCRefOut(), dupParam2.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int GetOffset(ISymbolDocument document, int line, int column) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("GetOffset", document == null ? null : document.getJCOInstance(), line, column);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int[] GetRanges(ISymbolDocument document, int line, int column) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetRanges", document == null ? null : document.getJCOInstance(), line, column);
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            int[] resultingArray = new int[resultingArrayList.size()];
            for(int indexGetRanges = 0; indexGetRanges < resultingArrayList.size(); indexGetRanges++ ) {
				resultingArray[indexGetRanges] = (int)resultingArrayList.get(indexGetRanges);
            }
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISymbolNamespace GetNamespace() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetNamespace = (JCObject)classInstance.Invoke("GetNamespace");
            return new ISymbolNamespaceImplementation(objGetNamespace);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISymbolScope GetScope(int offset) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetScope = (JCObject)classInstance.Invoke("GetScope", offset);
            return new ISymbolScopeImplementation(objGetScope);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISymbolVariable[] GetParameters() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<ISymbolVariable> resultingArrayList = new ArrayList<ISymbolVariable>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetParameters");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new ISymbolVariableImplementation(resultingObject));
            }
            ISymbolVariable[] resultingArray = new ISymbolVariable[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void GetSequencePoints(int[] offsets, ISymbolDocument[] documents, int[] lines, int[] columns, int[] endLines, int[] endColumns) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetSequencePoints", offsets, toObjectFromArray(documents), lines, columns, endLines, endColumns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void GetSequencePoints(JCORefOut dupParam0, ISymbolDocument[] dupParam1, JCORefOut dupParam2, JCORefOut dupParam3, JCORefOut dupParam4, JCORefOut dupParam5) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetSequencePoints", dupParam0.getJCRefOut(), toObjectFromArray(dupParam1), dupParam2.getJCRefOut(), dupParam3.getJCRefOut(), dupParam4.getJCRefOut(), dupParam5.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getSequencePointCount() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("SequencePointCount");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ISymbolScope getRootScope() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RootScope");
            return new ISymbolScopeImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SymbolToken getToken() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Token");
            return new SymbolToken(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}