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

package system.activities.xamlintegration;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.activities.Activity;
import system.io.Stream;
import system.activities.xamlintegration.ActivityXamlServicesSettings;
import system.io.TextReader;
import system.xml.XmlReader;
import system.xaml.XamlWriter;


/**
 * The base .NET class managing System.Activities.XamlIntegration.ActivityXamlServices, System.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Activities.XamlIntegration.ActivityXamlServices" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Activities.XamlIntegration.ActivityXamlServices</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class ActivityXamlServices extends NetObject  {
    /**
     * Fully assembly qualified name: System.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Activities, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Activities
     */
    public static final String assemblyShortName = "System.Activities";
    /**
     * Qualified class name: System.Activities.XamlIntegration.ActivityXamlServices
     */
    public static final String className = "System.Activities.XamlIntegration.ActivityXamlServices";
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
    public ActivityXamlServices(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ActivityXamlServices}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ActivityXamlServices} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ActivityXamlServices cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ActivityXamlServices(from.getJCOInstance());
    }

    // Constructors section
    
    public ActivityXamlServices() throws Throwable {
    }

    
    // Methods section
    
    public static Activity Load(Stream stream) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.FormatException, system.xaml.XamlSchemaException, system.collections.generic.KeyNotFoundException, system.xaml.XamlException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", stream == null ? null : stream.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(Stream stream, ActivityXamlServicesSettings settings) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.FormatException, system.xml.schema.XmlSchemaException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.xaml.XamlSchemaException, system.xaml.XamlException, system.io.EndOfStreamException, system.configuration.ConfigurationErrorsException, system.MissingMethodException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", stream == null ? null : stream.getJCOInstance(), settings == null ? null : settings.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(TextReader textReader) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.FormatException, system.xaml.XamlSchemaException, system.collections.generic.KeyNotFoundException, system.xaml.XamlException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", textReader == null ? null : textReader.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(TextReader textReader, ActivityXamlServicesSettings settings) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.FormatException, system.xml.schema.XmlSchemaException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.xaml.XamlSchemaException, system.xaml.XamlException, system.io.EndOfStreamException, system.configuration.ConfigurationErrorsException, system.MissingMethodException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", textReader == null ? null : textReader.getJCOInstance(), settings == null ? null : settings.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(java.lang.String fileName) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.AggregateException, system.FormatException, system.xaml.XamlSchemaException, system.collections.generic.KeyNotFoundException, system.xaml.XamlException, system.configuration.ConfigurationErrorsException, system.OutOfMemoryException, system.MissingMethodException, system.reflection.TargetInvocationException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", fileName);
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(java.lang.String fileName, ActivityXamlServicesSettings settings) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.threading.tasks.TaskSchedulerException, system.OperationCanceledException, system.AggregateException, system.FormatException, system.xml.schema.XmlSchemaException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.xaml.XamlSchemaException, system.xaml.XamlException, system.io.EndOfStreamException, system.configuration.ConfigurationErrorsException, system.MissingMethodException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", fileName, settings == null ? null : settings.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(XmlReader xmlReader) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.NotImplementedException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.xaml.XamlSchemaException, system.xml.XmlException, system.UriFormatException, system.xaml.XamlException, system.io.EndOfStreamException, system.NotSupportedException, system.configuration.ConfigurationErrorsException, system.MissingMethodException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", xmlReader == null ? null : xmlReader.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static Activity Load(XmlReader xmlReader, ActivityXamlServicesSettings settings) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.NotSupportedException, system.NotImplementedException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.xaml.XamlSchemaException, system.xml.XmlException, system.security.SecurityException, system.UriFormatException, system.threading.ThreadAbortException, system.xaml.XamlException, system.FormatException, system.io.EndOfStreamException, system.io.IOException, system.OverflowException, system.configuration.ConfigurationErrorsException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objLoad = (JCObject)classType.Invoke("Load", xmlReader == null ? null : xmlReader.getJCOInstance(), settings == null ? null : settings.getJCOInstance());
            return new Activity(objLoad);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static XamlWriter CreateBuilderWriter(XamlWriter innerWriter) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            JCObject objCreateBuilderWriter = (JCObject)classType.Invoke("CreateBuilderWriter", innerWriter == null ? null : innerWriter.getJCOInstance());
            return new XamlWriter(objCreateBuilderWriter);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static void InitializeComponent(NetType componentType, NetObject componentInstance) throws Throwable, system.IndexOutOfRangeException, system.ArgumentException, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.InvalidOperationException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.NullReferenceException, system.security.SecurityException, system.NotSupportedException, system.UnauthorizedAccessException, system.io.IOException, system.xml.XmlException, system.FormatException, system.collections.generic.KeyNotFoundException, system.OutOfMemoryException, system.xaml.XamlSchemaException, system.xaml.XamlException {
        if (classType == null)
            throw new UnsupportedOperationException("classType is null.");
        try {
            classType.Invoke("InitializeComponent", componentType == null ? null : componentType.getJCOInstance(), componentInstance == null ? null : componentInstance.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}