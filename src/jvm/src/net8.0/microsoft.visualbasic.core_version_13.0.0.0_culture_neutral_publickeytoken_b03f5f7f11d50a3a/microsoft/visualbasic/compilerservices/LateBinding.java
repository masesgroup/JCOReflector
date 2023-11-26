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

package microsoft.visualbasic.compilerservices;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section


/**
 * The base .NET class managing Microsoft.VisualBasic.CompilerServices.LateBinding, Microsoft.VisualBasic.Core, Version=13.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.VisualBasic.CompilerServices.LateBinding" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.VisualBasic.CompilerServices.LateBinding</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class LateBinding extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.VisualBasic.Core, Version=13.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.VisualBasic.Core, Version=13.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.VisualBasic.Core
     */
    public static final String assemblyShortName = "Microsoft.VisualBasic.Core";
    /**
     * Qualified class name: Microsoft.VisualBasic.CompilerServices.LateBinding
     */
    public static final String className = "Microsoft.VisualBasic.CompilerServices.LateBinding";
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
    public LateBinding(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link LateBinding}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link LateBinding} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static LateBinding cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new LateBinding(from.getJCOInstance());
    }

    // Constructors section
    
    public LateBinding() throws Throwable {
    }



    
    // Methods section
    
    public static NetObject LateGet(NetObject o, NetType objType, java.lang.String name, NetObject[] args, java.lang.String[] paramnames, boolean[] CopyBack) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.runtime.interopservices.ExternalException, system.MissingMethodException, system.InvalidCastException, system.RankException, system.ArrayTypeMismatchException, system.NullReferenceException, system.OverflowException, system.MissingMemberException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLateGet = (JCObject)classType.Invoke("LateGet", o == null ? null : o.getJCOInstance(), objType == null ? null : objType.getJCOInstance(), name, toObjectFromArray(args), paramnames, CopyBack);
            return new NetObject(objLateGet);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject LateGet(NetObject dupParam0, NetType dupParam1, java.lang.String dupParam2, NetObject[] dupParam3, JCORefOut dupParam4, JCORefOut dupParam5) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.runtime.interopservices.ExternalException, system.MissingMethodException, system.InvalidCastException, system.RankException, system.ArrayTypeMismatchException, system.NullReferenceException, system.OverflowException, system.MissingMemberException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLateGet = (JCObject)classType.Invoke("LateGet", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2, toObjectFromArray(dupParam3), dupParam4.getJCRefOut(), dupParam5.getJCRefOut());
            return new NetObject(objLateGet);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject LateIndexGet(NetObject o, NetObject[] args, java.lang.String[] paramnames) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.runtime.interopservices.ExternalException, system.RankException, system.OverflowException, system.InvalidCastException, system.MissingMemberException, system.reflection.AmbiguousMatchException, system.MissingMethodException, system.ArrayTypeMismatchException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLateIndexGet = (JCObject)classType.Invoke("LateIndexGet", o == null ? null : o.getJCOInstance(), toObjectFromArray(args), paramnames);
            return new NetObject(objLateIndexGet);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject LateIndexGet(NetObject dupParam0, NetObject[] dupParam1, JCORefOut dupParam2) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.runtime.interopservices.ExternalException, system.RankException, system.OverflowException, system.InvalidCastException, system.MissingMemberException, system.reflection.AmbiguousMatchException, system.MissingMethodException, system.ArrayTypeMismatchException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLateIndexGet = (JCObject)classType.Invoke("LateIndexGet", dupParam0 == null ? null : dupParam0.getJCOInstance(), toObjectFromArray(dupParam1), dupParam2.getJCRefOut());
            return new NetObject(objLateIndexGet);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateCall(NetObject o, NetType objType, java.lang.String name, NetObject[] args, java.lang.String[] paramnames, boolean[] CopyBack) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.MissingMemberException, system.InvalidCastException, system.OverflowException, system.MissingMethodException, system.RankException, system.NullReferenceException, system.ArgumentNullException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateCall", o == null ? null : o.getJCOInstance(), objType == null ? null : objType.getJCOInstance(), name, toObjectFromArray(args), paramnames, CopyBack);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateCall(NetObject dupParam0, NetType dupParam1, java.lang.String dupParam2, NetObject[] dupParam3, JCORefOut dupParam4, JCORefOut dupParam5) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.MissingMemberException, system.InvalidCastException, system.OverflowException, system.MissingMethodException, system.RankException, system.NullReferenceException, system.ArgumentNullException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateCall", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2, toObjectFromArray(dupParam3), dupParam4.getJCRefOut(), dupParam5.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateIndexSet(NetObject o, NetObject[] args, java.lang.String[] paramnames) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.runtime.interopservices.ExternalException, system.InvalidCastException, system.OverflowException, system.RankException, system.MissingMemberException, system.reflection.AmbiguousMatchException, system.MissingMethodException, system.ArrayTypeMismatchException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateIndexSet", o == null ? null : o.getJCOInstance(), toObjectFromArray(args), paramnames);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateIndexSet(NetObject dupParam0, NetObject[] dupParam1, JCORefOut dupParam2) throws Throwable, system.NotSupportedException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.runtime.interopservices.ExternalException, system.InvalidCastException, system.OverflowException, system.RankException, system.MissingMemberException, system.reflection.AmbiguousMatchException, system.MissingMethodException, system.ArrayTypeMismatchException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateIndexSet", dupParam0 == null ? null : dupParam0.getJCOInstance(), toObjectFromArray(dupParam1), dupParam2.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateIndexSetComplex(NetObject o, NetObject[] args, java.lang.String[] paramnames, boolean OptimisticSet, boolean RValueBase) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.InvalidCastException, system.OverflowException, system.RankException, system.MissingMemberException, system.ArgumentNullException, system.reflection.AmbiguousMatchException, system.MissingMethodException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateIndexSetComplex", o == null ? null : o.getJCOInstance(), toObjectFromArray(args), paramnames, OptimisticSet, RValueBase);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateIndexSetComplex(NetObject dupParam0, NetObject[] dupParam1, JCORefOut dupParam2, boolean dupParam3, boolean dupParam4) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.InvalidCastException, system.OverflowException, system.RankException, system.MissingMemberException, system.ArgumentNullException, system.reflection.AmbiguousMatchException, system.MissingMethodException, system.NullReferenceException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateIndexSetComplex", dupParam0 == null ? null : dupParam0.getJCOInstance(), toObjectFromArray(dupParam1), dupParam2.getJCRefOut(), dupParam3, dupParam4);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateSet(NetObject o, NetType objType, java.lang.String name, NetObject[] args, java.lang.String[] paramnames) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.MissingMemberException, system.MissingMethodException, system.InvalidCastException, system.OverflowException, system.RankException, system.NullReferenceException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateSet", o == null ? null : o.getJCOInstance(), objType == null ? null : objType.getJCOInstance(), name, toObjectFromArray(args), paramnames);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateSet(NetObject dupParam0, NetType dupParam1, java.lang.String dupParam2, NetObject[] dupParam3, JCORefOut dupParam4) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.MissingMemberException, system.MissingMethodException, system.InvalidCastException, system.OverflowException, system.RankException, system.NullReferenceException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateSet", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2, toObjectFromArray(dupParam3), dupParam4.getJCRefOut());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateSetComplex(NetObject o, NetType objType, java.lang.String name, NetObject[] args, java.lang.String[] paramnames, boolean OptimisticSet, boolean RValueBase) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.MissingMemberException, system.MissingMethodException, system.InvalidCastException, system.OverflowException, system.RankException, system.NullReferenceException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateSetComplex", o == null ? null : o.getJCOInstance(), objType == null ? null : objType.getJCOInstance(), name, toObjectFromArray(args), paramnames, OptimisticSet, RValueBase);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void LateSetComplex(NetObject dupParam0, NetType dupParam1, java.lang.String dupParam2, NetObject[] dupParam3, JCORefOut dupParam4, boolean dupParam5, boolean dupParam6) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.InvalidOperationException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArrayTypeMismatchException, system.MissingMemberException, system.MissingMethodException, system.InvalidCastException, system.OverflowException, system.RankException, system.NullReferenceException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("LateSetComplex", dupParam0 == null ? null : dupParam0.getJCOInstance(), dupParam1 == null ? null : dupParam1.getJCOInstance(), dupParam2, toObjectFromArray(dupParam3), dupParam4.getJCRefOut(), dupParam5, dupParam6);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}