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

package system.componentmodel.design.data;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.codedom.CodeExpression;
import system.componentmodel.design.data.DesignerDataConnection;
import system.windows.forms.IWin32Window;
import system.windows.forms.IWin32WindowImplementation;
import system.componentmodel.design.data.IDesignerDataSchema;
import system.componentmodel.design.data.IDesignerDataSchemaImplementation;
import system.data.common.DbConnection;
import system.componentmodel.design.data.QueryBuilderMode;
import system.collections.ICollection;
import system.collections.ICollectionImplementation;


/**
 * The base .NET class managing System.ComponentModel.Design.Data.IDataEnvironment, System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.Design.Data.IDataEnvironment" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.Design.Data.IDataEnvironment</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class IDataEnvironmentImplementation extends NetObject implements IDataEnvironment {
    /**
     * Fully assembly qualified name: System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Design, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Design
     */
    public static final String assemblyShortName = "System.Design";
    /**
     * Qualified class name: System.ComponentModel.Design.Data.IDataEnvironment
     */
    public static final String className = "System.ComponentModel.Design.Data.IDataEnvironment";
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
    public IDataEnvironmentImplementation(java.lang.Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IDataEnvironment}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IDataEnvironment} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IDataEnvironment ToIDataEnvironment(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IDataEnvironmentImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public CodeExpression GetCodeExpression(DesignerDataConnection connection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetCodeExpression = (JCObject)classInstance.Invoke("GetCodeExpression", connection == null ? null : connection.getJCOInstance());
            return new CodeExpression(objGetCodeExpression);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DesignerDataConnection BuildConnection(IWin32Window owner, DesignerDataConnection initialConnection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objBuildConnection = (JCObject)classInstance.Invoke("BuildConnection", owner == null ? null : owner.getJCOInstance(), initialConnection == null ? null : initialConnection.getJCOInstance());
            return new DesignerDataConnection(objBuildConnection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DesignerDataConnection ConfigureConnection(IWin32Window owner, DesignerDataConnection connection, java.lang.String name) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objConfigureConnection = (JCObject)classInstance.Invoke("ConfigureConnection", owner == null ? null : owner.getJCOInstance(), connection == null ? null : connection.getJCOInstance(), name);
            return new DesignerDataConnection(objConfigureConnection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IDesignerDataSchema GetConnectionSchema(DesignerDataConnection connection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetConnectionSchema = (JCObject)classInstance.Invoke("GetConnectionSchema", connection == null ? null : connection.getJCOInstance());
            return new IDesignerDataSchemaImplementation(objGetConnectionSchema);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public DbConnection GetDesignTimeConnection(DesignerDataConnection connection) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objGetDesignTimeConnection = (JCObject)classInstance.Invoke("GetDesignTimeConnection", connection == null ? null : connection.getJCOInstance());
            return new DbConnection(objGetDesignTimeConnection);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String BuildQuery(IWin32Window owner, DesignerDataConnection connection, QueryBuilderMode mode, java.lang.String initialQueryText) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("BuildQuery", owner == null ? null : owner.getJCOInstance(), connection == null ? null : connection.getJCOInstance(), mode == null ? null : mode.getJCOInstance(), initialQueryText);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public ICollection getConnections() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Connections");
            return new ICollectionImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}