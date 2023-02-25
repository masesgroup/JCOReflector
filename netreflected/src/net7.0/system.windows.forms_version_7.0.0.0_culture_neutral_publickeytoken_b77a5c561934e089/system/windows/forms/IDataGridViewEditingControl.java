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

// Import section
import system.windows.forms.Keys;
import system.windows.forms.DataGridViewDataErrorContexts;
import system.windows.forms.DataGridViewCellStyle;
import system.windows.forms.Cursor;
import system.windows.forms.DataGridView;


/**
 * The base .NET class managing System.Windows.Forms.IDataGridViewEditingControl, System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.IDataGridViewEditingControl" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.IDataGridViewEditingControl</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public interface IDataGridViewEditingControl extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.IDataGridViewEditingControl
     */
    public static final String className = "System.Windows.Forms.IDataGridViewEditingControl";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IDataGridViewEditingControl}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IDataGridViewEditingControl} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IDataGridViewEditingControl ToIDataGridViewEditingControl(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IDataGridViewEditingControlImplementation(from.getJCOInstance());
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
    
    public boolean EditingControlWantsInputKey(Keys keyData, boolean dataGridViewWantsInputKey) throws Throwable;

    public NetObject GetEditingControlFormattedValue(DataGridViewDataErrorContexts context) throws Throwable;

    public void ApplyCellStyleToEditingControl(DataGridViewCellStyle dataGridViewCellStyle) throws Throwable;

    public void PrepareEditingControlForEdit(boolean selectAll) throws Throwable;


    
    // Properties section
    
    public boolean getEditingControlValueChanged() throws Throwable;

    public void setEditingControlValueChanged(boolean EditingControlValueChanged) throws Throwable;

    public boolean getRepositionEditingControlOnValueChange() throws Throwable;

    public int getEditingControlRowIndex() throws Throwable;

    public void setEditingControlRowIndex(int EditingControlRowIndex) throws Throwable;

    public NetObject getEditingControlFormattedValue() throws Throwable;

    public void setEditingControlFormattedValue(NetObject EditingControlFormattedValue) throws Throwable;

    public Cursor getEditingPanelCursor() throws Throwable;

    public DataGridView getEditingControlDataGridView() throws Throwable;

    public void setEditingControlDataGridView(DataGridView EditingControlDataGridView) throws Throwable;



    // Instance Events section
    

}