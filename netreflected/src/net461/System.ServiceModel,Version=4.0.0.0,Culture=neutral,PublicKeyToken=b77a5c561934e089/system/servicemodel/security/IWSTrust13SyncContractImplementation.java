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

package system.servicemodel.security;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.servicemodel.channels.Message;


/**
 * The base .NET class managing System.ServiceModel.Security.IWSTrust13SyncContract, System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.Security.IWSTrust13SyncContract" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.Security.IWSTrust13SyncContract</a>
 */
public class IWSTrust13SyncContractImplementation extends NetObject implements IWSTrust13SyncContract {
    /**
     * Fully assembly qualified name: System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.ServiceModel
     */
    public static final String assemblyShortName = "System.ServiceModel";
    /**
     * Qualified class name: System.ServiceModel.Security.IWSTrust13SyncContract
     */
    public static final String className = "System.ServiceModel.Security.IWSTrust13SyncContract";
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

    public IWSTrust13SyncContractImplementation(Object instance) throws Throwable {
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

    public JCType getJCOType() {
        return classType;
    }
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IWSTrust13SyncContract}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IWSTrust13SyncContract} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IWSTrust13SyncContract ToIWSTrust13SyncContract(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new IWSTrust13SyncContractImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public Message ProcessTrust13Cancel(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13Cancel = (JCObject)classInstance.Invoke("ProcessTrust13Cancel", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13Cancel);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13CancelResponse(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13CancelResponse = (JCObject)classInstance.Invoke("ProcessTrust13CancelResponse", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13CancelResponse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13Issue(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13Issue = (JCObject)classInstance.Invoke("ProcessTrust13Issue", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13Issue);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13IssueResponse(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13IssueResponse = (JCObject)classInstance.Invoke("ProcessTrust13IssueResponse", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13IssueResponse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13Renew(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13Renew = (JCObject)classInstance.Invoke("ProcessTrust13Renew", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13Renew);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13RenewResponse(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13RenewResponse = (JCObject)classInstance.Invoke("ProcessTrust13RenewResponse", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13RenewResponse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13Validate(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13Validate = (JCObject)classInstance.Invoke("ProcessTrust13Validate", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13Validate);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Message ProcessTrust13ValidateResponse(Message message) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject objProcessTrust13ValidateResponse = (JCObject)classInstance.Invoke("ProcessTrust13ValidateResponse", message == null ? null : message.getJCOInstance());
            return new Message(objProcessTrust13ValidateResponse);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    


    // Instance Events section
    

}