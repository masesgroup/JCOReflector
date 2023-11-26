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
import java.util.ArrayList;

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
 * The base .NET class managing System.Runtime.InteropServices.ComTypes.IDataObject, System.Runtime.InteropServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.IDataObject" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.IDataObject</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class IDataObjectImplementation extends NetObject implements IDataObject {
    /**
     * Fully assembly qualified name: System.Runtime.InteropServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Runtime.InteropServices, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Runtime.InteropServices
     */
    public static final String assemblyShortName = "System.Runtime.InteropServices";
    /**
     * Qualified class name: System.Runtime.InteropServices.ComTypes.IDataObject
     */
    public static final String className = "System.Runtime.InteropServices.ComTypes.IDataObject";
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
    public IDataObjectImplementation(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IDataObject}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IDataObject} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IDataObject ToIDataObject(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IDataObjectImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public int DAdvise(JCORefOut<FORMATETC> pFormatetc, ADVF advf, IAdviseSink adviseSink, JCORefOut<java.util.concurrent.atomic.AtomicInteger> connection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("DAdvise", pFormatetc.getJCRefOut(), advf == null ? null : advf.getJCOInstance(), adviseSink == null ? null : adviseSink.getJCOInstance(), connection.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int EnumDAdvise(JCORefOut<IEnumSTATDATA> enumAdvise) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("EnumDAdvise", enumAdvise.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int GetCanonicalFormatEtc(JCORefOut<FORMATETC> formatIn, JCORefOut<FORMATETC> formatOut) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("GetCanonicalFormatEtc", formatIn.getJCRefOut(), formatOut.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int QueryGetData(JCORefOut<FORMATETC> format) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("QueryGetData", format.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IEnumFORMATETC EnumFormatEtc(DATADIR direction) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objEnumFormatEtc = (JCObject)classInstance.Invoke("EnumFormatEtc", direction == null ? null : direction.getJCOInstance());
            return new IEnumFORMATETCImplementation(objEnumFormatEtc);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DUnadvise(int connection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DUnadvise", connection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void GetData(JCORefOut<FORMATETC> format, JCORefOut<STGMEDIUM> medium) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetData", format.getJCRefOut(), medium.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void GetDataHere(JCORefOut<FORMATETC> format, JCORefOut<STGMEDIUM> medium) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("GetDataHere", format.getJCRefOut(), medium.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetData(JCORefOut<FORMATETC> formatIn, JCORefOut<STGMEDIUM> medium, boolean release) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetData", formatIn.getJCRefOut(), medium.getJCRefOut(), release);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}