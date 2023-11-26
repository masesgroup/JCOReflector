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

package system.identitymodel.protocols.wstrust;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.identitymodel.protocols.wstrust.WSTrustMessage;
import system.identitymodel.protocols.wstrust.AdditionalContext;
import system.identitymodel.protocols.wstrust.EndpointReference;
import system.identitymodel.protocols.wstrust.Participants;
import system.identitymodel.protocols.wstrust.Renewing;
import system.identitymodel.protocols.wstrust.RequestClaimCollection;
import system.identitymodel.protocols.wstrust.RequestSecurityToken;
import system.identitymodel.tokens.SecurityTokenElement;


/**
 * The base .NET class managing System.IdentityModel.Protocols.WSTrust.RequestSecurityToken, System.IdentityModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.IdentityModel.Protocols.WSTrust.RequestSecurityToken" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.IdentityModel.Protocols.WSTrust.RequestSecurityToken</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class RequestSecurityToken extends WSTrustMessage  {
    /**
     * Fully assembly qualified name: System.IdentityModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.IdentityModel, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.IdentityModel
     */
    public static final String assemblyShortName = "System.IdentityModel";
    /**
     * Qualified class name: System.IdentityModel.Protocols.WSTrust.RequestSecurityToken
     */
    public static final String className = "System.IdentityModel.Protocols.WSTrust.RequestSecurityToken";
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
    public RequestSecurityToken(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link RequestSecurityToken}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link RequestSecurityToken} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static RequestSecurityToken cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new RequestSecurityToken(from.getJCOInstance());
    }

    // Constructors section
    
    public RequestSecurityToken() throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.FormatException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RequestSecurityToken(java.lang.String requestType) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.FormatException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(requestType));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RequestSecurityToken(java.lang.String requestType, java.lang.String keyType) throws Throwable, system.ArgumentOutOfRangeException, system.ArgumentException, system.IndexOutOfRangeException, system.ArgumentNullException, system.NotImplementedException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.OverflowException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(requestType, keyType));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Methods section
    

    
    // Properties section
    
    public AdditionalContext getAdditionalContext() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("AdditionalContext");
            return new AdditionalContext(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setAdditionalContext(AdditionalContext AdditionalContext) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("AdditionalContext", AdditionalContext == null ? null : AdditionalContext.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public EndpointReference getIssuer() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Issuer");
            return new EndpointReference(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIssuer(EndpointReference Issuer) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Issuer", Issuer == null ? null : Issuer.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Participants getParticipants() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Participants");
            return new Participants(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setParticipants(Participants Participants) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Participants", Participants == null ? null : Participants.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Renewing getRenewing() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Renewing");
            return new Renewing(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRenewing(Renewing Renewing) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Renewing", Renewing == null ? null : Renewing.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RequestClaimCollection getClaims() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Claims");
            return new RequestClaimCollection(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public RequestSecurityToken getSecondaryParameters() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("SecondaryParameters");
            return new RequestSecurityToken(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setSecondaryParameters(RequestSecurityToken SecondaryParameters) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("SecondaryParameters", SecondaryParameters == null ? null : SecondaryParameters.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getActAs() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ActAs");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setActAs(SecurityTokenElement ActAs) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ActAs", ActAs == null ? null : ActAs.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getCancelTarget() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("CancelTarget");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCancelTarget(SecurityTokenElement CancelTarget) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("CancelTarget", CancelTarget == null ? null : CancelTarget.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getDelegateTo() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("DelegateTo");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setDelegateTo(SecurityTokenElement DelegateTo) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("DelegateTo", DelegateTo == null ? null : DelegateTo.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getEncryption() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Encryption");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setEncryption(SecurityTokenElement Encryption) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Encryption", Encryption == null ? null : Encryption.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getOnBehalfOf() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("OnBehalfOf");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setOnBehalfOf(SecurityTokenElement OnBehalfOf) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("OnBehalfOf", OnBehalfOf == null ? null : OnBehalfOf.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getProofEncryption() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ProofEncryption");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setProofEncryption(SecurityTokenElement ProofEncryption) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ProofEncryption", ProofEncryption == null ? null : ProofEncryption.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getRenewTarget() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("RenewTarget");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setRenewTarget(SecurityTokenElement RenewTarget) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("RenewTarget", RenewTarget == null ? null : RenewTarget.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public SecurityTokenElement getValidateTarget() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ValidateTarget");
            return new SecurityTokenElement(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setValidateTarget(SecurityTokenElement ValidateTarget) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ValidateTarget", ValidateTarget == null ? null : ValidateTarget.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public java.lang.String getComputedKeyAlgorithm() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Get("ComputedKeyAlgorithm");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setComputedKeyAlgorithm(java.lang.String ComputedKeyAlgorithm) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("ComputedKeyAlgorithm", ComputedKeyAlgorithm);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}