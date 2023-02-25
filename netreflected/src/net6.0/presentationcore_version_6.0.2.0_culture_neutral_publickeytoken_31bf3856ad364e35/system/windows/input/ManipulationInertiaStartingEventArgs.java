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

package system.windows.input;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.input.InputEventArgs;
import system.windows.input.manipulations.InertiaParameters2D;
import system.windows.IInputElement;
import system.windows.IInputElementImplementation;
import system.windows.input.InertiaExpansionBehavior;
import system.windows.input.InertiaRotationBehavior;
import system.windows.input.InertiaTranslationBehavior;
import system.windows.input.ManipulationVelocities;
import system.windows.Point;


/**
 * The base .NET class managing System.Windows.Input.ManipulationInertiaStartingEventArgs, PresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.ManipulationInertiaStartingEventArgs" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.ManipulationInertiaStartingEventArgs</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class ManipulationInertiaStartingEventArgs extends InputEventArgs  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=6.0.2.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Input.ManipulationInertiaStartingEventArgs
     */
    public static final String className = "System.Windows.Input.ManipulationInertiaStartingEventArgs";
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
    public ManipulationInertiaStartingEventArgs(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ManipulationInertiaStartingEventArgs}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ManipulationInertiaStartingEventArgs} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ManipulationInertiaStartingEventArgs cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ManipulationInertiaStartingEventArgs(from.getJCOInstance());
    }

    // Constructors section
    
    public ManipulationInertiaStartingEventArgs() throws Throwable {
    }



    
    // Methods section
    
    public boolean Cancel() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Cancel");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetInertiaParameter(InertiaParameters2D parameter) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetInertiaParameter", parameter == null ? null : parameter.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public IInputElement getManipulationContainer() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ManipulationContainer");
            return new IInputElementImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setManipulationContainer(IInputElement ManipulationContainer) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ManipulationContainer", ManipulationContainer == null ? null : ManipulationContainer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public InertiaExpansionBehavior getExpansionBehavior() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ExpansionBehavior");
            return new InertiaExpansionBehavior(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setExpansionBehavior(InertiaExpansionBehavior ExpansionBehavior) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ExpansionBehavior", ExpansionBehavior == null ? null : ExpansionBehavior.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public InertiaRotationBehavior getRotationBehavior() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RotationBehavior");
            return new InertiaRotationBehavior(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRotationBehavior(InertiaRotationBehavior RotationBehavior) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("RotationBehavior", RotationBehavior == null ? null : RotationBehavior.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public InertiaTranslationBehavior getTranslationBehavior() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TranslationBehavior");
            return new InertiaTranslationBehavior(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTranslationBehavior(InertiaTranslationBehavior TranslationBehavior) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TranslationBehavior", TranslationBehavior == null ? null : TranslationBehavior.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ManipulationVelocities getInitialVelocities() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InitialVelocities");
            return new ManipulationVelocities(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInitialVelocities(ManipulationVelocities InitialVelocities) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InitialVelocities", InitialVelocities == null ? null : InitialVelocities.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Point getManipulationOrigin() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ManipulationOrigin");
            return new Point(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setManipulationOrigin(Point ManipulationOrigin) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ManipulationOrigin", ManipulationOrigin == null ? null : ManipulationOrigin.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}