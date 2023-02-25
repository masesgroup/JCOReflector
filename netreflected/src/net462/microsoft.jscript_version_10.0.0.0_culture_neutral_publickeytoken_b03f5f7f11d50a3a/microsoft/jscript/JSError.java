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

package microsoft.jscript;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
// PACKAGE_IMPORT_SECTION

/**
 * The base .NET class managing Microsoft.JScript.JSError, Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.JSError" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.JScript.JSError</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 */
public class JSError extends NetObject  {
    /**
     * Fully assembly qualified name: Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.JScript, Version=10.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.JScript
     */
    public static final String assemblyShortName = "Microsoft.JScript";
    /**
     * Qualified class name: Microsoft.JScript.JSError
     */
    public static final String className = "Microsoft.JScript.JSError";
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
    public JSError(java.lang.Object instance) {
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

    public JSError() {
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

    final static JSError getFrom(JCEnum object, String value) {
        try {
            return new JSError(object.fromValue(value));
        } catch (JCException e) {
            return new JSError(object);
        }
    }

    // Enum fields section
    
    public static JSError NoError = getFrom(enumReflected, "NoError");
    public static JSError InvalidCall = getFrom(enumReflected, "InvalidCall");
    public static JSError OutOfMemory = getFrom(enumReflected, "OutOfMemory");
    public static JSError TypeMismatch = getFrom(enumReflected, "TypeMismatch");
    public static JSError OutOfStack = getFrom(enumReflected, "OutOfStack");
    public static JSError InternalError = getFrom(enumReflected, "InternalError");
    public static JSError FileNotFound = getFrom(enumReflected, "FileNotFound");
    public static JSError NeedObject = getFrom(enumReflected, "NeedObject");
    public static JSError CantCreateObject = getFrom(enumReflected, "CantCreateObject");
    public static JSError OLENoPropOrMethod = getFrom(enumReflected, "OLENoPropOrMethod");
    public static JSError ActionNotSupported = getFrom(enumReflected, "ActionNotSupported");
    public static JSError NotCollection = getFrom(enumReflected, "NotCollection");
    public static JSError SyntaxError = getFrom(enumReflected, "SyntaxError");
    public static JSError NoColon = getFrom(enumReflected, "NoColon");
    public static JSError NoSemicolon = getFrom(enumReflected, "NoSemicolon");
    public static JSError NoLeftParen = getFrom(enumReflected, "NoLeftParen");
    public static JSError NoRightParen = getFrom(enumReflected, "NoRightParen");
    public static JSError NoRightBracket = getFrom(enumReflected, "NoRightBracket");
    public static JSError NoLeftCurly = getFrom(enumReflected, "NoLeftCurly");
    public static JSError NoRightCurly = getFrom(enumReflected, "NoRightCurly");
    public static JSError NoIdentifier = getFrom(enumReflected, "NoIdentifier");
    public static JSError NoEqual = getFrom(enumReflected, "NoEqual");
    public static JSError IllegalChar = getFrom(enumReflected, "IllegalChar");
    public static JSError UnterminatedString = getFrom(enumReflected, "UnterminatedString");
    public static JSError NoCommentEnd = getFrom(enumReflected, "NoCommentEnd");
    public static JSError BadReturn = getFrom(enumReflected, "BadReturn");
    public static JSError BadBreak = getFrom(enumReflected, "BadBreak");
    public static JSError BadContinue = getFrom(enumReflected, "BadContinue");
    public static JSError BadHexDigit = getFrom(enumReflected, "BadHexDigit");
    public static JSError NoWhile = getFrom(enumReflected, "NoWhile");
    public static JSError BadLabel = getFrom(enumReflected, "BadLabel");
    public static JSError NoLabel = getFrom(enumReflected, "NoLabel");
    public static JSError DupDefault = getFrom(enumReflected, "DupDefault");
    public static JSError NoMemberIdentifier = getFrom(enumReflected, "NoMemberIdentifier");
    public static JSError NoCcEnd = getFrom(enumReflected, "NoCcEnd");
    public static JSError CcOff = getFrom(enumReflected, "CcOff");
    public static JSError NotConst = getFrom(enumReflected, "NotConst");
    public static JSError NoAt = getFrom(enumReflected, "NoAt");
    public static JSError NoCatch = getFrom(enumReflected, "NoCatch");
    public static JSError InvalidElse = getFrom(enumReflected, "InvalidElse");
    public static JSError NoComma = getFrom(enumReflected, "NoComma");
    public static JSError DupVisibility = getFrom(enumReflected, "DupVisibility");
    public static JSError IllegalVisibility = getFrom(enumReflected, "IllegalVisibility");
    public static JSError BadSwitch = getFrom(enumReflected, "BadSwitch");
    public static JSError CcInvalidEnd = getFrom(enumReflected, "CcInvalidEnd");
    public static JSError CcInvalidElse = getFrom(enumReflected, "CcInvalidElse");
    public static JSError CcInvalidElif = getFrom(enumReflected, "CcInvalidElif");
    public static JSError ErrEOF = getFrom(enumReflected, "ErrEOF");
    public static JSError IncompatibleVisibility = getFrom(enumReflected, "IncompatibleVisibility");
    public static JSError ClassNotAllowed = getFrom(enumReflected, "ClassNotAllowed");
    public static JSError NeedCompileTimeConstant = getFrom(enumReflected, "NeedCompileTimeConstant");
    public static JSError DuplicateName = getFrom(enumReflected, "DuplicateName");
    public static JSError NeedType = getFrom(enumReflected, "NeedType");
    public static JSError NotInsideClass = getFrom(enumReflected, "NotInsideClass");
    public static JSError InvalidPositionDirective = getFrom(enumReflected, "InvalidPositionDirective");
    public static JSError MustBeEOL = getFrom(enumReflected, "MustBeEOL");
    public static JSError WrongDirective = getFrom(enumReflected, "WrongDirective");
    public static JSError CannotNestPositionDirective = getFrom(enumReflected, "CannotNestPositionDirective");
    public static JSError CircularDefinition = getFrom(enumReflected, "CircularDefinition");
    public static JSError Deprecated = getFrom(enumReflected, "Deprecated");
    public static JSError IllegalUseOfThis = getFrom(enumReflected, "IllegalUseOfThis");
    public static JSError NotAccessible = getFrom(enumReflected, "NotAccessible");
    public static JSError CannotUseNameOfClass = getFrom(enumReflected, "CannotUseNameOfClass");
    public static JSError MustImplementMethod = getFrom(enumReflected, "MustImplementMethod");
    public static JSError NeedInterface = getFrom(enumReflected, "NeedInterface");
    public static JSError UnreachableCatch = getFrom(enumReflected, "UnreachableCatch");
    public static JSError TypeCannotBeExtended = getFrom(enumReflected, "TypeCannotBeExtended");
    public static JSError UndeclaredVariable = getFrom(enumReflected, "UndeclaredVariable");
    public static JSError VariableLeftUninitialized = getFrom(enumReflected, "VariableLeftUninitialized");
    public static JSError KeywordUsedAsIdentifier = getFrom(enumReflected, "KeywordUsedAsIdentifier");
    public static JSError NotAllowedInSuperConstructorCall = getFrom(enumReflected, "NotAllowedInSuperConstructorCall");
    public static JSError NotMeantToBeCalledDirectly = getFrom(enumReflected, "NotMeantToBeCalledDirectly");
    public static JSError GetAndSetAreInconsistent = getFrom(enumReflected, "GetAndSetAreInconsistent");
    public static JSError InvalidCustomAttribute = getFrom(enumReflected, "InvalidCustomAttribute");
    public static JSError InvalidCustomAttributeArgument = getFrom(enumReflected, "InvalidCustomAttributeArgument");
    public static JSError InvalidCustomAttributeClassOrCtor = getFrom(enumReflected, "InvalidCustomAttributeClassOrCtor");
    public static JSError TooManyParameters = getFrom(enumReflected, "TooManyParameters");
    public static JSError AmbiguousBindingBecauseOfWith = getFrom(enumReflected, "AmbiguousBindingBecauseOfWith");
    public static JSError AmbiguousBindingBecauseOfEval = getFrom(enumReflected, "AmbiguousBindingBecauseOfEval");
    public static JSError NoSuchMember = getFrom(enumReflected, "NoSuchMember");
    public static JSError ItemNotAllowedOnExpandoClass = getFrom(enumReflected, "ItemNotAllowedOnExpandoClass");
    public static JSError MethodNotAllowedOnExpandoClass = getFrom(enumReflected, "MethodNotAllowedOnExpandoClass");
    public static JSError MethodClashOnExpandoSuperClass = getFrom(enumReflected, "MethodClashOnExpandoSuperClass");
    public static JSError BaseClassIsExpandoAlready = getFrom(enumReflected, "BaseClassIsExpandoAlready");
    public static JSError AbstractCannotBePrivate = getFrom(enumReflected, "AbstractCannotBePrivate");
    public static JSError NotIndexable = getFrom(enumReflected, "NotIndexable");
    public static JSError StaticMissingInStaticInit = getFrom(enumReflected, "StaticMissingInStaticInit");
    public static JSError MissingConstructForAttributes = getFrom(enumReflected, "MissingConstructForAttributes");
    public static JSError OnlyClassesAllowed = getFrom(enumReflected, "OnlyClassesAllowed");
    public static JSError ExpandoClassShouldNotImpleEnumerable = getFrom(enumReflected, "ExpandoClassShouldNotImpleEnumerable");
    public static JSError NonCLSCompliantMember = getFrom(enumReflected, "NonCLSCompliantMember");
    public static JSError NotDeletable = getFrom(enumReflected, "NotDeletable");
    public static JSError PackageExpected = getFrom(enumReflected, "PackageExpected");
    public static JSError UselessExpression = getFrom(enumReflected, "UselessExpression");
    public static JSError HidesParentMember = getFrom(enumReflected, "HidesParentMember");
    public static JSError CannotChangeVisibility = getFrom(enumReflected, "CannotChangeVisibility");
    public static JSError HidesAbstractInBase = getFrom(enumReflected, "HidesAbstractInBase");
    public static JSError NewNotSpecifiedInMethodDeclaration = getFrom(enumReflected, "NewNotSpecifiedInMethodDeclaration");
    public static JSError MethodInBaseIsNotVirtual = getFrom(enumReflected, "MethodInBaseIsNotVirtual");
    public static JSError NoMethodInBaseToNew = getFrom(enumReflected, "NoMethodInBaseToNew");
    public static JSError DifferentReturnTypeFromBase = getFrom(enumReflected, "DifferentReturnTypeFromBase");
    public static JSError ClashWithProperty = getFrom(enumReflected, "ClashWithProperty");
    public static JSError OverrideAndHideUsedTogether = getFrom(enumReflected, "OverrideAndHideUsedTogether");
    public static JSError InvalidLanguageOption = getFrom(enumReflected, "InvalidLanguageOption");
    public static JSError NoMethodInBaseToOverride = getFrom(enumReflected, "NoMethodInBaseToOverride");
    public static JSError NotValidForConstructor = getFrom(enumReflected, "NotValidForConstructor");
    public static JSError CannotReturnValueFromVoidFunction = getFrom(enumReflected, "CannotReturnValueFromVoidFunction");
    public static JSError AmbiguousMatch = getFrom(enumReflected, "AmbiguousMatch");
    public static JSError AmbiguousConstructorCall = getFrom(enumReflected, "AmbiguousConstructorCall");
    public static JSError SuperClassConstructorNotAccessible = getFrom(enumReflected, "SuperClassConstructorNotAccessible");
    public static JSError OctalLiteralsAreDeprecated = getFrom(enumReflected, "OctalLiteralsAreDeprecated");
    public static JSError VariableMightBeUnitialized = getFrom(enumReflected, "VariableMightBeUnitialized");
    public static JSError NotOKToCallSuper = getFrom(enumReflected, "NotOKToCallSuper");
    public static JSError IllegalUseOfSuper = getFrom(enumReflected, "IllegalUseOfSuper");
    public static JSError BadWayToLeaveFinally = getFrom(enumReflected, "BadWayToLeaveFinally");
    public static JSError NoCommaOrTypeDefinitionError = getFrom(enumReflected, "NoCommaOrTypeDefinitionError");
    public static JSError AbstractWithBody = getFrom(enumReflected, "AbstractWithBody");
    public static JSError NoRightParenOrComma = getFrom(enumReflected, "NoRightParenOrComma");
    public static JSError NoRightBracketOrComma = getFrom(enumReflected, "NoRightBracketOrComma");
    public static JSError ExpressionExpected = getFrom(enumReflected, "ExpressionExpected");
    public static JSError UnexpectedSemicolon = getFrom(enumReflected, "UnexpectedSemicolon");
    public static JSError TooManyTokensSkipped = getFrom(enumReflected, "TooManyTokensSkipped");
    public static JSError BadVariableDeclaration = getFrom(enumReflected, "BadVariableDeclaration");
    public static JSError BadFunctionDeclaration = getFrom(enumReflected, "BadFunctionDeclaration");
    public static JSError BadPropertyDeclaration = getFrom(enumReflected, "BadPropertyDeclaration");
    public static JSError DoesNotHaveAnAddress = getFrom(enumReflected, "DoesNotHaveAnAddress");
    public static JSError TooFewParameters = getFrom(enumReflected, "TooFewParameters");
    public static JSError UselessAssignment = getFrom(enumReflected, "UselessAssignment");
    public static JSError SuspectAssignment = getFrom(enumReflected, "SuspectAssignment");
    public static JSError SuspectSemicolon = getFrom(enumReflected, "SuspectSemicolon");
    public static JSError ImpossibleConversion = getFrom(enumReflected, "ImpossibleConversion");
    public static JSError FinalPrecludesAbstract = getFrom(enumReflected, "FinalPrecludesAbstract");
    public static JSError NeedInstance = getFrom(enumReflected, "NeedInstance");
    public static JSError CannotBeAbstract = getFrom(enumReflected, "CannotBeAbstract");
    public static JSError InvalidBaseTypeForEnum = getFrom(enumReflected, "InvalidBaseTypeForEnum");
    public static JSError CannotInstantiateAbstractClass = getFrom(enumReflected, "CannotInstantiateAbstractClass");
    public static JSError ArrayMayBeCopied = getFrom(enumReflected, "ArrayMayBeCopied");
    public static JSError AbstractCannotBeStatic = getFrom(enumReflected, "AbstractCannotBeStatic");
    public static JSError StaticIsAlreadyFinal = getFrom(enumReflected, "StaticIsAlreadyFinal");
    public static JSError StaticMethodsCannotOverride = getFrom(enumReflected, "StaticMethodsCannotOverride");
    public static JSError StaticMethodsCannotHide = getFrom(enumReflected, "StaticMethodsCannotHide");
    public static JSError ExpandoPrecludesOverride = getFrom(enumReflected, "ExpandoPrecludesOverride");
    public static JSError IllegalParamArrayAttribute = getFrom(enumReflected, "IllegalParamArrayAttribute");
    public static JSError ExpandoPrecludesAbstract = getFrom(enumReflected, "ExpandoPrecludesAbstract");
    public static JSError ShouldBeAbstract = getFrom(enumReflected, "ShouldBeAbstract");
    public static JSError BadModifierInInterface = getFrom(enumReflected, "BadModifierInInterface");
    public static JSError VarIllegalInInterface = getFrom(enumReflected, "VarIllegalInInterface");
    public static JSError InterfaceIllegalInInterface = getFrom(enumReflected, "InterfaceIllegalInInterface");
    public static JSError NoVarInEnum = getFrom(enumReflected, "NoVarInEnum");
    public static JSError InvalidImport = getFrom(enumReflected, "InvalidImport");
    public static JSError EnumNotAllowed = getFrom(enumReflected, "EnumNotAllowed");
    public static JSError InvalidCustomAttributeTarget = getFrom(enumReflected, "InvalidCustomAttributeTarget");
    public static JSError PackageInWrongContext = getFrom(enumReflected, "PackageInWrongContext");
    public static JSError ConstructorMayNotHaveReturnType = getFrom(enumReflected, "ConstructorMayNotHaveReturnType");
    public static JSError OnlyClassesAndPackagesAllowed = getFrom(enumReflected, "OnlyClassesAndPackagesAllowed");
    public static JSError InvalidDebugDirective = getFrom(enumReflected, "InvalidDebugDirective");
    public static JSError CustomAttributeUsedMoreThanOnce = getFrom(enumReflected, "CustomAttributeUsedMoreThanOnce");
    public static JSError NestedInstanceTypeCannotBeExtendedByStatic = getFrom(enumReflected, "NestedInstanceTypeCannotBeExtendedByStatic");
    public static JSError PropertyLevelAttributesMustBeOnGetter = getFrom(enumReflected, "PropertyLevelAttributesMustBeOnGetter");
    public static JSError BadThrow = getFrom(enumReflected, "BadThrow");
    public static JSError ParamListNotLast = getFrom(enumReflected, "ParamListNotLast");
    public static JSError NoSuchType = getFrom(enumReflected, "NoSuchType");
    public static JSError BadOctalLiteral = getFrom(enumReflected, "BadOctalLiteral");
    public static JSError InstanceNotAccessibleFromStatic = getFrom(enumReflected, "InstanceNotAccessibleFromStatic");
    public static JSError StaticRequiresTypeName = getFrom(enumReflected, "StaticRequiresTypeName");
    public static JSError NonStaticWithTypeName = getFrom(enumReflected, "NonStaticWithTypeName");
    public static JSError NoSuchStaticMember = getFrom(enumReflected, "NoSuchStaticMember");
    public static JSError SuspectLoopCondition = getFrom(enumReflected, "SuspectLoopCondition");
    public static JSError ExpectedAssembly = getFrom(enumReflected, "ExpectedAssembly");
    public static JSError AssemblyAttributesMustBeGlobal = getFrom(enumReflected, "AssemblyAttributesMustBeGlobal");
    public static JSError ExpandoPrecludesStatic = getFrom(enumReflected, "ExpandoPrecludesStatic");
    public static JSError DuplicateMethod = getFrom(enumReflected, "DuplicateMethod");
    public static JSError NotAnExpandoFunction = getFrom(enumReflected, "NotAnExpandoFunction");
    public static JSError NotValidVersionString = getFrom(enumReflected, "NotValidVersionString");
    public static JSError ExecutablesCannotBeLocalized = getFrom(enumReflected, "ExecutablesCannotBeLocalized");
    public static JSError StringConcatIsSlow = getFrom(enumReflected, "StringConcatIsSlow");
    public static JSError CcInvalidInDebugger = getFrom(enumReflected, "CcInvalidInDebugger");
    public static JSError ExpandoMustBePublic = getFrom(enumReflected, "ExpandoMustBePublic");
    public static JSError DelegatesShouldNotBeExplicitlyConstructed = getFrom(enumReflected, "DelegatesShouldNotBeExplicitlyConstructed");
    public static JSError ImplicitlyReferencedAssemblyNotFound = getFrom(enumReflected, "ImplicitlyReferencedAssemblyNotFound");
    public static JSError PossibleBadConversion = getFrom(enumReflected, "PossibleBadConversion");
    public static JSError PossibleBadConversionFromString = getFrom(enumReflected, "PossibleBadConversionFromString");
    public static JSError InvalidResource = getFrom(enumReflected, "InvalidResource");
    public static JSError WrongUseOfAddressOf = getFrom(enumReflected, "WrongUseOfAddressOf");
    public static JSError NonCLSCompliantType = getFrom(enumReflected, "NonCLSCompliantType");
    public static JSError MemberTypeCLSCompliantMismatch = getFrom(enumReflected, "MemberTypeCLSCompliantMismatch");
    public static JSError TypeAssemblyCLSCompliantMismatch = getFrom(enumReflected, "TypeAssemblyCLSCompliantMismatch");
    public static JSError IncompatibleAssemblyReference = getFrom(enumReflected, "IncompatibleAssemblyReference");
    public static JSError InvalidAssemblyKeyFile = getFrom(enumReflected, "InvalidAssemblyKeyFile");
    public static JSError TypeNameTooLong = getFrom(enumReflected, "TypeNameTooLong");
    public static JSError MemberInitializerCannotContainFuncExpr = getFrom(enumReflected, "MemberInitializerCannotContainFuncExpr");
    public static JSError CantAssignThis = getFrom(enumReflected, "CantAssignThis");
    public static JSError NumberExpected = getFrom(enumReflected, "NumberExpected");
    public static JSError FunctionExpected = getFrom(enumReflected, "FunctionExpected");
    public static JSError CannotAssignToFunctionResult = getFrom(enumReflected, "CannotAssignToFunctionResult");
    public static JSError StringExpected = getFrom(enumReflected, "StringExpected");
    public static JSError DateExpected = getFrom(enumReflected, "DateExpected");
    public static JSError ObjectExpected = getFrom(enumReflected, "ObjectExpected");
    public static JSError IllegalAssignment = getFrom(enumReflected, "IllegalAssignment");
    public static JSError UndefinedIdentifier = getFrom(enumReflected, "UndefinedIdentifier");
    public static JSError BooleanExpected = getFrom(enumReflected, "BooleanExpected");
    public static JSError VBArrayExpected = getFrom(enumReflected, "VBArrayExpected");
    public static JSError EnumeratorExpected = getFrom(enumReflected, "EnumeratorExpected");
    public static JSError RegExpExpected = getFrom(enumReflected, "RegExpExpected");
    public static JSError RegExpSyntax = getFrom(enumReflected, "RegExpSyntax");
    public static JSError UncaughtException = getFrom(enumReflected, "UncaughtException");
    public static JSError InvalidPrototype = getFrom(enumReflected, "InvalidPrototype");
    public static JSError URIEncodeError = getFrom(enumReflected, "URIEncodeError");
    public static JSError URIDecodeError = getFrom(enumReflected, "URIDecodeError");
    public static JSError FractionOutOfRange = getFrom(enumReflected, "FractionOutOfRange");
    public static JSError PrecisionOutOfRange = getFrom(enumReflected, "PrecisionOutOfRange");
    public static JSError ArrayLengthConstructIncorrect = getFrom(enumReflected, "ArrayLengthConstructIncorrect");
    public static JSError ArrayLengthAssignIncorrect = getFrom(enumReflected, "ArrayLengthAssignIncorrect");
    public static JSError NeedArrayObject = getFrom(enumReflected, "NeedArrayObject");
    public static JSError NoConstructor = getFrom(enumReflected, "NoConstructor");
    public static JSError IllegalEval = getFrom(enumReflected, "IllegalEval");
    public static JSError NotYetImplemented = getFrom(enumReflected, "NotYetImplemented");
    public static JSError MustProvideNameForNamedParameter = getFrom(enumReflected, "MustProvideNameForNamedParameter");
    public static JSError DuplicateNamedParameter = getFrom(enumReflected, "DuplicateNamedParameter");
    public static JSError MissingNameParameter = getFrom(enumReflected, "MissingNameParameter");
    public static JSError MoreNamedParametersThanArguments = getFrom(enumReflected, "MoreNamedParametersThanArguments");
    public static JSError NonSupportedInDebugger = getFrom(enumReflected, "NonSupportedInDebugger");
    public static JSError AssignmentToReadOnly = getFrom(enumReflected, "AssignmentToReadOnly");
    public static JSError WriteOnlyProperty = getFrom(enumReflected, "WriteOnlyProperty");
    public static JSError IncorrectNumberOfIndices = getFrom(enumReflected, "IncorrectNumberOfIndices");
    public static JSError RefParamsNonSupportedInDebugger = getFrom(enumReflected, "RefParamsNonSupportedInDebugger");
    public static JSError CannotCallSecurityMethodLateBound = getFrom(enumReflected, "CannotCallSecurityMethodLateBound");
    public static JSError CannotUseStaticSecurityAttribute = getFrom(enumReflected, "CannotUseStaticSecurityAttribute");
    public static JSError NonClsException = getFrom(enumReflected, "NonClsException");
    public static JSError FuncEvalAborted = getFrom(enumReflected, "FuncEvalAborted");
    public static JSError FuncEvalTimedout = getFrom(enumReflected, "FuncEvalTimedout");
    public static JSError FuncEvalThreadSuspended = getFrom(enumReflected, "FuncEvalThreadSuspended");
    public static JSError FuncEvalThreadSleepWaitJoin = getFrom(enumReflected, "FuncEvalThreadSleepWaitJoin");
    public static JSError FuncEvalBadThreadState = getFrom(enumReflected, "FuncEvalBadThreadState");
    public static JSError FuncEvalBadThreadNotStarted = getFrom(enumReflected, "FuncEvalBadThreadNotStarted");
    public static JSError NoFuncEvalAllowed = getFrom(enumReflected, "NoFuncEvalAllowed");
    public static JSError FuncEvalBadLocation = getFrom(enumReflected, "FuncEvalBadLocation");
    public static JSError FuncEvalWebMethod = getFrom(enumReflected, "FuncEvalWebMethod");
    public static JSError StaticVarNotAvailable = getFrom(enumReflected, "StaticVarNotAvailable");
    public static JSError TypeObjectNotAvailable = getFrom(enumReflected, "TypeObjectNotAvailable");
    public static JSError ExceptionFromHResult = getFrom(enumReflected, "ExceptionFromHResult");
    public static JSError SideEffectsDisallowed = getFrom(enumReflected, "SideEffectsDisallowed");


    // Flags management section


}