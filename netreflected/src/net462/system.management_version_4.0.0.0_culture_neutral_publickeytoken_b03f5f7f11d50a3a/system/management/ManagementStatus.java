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

package system.management;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing System.Management.ManagementStatus, System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Management.ManagementStatus" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Management.ManagementStatus</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class ManagementStatus extends NetObject  {
    /**
     * Fully assembly qualified name: System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.Management, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.Management
     */
    public static final String assemblyShortName = "System.Management";
    /**
     * Qualified class name: System.Management.ManagementStatus
     */
    public static final String className = "System.Management.ManagementStatus";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    /**
     * The type managed from JCOBridge. See {@link JCType}
     */
    public static JCType classType = createType();
    static JCEnum enumReflected = createEnum();
    JCEnum classInstance = null;

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

    static JCEnum createEnum() {
        try {
            String enumToCreate = className + ", "
                    + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Creating Enum %s", enumToCreate);
            JCEnum enumCreated = bridge.GetEnum(enumToCreate);
            if (JCOReflector.getDebug())
                JCOReflector.writeLog("Created Enum: %s",
                        (enumCreated != null) ? enumCreated.toString() : "Returned null value");
            return enumCreated;
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
    public ManagementStatus(java.lang.Object instance) {
        super(instance);
        if (instance instanceof JCObject) {
            try {
                String enumName = NetEnum.GetName(classType, (JCObject)instance);
                classInstance = enumReflected.fromValue(enumName);
            } catch (Throwable t) {
                JCOReflector.writeLog(t);
                classInstance = enumReflected;
            }
        } else if (instance instanceof JCEnum) {
            classInstance = (JCEnum)instance;
        }
    }

    public ManagementStatus() {
        super();
        // add reference to assemblyName.dll file
        try {
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
        } catch (Throwable jcne) {
            JCOReflector.writeLog(jcne);
        }
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

    final static ManagementStatus getFrom(JCEnum object, String value) {
        try {
            return new ManagementStatus(object.fromValue(value));
        } catch (JCException e) {
            return new ManagementStatus(object);
        }
    }

    // Enum fields section
    
    public static ManagementStatus NoError = getFrom(enumReflected, "NoError");
    public static ManagementStatus False = getFrom(enumReflected, "False");
    public static ManagementStatus ResetToDefault = getFrom(enumReflected, "ResetToDefault");
    public static ManagementStatus Different = getFrom(enumReflected, "Different");
    public static ManagementStatus Timedout = getFrom(enumReflected, "Timedout");
    public static ManagementStatus NoMoreData = getFrom(enumReflected, "NoMoreData");
    public static ManagementStatus OperationCanceled = getFrom(enumReflected, "OperationCanceled");
    public static ManagementStatus Pending = getFrom(enumReflected, "Pending");
    public static ManagementStatus DuplicateObjects = getFrom(enumReflected, "DuplicateObjects");
    public static ManagementStatus PartialResults = getFrom(enumReflected, "PartialResults");
    public static ManagementStatus Failed = getFrom(enumReflected, "Failed");
    public static ManagementStatus NotFound = getFrom(enumReflected, "NotFound");
    public static ManagementStatus AccessDenied = getFrom(enumReflected, "AccessDenied");
    public static ManagementStatus ProviderFailure = getFrom(enumReflected, "ProviderFailure");
    public static ManagementStatus TypeMismatch = getFrom(enumReflected, "TypeMismatch");
    public static ManagementStatus OutOfMemory = getFrom(enumReflected, "OutOfMemory");
    public static ManagementStatus InvalidContext = getFrom(enumReflected, "InvalidContext");
    public static ManagementStatus InvalidParameter = getFrom(enumReflected, "InvalidParameter");
    public static ManagementStatus NotAvailable = getFrom(enumReflected, "NotAvailable");
    public static ManagementStatus CriticalError = getFrom(enumReflected, "CriticalError");
    public static ManagementStatus InvalidStream = getFrom(enumReflected, "InvalidStream");
    public static ManagementStatus NotSupported = getFrom(enumReflected, "NotSupported");
    public static ManagementStatus InvalidSuperclass = getFrom(enumReflected, "InvalidSuperclass");
    public static ManagementStatus InvalidNamespace = getFrom(enumReflected, "InvalidNamespace");
    public static ManagementStatus InvalidObject = getFrom(enumReflected, "InvalidObject");
    public static ManagementStatus InvalidClass = getFrom(enumReflected, "InvalidClass");
    public static ManagementStatus ProviderNotFound = getFrom(enumReflected, "ProviderNotFound");
    public static ManagementStatus InvalidProviderRegistration = getFrom(enumReflected, "InvalidProviderRegistration");
    public static ManagementStatus ProviderLoadFailure = getFrom(enumReflected, "ProviderLoadFailure");
    public static ManagementStatus InitializationFailure = getFrom(enumReflected, "InitializationFailure");
    public static ManagementStatus TransportFailure = getFrom(enumReflected, "TransportFailure");
    public static ManagementStatus InvalidOperation = getFrom(enumReflected, "InvalidOperation");
    public static ManagementStatus InvalidQuery = getFrom(enumReflected, "InvalidQuery");
    public static ManagementStatus InvalidQueryType = getFrom(enumReflected, "InvalidQueryType");
    public static ManagementStatus AlreadyExists = getFrom(enumReflected, "AlreadyExists");
    public static ManagementStatus OverrideNotAllowed = getFrom(enumReflected, "OverrideNotAllowed");
    public static ManagementStatus PropagatedQualifier = getFrom(enumReflected, "PropagatedQualifier");
    public static ManagementStatus PropagatedProperty = getFrom(enumReflected, "PropagatedProperty");
    public static ManagementStatus Unexpected = getFrom(enumReflected, "Unexpected");
    public static ManagementStatus IllegalOperation = getFrom(enumReflected, "IllegalOperation");
    public static ManagementStatus CannotBeKey = getFrom(enumReflected, "CannotBeKey");
    public static ManagementStatus IncompleteClass = getFrom(enumReflected, "IncompleteClass");
    public static ManagementStatus InvalidSyntax = getFrom(enumReflected, "InvalidSyntax");
    public static ManagementStatus NondecoratedObject = getFrom(enumReflected, "NondecoratedObject");
    public static ManagementStatus ReadOnly = getFrom(enumReflected, "ReadOnly");
    public static ManagementStatus ProviderNotCapable = getFrom(enumReflected, "ProviderNotCapable");
    public static ManagementStatus ClassHasChildren = getFrom(enumReflected, "ClassHasChildren");
    public static ManagementStatus ClassHasInstances = getFrom(enumReflected, "ClassHasInstances");
    public static ManagementStatus QueryNotImplemented = getFrom(enumReflected, "QueryNotImplemented");
    public static ManagementStatus IllegalNull = getFrom(enumReflected, "IllegalNull");
    public static ManagementStatus InvalidQualifierType = getFrom(enumReflected, "InvalidQualifierType");
    public static ManagementStatus InvalidPropertyType = getFrom(enumReflected, "InvalidPropertyType");
    public static ManagementStatus ValueOutOfRange = getFrom(enumReflected, "ValueOutOfRange");
    public static ManagementStatus CannotBeSingleton = getFrom(enumReflected, "CannotBeSingleton");
    public static ManagementStatus InvalidCimType = getFrom(enumReflected, "InvalidCimType");
    public static ManagementStatus InvalidMethod = getFrom(enumReflected, "InvalidMethod");
    public static ManagementStatus InvalidMethodParameters = getFrom(enumReflected, "InvalidMethodParameters");
    public static ManagementStatus SystemProperty = getFrom(enumReflected, "SystemProperty");
    public static ManagementStatus InvalidProperty = getFrom(enumReflected, "InvalidProperty");
    public static ManagementStatus CallCanceled = getFrom(enumReflected, "CallCanceled");
    public static ManagementStatus ShuttingDown = getFrom(enumReflected, "ShuttingDown");
    public static ManagementStatus PropagatedMethod = getFrom(enumReflected, "PropagatedMethod");
    public static ManagementStatus UnsupportedParameter = getFrom(enumReflected, "UnsupportedParameter");
    public static ManagementStatus MissingParameterID = getFrom(enumReflected, "MissingParameterID");
    public static ManagementStatus InvalidParameterID = getFrom(enumReflected, "InvalidParameterID");
    public static ManagementStatus NonconsecutiveParameterIDs = getFrom(enumReflected, "NonconsecutiveParameterIDs");
    public static ManagementStatus ParameterIDOnRetval = getFrom(enumReflected, "ParameterIDOnRetval");
    public static ManagementStatus InvalidObjectPath = getFrom(enumReflected, "InvalidObjectPath");
    public static ManagementStatus OutOfDiskSpace = getFrom(enumReflected, "OutOfDiskSpace");
    public static ManagementStatus BufferTooSmall = getFrom(enumReflected, "BufferTooSmall");
    public static ManagementStatus UnsupportedPutExtension = getFrom(enumReflected, "UnsupportedPutExtension");
    public static ManagementStatus UnknownObjectType = getFrom(enumReflected, "UnknownObjectType");
    public static ManagementStatus UnknownPacketType = getFrom(enumReflected, "UnknownPacketType");
    public static ManagementStatus MarshalVersionMismatch = getFrom(enumReflected, "MarshalVersionMismatch");
    public static ManagementStatus MarshalInvalidSignature = getFrom(enumReflected, "MarshalInvalidSignature");
    public static ManagementStatus InvalidQualifier = getFrom(enumReflected, "InvalidQualifier");
    public static ManagementStatus InvalidDuplicateParameter = getFrom(enumReflected, "InvalidDuplicateParameter");
    public static ManagementStatus TooMuchData = getFrom(enumReflected, "TooMuchData");
    public static ManagementStatus ServerTooBusy = getFrom(enumReflected, "ServerTooBusy");
    public static ManagementStatus InvalidFlavor = getFrom(enumReflected, "InvalidFlavor");
    public static ManagementStatus CircularReference = getFrom(enumReflected, "CircularReference");
    public static ManagementStatus UnsupportedClassUpdate = getFrom(enumReflected, "UnsupportedClassUpdate");
    public static ManagementStatus CannotChangeKeyInheritance = getFrom(enumReflected, "CannotChangeKeyInheritance");
    public static ManagementStatus CannotChangeIndexInheritance = getFrom(enumReflected, "CannotChangeIndexInheritance");
    public static ManagementStatus TooManyProperties = getFrom(enumReflected, "TooManyProperties");
    public static ManagementStatus UpdateTypeMismatch = getFrom(enumReflected, "UpdateTypeMismatch");
    public static ManagementStatus UpdateOverrideNotAllowed = getFrom(enumReflected, "UpdateOverrideNotAllowed");
    public static ManagementStatus UpdatePropagatedMethod = getFrom(enumReflected, "UpdatePropagatedMethod");
    public static ManagementStatus MethodNotImplemented = getFrom(enumReflected, "MethodNotImplemented");
    public static ManagementStatus MethodDisabled = getFrom(enumReflected, "MethodDisabled");
    public static ManagementStatus RefresherBusy = getFrom(enumReflected, "RefresherBusy");
    public static ManagementStatus UnparsableQuery = getFrom(enumReflected, "UnparsableQuery");
    public static ManagementStatus NotEventClass = getFrom(enumReflected, "NotEventClass");
    public static ManagementStatus MissingGroupWithin = getFrom(enumReflected, "MissingGroupWithin");
    public static ManagementStatus MissingAggregationList = getFrom(enumReflected, "MissingAggregationList");
    public static ManagementStatus PropertyNotAnObject = getFrom(enumReflected, "PropertyNotAnObject");
    public static ManagementStatus AggregatingByObject = getFrom(enumReflected, "AggregatingByObject");
    public static ManagementStatus UninterpretableProviderQuery = getFrom(enumReflected, "UninterpretableProviderQuery");
    public static ManagementStatus BackupRestoreWinmgmtRunning = getFrom(enumReflected, "BackupRestoreWinmgmtRunning");
    public static ManagementStatus QueueOverflow = getFrom(enumReflected, "QueueOverflow");
    public static ManagementStatus PrivilegeNotHeld = getFrom(enumReflected, "PrivilegeNotHeld");
    public static ManagementStatus InvalidOperator = getFrom(enumReflected, "InvalidOperator");
    public static ManagementStatus LocalCredentials = getFrom(enumReflected, "LocalCredentials");
    public static ManagementStatus CannotBeAbstract = getFrom(enumReflected, "CannotBeAbstract");
    public static ManagementStatus AmendedObject = getFrom(enumReflected, "AmendedObject");
    public static ManagementStatus ClientTooSlow = getFrom(enumReflected, "ClientTooSlow");
    public static ManagementStatus RegistrationTooBroad = getFrom(enumReflected, "RegistrationTooBroad");
    public static ManagementStatus RegistrationTooPrecise = getFrom(enumReflected, "RegistrationTooPrecise");


    // Flags management section


}