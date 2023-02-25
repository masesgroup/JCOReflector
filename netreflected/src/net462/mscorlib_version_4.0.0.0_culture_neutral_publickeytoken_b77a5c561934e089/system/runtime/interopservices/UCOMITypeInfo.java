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

package system.runtime.interopservices;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.runtime.interopservices.INVOKEKIND;
import system.Guid;
import system.runtime.interopservices.UCOMITypeLib;
import system.runtime.interopservices.UCOMITypeLibImplementation;
import system.runtime.interopservices.UCOMITypeInfo;
import system.runtime.interopservices.UCOMITypeInfoImplementation;
import system.runtime.interopservices.UCOMITypeComp;
import system.runtime.interopservices.UCOMITypeCompImplementation;


/**
 * The base .NET class managing System.Runtime.InteropServices.UCOMITypeInfo, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.UCOMITypeInfo" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.UCOMITypeInfo</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public interface UCOMITypeInfo extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: mscorlib
     */
    public static final String assemblyShortName = "mscorlib";
    /**
     * Qualified class name: System.Runtime.InteropServices.UCOMITypeInfo
     */
    public static final String className = "System.Runtime.InteropServices.UCOMITypeInfo";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link UCOMITypeInfo}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link UCOMITypeInfo} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static UCOMITypeInfo ToUCOMITypeInfo(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new UCOMITypeInfoImplementation(from.getJCOInstance());
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

    public void GetContainingTypeLib(JCORefOut<UCOMITypeLib> ppTLB, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pIndex) throws Throwable;

    public void GetDllEntry(int memid, INVOKEKIND invKind, JCORefOut pBstrDllName, JCORefOut pBstrName, JCORefOut<java.util.concurrent.atomic.AtomicReference<java.lang.Short>> pwOrdinal) throws Throwable;

    public void GetDocumentation(int index, JCORefOut strName, JCORefOut strDocString, JCORefOut<java.util.concurrent.atomic.AtomicInteger> dwHelpContext, JCORefOut strHelpFile) throws Throwable;

    public void GetIDsOfNames(java.lang.String[] rgszNames, int cNames, JCORefOut pMemId) throws Throwable;

    public void GetImplTypeFlags(int index, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pImplTypeFlags) throws Throwable;

    public void GetMops(int memid, JCORefOut pBstrMops) throws Throwable;

    public void GetNames(int memid, JCORefOut rgBstrNames, int cMaxNames, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pcNames) throws Throwable;

    public void GetRefTypeInfo(int hRef, JCORefOut<UCOMITypeInfo> ppTI) throws Throwable;

    public void GetRefTypeOfImplType(int index, JCORefOut<java.util.concurrent.atomic.AtomicInteger> href) throws Throwable;

    public void GetTypeComp(JCORefOut<UCOMITypeComp> ppTComp) throws Throwable;


    
    // Properties section
    


    // Instance Events section
    

}