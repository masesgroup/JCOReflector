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

package system.windows.automation.provider;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.windows.automation.provider.IGridItemProvider;
import system.windows.automation.provider.IGridItemProviderImplementation;
import system.windows.automation.provider.IRawElementProviderSimple;
import system.windows.automation.provider.IRawElementProviderSimpleImplementation;


/**
 * The base .NET class managing System.Windows.Automation.Provider.ITableItemProvider, UIAutomationProvider, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Automation.Provider.ITableItemProvider" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Automation.Provider.ITableItemProvider</a>
 */
public class ITableItemProviderImplementation extends NetObject implements ITableItemProvider {
    /**
     * Fully assembly qualified name: UIAutomationProvider, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "UIAutomationProvider, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: UIAutomationProvider
     */
    public static final String assemblyShortName = "UIAutomationProvider";
    /**
     * Qualified class name: System.Windows.Automation.Provider.ITableItemProvider
     */
    public static final String className = "System.Windows.Automation.Provider.ITableItemProvider";
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

    public ITableItemProviderImplementation(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ITableItemProvider}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ITableItemProvider} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ITableItemProvider ToITableItemProvider(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ITableItemProviderImplementation(from.getJCOInstance());
    }

    // Methods section
    
    public IRawElementProviderSimple[] GetColumnHeaderItems() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<IRawElementProviderSimple> resultingArrayList = new ArrayList<IRawElementProviderSimple>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetColumnHeaderItems");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IRawElementProviderSimpleImplementation(resultingObject));
            }
            IRawElementProviderSimple[] resultingArray = new IRawElementProviderSimple[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IRawElementProviderSimple[] GetRowHeaderItems() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            ArrayList<IRawElementProviderSimple> resultingArrayList = new ArrayList<IRawElementProviderSimple>();
            JCObject resultingObjects = (JCObject)classInstance.Invoke("GetRowHeaderItems");
            for (Object resultingObject : resultingObjects) {
			    resultingArrayList.add(new IRawElementProviderSimpleImplementation(resultingObject));
            }
            IRawElementProviderSimple[] resultingArray = new IRawElementProviderSimple[resultingArrayList.size()];
            resultingArray = resultingArrayList.toArray(resultingArray);
            return resultingArray;
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public int getColumn() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Column");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getColumnSpan() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("ColumnSpan");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getRow() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Row");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getRowSpan() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("RowSpan");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public IRawElementProviderSimple getContainingGrid() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("ContainingGrid");
            return new IRawElementProviderSimpleImplementation(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}