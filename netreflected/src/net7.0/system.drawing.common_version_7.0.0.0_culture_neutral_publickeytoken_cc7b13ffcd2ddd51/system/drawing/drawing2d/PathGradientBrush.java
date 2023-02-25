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

package system.drawing.drawing2d;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.drawing.Brush;
import system.drawing.drawing2d.GraphicsPath;
import system.drawing.Point;
import system.drawing.drawing2d.WrapMode;
import system.drawing.PointF;
import system.drawing.drawing2d.Matrix;
import system.drawing.drawing2d.MatrixOrder;
import system.Single;
import system.drawing.Color;
import system.drawing.drawing2d.Blend;
import system.drawing.drawing2d.ColorBlend;
import system.drawing.RectangleF;


/**
 * The base .NET class managing System.Drawing.Drawing2D.PathGradientBrush, System.Drawing.Common, Version=7.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Drawing2D.PathGradientBrush" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Drawing2D.PathGradientBrush</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class PathGradientBrush extends Brush  {
    /**
     * Fully assembly qualified name: System.Drawing.Common, Version=7.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Drawing.Common, Version=7.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Drawing.Common
     */
    public static final String assemblyShortName = "System.Drawing.Common";
    /**
     * Qualified class name: System.Drawing.Drawing2D.PathGradientBrush
     */
    public static final String className = "System.Drawing.Drawing2D.PathGradientBrush";
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
    public PathGradientBrush(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link PathGradientBrush}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link PathGradientBrush} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static PathGradientBrush cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new PathGradientBrush(from.getJCOInstance());
    }

    // Constructors section
    
    public PathGradientBrush() throws Throwable {
    }

    public PathGradientBrush(GraphicsPath path) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(path == null ? null : path.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PathGradientBrush(Point[] points, WrapMode wrapMode) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(toObjectFromArray(points), wrapMode == null ? null : wrapMode.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PathGradientBrush(Point[] points) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject((java.lang.Object)toObjectFromArray(points)));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PathGradientBrush(PointF[] points, WrapMode wrapMode) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(toObjectFromArray(points), wrapMode == null ? null : wrapMode.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PathGradientBrush(PointF[] points) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.componentmodel.InvalidEnumArgumentException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject((java.lang.Object)toObjectFromArray(points)));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public NetObject Clone() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objClone = (JCObject)classInstance.Invoke("Clone");
            return new NetObject(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void MultiplyTransform(Matrix matrix, MatrixOrder order) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("MultiplyTransform", matrix == null ? null : matrix.getJCOInstance(), order == null ? null : order.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void MultiplyTransform(Matrix matrix) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("MultiplyTransform", matrix == null ? null : matrix.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ResetTransform() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ResetTransform");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RotateTransform(Single angle, MatrixOrder order) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RotateTransform", angle == null ? null : angle.getJCOInstance(), order == null ? null : order.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RotateTransform(Single angle) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RotateTransform", angle == null ? null : angle.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ScaleTransform(Single sx, Single sy, MatrixOrder order) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ScaleTransform", sx == null ? null : sx.getJCOInstance(), sy == null ? null : sy.getJCOInstance(), order == null ? null : order.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ScaleTransform(Single sx, Single sy) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ScaleTransform", sx == null ? null : sx.getJCOInstance(), sy == null ? null : sy.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetBlendTriangularShape(Single focus, Single scale) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetBlendTriangularShape", focus == null ? null : focus.getJCOInstance(), scale == null ? null : scale.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetBlendTriangularShape(Single focus) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetBlendTriangularShape", focus == null ? null : focus.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSigmaBellShape(Single focus, Single scale) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSigmaBellShape", focus == null ? null : focus.getJCOInstance(), scale == null ? null : scale.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SetSigmaBellShape(Single focus) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SetSigmaBellShape", focus == null ? null : focus.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TranslateTransform(Single dx, Single dy, MatrixOrder order) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TranslateTransform", dx == null ? null : dx.getJCOInstance(), dy == null ? null : dy.getJCOInstance(), order == null ? null : order.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void TranslateTransform(Single dx, Single dy) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("TranslateTransform", dx == null ? null : dx.getJCOInstance(), dy == null ? null : dy.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public Color getCenterColor() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CenterColor");
            return new Color(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCenterColor(Color CenterColor) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CenterColor", CenterColor == null ? null : CenterColor.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public final Color[] getSurroundColors() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Color> resultingArrayList = new ArrayList<Color>();
            JCObject resultingObjects = (JCObject)classInstance.Get("SurroundColors");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new Color(resultingObject));
            }
            Color[] resultingArray = new Color[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSurroundColors(Color[] SurroundColors) throws Throwable, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SurroundColors", toObjectFromArray(SurroundColors));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Blend getBlend() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Blend");
            return new Blend(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setBlend(Blend Blend) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException, system.NullReferenceException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Blend", Blend == null ? null : Blend.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ColorBlend getInterpolationColors() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("InterpolationColors");
            return new ColorBlend(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInterpolationColors(ColorBlend InterpolationColors) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InterpolationColors", InterpolationColors == null ? null : InterpolationColors.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Matrix getTransform() throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Transform");
            return new Matrix(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTransform(Matrix Transform) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.globalization.CultureNotFoundException, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Transform", Transform == null ? null : Transform.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public WrapMode getWrapMode() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("WrapMode");
            return new WrapMode(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWrapMode(WrapMode WrapMode) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArrayTypeMismatchException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("WrapMode", WrapMode == null ? null : WrapMode.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PointF getCenterPoint() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CenterPoint");
            return new PointF(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCenterPoint(PointF CenterPoint) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CenterPoint", CenterPoint == null ? null : CenterPoint.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PointF getFocusScales() throws Throwable, system.PlatformNotSupportedException, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("FocusScales");
            return new PointF(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFocusScales(PointF FocusScales) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FocusScales", FocusScales == null ? null : FocusScales.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RectangleF getRectangle() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Rectangle");
            return new RectangleF(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}