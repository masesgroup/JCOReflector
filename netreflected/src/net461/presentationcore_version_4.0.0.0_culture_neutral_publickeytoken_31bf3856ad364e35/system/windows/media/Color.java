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

package system.windows.media;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.ValueType;
import system.windows.media.Color;
import system.Single;
import system.IFormatProvider;
import system.IFormatProviderImplementation;
import system.Uri;
import system.windows.media.ColorContext;


/**
 * The base .NET class managing System.Windows.Media.Color, PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link ValueType}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.Color" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.Color</a>
 */
public class Color extends ValueType  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Media.Color
     */
    public static final String className = "System.Windows.Media.Color";
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

    public Color(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Color}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Color} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Color cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Color(from.getJCOInstance());
    }

    // Constructors section
    
    public Color() throws Throwable {
    }



    
    // Methods section
    
    public static boolean AreClose(Color color1, Color color2) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("AreClose", color1 == null ? null : color1.getJCOInstance(), color2 == null ? null : color2.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Equals(Color color) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Equals", color == null ? null : color.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean Equals(Color color1, Color color2) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("Equals", color1 == null ? null : color1.getJCOInstance(), color2 == null ? null : color2.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Single[] GetNativeColorValues() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Single> resultingArrayList = new ArrayList<Single>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetNativeColorValues");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new Single(resultingObject));
            }
            Single[] resultingArray = new Single[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String ToString(IFormatProvider provider) throws Throwable, system.ArgumentNullException, system.FormatException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.NotSupportedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.UriFormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("ToString", provider == null ? null : provider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color Add(Color color1, Color color2) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.UriFormatException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.OutOfMemoryException, system.net.WebException, system.NotImplementedException, system.componentmodel.Win32Exception, system.net.CookieException, system.io.IOException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.FileNotFoundException, system.AccessViolationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objAdd = (JCObject)classType.Invoke("Add", color1 == null ? null : color1.getJCOInstance(), color2 == null ? null : color2.getJCOInstance());
            return new Color(objAdd);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color FromArgb(byte a, byte r, byte g, byte b) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromArgb = (JCObject)classType.Invoke("FromArgb", a, r, g, b);
            return new Color(objFromArgb);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color FromAValues(Single a, Single[] values, Uri profileUri) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.net.WebException, system.componentmodel.Win32Exception, system.net.CookieException, system.security.SecurityException, system.io.IOException, system.UnauthorizedAccessException, system.io.FileNotFoundException, system.AccessViolationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromAValues = (JCObject)classType.Invoke("FromAValues", a == null ? null : a.getJCOInstance(), toObjectFromArray(values), profileUri == null ? null : profileUri.getJCOInstance());
            return new Color(objFromAValues);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color FromRgb(byte r, byte g, byte b) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromRgb = (JCObject)classType.Invoke("FromRgb", r, g, b);
            return new Color(objFromRgb);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color FromScRgb(Single a, Single r, Single g, Single b) throws Throwable {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromScRgb = (JCObject)classType.Invoke("FromScRgb", a == null ? null : a.getJCOInstance(), r == null ? null : r.getJCOInstance(), g == null ? null : g.getJCOInstance(), b == null ? null : b.getJCOInstance());
            return new Color(objFromScRgb);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color FromValues(Single[] values, Uri profileUri) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.ArgumentOutOfRangeException, system.net.WebException, system.NotImplementedException, system.componentmodel.Win32Exception, system.net.CookieException, system.security.SecurityException, system.io.IOException, system.MissingMethodException, system.reflection.TargetInvocationException, system.io.FileNotFoundException, system.OutOfMemoryException, system.AccessViolationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFromValues = (JCObject)classType.Invoke("FromValues", toObjectFromArray(values), profileUri == null ? null : profileUri.getJCOInstance());
            return new Color(objFromValues);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color Multiply(Color color, Single coefficient) throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.net.WebException, system.NotImplementedException, system.componentmodel.Win32Exception, system.net.CookieException, system.io.IOException, system.security.SecurityException, system.io.FileNotFoundException, system.OutOfMemoryException, system.AccessViolationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objMultiply = (JCObject)classType.Invoke("Multiply", color == null ? null : color.getJCOInstance(), coefficient == null ? null : coefficient.getJCOInstance());
            return new Color(objMultiply);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Color Subtract(Color color1, Color color2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.UriFormatException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.OutOfMemoryException, system.net.WebException, system.componentmodel.Win32Exception, system.net.CookieException, system.io.IOException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.FileNotFoundException, system.AccessViolationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objSubtract = (JCObject)classType.Invoke("Subtract", color1 == null ? null : color1.getJCOInstance(), color2 == null ? null : color2.getJCOInstance());
            return new Color(objSubtract);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Clamp() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Clamp");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public byte getA() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (byte)classInstance.Get("A");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setA(byte A) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("A", A);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte getB() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (byte)classInstance.Get("B");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setB(byte B) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("B", B);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte getG() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (byte)classInstance.Get("G");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setG(byte G) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("G", G);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public byte getR() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (byte)classInstance.Get("R");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setR(byte R) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("R", R);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Single getScA() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ScA");
            return new Single(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setScA(Single ScA) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ScA", ScA == null ? null : ScA.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Single getScB() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ScB");
            return new Single(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setScB(Single ScB) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ScB", ScB == null ? null : ScB.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Single getScG() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ScG");
            return new Single(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setScG(Single ScG) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ScG", ScG == null ? null : ScG.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Single getScR() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ScR");
            return new Single(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setScR(Single ScR) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.ArgumentOutOfRangeException, system.FormatException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ScR", ScR == null ? null : ScR.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ColorContext getColorContext() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ColorContext");
            return new ColorContext(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}