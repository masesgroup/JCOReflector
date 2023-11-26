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

package system.windows.ink;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.Guid;
import system.windows.ink.DrawingAttributes;
import system.windows.ink.StylusTip;
import system.windows.media.Color;
import system.windows.media.Matrix;
import system.windows.ink.PropertyDataChangedEventHandler;


/**
 * The base .NET class managing System.Windows.Ink.DrawingAttributes, PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Ink.DrawingAttributes" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Ink.DrawingAttributes</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class DrawingAttributes extends NetObject  {
    /**
     * Fully assembly qualified name: PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "PresentationCore, Version=7.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: PresentationCore
     */
    public static final String assemblyShortName = "PresentationCore";
    /**
     * Qualified class name: System.Windows.Ink.DrawingAttributes
     */
    public static final String className = "System.Windows.Ink.DrawingAttributes";
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
    public DrawingAttributes(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link DrawingAttributes}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link DrawingAttributes} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static DrawingAttributes cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new DrawingAttributes(from.getJCOInstance());
    }

    // Constructors section
    
    public DrawingAttributes() throws Throwable, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.InvalidOperationException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.OverflowException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public boolean ContainsPropertyData(Guid propertyDataId) throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("ContainsPropertyData", propertyDataId == null ? null : propertyDataId.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Guid[] GetPropertyDataIds() throws Throwable, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<Guid> resultingArrayList = new ArrayList<Guid>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetPropertyDataIds");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new Guid(resultingObject));
            }
            Guid[] resultingArray = new Guid[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject GetPropertyData(Guid propertyDataId) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetPropertyData = (JCObject)classInstance.Invoke("GetPropertyData", propertyDataId == null ? null : propertyDataId.getJCOInstance());
            return new NetObject(objGetPropertyData);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DrawingAttributes Clone() throws Throwable, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.NotSupportedException, system.ArgumentException, system.globalization.CultureNotFoundException, system.ArgumentNullException, system.IndexOutOfRangeException, system.OverflowException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objClone = (JCObject)classInstance.Invoke("Clone");
            return new DrawingAttributes(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void AddPropertyData(Guid propertyDataId, NetObject propertyData) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ArrayTypeMismatchException, system.IndexOutOfRangeException, system.NotSupportedException, system.ObjectDisposedException, system.RankException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("AddPropertyData", propertyDataId == null ? null : propertyDataId.getJCOInstance(), propertyData == null ? null : propertyData.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemovePropertyData(Guid propertyDataId) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RemovePropertyData", propertyDataId == null ? null : propertyDataId.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getFitToCurve() throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("FitToCurve");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFitToCurve(boolean FitToCurve) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FitToCurve", FitToCurve);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIgnorePressure() throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IgnorePressure");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIgnorePressure(boolean IgnorePressure) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentNullException, system.ArgumentException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IgnorePressure", IgnorePressure);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsHighlighter() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("IsHighlighter");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIsHighlighter(boolean IsHighlighter) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IsHighlighter", IsHighlighter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getHeight() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentNullException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("Height");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setHeight(double Height) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Height", Height);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public double getWidth() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentNullException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (double)classInstance.Get("Width");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setWidth(double Width) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Width", Width);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StylusTip getStylusTip() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("StylusTip");
            return new StylusTip(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStylusTip(StylusTip StylusTip) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StylusTip", StylusTip == null ? null : StylusTip.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Color getColor() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentNullException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Color");
            return new Color(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setColor(Color Color) throws Throwable, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ArgumentException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.RankException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.ArgumentNullException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Color", Color == null ? null : Color.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Matrix getStylusTipTransform() throws Throwable, system.NotSupportedException, system.ArgumentException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentNullException, system.InvalidOperationException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("StylusTipTransform");
            return new Matrix(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setStylusTipTransform(Matrix StylusTipTransform) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.NotSupportedException, system.RankException, system.ArrayTypeMismatchException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("StylusTipTransform", StylusTipTransform == null ? null : StylusTipTransform.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

    public void addAttributeChanged(PropertyDataChangedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("AttributeChanged", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeAttributeChanged(PropertyDataChangedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("AttributeChanged", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void addPropertyDataChanged(PropertyDataChangedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("PropertyDataChanged", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removePropertyDataChanged(PropertyDataChangedEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("PropertyDataChanged", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}