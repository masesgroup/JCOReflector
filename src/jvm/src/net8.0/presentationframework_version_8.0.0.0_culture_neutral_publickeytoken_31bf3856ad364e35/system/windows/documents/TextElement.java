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

package system.windows.documents;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.FrameworkContentElement;
import system.windows.DependencyObject;
import system.windows.FontStretch;
import system.windows.FontStyle;
import system.windows.FontWeight;
import system.windows.media.Brush;
import system.windows.media.FontFamily;
import system.windows.documents.TextPointer;
import system.windows.documents.Typography;
import system.windows.media.TextEffectCollection;
import system.windows.markup.IAddChild;
import system.windows.markup.IAddChildImplementation;


/**
 * The base .NET class managing System.Windows.Documents.TextElement, PresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Documents.TextElement" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Documents.TextElement</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class TextElement extends FrameworkContentElement implements system.windows.markup.IAddChild {
    /**
     * Fully assembly qualified name: PresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationFramework
     */
    public static final String assemblyShortName = "PresentationFramework";
    /**
     * Qualified class name: System.Windows.Documents.TextElement
     */
    public static final String className = "System.Windows.Documents.TextElement";
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
    public TextElement(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link TextElement}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link TextElement} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static TextElement cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new TextElement(from.getJCOInstance());
    }

    // Constructors section
    
    public TextElement() throws Throwable {
    }

    
    // Methods section
    
    public static double GetFontSize(DependencyObject element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (double)classType.Invoke("GetFontSize", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static FontStretch GetFontStretch(DependencyObject element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetFontStretch = (JCObject)classType.Invoke("GetFontStretch", element == null ? null : element.getJCOInstance());
            return new FontStretch(objGetFontStretch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static FontStyle GetFontStyle(DependencyObject element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetFontStyle = (JCObject)classType.Invoke("GetFontStyle", element == null ? null : element.getJCOInstance());
            return new FontStyle(objGetFontStyle);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static FontWeight GetFontWeight(DependencyObject element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetFontWeight = (JCObject)classType.Invoke("GetFontWeight", element == null ? null : element.getJCOInstance());
            return new FontWeight(objGetFontWeight);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Brush GetForeground(DependencyObject element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetForeground = (JCObject)classType.Invoke("GetForeground", element == null ? null : element.getJCOInstance());
            return new Brush(objGetForeground);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static FontFamily GetFontFamily(DependencyObject element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetFontFamily = (JCObject)classType.Invoke("GetFontFamily", element == null ? null : element.getJCOInstance());
            return new FontFamily(objGetFontFamily);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetFontFamily(DependencyObject element, FontFamily value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetFontFamily", element == null ? null : element.getJCOInstance(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetFontSize(DependencyObject element, double value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetFontSize", element == null ? null : element.getJCOInstance(), value);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetFontStretch(DependencyObject element, FontStretch value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetFontStretch", element == null ? null : element.getJCOInstance(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetFontStyle(DependencyObject element, FontStyle value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetFontStyle", element == null ? null : element.getJCOInstance(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetFontWeight(DependencyObject element, FontWeight value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetFontWeight", element == null ? null : element.getJCOInstance(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void SetForeground(DependencyObject element, Brush value) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.OutOfMemoryException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("SetForeground", element == null ? null : element.getJCOInstance(), value == null ? null : value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIAddChild method available in IAddChild to obtain an object with an invocable method
     */
    @Deprecated 
    public void AddChild(NetObject value) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIAddChild to obtain the full interface.");
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIAddChild method available in IAddChild to obtain an object with an invocable method
     */
    @Deprecated 
    public void AddText(java.lang.String text) throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIAddChild to obtain the full interface.");
    }


    
    // Properties section
    
    public double getFontSize() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("FontSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFontSize(double FontSize) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FontSize", FontSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextPointer getContentEnd() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ContentEnd");
            return new TextPointer(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextPointer getContentStart() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ContentStart");
            return new TextPointer(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextPointer getElementEnd() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ElementEnd");
            return new TextPointer(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextPointer getElementStart() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ElementStart");
            return new TextPointer(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Typography getTypography() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Typography");
            return new Typography(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontStretch getFontStretch() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FontStretch");
            return new FontStretch(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFontStretch(FontStretch FontStretch) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FontStretch", FontStretch == null ? null : FontStretch.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontStyle getFontStyle() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FontStyle");
            return new FontStyle(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFontStyle(FontStyle FontStyle) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FontStyle", FontStyle == null ? null : FontStyle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontWeight getFontWeight() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FontWeight");
            return new FontWeight(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFontWeight(FontWeight FontWeight) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FontWeight", FontWeight == null ? null : FontWeight.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Brush getBackground() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Background");
            return new Brush(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setBackground(Brush Background) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Background", Background == null ? null : Background.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Brush getForeground() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Foreground");
            return new Brush(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setForeground(Brush Foreground) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Foreground", Foreground == null ? null : Foreground.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FontFamily getFontFamily() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FontFamily");
            return new FontFamily(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFontFamily(FontFamily FontFamily) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FontFamily", FontFamily == null ? null : FontFamily.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextEffectCollection getTextEffects() throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("TextEffects");
            return new TextEffectCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTextEffects(TextEffectCollection TextEffects) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.FormatException, system.NotSupportedException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("TextEffects", TextEffects == null ? null : TextEffects.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    


}