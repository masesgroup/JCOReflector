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

/**************************************************************************************
 * <auto-generated>
 *      This code was generated from a template using JCOReflector version 1.1.0.0
 * 
 *      Manual changes to this file may cause unexpected behavior in your application.
 *      Manual changes to this file will be overwritten if the code is regenerated.
 * </auto-generated>
 *************************************************************************************/

package system.data;

import org.mases.jcobridge.*;
import org.mases.jcobridge.netreflection.*;

// Import section
import system.data.common.DbDataRecord;
import system.data.common.DbDataReader;
import system.Guid;
import system.Single;
import system.Decimal;
import system.DateTime;
import system.data.IDataReader;
import system.data.IDataReaderImplementation;
import system.data.common.DataRecordInfo;


/**
 * The base .NET class managing System.Data.IExtendedDataRecord, System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089. Implements {@link IJCOBridgeReflected}.
 */
public interface IExtendedDataRecord extends IJCOBridgeReflected {

    public static IExtendedDataRecord ToIExtendedDataRecord(IJCOBridgeReflected from) throws Throwable {
        JCOBridge bridge = JCOBridgeInstance.getInstance("System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089");
        JCType classType = bridge.GetType("System.Data.IExtendedDataRecord, " + (JCOBridgeInstance.getUseFullAssemblyName() ? "System.Data.Entity, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089" : "System.Data.Entity"));
        NetType.AssertCast(classType, from);
        return new IExtendedDataRecordImplementation(from.getJCOInstance());
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
    
    public DbDataRecord GetDataRecord(int i) throws Throwable;

    public DbDataReader GetDataReader(int i) throws Throwable;

    public java.lang.String GetString(int i) throws Throwable;

    public boolean IsDBNull(int i) throws Throwable;

    public java.lang.String GetName(int i) throws Throwable;

    public java.lang.String GetDataTypeName(int i) throws Throwable;

    public NetType GetFieldType(int i) throws Throwable;

    public NetObject GetValue(int i) throws Throwable;

    public int GetValues(NetObject[] values) throws Throwable;

    public int GetOrdinal(java.lang.String name) throws Throwable;

    public boolean GetBoolean(int i) throws Throwable;

    public byte GetByte(int i) throws Throwable;

    public long GetBytes(int i, long fieldOffset, byte[] buffer, int bufferoffset, int length) throws Throwable;

    public char GetChar(int i) throws Throwable;

    public long GetChars(int i, long fieldoffset, char[] buffer, int bufferoffset, int length) throws Throwable;

    public Guid GetGuid(int i) throws Throwable;

    public short GetInt16(int i) throws Throwable;

    public int GetInt32(int i) throws Throwable;

    public long GetInt64(int i) throws Throwable;

    public Single GetFloat(int i) throws Throwable;

    public double GetDouble(int i) throws Throwable;

    public Decimal GetDecimal(int i) throws Throwable;

    public DateTime GetDateTime(int i) throws Throwable;

    public IDataReader GetData(int i) throws Throwable;


    
    // Properties section
    
    public DataRecordInfo getDataRecordInfo() throws Throwable;

    public int getFieldCount() throws Throwable;



    // Instance Events section
    

}