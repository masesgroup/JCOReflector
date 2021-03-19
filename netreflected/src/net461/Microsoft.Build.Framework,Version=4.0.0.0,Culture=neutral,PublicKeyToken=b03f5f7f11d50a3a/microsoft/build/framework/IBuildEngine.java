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

package microsoft.build.framework;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.collections.IDictionary;
import system.collections.IDictionaryImplementation;
import microsoft.build.framework.CustomBuildEventArgs;
import microsoft.build.framework.BuildErrorEventArgs;
import microsoft.build.framework.BuildMessageEventArgs;
import microsoft.build.framework.BuildWarningEventArgs;


/**
 * The base .NET class managing Microsoft.Build.Framework.IBuildEngine, Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Implements {@link IJCOBridgeReflected}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/Microsoft.Build.Framework.IBuildEngine" target="_top">https://docs.microsoft.com/en-us/dotnet/api/Microsoft.Build.Framework.IBuildEngine</a>
 */
public interface IBuildEngine extends IJCOBridgeReflected {
    /**
     * Fully assembly qualified name: Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: Microsoft.Build.Framework
     */
    public static final String assemblyShortName = "Microsoft.Build.Framework";
    /**
     * Qualified class name: Microsoft.Build.Framework.IBuildEngine
     */
    public static final String className = "Microsoft.Build.Framework.IBuildEngine";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IBuildEngine}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IBuildEngine} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IBuildEngine ToIBuildEngine(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("Microsoft.Build.Framework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IBuildEngineImplementation(from.getJCOInstance());
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
     * @return An {@link Object} representing the instance of the instantiated Class
     */
    public Object getJCOInstance();

    /**
     * Returns the instantiated class Type
     * 
     * @return A {@link JCType} representing the Type of the instantiated Class
     */
    public JCType getJCOType();

    // Methods section
    
    public boolean BuildProjectFile(java.lang.String projectFileName, java.lang.String[] targetNames, IDictionary globalProperties, IDictionary targetOutputs) throws Throwable;

    public boolean BuildProjectFile(java.lang.String dupParam0, JCORefOut dupParam1, IDictionary dupParam2, IDictionary dupParam3) throws Throwable;

    public void LogCustomEvent(CustomBuildEventArgs e) throws Throwable;

    public void LogErrorEvent(BuildErrorEventArgs e) throws Throwable;

    public void LogMessageEvent(BuildMessageEventArgs e) throws Throwable;

    public void LogWarningEvent(BuildWarningEventArgs e) throws Throwable;


    
    // Properties section
    
    public boolean getContinueOnError() throws Throwable;

    public int getColumnNumberOfTaskNode() throws Throwable;

    public int getLineNumberOfTaskNode() throws Throwable;

    public java.lang.String getProjectFileOfTaskNode() throws Throwable;



    // Instance Events section
    

}