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
import system.windows.input.Key;
import system.windows.IInputElement;
import system.windows.IInputElementImplementation;
import system.windows.input.KeyStates;
import system.windows.DependencyObject;
import system.windows.input.KeyboardFocusChangedEventHandler;
import system.windows.input.KeyboardInputProviderAcquireFocusEventHandler;
import system.windows.input.KeyEventHandler;
import system.windows.input.KeyboardDevice;
import system.windows.input.ModifierKeys;
import system.windows.input.RestoreFocusMode;


/**
 * The base .NET class managing System.Windows.Input.Keyboard, PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.Keyboard" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Input.Keyboard</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class Keyboard extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Input.Keyboard
     */
    public static final String className = "System.Windows.Input.Keyboard";
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
    public Keyboard(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link Keyboard}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link Keyboard} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static Keyboard cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new Keyboard(from.getJCOInstance());
    }

    // Constructors section
    
    public Keyboard() throws Throwable {
    }

    
    // Methods section
    
    public static boolean IsKeyDown(Key key) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsKeyDown", key == null ? null : key.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsKeyToggled(Key key) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsKeyToggled", key == null ? null : key.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsKeyUp(Key key) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsKeyUp", key == null ? null : key.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static IInputElement Focus(IInputElement element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objFocus = (JCObject)classType.Invoke("Focus", element == null ? null : element.getJCOInstance());
            return new IInputElementImplementation(objFocus);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static KeyStates GetKeyStates(Key key) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetKeyStates = (JCObject)classType.Invoke("GetKeyStates", key == null ? null : key.getJCOInstance());
            return new KeyStates(objGetKeyStates);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddGotKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddGotKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddKeyboardInputProviderAcquireFocusHandler(DependencyObject element, KeyboardInputProviderAcquireFocusEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddKeyboardInputProviderAcquireFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddKeyDownHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddKeyDownHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddKeyUpHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddKeyUpHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddLostKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddLostKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddPreviewGotKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddPreviewGotKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddPreviewKeyboardInputProviderAcquireFocusHandler(DependencyObject element, KeyboardInputProviderAcquireFocusEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddPreviewKeyboardInputProviderAcquireFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddPreviewKeyDownHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddPreviewKeyDownHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddPreviewKeyUpHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddPreviewKeyUpHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void AddPreviewLostKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("AddPreviewLostKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void ClearFocus() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("ClearFocus");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemoveGotKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemoveGotKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemoveKeyboardInputProviderAcquireFocusHandler(DependencyObject element, KeyboardInputProviderAcquireFocusEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemoveKeyboardInputProviderAcquireFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemoveKeyDownHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemoveKeyDownHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemoveKeyUpHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemoveKeyUpHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemoveLostKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemoveLostKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemovePreviewGotKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemovePreviewGotKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemovePreviewKeyboardInputProviderAcquireFocusHandler(DependencyObject element, KeyboardInputProviderAcquireFocusEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemovePreviewKeyboardInputProviderAcquireFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemovePreviewKeyDownHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemovePreviewKeyDownHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemovePreviewKeyUpHandler(DependencyObject element, KeyEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemovePreviewKeyUpHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void RemovePreviewLostKeyboardFocusHandler(DependencyObject element, KeyboardFocusChangedEventHandler handler) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("RemovePreviewLostKeyboardFocusHandler", element == null ? null : element.getJCOInstance(), handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static IInputElement getFocusedElement() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("FocusedElement");
            return new IInputElementImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static KeyboardDevice getPrimaryDevice() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.FormatException, system.MulticastNotSupportedException, system.collections.generic.KeyNotFoundException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("PrimaryDevice");
            return new KeyboardDevice(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static ModifierKeys getModifiers() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("Modifiers");
            return new ModifierKeys(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static RestoreFocusMode getDefaultRestoreFocusMode() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject val = (JCObject)classType.Get("DefaultRestoreFocusMode");
            return new RestoreFocusMode(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void setDefaultRestoreFocusMode(RestoreFocusMode DefaultRestoreFocusMode) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.ArgumentNullException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.InvalidOperationException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.NotSupportedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Set("DefaultRestoreFocusMode", DefaultRestoreFocusMode == null ? null : DefaultRestoreFocusMode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}