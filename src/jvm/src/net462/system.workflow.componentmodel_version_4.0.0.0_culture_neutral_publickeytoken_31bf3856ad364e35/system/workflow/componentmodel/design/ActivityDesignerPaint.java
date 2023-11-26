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

package system.workflow.componentmodel.design;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.drawing.drawing2d.GraphicsPath;
import system.drawing.Rectangle;
import system.drawing.Graphics;
import system.drawing.Image;
import system.Single;
import system.windows.forms.ButtonState;
import system.workflow.componentmodel.design.CompositeDesignerTheme;
import system.workflow.componentmodel.design.DesignerContentAlignment;
import system.drawing.Pen;
import system.drawing.Font;
import system.drawing.StringAlignment;
import system.workflow.componentmodel.design.TextQuality;
import system.drawing.Brush;


/**
 * The base .NET class managing System.Workflow.ComponentModel.Design.ActivityDesignerPaint, System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.ComponentModel.Design.ActivityDesignerPaint" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.ComponentModel.Design.ActivityDesignerPaint</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ActivityDesignerPaint extends NetObject  {
    /**
     * Fully assembly qualified name: System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Workflow.ComponentModel
     */
    public static final String assemblyShortName = "System.Workflow.ComponentModel";
    /**
     * Qualified class name: System.Workflow.ComponentModel.Design.ActivityDesignerPaint
     */
    public static final String className = "System.Workflow.ComponentModel.Design.ActivityDesignerPaint";
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
    public ActivityDesignerPaint(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ActivityDesignerPaint}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ActivityDesignerPaint} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ActivityDesignerPaint cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ActivityDesignerPaint(from.getJCOInstance());
    }

    // Constructors section
    
    public ActivityDesignerPaint() throws Throwable {
    }

    
    // Methods section
    
    public static GraphicsPath GetRoundedRectanglePath(Rectangle rectangle, int radius) throws Throwable, system.InvalidOperationException, system.ArgumentNullException, system.ArgumentException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.IndexOutOfRangeException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objGetRoundedRectanglePath = (JCObject)classType.Invoke("GetRoundedRectanglePath", rectangle == null ? null : rectangle.getJCOInstance(), radius);
            return new GraphicsPath(objGetRoundedRectanglePath);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void Draw3DButton(Graphics graphics, Image image, Rectangle bounds, Single transparency, ButtonState buttonState) throws Throwable, system.ArgumentNullException, system.OverflowException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.runtime.interopservices.ExternalException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("Draw3DButton", graphics == null ? null : graphics.getJCOInstance(), image == null ? null : image.getJCOInstance(), bounds == null ? null : bounds.getJCOInstance(), transparency == null ? null : transparency.getJCOInstance(), buttonState == null ? null : buttonState.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DrawExpandButton(Graphics graphics, Rectangle boundingRect, boolean drawExpanded, CompositeDesignerTheme compositeDesignerTheme) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.componentmodel.InvalidEnumArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DrawExpandButton", graphics == null ? null : graphics.getJCOInstance(), boundingRect == null ? null : boundingRect.getJCOInstance(), drawExpanded, compositeDesignerTheme == null ? null : compositeDesignerTheme.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DrawImage(Graphics graphics, Image image, Rectangle destination, Rectangle source, DesignerContentAlignment alignment, Single transparency, boolean grayscale) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DrawImage", graphics == null ? null : graphics.getJCOInstance(), image == null ? null : image.getJCOInstance(), destination == null ? null : destination.getJCOInstance(), source == null ? null : source.getJCOInstance(), alignment == null ? null : alignment.getJCOInstance(), transparency == null ? null : transparency.getJCOInstance(), grayscale);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DrawImage(Graphics graphics, Image image, Rectangle destination, DesignerContentAlignment alignment) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DrawImage", graphics == null ? null : graphics.getJCOInstance(), image == null ? null : image.getJCOInstance(), destination == null ? null : destination.getJCOInstance(), alignment == null ? null : alignment.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DrawRoundedRectangle(Graphics graphics, Pen drawingPen, Rectangle rectangle, int radius) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DrawRoundedRectangle", graphics == null ? null : graphics.getJCOInstance(), drawingPen == null ? null : drawingPen.getJCOInstance(), rectangle == null ? null : rectangle.getJCOInstance(), radius);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void DrawText(Graphics graphics, Font font, java.lang.String text, Rectangle boundingRect, StringAlignment alignment, TextQuality textQuality, Brush textBrush) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("DrawText", graphics == null ? null : graphics.getJCOInstance(), font == null ? null : font.getJCOInstance(), text, boundingRect == null ? null : boundingRect.getJCOInstance(), alignment == null ? null : alignment.getJCOInstance(), textQuality == null ? null : textQuality.getJCOInstance(), textBrush == null ? null : textBrush.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}