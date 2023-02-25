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

package system.runtime.interopservices.comtypes;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.runtime.interopservices.comtypes.ITypeInfo;
import system.runtime.interopservices.comtypes.ITypeInfoImplementation;
import system.runtime.interopservices.comtypes.INVOKEKIND;
import system.Guid;
import system.runtime.interopservices.comtypes.ITypeLib;
import system.runtime.interopservices.comtypes.ITypeLibImplementation;
import system.runtime.interopservices.comtypes.IMPLTYPEFLAGS;
import system.runtime.interopservices.comtypes.ITypeComp;
import system.runtime.interopservices.comtypes.ITypeCompImplementation;
import system.runtime.interopservices.comtypes.TYPEKIND;


/**
 * The base .NET class managing System.Runtime.InteropServices.ComTypes.ITypeInfo2, System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.ITypeInfo2" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.ITypeInfo2</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public interface ITypeInfo2 extends IJCOBridgeReflected, ITypeInfo {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.Runtime.InteropServices.ComTypes.ITypeInfo2
     */
    public static final String className = "System.Runtime.InteropServices.ComTypes.ITypeInfo2";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ITypeInfo2}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ITypeInfo2} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ITypeInfo2 ToITypeInfo2(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new ITypeInfo2Implementation(from.getJCOInstance());
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
    
    public void CreateInstance(NetObject pUnkOuter, JCORefOut<Guid> riid, JCORefOut<NetObject> ppvObj) throws Throwable;

    public void GetContainingTypeLib(JCORefOut<ITypeLib> ppTLB, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pIndex) throws Throwable;

    public void GetCustData(JCORefOut<Guid> guid, JCORefOut<NetObject> pVarVal) throws Throwable;

    public void GetDocumentation(int index, JCORefOut strName, JCORefOut strDocString, JCORefOut<java.util.concurrent.atomic.AtomicInteger> dwHelpContext, JCORefOut strHelpFile) throws Throwable;

    public void GetDocumentation2(int memid, JCORefOut pbstrHelpString, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pdwHelpStringContext, JCORefOut pbstrHelpStringDll) throws Throwable;

    public void GetFuncCustData(int index, JCORefOut<Guid> guid, JCORefOut<NetObject> pVarVal) throws Throwable;

    public void GetFuncIndexOfMemId(int memid, INVOKEKIND invKind, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pFuncIndex) throws Throwable;

    public void GetIDsOfNames(java.lang.String[] rgszNames, int cNames, JCORefOut pMemId) throws Throwable;

    public void GetImplTypeCustData(int index, JCORefOut<Guid> guid, JCORefOut<NetObject> pVarVal) throws Throwable;

    public void GetImplTypeFlags(int index, JCORefOut<IMPLTYPEFLAGS> pImplTypeFlags) throws Throwable;

    public void GetMops(int memid, JCORefOut pBstrMops) throws Throwable;

    public void GetNames(int memid, JCORefOut rgBstrNames, int cMaxNames, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pcNames) throws Throwable;

    public void GetParamCustData(int indexFunc, int indexParam, JCORefOut<Guid> guid, JCORefOut<NetObject> pVarVal) throws Throwable;

    public void GetRefTypeInfo(int hRef, JCORefOut<ITypeInfo> ppTI) throws Throwable;

    public void GetRefTypeOfImplType(int index, JCORefOut<java.util.concurrent.atomic.AtomicInteger> href) throws Throwable;

    public void GetTypeComp(JCORefOut<ITypeComp> ppTComp) throws Throwable;

    public void GetTypeFlags(JCORefOut<java.util.concurrent.atomic.AtomicInteger> pTypeFlags) throws Throwable;

    public void GetTypeKind(JCORefOut<TYPEKIND> pTypeKind) throws Throwable;

    public void GetVarCustData(int index, JCORefOut<Guid> guid, JCORefOut<NetObject> pVarVal) throws Throwable;

    public void GetVarIndexOfMemId(int memid, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pVarIndex) throws Throwable;


    
    // Properties section
    


    // Instance Events section
    

}