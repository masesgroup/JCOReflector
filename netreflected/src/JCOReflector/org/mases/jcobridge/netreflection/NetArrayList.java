/*
 *  MIT License
 *
 *  Copyright (c) 2020 MASES s.r.l.
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

package org.mases.jcobridge.netreflection;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

/**
 * The base .NET class managing System.Collections.ArrayList, mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Extends {@link NetObject}.
 */
public class NetArrayList extends NetObject {
    public static final String assemblyFullName = "mscorlib, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    public static final String assemblyShortName = "mscorlib";
    public static final String className = "System.Collections.ArrayList";
    static JCOBridge bridge = JCOBridgeInstance.getInstance(assemblyFullName);
    public static JCType classType = createType();
    static JCEnum enumInstance = null;
    JCObject classInstance = null;

    static JCType createType() {
        try {
            return bridge.GetType(className + ", "
                    + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        } catch (JCException e) {
            JCOBridgeInstance.writeLog(e.toString());
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

    public NetArrayList(Object instance) throws Throwable {
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
        return className + ", " + (JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
    }

    public Object getJCOInstance() {
        return classInstance;
    }

    public JCType getJCOType() {
        return classType;
    }

    public static NetArrayList castFrom(IJCOBridgeReflected from) throws Throwable {
        return new NetArrayList(from.getJCOInstance());
    }

    // Constructors section

    public NetArrayList() throws Throwable {
        super();
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            classInstance = (JCObject) classType.NewObject();
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetArrayList(int capacity) throws Throwable {
        super();
        try {
            // add reference to assemblyName.dll file
            addReference(JCOBridgeInstance.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            classInstance = (JCObject) classType.NewObject(capacity);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    // Methods section

    public int Add(NetObject value) throws Throwable {
        try {
            return (int) classInstance.Invoke("Add", value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int BinarySearch(NetObject value) throws Throwable {
        try {
            return (int) classInstance.Invoke("BinarySearch", value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject Clone() throws Throwable {
        try {
            JCObject objClone = (JCObject) classInstance.Invoke("Clone");
            return new NetObject(objClone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean Contains(NetObject item) throws Throwable {
        try {
            return (boolean) classInstance.Invoke("Contains", item.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetArrayList FixedSize(NetArrayList list) throws Throwable {
        try {
            JCObject objFixedSize = (JCObject) classType.Invoke("FixedSize", list.getJCOInstance());
            return new NetArrayList(objFixedSize);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int IndexOf(NetObject value) throws Throwable {
        try {
            return (int) classInstance.Invoke("IndexOf", value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int IndexOf(NetObject value, int startIndex) throws Throwable {
        try {
            return (int) classInstance.Invoke("IndexOf", value.getJCOInstance(), startIndex);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int IndexOf(NetObject value, int startIndex, int count) throws Throwable {
        try {
            return (int) classInstance.Invoke("IndexOf", value.getJCOInstance(), startIndex, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Insert(int index, NetObject value) throws Throwable {
        try {
            classInstance.Invoke("Insert", index, value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int LastIndexOf(NetObject value) throws Throwable {
        try {
            return (int) classInstance.Invoke("LastIndexOf", value.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int LastIndexOf(NetObject value, int startIndex) throws Throwable {
        try {
            return (int) classInstance.Invoke("LastIndexOf", value.getJCOInstance(), startIndex);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetArrayList ReadOnly(NetArrayList list) throws Throwable {
        try {
            JCObject objReadOnly = (JCObject) classType.Invoke("ReadOnly", list.getJCOInstance());
            return new NetArrayList(objReadOnly);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Remove(NetObject obj) throws Throwable {
        try {
            classInstance.Invoke("Remove", obj.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveAt(int index) throws Throwable {
        try {
            classInstance.Invoke("RemoveAt", index);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void RemoveRange(int index, int count) throws Throwable {
        try {
            classInstance.Invoke("RemoveRange", index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetArrayList Repeat(NetObject value, int count) throws Throwable {
        try {
            JCObject objRepeat = (JCObject) classType.Invoke("Repeat", value.getJCOInstance(), count);
            return new NetArrayList(objRepeat);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Reverse() throws Throwable {
        try {
            classInstance.Invoke("Reverse");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Reverse(int index, int count) throws Throwable {
        try {
            classInstance.Invoke("Reverse", index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public static NetArrayList Synchronized(NetArrayList list) throws Throwable {
        try {
            JCObject objSynchronized = (JCObject) classType.Invoke("Synchronized", list.getJCOInstance());
            return new NetArrayList(objSynchronized);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int LastIndexOf(NetObject value, int startIndex, int count) throws Throwable {
        try {
            return (int) classInstance.Invoke("LastIndexOf", value.getJCOInstance(), startIndex, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetArrayList GetRange(int index, int count) throws Throwable {
        try {
            JCObject objGetRange = (JCObject) classInstance.Invoke("GetRange", index, count);
            return new NetArrayList(objGetRange);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    // Properties section

    public int getCapacity() throws Throwable {
        try {
            return (int) classInstance.Get("Capacity");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setCapacity(int Capacity) throws Throwable {
        try {
            classInstance.Set("Capacity", Capacity);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getCount() throws Throwable {
        try {
            return (int) classInstance.Get("Count");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsFixedSize() throws Throwable {
        try {
            return (boolean) classInstance.Get("IsFixedSize");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsReadOnly() throws Throwable {
        try {
            return (boolean) classInstance.Get("IsReadOnly");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public boolean getIsSynchronized() throws Throwable {
        try {
            return (boolean) classInstance.Get("IsSynchronized");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public NetObject getSyncRoot() throws Throwable {
        try {
            JCObject val = (JCObject) classInstance.Get("SyncRoot");
            return new NetObject(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }
}