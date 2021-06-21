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

package system.activities.presentation.debug;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.activities.debugger.SourceLocation;
import system.activities.presentation.debug.BreakpointTypes;


/**
 * The base .NET class managing System.Activities.Presentation.Debug.IDesignerDebugView, System.Activities.Presentation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link IJCOBridgeReflected}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Activities.Presentation.Debug.IDesignerDebugView" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Activities.Presentation.Debug.IDesignerDebugView</a>
 */
public interface IDesignerDebugView extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: System.Activities.Presentation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Activities.Presentation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Activities.Presentation
     */
    public static final String assemblyShortName = "System.Activities.Presentation";
    /**
     * Qualified class name: System.Activities.Presentation.Debug.IDesignerDebugView
     */
    public static final String className = "System.Activities.Presentation.Debug.IDesignerDebugView";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IDesignerDebugView}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IDesignerDebugView} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IDesignerDebugView ToIDesignerDebugView(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Activities.Presentation, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IDesignerDebugViewImplementation(from.getJCOInstance());
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
     * @return An {@link Object} representing the instance of the instantiated Class
     */
    public Object getJCOInstance();

    /**
     * Returns the instantiated class Type
     * 
     * @return A {@link JCType} representing the Type of the instantiated Class
     */
    public JCType getJCOType();

    // Methods section
    
    public SourceLocation GetExactLocation(SourceLocation approximateLocation) throws Throwable;

    public void DeleteBreakpoint(SourceLocation sourceLocation) throws Throwable;

    public void EnsureVisible(SourceLocation sourceLocation) throws Throwable;

    public void InsertBreakpoint(SourceLocation sourceLocation, BreakpointTypes breakpointType) throws Throwable;

    public void ResetBreakpoints() throws Throwable;

    public void UpdateBreakpoint(SourceLocation sourceLocation, BreakpointTypes breakpointType) throws Throwable;


    
    // Properties section
    
    public boolean getHideSourceFileName() throws Throwable;

    public void setHideSourceFileName(boolean HideSourceFileName) throws Throwable;

    public boolean getIsDebugging() throws Throwable;

    public void setIsDebugging(boolean IsDebugging) throws Throwable;

    public SourceLocation getCurrentContext() throws Throwable;

    public void setCurrentContext(SourceLocation CurrentContext) throws Throwable;

    public SourceLocation getCurrentLocation() throws Throwable;

    public void setCurrentLocation(SourceLocation CurrentLocation) throws Throwable;

    public SourceLocation getSelectedLocation() throws Throwable;



    // Instance Events section
    

}