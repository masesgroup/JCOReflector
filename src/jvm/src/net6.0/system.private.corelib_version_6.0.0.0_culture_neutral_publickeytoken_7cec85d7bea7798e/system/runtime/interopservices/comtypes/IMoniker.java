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
import system.runtime.interopservices.comtypes.IMoniker;
import system.runtime.interopservices.comtypes.IMonikerImplementation;
import system.runtime.interopservices.comtypes.IBindCtx;
import system.runtime.interopservices.comtypes.IBindCtxImplementation;
import system.Guid;
import system.runtime.interopservices.comtypes.IEnumMoniker;
import system.runtime.interopservices.comtypes.IEnumMonikerImplementation;
import system.runtime.interopservices.comtypes.FILETIME;
import system.runtime.interopservices.comtypes.IStream;
import system.runtime.interopservices.comtypes.IStreamImplementation;


/**
 * The base .NET class managing System.Runtime.InteropServices.ComTypes.IMoniker, System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.IMoniker" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Runtime.InteropServices.ComTypes.IMoniker</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public interface IMoniker extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e
     */
    public static final String assemblyFullName = "System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e";
    /**
     * Assembly name: System.Private.CoreLib
     */
    public static final String assemblyShortName = "System.Private.CoreLib";
    /**
     * Qualified class name: System.Runtime.InteropServices.ComTypes.IMoniker
     */
    public static final String className = "System.Runtime.InteropServices.ComTypes.IMoniker";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IMoniker}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IMoniker} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IMoniker ToIMoniker(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Private.CoreLib, Version=6.0.0.0, Culture=neutral, PublicKeyToken=7cec85d7bea7798e");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IMonikerImplementation(from.getJCOInstance());
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
    
    public int IsDirty() throws Throwable;

    public int IsEqual(IMoniker pmkOtherMoniker) throws Throwable;

    public int IsRunning(IBindCtx pbc, IMoniker pmkToLeft, IMoniker pmkNewlyRunning) throws Throwable;

    public int IsSystemMoniker(JCORefOut<java.util.concurrent.atomic.AtomicInteger> pdwMksys) throws Throwable;

    public void BindToObject(IBindCtx pbc, IMoniker pmkToLeft, JCORefOut<Guid> riidResult, JCORefOut<NetObject> ppvResult) throws Throwable;

    public void BindToStorage(IBindCtx pbc, IMoniker pmkToLeft, JCORefOut<Guid> riid, JCORefOut<NetObject> ppvObj) throws Throwable;

    public void CommonPrefixWith(IMoniker pmkOther, JCORefOut<IMoniker> ppmkPrefix) throws Throwable;

    public void ComposeWith(IMoniker pmkRight, boolean fOnlyIfNotGeneric, JCORefOut<IMoniker> ppmkComposite) throws Throwable;

    public void Enum(boolean fForward, JCORefOut<IEnumMoniker> ppenumMoniker) throws Throwable;

    public void GetClassID(JCORefOut<Guid> pClassID) throws Throwable;

    public void GetDisplayName(IBindCtx pbc, IMoniker pmkToLeft, JCORefOut ppszDisplayName) throws Throwable;

    public void GetSizeMax(JCORefOut<java.util.concurrent.atomic.AtomicLong> pcbSize) throws Throwable;

    public void GetTimeOfLastChange(IBindCtx pbc, IMoniker pmkToLeft, JCORefOut<FILETIME> pFileTime) throws Throwable;

    public void Hash(JCORefOut<java.util.concurrent.atomic.AtomicInteger> pdwHash) throws Throwable;

    public void Inverse(JCORefOut<IMoniker> ppmk) throws Throwable;

    public void Load(IStream pStm) throws Throwable;

    public void ParseDisplayName(IBindCtx pbc, IMoniker pmkToLeft, java.lang.String pszDisplayName, JCORefOut<java.util.concurrent.atomic.AtomicInteger> pchEaten, JCORefOut<IMoniker> ppmkOut) throws Throwable;

    public void Reduce(IBindCtx pbc, int dwReduceHowFar, JCORefOut<IMoniker> ppmkToLeft, JCORefOut<IMoniker> ppmkReduced) throws Throwable;

    public void RelativePathTo(IMoniker pmkOther, JCORefOut<IMoniker> ppmkRelPath) throws Throwable;

    public void Save(IStream pStm, boolean fClearDirty) throws Throwable;


    
    // Properties section
    


    // Instance Events section
    

}