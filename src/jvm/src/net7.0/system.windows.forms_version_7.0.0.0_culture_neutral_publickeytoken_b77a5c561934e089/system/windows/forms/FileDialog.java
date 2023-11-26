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

package system.windows.forms;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.forms.CommonDialog;
import system.windows.forms.FileDialogCustomPlacesCollection;
import system.componentmodel.CancelEventHandler;


/**
 * The base .NET class managing System.Windows.Forms.FileDialog, System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.FileDialog" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Forms.FileDialog</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class FileDialog extends CommonDialog  {
    /**
     * Fully assembly qualified name: System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Windows.Forms, Version=7.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Windows.Forms
     */
    public static final String assemblyShortName = "System.Windows.Forms";
    /**
     * Qualified class name: System.Windows.Forms.FileDialog
     */
    public static final String className = "System.Windows.Forms.FileDialog";
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
    public FileDialog(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link FileDialog}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link FileDialog} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static FileDialog cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new FileDialog(from.getJCOInstance());
    }

    // Constructors section
    
    public FileDialog() throws Throwable {
    }

    
    // Methods section
    
    public void Reset() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.PlatformNotSupportedException, system.NotSupportedException, system.ObjectDisposedException, system.InvalidOperationException, system.RankException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Reset");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getAddExtension() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AddExtension");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAddExtension(boolean AddExtension) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AddExtension", AddExtension);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getAddToRecent() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AddToRecent");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAddToRecent(boolean AddToRecent) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AddToRecent", AddToRecent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getAutoUpgradeEnabled() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("AutoUpgradeEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAutoUpgradeEnabled(boolean AutoUpgradeEnabled) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AutoUpgradeEnabled", AutoUpgradeEnabled);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getCheckFileExists() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("CheckFileExists");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCheckFileExists(boolean CheckFileExists) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CheckFileExists", CheckFileExists);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getCheckPathExists() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("CheckPathExists");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCheckPathExists(boolean CheckPathExists) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CheckPathExists", CheckPathExists);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getDereferenceLinks() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("DereferenceLinks");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDereferenceLinks(boolean DereferenceLinks) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DereferenceLinks", DereferenceLinks);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getOkRequiresInteraction() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("OkRequiresInteraction");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOkRequiresInteraction(boolean OkRequiresInteraction) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("OkRequiresInteraction", OkRequiresInteraction);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getRestoreDirectory() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("RestoreDirectory");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRestoreDirectory(boolean RestoreDirectory) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("RestoreDirectory", RestoreDirectory);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getShowHelp() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ShowHelp");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setShowHelp(boolean ShowHelp) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ShowHelp", ShowHelp);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getShowHiddenFiles() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ShowHiddenFiles");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setShowHiddenFiles(boolean ShowHiddenFiles) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ShowHiddenFiles", ShowHiddenFiles);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getShowPinnedPlaces() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ShowPinnedPlaces");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setShowPinnedPlaces(boolean ShowPinnedPlaces) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ShowPinnedPlaces", ShowPinnedPlaces);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSupportMultiDottedExtensions() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SupportMultiDottedExtensions");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSupportMultiDottedExtensions(boolean SupportMultiDottedExtensions) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SupportMultiDottedExtensions", SupportMultiDottedExtensions);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getValidateNames() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("ValidateNames");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setValidateNames(boolean ValidateNames) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ValidateNames", ValidateNames);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getFilterIndex() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("FilterIndex");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFilterIndex(int FilterIndex) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FilterIndex", FilterIndex);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getDefaultExt() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("DefaultExt");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDefaultExt(java.lang.String DefaultExt) throws Throwable, system.ArgumentException, system.PlatformNotSupportedException, system.NotSupportedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DefaultExt", DefaultExt);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getFileName() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("FileName");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFileName(java.lang.String FileName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("FileName", FileName);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getFilter() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Filter");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFilter(java.lang.String Filter) throws Throwable, system.NotSupportedException, system.ArgumentException, system.PlatformNotSupportedException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.InvalidOperationException, system.ArrayTypeMismatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Filter", Filter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getInitialDirectory() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("InitialDirectory");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setInitialDirectory(java.lang.String InitialDirectory) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("InitialDirectory", InitialDirectory);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getTitle() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("Title");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setTitle(java.lang.String Title) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Title", Title);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String[] getFileNames() throws Throwable, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<java.lang.Object> resultingArrayList = new ArrayList<java.lang.Object>();
            JCObject resultingObjects = (JCObject)classInstance.Get("FileNames");
            for (java.lang.Object resultingObject : resultingObjects) {
			    resultingArrayList.add(resultingObject);
            }
            java.lang.String[] resultingArray = new java.lang.String[resultingArrayList.size()];
			for(int indexFileNames = 0; indexFileNames < resultingArrayList.size(); indexFileNames++ ) {
				resultingArray[indexFileNames] = (java.lang.String)resultingArrayList.get(indexFileNames);
			}
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public FileDialogCustomPlacesCollection getCustomPlaces() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CustomPlaces");
            return new FileDialogCustomPlacesCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

    public void addFileOk(CancelEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("FileOk", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeFileOk(CancelEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("FileOk", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}