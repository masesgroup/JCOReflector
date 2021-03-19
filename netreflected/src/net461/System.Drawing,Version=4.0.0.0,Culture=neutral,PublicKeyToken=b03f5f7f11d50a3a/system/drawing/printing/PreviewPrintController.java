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

package system.drawing.printing;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.drawing.printing.PrintController;
import system.drawing.Graphics;
import system.drawing.printing.PrintDocument;
import system.drawing.printing.PrintPageEventArgs;
import system.drawing.printing.PreviewPageInfo;
import system.drawing.printing.PrintEventArgs;


/**
 * The base .NET class managing System.Drawing.Printing.PreviewPrintController, System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Printing.PreviewPrintController" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Drawing.Printing.PreviewPrintController</a>
 */
public class PreviewPrintController extends PrintController  {
    /**
     * Fully assembly qualified name: System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Drawing, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Drawing
     */
    public static final String assemblyShortName = "System.Drawing";
    /**
     * Qualified class name: System.Drawing.Printing.PreviewPrintController
     */
    public static final String className = "System.Drawing.Printing.PreviewPrintController";
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

    public PreviewPrintController(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link PreviewPrintController}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link PreviewPrintController} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static PreviewPrintController cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new PreviewPrintController(from.getJCOInstance());
    }

    // Constructors section
    
    public PreviewPrintController() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public Graphics OnStartPage(PrintDocument document, PrintPageEventArgs e) throws Throwable, system.ArgumentException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.globalization.CultureNotFoundException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.NullReferenceException, system.security.SecurityException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.InvalidCastException, system.componentmodel.Win32Exception, system.AccessViolationException, system.drawing.printing.InvalidPrinterException, system.componentmodel.InvalidEnumArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objOnStartPage = (JCObject)classInstance.Invoke("OnStartPage", document == null ? null : document.getJCOInstance(), e == null ? null : e.getJCOInstance());
            return new Graphics(objOnStartPage);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PreviewPageInfo[] GetPreviewPageInfo() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<PreviewPageInfo> resultingArrayList = new ArrayList<PreviewPageInfo>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetPreviewPageInfo");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new PreviewPageInfo(resultingObject));
            }
            PreviewPageInfo[] resultingArray = new PreviewPageInfo[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OnEndPage(PrintDocument document, PrintPageEventArgs e) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OnEndPage", document == null ? null : document.getJCOInstance(), e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OnEndPrint(PrintDocument document, PrintEventArgs e) throws Throwable, system.ArgumentException, system.ArgumentNullException, system.security.SecurityException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OnEndPrint", document == null ? null : document.getJCOInstance(), e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void OnStartPrint(PrintDocument document, PrintEventArgs e) throws Throwable, system.ArgumentException, system.NotSupportedException, system.ArgumentNullException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.security.SecurityException, system.resources.MissingManifestResourceException, system.componentmodel.Win32Exception, system.AccessViolationException, system.IndexOutOfRangeException, system.drawing.printing.InvalidPrinterException, system.MissingMethodException, system.reflection.TargetInvocationException, system.InvalidCastException, system.MulticastNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("OnStartPrint", document == null ? null : document.getJCOInstance(), e == null ? null : e.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getUseAntiAlias() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("UseAntiAlias");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setUseAntiAlias(boolean UseAntiAlias) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("UseAntiAlias", UseAntiAlias);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}