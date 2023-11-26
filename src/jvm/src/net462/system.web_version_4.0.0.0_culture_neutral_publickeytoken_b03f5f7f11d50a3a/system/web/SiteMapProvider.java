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

package system.web;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.configuration.provider.ProviderBase;
import system.web.HttpContext;
import system.web.SiteMapNode;
import system.web.SiteMapNodeCollection;
import system.collections.specialized.NameValueCollection;
import system.web.SiteMapProvider;
import system.web.SiteMapResolveEventHandler;


/**
 * The base .NET class managing System.Web.SiteMapProvider, System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Web.SiteMapProvider" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Web.SiteMapProvider</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class SiteMapProvider extends ProviderBase  {
    /**
     * Fully assembly qualified name: System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Web, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Web
     */
    public static final String assemblyShortName = "System.Web";
    /**
     * Qualified class name: System.Web.SiteMapProvider
     */
    public static final String className = "System.Web.SiteMapProvider";
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
    public SiteMapProvider(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link SiteMapProvider}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link SiteMapProvider} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static SiteMapProvider cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new SiteMapProvider(from.getJCOInstance());
    }

    // Constructors section
    
    public SiteMapProvider() throws Throwable {
    }

    
    // Methods section
    
    public boolean IsAccessibleToUser(HttpContext context, SiteMapNode node) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.web.HttpException, system.globalization.CultureNotFoundException, system.web.HttpRequestValidationException, system.configuration.provider.ProviderException, system.configuration.ConfigurationErrorsException, system.security.SecurityException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("IsAccessibleToUser", context == null ? null : context.getJCOInstance(), node == null ? null : node.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode FindSiteMapNode(java.lang.String rawUrl) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objFindSiteMapNode = (JCObject)classInstance.Invoke("FindSiteMapNode", rawUrl);
            return new SiteMapNode(objFindSiteMapNode);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode FindSiteMapNode(HttpContext context) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.NullReferenceException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objFindSiteMapNode = (JCObject)classInstance.Invoke("FindSiteMapNode", context == null ? null : context.getJCOInstance());
            return new SiteMapNode(objFindSiteMapNode);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode FindSiteMapNodeFromKey(java.lang.String key) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objFindSiteMapNodeFromKey = (JCObject)classInstance.Invoke("FindSiteMapNodeFromKey", key);
            return new SiteMapNode(objFindSiteMapNodeFromKey);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode GetCurrentNodeAndHintAncestorNodes(int upLevel) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException, system.NotSupportedException, system.configuration.ConfigurationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetCurrentNodeAndHintAncestorNodes = (JCObject)classInstance.Invoke("GetCurrentNodeAndHintAncestorNodes", upLevel);
            return new SiteMapNode(objGetCurrentNodeAndHintAncestorNodes);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode GetCurrentNodeAndHintNeighborhoodNodes(int upLevel, int downLevel) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.web.HttpException, system.configuration.ConfigurationErrorsException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException, system.NotSupportedException, system.configuration.ConfigurationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetCurrentNodeAndHintNeighborhoodNodes = (JCObject)classInstance.Invoke("GetCurrentNodeAndHintNeighborhoodNodes", upLevel, downLevel);
            return new SiteMapNode(objGetCurrentNodeAndHintNeighborhoodNodes);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode GetParentNode(SiteMapNode node) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetParentNode = (JCObject)classInstance.Invoke("GetParentNode", node == null ? null : node.getJCOInstance());
            return new SiteMapNode(objGetParentNode);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode GetParentNodeRelativeToCurrentNodeAndHintDownFromParent(int walkupLevels, int relativeDepthFromWalkup) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.NotImplementedException, system.ObjectDisposedException, system.InvalidOperationException, system.web.HttpException, system.threading.ThreadAbortException, system.web.HttpRequestValidationException, system.NotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetParentNodeRelativeToCurrentNodeAndHintDownFromParent = (JCObject)classInstance.Invoke("GetParentNodeRelativeToCurrentNodeAndHintDownFromParent", walkupLevels, relativeDepthFromWalkup);
            return new SiteMapNode(objGetParentNodeRelativeToCurrentNodeAndHintDownFromParent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode GetParentNodeRelativeToNodeAndHintDownFromParent(SiteMapNode node, int walkupLevels, int relativeDepthFromWalkup) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetParentNodeRelativeToNodeAndHintDownFromParent = (JCObject)classInstance.Invoke("GetParentNodeRelativeToNodeAndHintDownFromParent", node == null ? null : node.getJCOInstance(), walkupLevels, relativeDepthFromWalkup);
            return new SiteMapNode(objGetParentNodeRelativeToNodeAndHintDownFromParent);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNodeCollection GetChildNodes(SiteMapNode node) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetChildNodes = (JCObject)classInstance.Invoke("GetChildNodes", node == null ? null : node.getJCOInstance());
            return new SiteMapNodeCollection(objGetChildNodes);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void HintAncestorNodes(SiteMapNode node, int upLevel) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("HintAncestorNodes", node == null ? null : node.getJCOInstance(), upLevel);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void HintNeighborhoodNodes(SiteMapNode node, int upLevel, int downLevel) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("HintNeighborhoodNodes", node == null ? null : node.getJCOInstance(), upLevel, downLevel);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Initialize(java.lang.String name, NameValueCollection attributes) throws Throwable, system.ArgumentNullException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotSupportedException, system.configuration.ConfigurationErrorsException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Initialize", name, attributes == null ? null : attributes.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getEnableLocalization() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("EnableLocalization");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEnableLocalization(boolean EnableLocalization) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("EnableLocalization", EnableLocalization);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getSecurityTrimmingEnabled() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("SecurityTrimmingEnabled");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getResourceKey() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ResourceKey");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setResourceKey(java.lang.String ResourceKey) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ResourceKey", ResourceKey);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode getCurrentNode() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.FormatException, system.ArgumentException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.web.HttpException, system.NullReferenceException, system.configuration.ConfigurationErrorsException, system.NotSupportedException, system.configuration.ConfigurationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CurrentNode");
            return new SiteMapNode(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapNode getRootNode() throws Throwable, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.web.HttpException, system.ArgumentException, system.globalization.CultureNotFoundException, system.configuration.ConfigurationErrorsException, system.configuration.ConfigurationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RootNode");
            return new SiteMapNode(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapProvider getParentProvider() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ParentProvider");
            return new SiteMapProvider(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setParentProvider(SiteMapProvider ParentProvider) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ParentProvider", ParentProvider == null ? null : ParentProvider.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SiteMapProvider getRootProvider() throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.FormatException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.threading.AbandonedMutexException, system.configuration.provider.ProviderException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RootProvider");
            return new SiteMapProvider(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

    public void addSiteMapResolve(SiteMapResolveEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.RegisterEventListener("SiteMapResolve", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void removeSiteMapResolve(SiteMapResolveEventHandler handler) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.UnregisterEventListener("SiteMapResolve", handler);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


}