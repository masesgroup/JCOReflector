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

package system.servicemodel.security;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.servicemodel.security.IWSTrustContract;
import system.servicemodel.security.IWSTrustContractImplementation;
import system.IAsyncResult;
import system.IAsyncResultImplementation;
import system.identitymodel.protocols.wstrust.RequestSecurityToken;
import system.AsyncCallback;
import system.servicemodel.channels.Message;
import system.identitymodel.protocols.wstrust.RequestSecurityTokenResponse;
import system.identitymodel.tokens.SecurityToken;


/**
 * The base .NET class managing System.ServiceModel.Security.IWSTrustChannelContract, System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.Security.IWSTrustChannelContract" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ServiceModel.Security.IWSTrustChannelContract</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public interface IWSTrustChannelContract extends IJCOBridgeReflected, IWSTrustContract {
    /**
     * Fully assembly qualified name: System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.ServiceModel
     */
    public static final String assemblyShortName = "System.ServiceModel";
    /**
     * Qualified class name: System.ServiceModel.Security.IWSTrustChannelContract
     */
    public static final String className = "System.ServiceModel.Security.IWSTrustChannelContract";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IWSTrustChannelContract}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IWSTrustChannelContract} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IWSTrustChannelContract ToIWSTrustChannelContract(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.ServiceModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IWSTrustChannelContractImplementation(from.getJCOInstance());
    }

    /**
     * Returns the reflected Assembly name
     * 
     * @return A {@link String} representing the Fullname of reflected Assembly
     */
    public String getJCOAssemblyName();

    /**
     * Returns the reflected Class name
     * 
     * @return A {@link String} representing the Fullname of reflected Class
     */
    public String getJCOClassName();

    /**
     * Returns the reflected Class name used to build the object
     * 
     * @return A {@link String} representing the name used to allocated the object
     *         in CLR context
     */
    public String getJCOObjectName();

    /**
     * Returns the instantiated class
     * 
     * @return An {@link java.lang.Object} representing the instance of the instantiated Class
     */
    public java.lang.Object getJCOInstance();

    /**
     * Returns the instantiated class Type
     * 
     * @return A {@link JCType} representing the Type of the instantiated Class
     */
    public JCType getJCOType();

    // Methods section
    
    public IAsyncResult BeginCancel(RequestSecurityToken request, AsyncCallback callback, NetObject state) throws Throwable;


    public IAsyncResult BeginIssue(RequestSecurityToken request, AsyncCallback callback, NetObject asyncState) throws Throwable;


    public IAsyncResult BeginRenew(RequestSecurityToken request, AsyncCallback callback, NetObject state) throws Throwable;


    public IAsyncResult BeginValidate(RequestSecurityToken request, AsyncCallback callback, NetObject state) throws Throwable;


    public RequestSecurityTokenResponse Cancel(RequestSecurityToken request) throws Throwable;

    public RequestSecurityTokenResponse Renew(RequestSecurityToken request) throws Throwable;

    public RequestSecurityTokenResponse Validate(RequestSecurityToken request) throws Throwable;

    public SecurityToken EndIssue(IAsyncResult result, JCORefOut<RequestSecurityTokenResponse> response) throws Throwable;

    public SecurityToken Issue(RequestSecurityToken request) throws Throwable;

    public SecurityToken Issue(RequestSecurityToken request, JCORefOut<RequestSecurityTokenResponse> response) throws Throwable;









    public void EndCancel(IAsyncResult result, JCORefOut<RequestSecurityTokenResponse> response) throws Throwable;

    public void EndRenew(IAsyncResult result, JCORefOut<RequestSecurityTokenResponse> response) throws Throwable;

    public void EndValidate(IAsyncResult result, JCORefOut<RequestSecurityTokenResponse> response) throws Throwable;


    
    // Properties section
    


    // Instance Events section
    

}