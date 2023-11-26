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

package system.windows.media.imaging;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.media.imaging.BitmapSizeOptions;
import system.windows.media.imaging.Rotation;


/**
 * The base .NET class managing System.Windows.Media.Imaging.BitmapSizeOptions, PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.Imaging.BitmapSizeOptions" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.Imaging.BitmapSizeOptions</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class BitmapSizeOptions extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Media.Imaging.BitmapSizeOptions
     */
    public static final String className = "System.Windows.Media.Imaging.BitmapSizeOptions";
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
    public BitmapSizeOptions(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link BitmapSizeOptions}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link BitmapSizeOptions} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static BitmapSizeOptions cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new BitmapSizeOptions(from.getJCOInstance());
    }

    // Constructors section
    
    public BitmapSizeOptions() throws Throwable {
    }



    
    // Methods section
    
    public static BitmapSizeOptions FromEmptyOptions() throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromEmptyOptions = (JCObject)classType.Invoke("FromEmptyOptions");
            return new BitmapSizeOptions(objFromEmptyOptions);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static BitmapSizeOptions FromHeight(int pixelHeight) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromHeight = (JCObject)classType.Invoke("FromHeight", pixelHeight);
            return new BitmapSizeOptions(objFromHeight);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static BitmapSizeOptions FromRotation(Rotation rotation) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromRotation = (JCObject)classType.Invoke("FromRotation", rotation == null ? null : rotation.getJCOInstance());
            return new BitmapSizeOptions(objFromRotation);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static BitmapSizeOptions FromWidth(int pixelWidth) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromWidth = (JCObject)classType.Invoke("FromWidth", pixelWidth);
            return new BitmapSizeOptions(objFromWidth);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static BitmapSizeOptions FromWidthAndHeight(int pixelWidth, int pixelHeight) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromWidthAndHeight = (JCObject)classType.Invoke("FromWidthAndHeight", pixelWidth, pixelHeight);
            return new BitmapSizeOptions(objFromWidthAndHeight);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getPreservesAspectRatio() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("PreservesAspectRatio");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getPixelHeight() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("PixelHeight");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getPixelWidth() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("PixelWidth");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rotation getRotation() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Rotation");
            return new Rotation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}