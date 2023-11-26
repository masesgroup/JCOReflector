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

package system.componentmodel;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.collections.specialized.INotifyCollectionChanged;
import system.collections.specialized.INotifyCollectionChangedImplementation;
import system.IDisposable;
import system.IDisposableImplementation;
import system.componentmodel.SortDescriptionCollection;
import system.globalization.CultureInfo;
import system.collections.specialized.NotifyCollectionChangedEventHandler;
import system.componentmodel.CurrentChangingEventHandler;
import system.EventHandler;


/**
 * The base .NET class managing System.ComponentModel.ICollectionView, WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.ICollectionView" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.ICollectionView</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public interface ICollectionView extends IJCOBridgeReflected, IEnumerable, INotifyCollectionChanged {
    /**
     * Fully assembly qualified name: WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: WindowsBase
     */
    public static final String assemblyShortName = "WindowsBase";
    /**
     * Qualified class name: System.ComponentModel.ICollectionView
     */
    public static final String className = "System.ComponentModel.ICollectionView";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ICollectionView}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ICollectionView} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ICollectionView ToICollectionView(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("WindowsBase, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new ICollectionViewImplementation(from.getJCOInstance());
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
    
    public boolean Contains(NetObject item) throws Throwable;

    public boolean MoveCurrentTo(NetObject item) throws Throwable;

    public boolean MoveCurrentToFirst() throws Throwable;

    public boolean MoveCurrentToLast() throws Throwable;

    public boolean MoveCurrentToNext() throws Throwable;

    public boolean MoveCurrentToPosition(int position) throws Throwable;

    public boolean MoveCurrentToPrevious() throws Throwable;

    public IDisposable DeferRefresh() throws Throwable;

    public void Refresh() throws Throwable;


    
    // Properties section
    
    public boolean getCanFilter() throws Throwable;

    public boolean getCanGroup() throws Throwable;

    public boolean getCanSort() throws Throwable;

    public boolean getIsCurrentAfterLast() throws Throwable;

    public boolean getIsCurrentBeforeFirst() throws Throwable;

    public boolean getIsEmpty() throws Throwable;

    public int getCurrentPosition() throws Throwable;

    public IEnumerable getSourceCollection() throws Throwable;

    public SortDescriptionCollection getSortDescriptions() throws Throwable;

    public CultureInfo getCulture() throws Throwable;

    public void setCulture(CultureInfo Culture) throws Throwable;

    public NetObject getCurrentItem() throws Throwable;



    // Instance Events section
    
    public void addCurrentChanging(CurrentChangingEventHandler handler) throws Throwable;

    public void removeCurrentChanging(CurrentChangingEventHandler handler) throws Throwable;

    public void addCurrentChanged(EventHandler handler) throws Throwable;

    public void removeCurrentChanged(EventHandler handler) throws Throwable;


}