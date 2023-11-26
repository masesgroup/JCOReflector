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

package system.xaml;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;
import java.util.ArrayList;

// Import section
import system.io.Stream;
import system.xaml.XamlSchemaContext;
import system.xaml.XamlXmlReaderSettings;
import system.io.TextReader;
import system.xml.XmlReader;
import system.xaml.NamespaceDeclaration;
import system.xaml.XamlMember;
import system.xaml.XamlNodeType;
import system.xaml.XamlType;


/**
 * The base .NET class managing System.Xaml.XamlXmlReader, System.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Xaml.XamlXmlReader" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Xaml.XamlXmlReader</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public class XamlXmlReader extends NetObject  {
    /**
     * Fully assembly qualified name: System.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089
     */
    public static final String assemblyFullName = "System.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089";
    /**
     * Assembly name: System.Xaml
     */
    public static final String assemblyShortName = "System.Xaml";
    /**
     * Qualified class name: System.Xaml.XamlXmlReader
     */
    public static final String className = "System.Xaml.XamlXmlReader";
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
    public XamlXmlReader(java.lang.Object instance) throws Throwable {
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
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link XamlXmlReader}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link XamlXmlReader} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static XamlXmlReader cast(IJCOBridgeReflected from) throws Throwable {
        NetType.AssertCast(classType, from);
        return new XamlXmlReader(from.getJCOInstance());
    }

    // Constructors section
    
    public XamlXmlReader() throws Throwable {
    }

    public XamlXmlReader(Stream stream) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(Stream stream, XamlSchemaContext schemaContext) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance(), schemaContext == null ? null : schemaContext.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(Stream stream, XamlSchemaContext schemaContext, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance(), schemaContext == null ? null : schemaContext.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(Stream stream, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(stream == null ? null : stream.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(TextReader textReader) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(textReader == null ? null : textReader.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(TextReader textReader, XamlSchemaContext schemaContext) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(textReader == null ? null : textReader.getJCOInstance(), schemaContext == null ? null : schemaContext.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(TextReader textReader, XamlSchemaContext schemaContext, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(textReader == null ? null : textReader.getJCOInstance(), schemaContext == null ? null : schemaContext.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(TextReader textReader, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(textReader == null ? null : textReader.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(java.lang.String fileName) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.AggregateException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(java.lang.String fileName, XamlSchemaContext schemaContext) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.AggregateException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, schemaContext == null ? null : schemaContext.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(java.lang.String fileName, XamlSchemaContext schemaContext, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.AggregateException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, schemaContext == null ? null : schemaContext.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(java.lang.String fileName, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.InvalidOperationException, system.ArgumentException, system.ObjectDisposedException, system.security.SecurityException, system.UnauthorizedAccessException, system.io.IOException, system.resources.MissingManifestResourceException, system.ArgumentOutOfRangeException, system.xml.XmlException, system.NotImplementedException, system.NotSupportedException, system.IndexOutOfRangeException, system.AggregateException, system.FormatException, system.globalization.CultureNotFoundException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(fileName, settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(XmlReader xmlReader) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.NotImplementedException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.xml.XmlException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.UriFormatException, system.MulticastNotSupportedException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(xmlReader == null ? null : xmlReader.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(XmlReader xmlReader, XamlSchemaContext schemaContext) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.NotImplementedException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.xml.XmlException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.UriFormatException, system.MulticastNotSupportedException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(xmlReader == null ? null : xmlReader.getJCOInstance(), schemaContext == null ? null : schemaContext.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(XmlReader xmlReader, XamlSchemaContext schemaContext, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.NotImplementedException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.xml.XmlException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.UriFormatException, system.MulticastNotSupportedException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(xmlReader == null ? null : xmlReader.getJCOInstance(), schemaContext == null ? null : schemaContext.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public XamlXmlReader(XmlReader xmlReader, XamlXmlReaderSettings settings) throws Throwable, system.ArgumentNullException, system.ArgumentOutOfRangeException, system.ArgumentException, system.globalization.CultureNotFoundException, system.resources.MissingManifestResourceException, system.ObjectDisposedException, system.InvalidOperationException, system.NotSupportedException, system.NotImplementedException, system.collections.generic.KeyNotFoundException, system.xaml.XamlSchemaException, system.OutOfMemoryException, system.IndexOutOfRangeException, system.xml.XmlException, system.security.SecurityException, system.MemberAccessException, system.NullReferenceException, system.UriFormatException, system.MulticastNotSupportedException, system.threading.ThreadAbortException {
        try {
            // add reference to assemblyName.dll file
            addReference(JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName);
            setJCOInstance((JCObject)classType.NewObject(xmlReader == null ? null : xmlReader.getJCOInstance(), settings == null ? null : settings.getJCOInstance()));
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    
    // Methods section
    
    public boolean Read() throws Throwable, system.ObjectDisposedException {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Invoke("Read");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }


    
    // Properties section
    
    public boolean getHasLineInfo() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (boolean)classInstance.Get("HasLineInfo");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getLineNumber() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("LineNumber");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }

    public int getLinePosition() throws Throwable {
        if (classInstance == null)
            throw new UnsupportedOperationException("classInstance is null.");
        try {
            return (int)classInstance.Get("LinePosition");
        } catch (JCNativeException jcne) {
            throw translateException(jcne);
        }
    }



    // Instance Events section
    

}