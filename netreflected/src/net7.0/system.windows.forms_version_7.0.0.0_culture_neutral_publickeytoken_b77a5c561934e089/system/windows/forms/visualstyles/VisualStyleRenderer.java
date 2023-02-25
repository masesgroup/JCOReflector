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

package system.windows.forms.visualstyles;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.forms.visualstyles.VisualStyleElement;
import system.windows.forms.visualstyles.BooleanProperty;
import system.windows.forms.visualstyles.EnumProperty;
import system.windows.forms.visualstyles.IntegerProperty;
import system.drawing.Color;
import system.windows.forms.visualstyles.ColorProperty;
import system.drawing.Font;
import system.drawing.IDeviceContext;
import system.drawing.IDeviceContextImplementation;
import system.windows.forms.visualstyles.FontProperty;
import system.drawing.Point;
import system.windows.forms.visualstyles.PointProperty;
import system.drawing.Rectangle;
import system.windows.forms.visualstyles.Edges;
import system.windows.forms.visualstyles.EdgeStyle;
import system.windows.forms.visualstyles.EdgeEffects;
import system.windows.forms.TextFormatFlags;
import system.drawing.Region;
import system.drawing.Size;
import system.windows.forms.visualstyles.ThemeSizeType;
import system.windows.forms.visualstyles.FilenameProperty;
import system.windows.forms.visualstyles.StringProperty;
import system.windows.forms.Padding;
import system.windows.forms.visualstyles.MarginProperty;
import system.windows.forms.visualstyles.HitTestCode;
import system.drawing.Graphics;
import system.windows.forms.visualstyles.HitTestOptions;
import system.windows.forms.visualstyles.TextMetrics;
import system.drawing.Image;
import system.windows.forms.ImageList;
import system.windows.forms.Control;


/**
 * The base .NET class managing System.Windows.Forms.VisualStyles.VisualStyleRenderer, System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.VisualStyles.VisualStyleRenderer" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.VisualStyles.VisualStyleRenderer</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class VisualStyleRenderer extends NetObject  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.VisualStyles.VisualStyleRenderer
     */
    public static final String className = "System.Windows.Forms.VisualStyles.VisualStyleRenderer";
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
    public VisualStyleRenderer(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link VisualStyleRenderer}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link VisualStyleRenderer} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static VisualStyleRenderer cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new VisualStyleRenderer(from.getJCOInstance());
    }

    // Constructors section
    
    public VisualStyleRenderer() throws Throwable {
    }

    public VisualStyleRenderer(java.lang.String className, int part, int state) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(className, part, state));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public VisualStyleRenderer(VisualStyleElement element) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(element == null ? null : element.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean GetBoolean(BooleanProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("GetBoolean", prop == null ? null : prop.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean IsBackgroundPartiallyTransparent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsBackgroundPartiallyTransparent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static boolean IsElementDefined(VisualStyleElement element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Invoke("IsElementDefined", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int GetEnumValue(EnumProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("GetEnumValue", prop == null ? null : prop.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int GetInteger(IntegerProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Invoke("GetInteger", prop == null ? null : prop.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Color GetColor(ColorProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetColor = (JCObject)classInstance.Invoke("GetColor", prop == null ? null : prop.getJCOInstance());
            return new Color(objGetColor);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Font GetFont(IDeviceContext dc, FontProperty prop) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetFont = (JCObject)classInstance.Invoke("GetFont", dc == null ? null : dc.getJCOInstance(), prop == null ? null : prop.getJCOInstance());
            return new Font(objGetFont);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Point GetPoint(PointProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPoint = (JCObject)classInstance.Invoke("GetPoint", prop == null ? null : prop.getJCOInstance());
            return new Point(objGetPoint);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle DrawEdge(IDeviceContext dc, Rectangle bounds, Edges edges, EdgeStyle style, EdgeEffects effects) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDrawEdge = (JCObject)classInstance.Invoke("DrawEdge", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), edges == null ? null : edges.getJCOInstance(), style == null ? null : style.getJCOInstance(), effects == null ? null : effects.getJCOInstance());
            return new Rectangle(objDrawEdge);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle GetBackgroundContentRectangle(IDeviceContext dc, Rectangle bounds) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetBackgroundContentRectangle = (JCObject)classInstance.Invoke("GetBackgroundContentRectangle", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance());
            return new Rectangle(objGetBackgroundContentRectangle);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle GetBackgroundExtent(IDeviceContext dc, Rectangle contentBounds) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetBackgroundExtent = (JCObject)classInstance.Invoke("GetBackgroundExtent", dc == null ? null : dc.getJCOInstance(), contentBounds == null ? null : contentBounds.getJCOInstance());
            return new Rectangle(objGetBackgroundExtent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle GetTextExtent(IDeviceContext dc, Rectangle bounds, java.lang.String textToDraw, TextFormatFlags flags) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetTextExtent = (JCObject)classInstance.Invoke("GetTextExtent", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), textToDraw, flags == null ? null : flags.getJCOInstance());
            return new Rectangle(objGetTextExtent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Rectangle GetTextExtent(IDeviceContext dc, java.lang.String textToDraw, TextFormatFlags flags) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetTextExtent = (JCObject)classInstance.Invoke("GetTextExtent", dc == null ? null : dc.getJCOInstance(), textToDraw, flags == null ? null : flags.getJCOInstance());
            return new Rectangle(objGetTextExtent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Region GetBackgroundRegion(IDeviceContext dc, Rectangle bounds) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetBackgroundRegion = (JCObject)classInstance.Invoke("GetBackgroundRegion", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance());
            return new Region(objGetBackgroundRegion);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Size GetPartSize(IDeviceContext dc, Rectangle bounds, ThemeSizeType type) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPartSize = (JCObject)classInstance.Invoke("GetPartSize", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), type == null ? null : type.getJCOInstance());
            return new Size(objGetPartSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Size GetPartSize(IDeviceContext dc, ThemeSizeType type) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPartSize = (JCObject)classInstance.Invoke("GetPartSize", dc == null ? null : dc.getJCOInstance(), type == null ? null : type.getJCOInstance());
            return new Size(objGetPartSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String GetFilename(FilenameProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetFilename", prop == null ? null : prop.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String GetString(StringProperty prop) throws Throwable, system.ArgumentException, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("GetString", prop == null ? null : prop.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Padding GetMargins(IDeviceContext dc, MarginProperty prop) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetMargins = (JCObject)classInstance.Invoke("GetMargins", dc == null ? null : dc.getJCOInstance(), prop == null ? null : prop.getJCOInstance());
            return new Padding(objGetMargins);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HitTestCode HitTestBackground(Graphics g, Rectangle backgroundRectangle, Region region, Point pt, HitTestOptions options) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objHitTestBackground = (JCObject)classInstance.Invoke("HitTestBackground", g == null ? null : g.getJCOInstance(), backgroundRectangle == null ? null : backgroundRectangle.getJCOInstance(), region == null ? null : region.getJCOInstance(), pt == null ? null : pt.getJCOInstance(), options == null ? null : options.getJCOInstance());
            return new HitTestCode(objHitTestBackground);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public HitTestCode HitTestBackground(IDeviceContext dc, Rectangle backgroundRectangle, Point pt, HitTestOptions options) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objHitTestBackground = (JCObject)classInstance.Invoke("HitTestBackground", dc == null ? null : dc.getJCOInstance(), backgroundRectangle == null ? null : backgroundRectangle.getJCOInstance(), pt == null ? null : pt.getJCOInstance(), options == null ? null : options.getJCOInstance());
            return new HitTestCode(objHitTestBackground);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public TextMetrics GetTextMetrics(IDeviceContext dc) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetTextMetrics = (JCObject)classInstance.Invoke("GetTextMetrics", dc == null ? null : dc.getJCOInstance());
            return new TextMetrics(objGetTextMetrics);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawBackground(IDeviceContext dc, Rectangle bounds, Rectangle clipRectangle) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawBackground", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), clipRectangle == null ? null : clipRectangle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawBackground(IDeviceContext dc, Rectangle bounds) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawBackground", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawImage(Graphics g, Rectangle bounds, Image image) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawImage", g == null ? null : g.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), image == null ? null : image.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawImage(Graphics g, Rectangle bounds, ImageList imageList, int imageIndex) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.AccessViolationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawImage", g == null ? null : g.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), imageList == null ? null : imageList.getJCOInstance(), imageIndex);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawParentBackground(IDeviceContext dc, Rectangle bounds, Control childControl) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawParentBackground", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), childControl == null ? null : childControl.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawText(IDeviceContext dc, Rectangle bounds, java.lang.String textToDraw, boolean drawDisabled, TextFormatFlags flags) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawText", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), textToDraw, drawDisabled, flags == null ? null : flags.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawText(IDeviceContext dc, Rectangle bounds, java.lang.String textToDraw, boolean drawDisabled) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawText", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), textToDraw, drawDisabled);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void DrawText(IDeviceContext dc, Rectangle bounds, java.lang.String textToDraw) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.FormatException, system.componentmodel.Win32Exception {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("DrawText", dc == null ? null : dc.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), textToDraw);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetParameters(java.lang.String className, int part, int state) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetParameters", className, part, state);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetParameters(VisualStyleElement element) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetParameters", element == null ? null : element.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public static boolean getIsSupported() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            return (boolean)classType.Get("IsSupported");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getLastHResult() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("LastHResult");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getPart() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Part");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setPart(int Part) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Part", Part);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getState() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("State");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setState(int State) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("State", State);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String get_Class() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Class");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void set_Class(java.lang.String Class) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Class", Class);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}