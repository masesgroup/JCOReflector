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

package system.windows.xps.packaging;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.windows.xps.packaging.IStoryFragmentProvider;
import system.windows.xps.packaging.IStoryFragmentProviderImplementation;
import system.windows.xps.packaging.XpsColorContext;
import system.windows.xps.packaging.XpsFont;
import system.windows.xps.packaging.XpsImage;
import system.windows.xps.packaging.XpsImageType;
import system.windows.xps.packaging.XpsResource;
import system.Uri;
import system.windows.xps.packaging.XpsResourceDictionary;
import system.windows.xps.packaging.XpsStructure;
import system.windows.xps.packaging.XpsThumbnail;
import system.printing.PrintTicket;
import system.xml.XmlWriter;


/**
 * The base .NET class managing System.Windows.Xps.Packaging.IXpsFixedPageWriter, ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35.
 * <p>
 * 
 * .NET documentation at <a href="https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Xps.Packaging.IXpsFixedPageWriter" target="_top">https://docs.microsoft.com/en-us/dotnet/api/System.Windows.Xps.Packaging.IXpsFixedPageWriter</a>
 * <p>
 *
 * Powered by JCOBridge: more info at <a href="https://www.jcobridge.com" target="_top">https://www.jcobridge.com</a>
 *
 * @author  MASES s.r.l https://masesgroup.com
 * @version 1.13.0.0
 */
public interface IXpsFixedPageWriter extends IJCOBridgeReflected, IStoryFragmentProvider {
    /**
     * Fully assembly qualified name: ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35
     */
    public static final String assemblyFullName = "ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35";
    /**
     * Assembly name: ReachFramework
     */
    public static final String assemblyShortName = "ReachFramework";
    /**
     * Qualified class name: System.Windows.Xps.Packaging.IXpsFixedPageWriter
     */
    public static final String className = "System.Windows.Xps.Packaging.IXpsFixedPageWriter";
    /**
     * Try to cast the {@link IJCOBridgeReflected} instance into {@link IXpsFixedPageWriter}, a cast assert is made to check if types are compatible.
     * @param from {@link IJCOBridgeReflected} instance to be casted
     * @return {@link IXpsFixedPageWriter} instance
     * @throws java.lang.Throwable in case of error during cast operation
     */
    public static IXpsFixedPageWriter ToIXpsFixedPageWriter(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("ReachFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35");
        JCType classType = bridge.GetType(className + ", " + (JCOReflector.getUseFullAssemblyName() ? assemblyFullName : assemblyShortName));
        NetType.AssertCast(classType, from);
        return new IXpsFixedPageWriterImplementation(from.getJCOInstance());
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
     * @return An {@link java.lang.Object} representing the instance of the instantiated Class
     */
    public java.lang.Object getJCOInstance();

    /**
     * Returns the instantiated class Type
     * 
     * @return A {@link JCType} representing the Type of the instantiated Class
     */
    public JCType getJCOType();

    // Methods section
    
    public XpsColorContext AddColorContext() throws Throwable;

    public XpsFont AddFont() throws Throwable;

    public XpsFont AddFont(boolean obfuscate) throws Throwable;

    public XpsFont AddFont(boolean obfuscate, boolean addRestrictedRelationship) throws Throwable;

    public XpsImage AddImage(java.lang.String mimeType) throws Throwable;

    public XpsImage AddImage(XpsImageType imageType) throws Throwable;

    public XpsResource AddResource(NetType resourceType, Uri resourceUri) throws Throwable;

    public XpsResourceDictionary AddResourceDictionary() throws Throwable;


    public XpsThumbnail AddThumbnail(XpsImageType imageType) throws Throwable;

    public void Commit() throws Throwable;


    
    // Properties section
    
    public int getPageNumber() throws Throwable;

    public void setPrintTicket(PrintTicket PrintTicket) throws Throwable;

    public Uri getUri() throws Throwable;

    public XmlWriter getXmlWriter() throws Throwable;



    // Instance Events section
    

}