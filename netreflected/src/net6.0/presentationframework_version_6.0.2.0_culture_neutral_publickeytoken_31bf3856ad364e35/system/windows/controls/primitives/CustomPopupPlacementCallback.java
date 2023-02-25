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

package system.windows.controls.primitives;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.controls.primitives.CustomPopupPlacement;
import system.windows.Size;
import system.windows.Point;
import system.windows.controls.primitives.ICustomPopupPlacementCallback;
/**
 * The base .NET class managing System.Windows.Controls.Primitives.CustomPopupPlacementCallback, PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link JCDelegate}.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Controls.Primitives.CustomPopupPlacementCallback" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Controls.Primitives.CustomPopupPlacementCallback</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class CustomPopupPlacementCallback extends JCDelegate implements IJCEventEmit, IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationFramework, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationFramework
     */
    public static final String assemblyShortName = "PresentationFramework";
    /**
     * Qualified class name: System.Windows.Controls.Primitives.CustomPopupPlacementCallback
     */
    public static final String className = "System.Windows.Controls.Primitives.CustomPopupPlacementCallback";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    JCObject classInstance = null;
    ICustomPopupPlacementCallback callerInstance = null;

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
        return this;
    }

    public JCType getJCOType() {
        return classType;
    }

    public final java.lang.Object EventRaised(java.lang.Object... argsFromJCOBridge) {
        try
        {
            Size popupSize = argsFromJCOBridge[0] == null ? null : new Size(argsFromJCOBridge[0]);
            Size targetSize = argsFromJCOBridge[1] == null ? null : new Size(argsFromJCOBridge[1]);
            Point offset = argsFromJCOBridge[2] == null ? null : new Point(argsFromJCOBridge[2]);


            CustomPopupPlacement[] retVal;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(popupSize, targetSize, offset);
            } else {
                retVal = Invoke(popupSize, targetSize, offset);
            }
            if (retVal == null) return retVal;
            ArrayList<java.lang.Object> retValJCArrayList = new ArrayList<java.lang.Object>();
            for (CustomPopupPlacement retValJCObject : retVal) {
                retValJCArrayList.add(retValJCObject.getJCOInstance());
            }
            return (java.lang.Object)retValJCArrayList.toArray();
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
			return null;
        }
    }

    public final java.lang.Object DelegateInvoked(java.lang.Object... argsFromJCOBridge) {
        try
        {
            Size popupSize = argsFromJCOBridge[0] == null ? null : new Size(argsFromJCOBridge[0]);
            Size targetSize = argsFromJCOBridge[1] == null ? null : new Size(argsFromJCOBridge[1]);
            Point offset = argsFromJCOBridge[2] == null ? null : new Point(argsFromJCOBridge[2]);


            CustomPopupPlacement[] retVal;
            if (callerInstance != null)	{
                retVal = callerInstance.Invoke(popupSize, targetSize, offset);
            } else {
                retVal = Invoke(popupSize, targetSize, offset);
            }
            if (retVal == null) return retVal;
            ArrayList<java.lang.Object> retValJCArrayList = new ArrayList<java.lang.Object>();
            for (CustomPopupPlacement retValJCObject : retVal) {
                retValJCArrayList.add(retValJCObject.getJCOInstance());
            }
            return (java.lang.Object)retValJCArrayList.toArray();
        }
        catch (Throwable throwableFromJCEvent)
        {
            JCOReflector.writeLog(throwableFromJCEvent);
			return null;
        }
    }

    public CustomPopupPlacementCallback() {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
    }

    public CustomPopupPlacementCallback(ICustomPopupPlacementCallback instance) {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        callerInstance = instance;
    }
    /**
     * Internal constructor. Use with caution 
     */
    public CustomPopupPlacementCallback(java.lang.Object instance) throws Throwable {
        super(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        if (instance == null) throw new IllegalArgumentException("Instance cannot be null");
        if (instance instanceof ICustomPopupPlacementCallback) {
            callerInstance = (ICustomPopupPlacementCallback) instance;
        } else if (instance instanceof JCObject) {
            classInstance = (JCObject) instance;
        } else
            throw new UnsupportedOperationException(
                    String.format("Class %s is not supported.", instance.getClass().getTypeName()));
    }

    protected final static <T extends IJCOBridgeReflected> java.lang.Object toObjectFromArray(T[] input) {
        return JCOBridgeInstance.toObjectFromArray(input);
    }

    static protected Throwable translateException(JCNativeException ne) throws Throwable {
        return JCOBridgeInstance.translateException(ne);
    }

    public CustomPopupPlacement[] DynamicInvoke(Size popupSize, Size targetSize, Point offset) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<CustomPopupPlacement> resultingArrayList = new ArrayList<CustomPopupPlacement>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("DynamicInvoke", popupSize == null ? null : popupSize.getJCOInstance(), targetSize == null ? null : targetSize.getJCOInstance(), offset == null ? null : offset.getJCOInstance());
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new CustomPopupPlacement(resultingObject));
            }
            CustomPopupPlacement[] resultingArray = new CustomPopupPlacement[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * Methods invoked in JVM when an event is raised in CLR 
     */
    public CustomPopupPlacement[] Invoke(Size popupSize, Size targetSize, Point offset) {
        return null;
    }
}