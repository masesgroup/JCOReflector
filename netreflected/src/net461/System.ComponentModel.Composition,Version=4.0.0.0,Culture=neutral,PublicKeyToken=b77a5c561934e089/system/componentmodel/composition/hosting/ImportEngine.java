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

package system.componentmodel.composition.hosting;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.componentmodel.composition.hosting.ExportProvider;
import system.componentmodel.composition.hosting.CompositionOptions;
import system.componentmodel.composition.primitives.ComposablePart;
import system.componentmodel.composition.hosting.AtomicComposition;


/**
 * The base .NET class managing System.ComponentModel.Composition.Hosting.ImportEngine, System.ComponentModel.Composition, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.Composition.Hosting.ImportEngine" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.ComponentModel.Composition.Hosting.ImportEngine</a>
 */
public class ImportEngine extends NetObject implements AutoCloseable {
    /**
     * Fully assembly qualified name: System.ComponentModel.Composition, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.ComponentModel.Composition, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.ComponentModel.Composition
     */
    public static final String assemblyShortName = "System.ComponentModel.Composition";
    /**
     * Qualified class name: System.ComponentModel.Composition.Hosting.ImportEngine
     */
    public static final String className = "System.ComponentModel.Composition.Hosting.ImportEngine";
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

    public ImportEngine(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link ImportEngine}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link ImportEngine} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static ImportEngine cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new ImportEngine(from.getJCOInstance());
    }

    // Constructors section
    
    public ImportEngine() throws Throwable {
    }

    public ImportEngine(ExportProvider sourceProvider) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotImplementedException, system.ObjectDisposedException, system.componentmodel.composition.ImportCardinalityMismatchException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(sourceProvider == null ? null : sourceProvider.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ImportEngine(ExportProvider sourceProvider, boolean isThreadSafe) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.NotImplementedException, system.ObjectDisposedException, system.componentmodel.composition.ImportCardinalityMismatchException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException, system.MulticastNotSupportedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(sourceProvider == null ? null : sourceProvider.getJCOInstance(), isThreadSafe));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public ImportEngine(ExportProvider sourceProvider, CompositionOptions compositionOptions) throws Throwable, system.ArgumentException, system.ArgumentOutOfRangeException, system.ArgumentNullException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotImplementedException, system.componentmodel.composition.ImportCardinalityMismatchException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(sourceProvider == null ? null : sourceProvider.getJCOInstance(), compositionOptions == null ? null : compositionOptions.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public void Dispose() throws Throwable, system.ArgumentOutOfRangeException, system.ObjectDisposedException, system.threading.LockRecursionException, system.ArgumentNullException, system.ArgumentException, system.NotImplementedException, system.InvalidOperationException, system.componentmodel.composition.ImportCardinalityMismatchException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException, system.threading.SynchronizationLockException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Dispose");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void PreviewImports(ComposablePart part, AtomicComposition atomicComposition) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.threading.LockRecursionException, system.componentmodel.composition.ImportCardinalityMismatchException, system.NotImplementedException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("PreviewImports", part == null ? null : part.getJCOInstance(), atomicComposition == null ? null : atomicComposition.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void ReleaseImports(ComposablePart part, AtomicComposition atomicComposition) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.threading.LockRecursionException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("ReleaseImports", part == null ? null : part.getJCOInstance(), atomicComposition == null ? null : atomicComposition.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SatisfyImports(ComposablePart part) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.threading.LockRecursionException, system.componentmodel.composition.ImportCardinalityMismatchException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SatisfyImports", part == null ? null : part.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void SatisfyImportsOnce(ComposablePart part) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.resources.MissingManifestResourceException, system.InvalidOperationException, system.ObjectDisposedException, system.ArgumentOutOfRangeException, system.threading.LockRecursionException, system.componentmodel.composition.ImportCardinalityMismatchException, system.componentmodel.composition.CompositionException, system.componentmodel.composition.ChangeRejectedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("SatisfyImportsOnce", part == null ? null : part.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void close() throws Exception {
        try {
            if (classInstance == null)
                throw new UnsupportedOperationException("classInstance is null.");
            try {
                classInstance.Invoke("Dispose");
            }
            catch (JCNativeException jcne) {
                throw translateException(jcne);
            }
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }
    
    // Properties section
    


    // Instance Events section
    

}