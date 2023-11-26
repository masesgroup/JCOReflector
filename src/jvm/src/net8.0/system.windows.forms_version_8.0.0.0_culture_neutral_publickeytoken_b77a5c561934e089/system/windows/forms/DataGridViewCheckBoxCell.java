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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.forms.DataGridViewCell;
import system.windows.forms.DataGridViewDataErrorContexts;
import system.windows.forms.DataGridViewCellStyle;
import system.componentmodel.TypeConverter;
import system.windows.forms.FlatStyle;


/**
 * The base .NET class managing System.Windows.Forms.DataGridViewCheckBoxCell, System.Windows.Forms, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.DataGridViewCheckBoxCell" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.DataGridViewCheckBoxCell</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class DataGridViewCheckBoxCell extends DataGridViewCell  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.DataGridViewCheckBoxCell
     */
    public static final String className = "System.Windows.Forms.DataGridViewCheckBoxCell";
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
    public DataGridViewCheckBoxCell(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DataGridViewCheckBoxCell}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DataGridViewCheckBoxCell} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DataGridViewCheckBoxCell cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DataGridViewCheckBoxCell(from.getJCOInstance());
    }

    // Constructors section
    
    public DataGridViewCheckBoxCell() throws Throwable, system.ArgumentNullException, system.NotSupportedException, system.PlatformNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DataGridViewCheckBoxCell(boolean threeState) throws Throwable, system.ArgumentNullException, system.NotSupportedException, system.PlatformNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(threeState));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public NetObject Clone() throws Throwable, system.ArgumentNullException, system.NotSupportedException, system.PlatformNotSupportedException, system.ArgumentException, system.MethodAccessException, system.MissingMethodException, system.MemberAccessException, system.reflection.TargetInvocationException, system.RankException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.globalization.CultureNotFoundException, system.componentmodel.Win32Exception, system.MulticastNotSupportedException, system.InvalidOperationException, system.threading.ThreadStateException, system.collections.generic.KeyNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objClone = (JCObject)classInstance.Invoke("Clone");
            return new NetObject(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetEditingCellFormattedValue(DataGridViewDataErrorContexts context) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetEditingCellFormattedValue = (JCObject)classInstance.Invoke("GetEditingCellFormattedValue", context == null ? null : context.getJCOInstance());
            return new NetObject(objGetEditingCellFormattedValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject ParseFormattedValue(NetObject formattedValue, DataGridViewCellStyle cellStyle, TypeConverter formattedValueTypeConverter, TypeConverter valueTypeConverter) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objParseFormattedValue = (JCObject)classInstance.Invoke("ParseFormattedValue", formattedValue == null ? null : formattedValue.getJCOInstance(), cellStyle == null ? null : cellStyle.getJCOInstance(), formattedValueTypeConverter == null ? null : formattedValueTypeConverter.getJCOInstance(), valueTypeConverter == null ? null : valueTypeConverter.getJCOInstance());
            return new NetObject(objParseFormattedValue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PrepareEditingCellForEdit(boolean selectAll) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PrepareEditingCellForEdit", selectAll);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getEditingCellValueChanged() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("EditingCellValueChanged");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEditingCellValueChanged(boolean EditingCellValueChanged) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EditingCellValueChanged", EditingCellValueChanged);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getThreeState() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ThreeState");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setThreeState(boolean ThreeState) throws Throwable, system.ArgumentException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ThreeState", ThreeState);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject getEditingCellFormattedValue() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("EditingCellFormattedValue");
            return new NetObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEditingCellFormattedValue(NetObject EditingCellFormattedValue) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EditingCellFormattedValue", EditingCellFormattedValue == null ? null : EditingCellFormattedValue.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject getFalseValue() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FalseValue");
            return new NetObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFalseValue(NetObject FalseValue) throws Throwable, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArgumentException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FalseValue", FalseValue == null ? null : FalseValue.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject getIndeterminateValue() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("IndeterminateValue");
            return new NetObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIndeterminateValue(NetObject IndeterminateValue) throws Throwable, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArgumentException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IndeterminateValue", IndeterminateValue == null ? null : IndeterminateValue.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject getTrueValue() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TrueValue");
            return new NetObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTrueValue(NetObject TrueValue) throws Throwable, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArgumentException, system.ArrayTypeMismatchException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TrueValue", TrueValue == null ? null : TrueValue.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FlatStyle getFlatStyle() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FlatStyle");
            return new FlatStyle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFlatStyle(FlatStyle FlatStyle) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FlatStyle", FlatStyle == null ? null : FlatStyle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}