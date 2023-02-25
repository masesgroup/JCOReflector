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
import system.runtime.interopservices.comtypes.FORMATETC;
import system.runtime.interopservices.comtypes.ADVF;
import system.runtime.interopservices.comtypes.IAdviseSink;
import system.runtime.interopservices.comtypes.IAdviseSinkImplementation;
import system.runtime.interopservices.comtypes.IEnumSTATDATA;
import system.runtime.interopservices.comtypes.IEnumSTATDATAImplementation;
import system.runtime.interopservices.comtypes.IEnumFORMATETC;
import system.runtime.interopservices.comtypes.IEnumFORMATETCImplementation;
import system.runtime.interopservices.comtypes.DATADIR;
import system.runtime.interopservices.comtypes.STGMEDIUM;


/**
 * The base .NET class managing System.Runtime.InteropServices.ComTypes.IDataObject, System.Runtime.InteropServices, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.IDataObject" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.IDataObject</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public interface IDataObject extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.Runtime.InteropServices, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Runtime.InteropServices, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Runtime.InteropServices
     */
    public static final String assemblyShortName = "System.Runtime.InteropServices";
    /**
     * Qualified class name: System.Runtime.InteropServices.ComTypes.IDataObject
     */
    public static final String className = "System.Runtime.InteropServices.ComTypes.IDataObject";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IDataObject}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IDataObject} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IDataObject ToIDataObject(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Runtime.InteropServices, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IDataObjectImplementation(from.getJCOInstance());
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
    
    public int DAdvise(JCORefOut<FORMATETC> pFormatetc, ADVF advf, IAdviseSink adviseSink, JCORefOut<java.util.concurrent.atomic.AtomicInteger> connection) throws Throwable;

    public int EnumDAdvise(JCORefOut<IEnumSTATDATA> enumAdvise) throws Throwable;

    public int GetCanonicalFormatEtc(JCORefOut<FORMATETC> formatIn, JCORefOut<FORMATETC> formatOut) throws Throwable;

    public int QueryGetData(JCORefOut<FORMATETC> format) throws Throwable;

    public IEnumFORMATETC EnumFormatEtc(DATADIR direction) throws Throwable;

    public void DUnadvise(int connection) throws Throwable;

    public void GetData(JCORefOut<FORMATETC> format, JCORefOut<STGMEDIUM> medium) throws Throwable;

    public void GetDataHere(JCORefOut<FORMATETC> format, JCORefOut<STGMEDIUM> medium) throws Throwable;

    public void SetData(JCORefOut<FORMATETC> formatIn, JCORefOut<STGMEDIUM> medium, boolean release) throws Throwable;


    
    // Properties section
    


    // Instance Events section
    

}