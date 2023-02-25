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

package system.windows.media;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.threading.DispatcherObject;
import system.windows.media.Drawing;
import system.windows.media.Brush;
import system.windows.media.Pen;
import system.windows.Point;
import system.windows.media.animation.AnimationClock;
import system.windows.media.Geometry;
import system.windows.media.GlyphRun;
import system.windows.media.ImageSource;
import system.windows.Rect;
import system.windows.media.FormattedText;
import system.windows.media.MediaPlayer;
import system.windows.media.effects.BitmapEffect;
import system.windows.media.effects.BitmapEffectInput;
import system.windows.media.GuidelineSet;
import system.windows.media.Transform;
import system.IDisposable;
import system.IDisposableImplementation;


/**
 * The base .NET class managing System.Windows.Media.DrawingContext, PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.DrawingContext" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Media.DrawingContext</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class DrawingContext extends DispatcherObject implements system.IDisposable, AutoCloseable {
    /**
     * Fully assembly qualified name: PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Media.DrawingContext
     */
    public static final String className = "System.Windows.Media.DrawingContext";
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
    public DrawingContext(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DrawingContext}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DrawingContext} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DrawingContext cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DrawingContext(from.getJCOInstance());
    }

    // Constructors section
    
    public DrawingContext() throws Throwable {
    }

    
    // Methods section
    
    public void Close() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawDrawing(Drawing drawing) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawDrawing", drawing == null ? null : drawing.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawEllipse(Brush brush, Pen pen, Point center, double radiusX, double radiusY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawEllipse", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), center == null ? null : center.getJCOInstance(), radiusX, radiusY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawEllipse(Brush brush, Pen pen, Point center, AnimationClock centerAnimations, double radiusX, AnimationClock radiusXAnimations, double radiusY, AnimationClock radiusYAnimations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawEllipse", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), center == null ? null : center.getJCOInstance(), centerAnimations == null ? null : centerAnimations.getJCOInstance(), radiusX, radiusXAnimations == null ? null : radiusXAnimations.getJCOInstance(), radiusY, radiusYAnimations == null ? null : radiusYAnimations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawGeometry(Brush brush, Pen pen, Geometry geometry) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawGeometry", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), geometry == null ? null : geometry.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawGlyphRun(Brush foregroundBrush, GlyphRun glyphRun) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawGlyphRun", foregroundBrush == null ? null : foregroundBrush.getJCOInstance(), glyphRun == null ? null : glyphRun.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawImage(ImageSource imageSource, Rect rectangle, AnimationClock rectangleAnimations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawImage", imageSource == null ? null : imageSource.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance(), rectangleAnimations == null ? null : rectangleAnimations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawImage(ImageSource imageSource, Rect rectangle) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawImage", imageSource == null ? null : imageSource.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawLine(Pen pen, Point point0, AnimationClock point0Animations, Point point1, AnimationClock point1Animations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawLine", pen == null ? null : pen.getJCOInstance(), point0 == null ? null : point0.getJCOInstance(), point0Animations == null ? null : point0Animations.getJCOInstance(), point1 == null ? null : point1.getJCOInstance(), point1Animations == null ? null : point1Animations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawLine(Pen pen, Point point0, Point point1) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawLine", pen == null ? null : pen.getJCOInstance(), point0 == null ? null : point0.getJCOInstance(), point1 == null ? null : point1.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawRectangle(Brush brush, Pen pen, Rect rectangle, AnimationClock rectangleAnimations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawRectangle", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance(), rectangleAnimations == null ? null : rectangleAnimations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawRectangle(Brush brush, Pen pen, Rect rectangle) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawRectangle", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawRoundedRectangle(Brush brush, Pen pen, Rect rectangle, double radiusX, double radiusY) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawRoundedRectangle", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance(), radiusX, radiusY);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawRoundedRectangle(Brush brush, Pen pen, Rect rectangle, AnimationClock rectangleAnimations, double radiusX, AnimationClock radiusXAnimations, double radiusY, AnimationClock radiusYAnimations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawRoundedRectangle", brush == null ? null : brush.getJCOInstance(), pen == null ? null : pen.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance(), rectangleAnimations == null ? null : rectangleAnimations.getJCOInstance(), radiusX, radiusXAnimations == null ? null : radiusXAnimations.getJCOInstance(), radiusY, radiusYAnimations == null ? null : radiusYAnimations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawText(FormattedText formattedText, Point origin) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidCastException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawText", formattedText == null ? null : formattedText.getJCOInstance(), origin == null ? null : origin.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawVideo(MediaPlayer player, Rect rectangle, AnimationClock rectangleAnimations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawVideo", player == null ? null : player.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance(), rectangleAnimations == null ? null : rectangleAnimations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawVideo(MediaPlayer player, Rect rectangle) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawVideo", player == null ? null : player.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Pop() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Pop");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushClip(Geometry clipGeometry) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushClip", clipGeometry == null ? null : clipGeometry.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushEffect(BitmapEffect effect, BitmapEffectInput effectInput) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushEffect", effect == null ? null : effect.getJCOInstance(), effectInput == null ? null : effectInput.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushGuidelineSet(GuidelineSet guidelines) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushGuidelineSet", guidelines == null ? null : guidelines.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushOpacity(double opacity, AnimationClock opacityAnimations) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushOpacity", opacity, opacityAnimations == null ? null : opacityAnimations.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushOpacity(double opacity) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushOpacity", opacity);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushOpacityMask(Brush opacityMask) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushOpacityMask", opacityMask == null ? null : opacityMask.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PushTransform(Transform transform) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PushTransform", transform == null ? null : transform.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    /**
     * @deprecated Not for public use because the method is implemented in .NET with an explicit interface.
     *    Use the static ToIDisposable method available in IDisposable to obtain an object with an invocable method
     */
    @Deprecated 
    public void Dispose() throws Throwable {
        throw new UnsupportedOperationException("Not for public use because the method is implemented with an explicit interface. Use ToIDisposable to obtain the full interface.");
    }

    public void close() throws Exception {
        try {
            if (classInstance == null)
                throw new UnsupportedOperationException("classInstance is null.");
            try {
                classInstance.Invoke("Dispose");
            }
            catch (JCNativeException jcne) {
                throw translateException(jcne);
            }
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }
    
    // Properties section
    


    // Instance Events section
    

}