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

package microsoft.visualbasic;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import microsoft.visualbasic.AppWinStyle;
import microsoft.visualbasic.MsgBoxResult;
import microsoft.visualbasic.MsgBoxStyle;
import microsoft.visualbasic.CallType;


/**
 * The base .NET class managing Microsoft.VisualBasic.Interaction, Microsoft.VisualBasic.Core, Version=10.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.VisualBasic.Interaction" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.VisualBasic.Interaction</a>
 */
public class Interaction extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.VisualBasic.Core, Version=10.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.VisualBasic.Core, Version=10.0.6.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.VisualBasic.Core
     */
    public static final String assemblyShortName = "Microsoft.VisualBasic.Core";
    /**
     * Qualified class name: Microsoft.VisualBasic.Interaction
     */
    public static final String className = "Microsoft.VisualBasic.Interaction";
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

    public Interaction(Object instance) throws Throwable {
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

    public void setJCOInstance(JCObject instance) {
        classInstance = instance;
        super.setJCOInstance(classInstance);
    }

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Interaction}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Interaction} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Interaction cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Interaction(from.getJCOInstance());
    }

    // Constructors section
    
    public Interaction() throws Throwable {
    }



    
    // Methods section
    
    public static int Shell(java.lang.String PathName, AppWinStyle Style, boolean Wait, int Timeout) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.TypeLoadException, system.PlatformNotSupportedException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (int)classType.Invoke("Shell", PathName, Style == null ? null : Style.getJCOInstance(), Wait, Timeout);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static MsgBoxResult MsgBox(NetObject Prompt, MsgBoxStyle Buttons, NetObject Title) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.TypeLoadException, system.PlatformNotSupportedException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objMsgBox = (JCObject)classType.Invoke("MsgBox", Prompt == null ? null : Prompt.getJCOInstance(), Buttons == null ? null : Buttons.getJCOInstance(), Title == null ? null : Title.getJCOInstance());
            return new MsgBoxResult(objMsgBox);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject CallByName(NetObject ObjectRef, java.lang.String ProcName, CallType UseCallType, NetObject... Args) throws Throwable, system.InvalidOperationException, system.PlatformNotSupportedException, system.FormatException, system.IndexOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.NotSupportedException, system.MissingMemberException, system.InvalidCastException, system.OverflowException, system.MissingMethodException, system.RankException, system.ArrayTypeMismatchException, system.NullReferenceException, system.reflection.AmbiguousMatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCallByName = (JCObject)classType.Invoke("CallByName", ObjectRef == null ? null : ObjectRef.getJCOInstance(), ProcName, UseCallType == null ? null : UseCallType.getJCOInstance(), toObjectFromArray(Args));
            return new NetObject(objCallByName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject Choose(double Index, NetObject... Choice) throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.InvalidOperationException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objChoose = (JCObject)classType.Invoke("Choose", Index, toObjectFromArray(Choice));
            return new NetObject(objChoose);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject CreateObject(java.lang.String ProgId, java.lang.String ServerName) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateObject = (JCObject)classType.Invoke("CreateObject", ProgId, ServerName);
            return new NetObject(objCreateObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject GetObject(java.lang.String PathName, java.lang.String _Class) throws Throwable, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetObject = (JCObject)classType.Invoke("GetObject", PathName, _Class);
            return new NetObject(objGetObject);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject IIf(boolean Expression, NetObject TruePart, NetObject FalsePart) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objIIf = (JCObject)classType.Invoke("IIf", Expression, TruePart == null ? null : TruePart.getJCOInstance(), FalsePart == null ? null : FalsePart.getJCOInstance());
            return new NetObject(objIIf);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetObject Switch(NetObject... VarExpr) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.NotSupportedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.FormatException, system.OverflowException, system.InvalidCastException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objSwitch = (JCObject)classType.Invoke("Switch", (Object)toObjectFromArray(VarExpr));
            return new NetObject(objSwitch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String Command() throws Throwable, system.PlatformNotSupportedException, system.InvalidOperationException, system.ApplicationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("Command");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String Environ(int Expression) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.NotSupportedException, system.InvalidOperationException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("Environ", Expression);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String Environ(java.lang.String Expression) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("Environ", Expression);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String GetSetting(java.lang.String AppName, java.lang.String Section, java.lang.String Key, java.lang.String Default) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("GetSetting", AppName, Section, Key, Default);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String InputBox(java.lang.String Prompt, java.lang.String Title, java.lang.String DefaultResponse, int XPos, int YPos) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.TypeLoadException, system.PlatformNotSupportedException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("InputBox", Prompt, Title, DefaultResponse, XPos, YPos);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static java.lang.String Partition(long Number, long Start, long Stop, long Interval) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.NotSupportedException, system.IndexOutOfRangeException, system.InvalidOperationException, system.FormatException, system.ArrayTypeMismatchException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (java.lang.String)classType.Invoke("Partition", Number, Start, Stop, Interval);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AppActivate(int ProcessId) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.TypeLoadException, system.PlatformNotSupportedException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AppActivate", ProcessId);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AppActivate(java.lang.String Title) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.TypeLoadException, system.PlatformNotSupportedException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AppActivate", Title);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Beep() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Beep");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DeleteSetting(java.lang.String AppName, java.lang.String Section, java.lang.String Key) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.UnauthorizedAccessException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.io.IOException, system.security.SecurityException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DeleteSetting", AppName, Section, Key);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SaveSetting(java.lang.String AppName, java.lang.String Section, java.lang.String Key, java.lang.String Setting) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.IndexOutOfRangeException, system.UnauthorizedAccessException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.io.IOException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SaveSetting", AppName, Section, Key, Setting);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}