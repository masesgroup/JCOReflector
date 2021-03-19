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

package system.xml;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.xml.XmlWriter;
import system.io.Stream;
import system.text.Encoding;
import system.io.TextWriter;
import system.xml.Formatting;
import system.xml.WriteState;
import system.xml.XmlSpace;


/**
 * The base .NET class managing System.Xml.XmlTextWriter, System.Private.Xml, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51. Extends {@link NetObject}.
 * <p>
 * 
 * See: <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Xml.XmlTextWriter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Xml.XmlTextWriter</a>
 */
public class XmlTextWriter extends XmlWriter  {
    /**
     * Fully assembly qualified name: System.Private.Xml, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51
     */
    public static final String assemblyFullName = "System.Private.Xml, Version=5.0.0.0, Culture=neutral, PublicKeyToken=cc7b13ffcd2ddd51";
    /**
     * Assembly name: System.Private.Xml
     */
    public static final String assemblyShortName = "System.Private.Xml";
    /**
     * Qualified class name: System.Xml.XmlTextWriter
     */
    public static final String className = "System.Xml.XmlTextWriter";
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

    public XmlTextWriter(Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link XmlTextWriter}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link XmlTextWriter} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static XmlTextWriter cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new XmlTextWriter(from.getJCOInstance());
    }

    // Constructors section
    
    public XmlTextWriter() throws Throwable {
    }

    public XmlTextWriter(Stream w, Encoding encoding) throws Throwable, system.PlatformNotSupportedException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException, system.ArgumentNullException, system.ArgumentOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(w == null ? null : w.getJCOInstance(), encoding == null ? null : encoding.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlTextWriter(TextWriter w) throws Throwable, system.PlatformNotSupportedException, system.ArgumentException, system.NotSupportedException, system.IndexOutOfRangeException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(w == null ? null : w.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XmlTextWriter(java.lang.String filename, Encoding encoding) throws Throwable, system.ArgumentException, system.IndexOutOfRangeException, system.NotSupportedException, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentOutOfRangeException, system.PlatformNotSupportedException, system.FormatException, system.globalization.CultureNotFoundException, system.runtime.serialization.SerializationException, system.ObjectDisposedException, system.io.IOException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(filename, encoding == null ? null : encoding.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public java.lang.String LookupPrefix(java.lang.String ns) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (java.lang.String)classInstance.Invoke("LookupPrefix", ns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Close() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Close");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void Flush() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("Flush");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteBase64(byte[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteBase64", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteBase64(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteBase64", dupParam0.getJCRefOut(), dupParam1, dupParam2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteBinHex(byte[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteBinHex", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteBinHex(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteBinHex", dupParam0.getJCRefOut(), dupParam1, dupParam2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteCData(java.lang.String text) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteCData", text);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteCharEntity(char ch) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteCharEntity", ch);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteChars(char[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteChars", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteChars(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteChars", dupParam0.getJCRefOut(), dupParam1, dupParam2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteComment(java.lang.String text) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.ArrayTypeMismatchException, system.FormatException, system.RankException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteComment", text);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteDocType(java.lang.String name, java.lang.String pubid, java.lang.String sysid, java.lang.String subset) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteDocType", name, pubid, sysid, subset);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteEndAttribute() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteEndAttribute");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteEndDocument() throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.FormatException, system.ArgumentException, system.OutOfMemoryException, system.globalization.CultureNotFoundException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteEndDocument");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteEndElement() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteEndElement");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteEntityRef(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteEntityRef", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteFullEndElement() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteFullEndElement");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteName(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteName", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteNmToken(java.lang.String name) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteNmToken", name);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteProcessingInstruction(java.lang.String name, java.lang.String text) throws Throwable, system.NotSupportedException, system.ArgumentNullException, system.PlatformNotSupportedException, system.InvalidOperationException, system.ArgumentException, system.ArgumentOutOfRangeException, system.IndexOutOfRangeException, system.globalization.CultureNotFoundException, system.OutOfMemoryException, system.runtime.interopservices.ExternalException, system.RankException, system.ArrayTypeMismatchException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteProcessingInstruction", name, text);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteQualifiedName(java.lang.String localName, java.lang.String ns) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteQualifiedName", localName, ns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteRaw(char[] buffer, int index, int count) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteRaw", buffer, index, count);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteRaw(JCORefOut dupParam0, int dupParam1, int dupParam2) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteRaw", dupParam0.getJCRefOut(), dupParam1, dupParam2);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteRaw(java.lang.String data) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteRaw", data);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteStartAttribute(java.lang.String prefix, java.lang.String localName, java.lang.String ns) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteStartAttribute", prefix, localName, ns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteStartDocument() throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.NotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteStartDocument");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteStartDocument(boolean standalone) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.NotSupportedException, system.IndexOutOfRangeException, system.OutOfMemoryException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteStartDocument", standalone);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteStartElement(java.lang.String prefix, java.lang.String localName, java.lang.String ns) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteStartElement", prefix, localName, ns);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteString(java.lang.String text) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteString", text);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteSurrogateCharEntity(char lowChar, char highChar) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.ObjectDisposedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.NotSupportedException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteSurrogateCharEntity", lowChar, highChar);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void WriteWhitespace(java.lang.String ws) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException, system.PlatformNotSupportedException, system.IndexOutOfRangeException, system.RankException, system.ArrayTypeMismatchException, system.OutOfMemoryException, system.FormatException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Invoke("WriteWhitespace", ws);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getNamespaces() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("Namespaces");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setNamespaces(boolean Namespaces) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException, system.InvalidOperationException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Namespaces", Namespaces);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public char getIndentChar() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (char)classInstance.Get("IndentChar");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIndentChar(char IndentChar) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("IndentChar", IndentChar);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public char getQuoteChar() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (char)classInstance.Get("QuoteChar");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setQuoteChar(char QuoteChar) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("QuoteChar", QuoteChar);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getIndentation() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("Indentation");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setIndentation(int Indentation) throws Throwable, system.ArgumentNullException, system.ArgumentException, system.ArgumentOutOfRangeException, system.globalization.CultureNotFoundException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Indentation", Indentation);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Stream getBaseStream() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("BaseStream");
            return new Stream(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public Formatting getFormatting() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            JCObject val = (JCObject)classInstance.Get("Formatting");
            return new Formatting(val);
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public void setFormatting(Formatting Formatting) throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            classInstance.Set("Formatting", Formatting == null ? null : Formatting.getJCOInstance());
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}