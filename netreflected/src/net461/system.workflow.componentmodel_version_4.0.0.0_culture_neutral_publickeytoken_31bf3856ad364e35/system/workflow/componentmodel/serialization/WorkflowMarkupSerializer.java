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

package system.workflow.componentmodel.serialization;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.design.serialization.IDesignerSerializationManager;
import system.componentmodel.design.serialization.IDesignerSerializationManagerImplementation;
import system.xml.XmlReader;
import system.xml.XmlWriter;


/**
 * The base .NET class managing System.Workflow.ComponentModel.Serialization.WorkflowMarkupSerializer, System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.ComponentModel.Serialization.WorkflowMarkupSerializer" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Workflow.ComponentModel.Serialization.WorkflowMarkupSerializer</a>
 */
public class WorkflowMarkupSerializer extends NetObject  {
    /**
     * Fully assembly qualified name: System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "System.Workflow.ComponentModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: System.Workflow.ComponentModel
     */
    public static final String assemblyShortName = "System.Workflow.ComponentModel";
    /**
     * Qualified class name: System.Workflow.ComponentModel.Serialization.WorkflowMarkupSerializer
     */
    public static final String className = "System.Workflow.ComponentModel.Serialization.WorkflowMarkupSerializer";
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

    public WorkflowMarkupSerializer(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link WorkflowMarkupSerializer}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link WorkflowMarkupSerializer} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static WorkflowMarkupSerializer cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new WorkflowMarkupSerializer(from.getJCOInstance());
    }

    // Constructors section
    
    public WorkflowMarkupSerializer() throws Throwable {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    
    public NetObject Deserialize(IDesignerSerializationManager serializationManager, XmlReader reader) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.configuration.ConfigurationErrorsException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.NotSupportedException, system.MissingMethodException, system.reflection.TargetInvocationException, system.OverflowException, system.FormatException, system.NotImplementedException, system.security.SecurityException, system.NullReferenceException, system.TypeInitializationException, system.InvalidCastException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException, system.reflection.AmbiguousMatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDeserialize = (JCObject)classInstance.Invoke("Deserialize", serializationManager == null ? null : serializationManager.getJCOInstance(), reader == null ? null : reader.getJCOInstance());
            return new NetObject(objDeserialize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject Deserialize(XmlReader reader) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.configuration.ConfigurationErrorsException, system.FormatException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.NotSupportedException, system.NullReferenceException, system.InvalidCastException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException, system.reflection.AmbiguousMatchException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objDeserialize = (JCObject)classInstance.Invoke("Deserialize", reader == null ? null : reader.getJCOInstance());
            return new NetObject(objDeserialize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Serialize(IDesignerSerializationManager serializationManager, XmlWriter writer, NetObject obj) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.FormatException, system.IndexOutOfRangeException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.xml.XmlException, system.io.PathTooLongException, system.globalization.CultureNotFoundException, system.NotSupportedException, system.NullReferenceException, system.security.SecurityException, system.io.IOException, system.NotImplementedException, system.OutOfMemoryException, system.configuration.ConfigurationErrorsException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException, system.OverflowException, system.reflection.AmbiguousMatchException, system.MulticastNotSupportedException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Serialize", serializationManager == null ? null : serializationManager.getJCOInstance(), writer == null ? null : writer.getJCOInstance(), obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Serialize(XmlWriter writer, NetObject obj) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.InvalidOperationException, system.MissingMethodException, system.reflection.TargetInvocationException, system.NotImplementedException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.xml.XmlException, system.NotSupportedException, system.NullReferenceException, system.io.FileNotFoundException, system.io.DirectoryNotFoundException, system.UnauthorizedAccessException, system.io.IOException, system.io.PathTooLongException, system.io.DriveNotFoundException, system.OperationCanceledException, system.security.SecurityException, system.OutOfMemoryException, system.configuration.ConfigurationErrorsException, system.workflow.componentmodel.serialization.WorkflowMarkupSerializationException, system.OverflowException, system.FormatException, system.IndexOutOfRangeException, system.reflection.AmbiguousMatchException, system.MulticastNotSupportedException, system.InvalidCastException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Serialize", writer == null ? null : writer.getJCOInstance(), obj == null ? null : obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}