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

package system.web.ui.adapters;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.web.ui.adapters.ControlAdapter;
import system.collections.ICollection;
import system.collections.ICollectionImplementation;
import system.collections.specialized.NameValueCollection;
import system.web.ui.PageStatePersister;
import system.web.ui.webcontrols.RadioButton;
import system.web.ui.HtmlTextWriter;
import system.collections.specialized.StringCollection;


/**
 * The base .NET class managing System.Web.UI.Adapters.PageAdapter, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.Adapters.PageAdapter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.UI.Adapters.PageAdapter</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class PageAdapter extends ControlAdapter  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.UI.Adapters.PageAdapter
     */
    public static final String className = "System.Web.UI.Adapters.PageAdapter";
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
    public PageAdapter(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link PageAdapter}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link PageAdapter} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static PageAdapter cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new PageAdapter(from.getJCOInstance());
    }

    // Constructors section
    
    public PageAdapter() throws Throwable {
    }

    
    // Methods section
    
    public ICollection GetRadioButtonsByGroup(java.lang.String groupName) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetRadioButtonsByGroup = (JCObject)classInstance.Invoke("GetRadioButtonsByGroup", groupName);
            return new ICollectionImplementation(objGetRadioButtonsByGroup);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NameValueCollection DeterminePostBackMode() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.web.HttpException, system.NullReferenceException, system.configuration.ConfigurationErrorsException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDeterminePostBackMode = (JCObject)classInstance.Invoke("DeterminePostBackMode");
            return new NameValueCollection(objDeterminePostBackMode);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NameValueCollection DeterminePostBackModeUnvalidated() throws Throwable, system.ArgumentNullException, system.globalization.CultureNotFoundException, system.ArgumentException, system.web.HttpException, system.ArgumentOutOfRangeException, system.NullReferenceException, system.configuration.ConfigurationErrorsException, system.InvalidOperationException, system.NotSupportedException, system.configuration.ConfigurationException, system.FormatException, system.OverflowException, system.IndexOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDeterminePostBackModeUnvalidated = (JCObject)classInstance.Invoke("DeterminePostBackModeUnvalidated");
            return new NameValueCollection(objDeterminePostBackModeUnvalidated);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String TransformText(java.lang.String text) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("TransformText", text);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public PageStatePersister GetStatePersister() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.ArgumentOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetStatePersister = (JCObject)classInstance.Invoke("GetStatePersister");
            return new PageStatePersister(objGetStatePersister);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RegisterRadioButton(RadioButton radioButton) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RegisterRadioButton", radioButton == null ? null : radioButton.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RenderBeginHyperlink(HtmlTextWriter writer, java.lang.String targetUrl, boolean encodeUrl, java.lang.String softkeyLabel) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.threading.ThreadAbortException, system.InvalidOperationException, system.ArgumentNullException, system.MissingMethodException, system.reflection.TargetInvocationException, system.resources.MissingManifestResourceException, system.web.HttpException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RenderBeginHyperlink", writer == null ? null : writer.getJCOInstance(), targetUrl, encodeUrl, softkeyLabel);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RenderBeginHyperlink(HtmlTextWriter writer, java.lang.String targetUrl, boolean encodeUrl, java.lang.String softkeyLabel, java.lang.String accessKey) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.InvalidOperationException, system.threading.ThreadAbortException, system.ArgumentNullException, system.MissingMethodException, system.reflection.TargetInvocationException, system.OutOfMemoryException, system.resources.MissingManifestResourceException, system.web.HttpException, system.PlatformNotSupportedException, system.NotSupportedException, system.NullReferenceException, system.ObjectDisposedException, system.threading.AbandonedMutexException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RenderBeginHyperlink", writer == null ? null : writer.getJCOInstance(), targetUrl, encodeUrl, softkeyLabel, accessKey);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RenderEndHyperlink(HtmlTextWriter writer) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RenderEndHyperlink", writer == null ? null : writer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RenderPostBackEvent(HtmlTextWriter writer, java.lang.String target, java.lang.String argument, java.lang.String softkeyLabel, java.lang.String text) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.resources.MissingManifestResourceException, system.configuration.ConfigurationErrorsException, system.web.HttpException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.configuration.provider.ProviderException, system.NullReferenceException, system.web.HttpRequestValidationException, system.globalization.CultureNotFoundException, system.security.cryptography.CryptographicException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RenderPostBackEvent", writer == null ? null : writer.getJCOInstance(), target, argument, softkeyLabel, text);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RenderPostBackEvent(HtmlTextWriter writer, java.lang.String target, java.lang.String argument, java.lang.String softkeyLabel, java.lang.String text, java.lang.String postUrl, java.lang.String accessKey) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.configuration.ConfigurationErrorsException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.web.HttpException, system.TypeLoadException, system.MissingMethodException, system.reflection.TargetInvocationException, system.configuration.provider.ProviderException, system.IndexOutOfRangeException, system.ObjectDisposedException, system.globalization.CultureNotFoundException, system.UriFormatException, system.threading.ThreadAbortException, system.security.cryptography.CryptographicException, system.PlatformNotSupportedException, system.NotSupportedException, system.OutOfMemoryException, system.FormatException, system.OverflowException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("RenderPostBackEvent", writer == null ? null : writer.getJCOInstance(), target, argument, softkeyLabel, text, postUrl, accessKey);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public StringCollection getCacheVaryByHeaders() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CacheVaryByHeaders");
            return new StringCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public StringCollection getCacheVaryByParams() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CacheVaryByParams");
            return new StringCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}