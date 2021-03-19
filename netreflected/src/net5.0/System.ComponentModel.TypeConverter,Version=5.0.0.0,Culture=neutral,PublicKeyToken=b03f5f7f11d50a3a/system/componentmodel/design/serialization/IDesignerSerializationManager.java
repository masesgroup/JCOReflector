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

package system.componentmodel.design.serialization;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.IServiceProvider;
import system.IServiceProviderImplementation;
import system.collections.ICollection;
import system.collections.ICollectionImplementation;
import system.componentmodel.design.serialization.IDesignerSerializationProvider;
import system.componentmodel.design.serialization.IDesignerSerializationProviderImplementation;
import system.componentmodel.design.serialization.ContextStack;
import system.componentmodel.PropertyDescriptorCollection;
import system.componentmodel.design.serialization.ResolveNameEventHandler;
import system.EventHandler;


/**
 * The base .NET class managing System.ComponentModel.Design.Serialization.IDesignerSerializationManager, System.ComponentModel.TypeConverter, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a. Implements {@link IJCOBridgeReflected}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.Design.Serialization.IDesignerSerializationManager" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.Design.Serialization.IDesignerSerializationManager</a>
 */
public interface IDesignerSerializationManager extends IJCOBridgeReflected, IServiceProvider {
    /**
     * Fully assembly qualified name: System.ComponentModel.TypeConverter, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a
     */
    public static final String assemblyFullName = "System.ComponentModel.TypeConverter, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a";
    /**
     * Assembly name: System.ComponentModel.TypeConverter
     */
    public static final String assemblyShortName = "System.ComponentModel.TypeConverter";
    /**
     * Qualified class name: System.ComponentModel.Design.Serialization.IDesignerSerializationManager
     */
    public static final String className = "System.ComponentModel.Design.Serialization.IDesignerSerializationManager";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IDesignerSerializationManager}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IDesignerSerializationManager} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IDesignerSerializationManager ToIDesignerSerializationManager(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.ComponentModel.TypeConverter, Version=5.0.0.0, Culture=neutral, PublicKeyToken=b03f5f7f11d50a3a");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IDesignerSerializationManagerImplementation(from.getJCOInstance());
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
    
    public NetObject CreateInstance(NetType type, ICollection arguments, java.lang.String name, boolean addToContainer) throws Throwable;

    public NetObject GetInstance(java.lang.String name) throws Throwable;

    public NetObject GetSerializer(NetType objectType, NetType serializerType) throws Throwable;


    public java.lang.String GetName(NetObject value) throws Throwable;

    public NetType GetType(java.lang.String typeName) throws Throwable;

    public void AddSerializationProvider(IDesignerSerializationProvider provider) throws Throwable;

    public void RemoveSerializationProvider(IDesignerSerializationProvider provider) throws Throwable;

    public void ReportError(NetObject errorInformation) throws Throwable;

    public void SetName(NetObject instance, java.lang.String name) throws Throwable;


    
    // Properties section
    
    public ContextStack getContext() throws Throwable;

    public PropertyDescriptorCollection getProperties() throws Throwable;



    // Instance Events section
    
    public void addResolveName(ResolveNameEventHandler handler) throws Throwable;

    public void removeResolveName(ResolveNameEventHandler handler) throws Throwable;

    public void addSerializationComplete(EventHandler handler) throws Throwable;

    public void removeSerializationComplete(EventHandler handler) throws Throwable;


}