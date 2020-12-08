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
import java.util.*;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.lang.reflect.*;

/**
 * Manages all instances of {@link JCOBridge}
 * 
 */
public final class JCOBridgeInstance implements IJCEventLog {
    static boolean _useFullname = false;
    static boolean _isDebug = false;
    static boolean _isLogging = false;
    static IJCEventLog _logger = null;
    static String _loggingFilename = "JCOReflector.log";
    static boolean _isMultiInstance = false;
    static boolean initialized = false;
    static Object synchObj = new Object();
    static HashMap<String, JCOBridge> bridgeInstances = new HashMap<String, JCOBridge>();
    static JCOBridge bridgeInstance = null;
    static String[] _commandLineArgs = new String[0];

    BufferedWriter bw = null;
    FileWriter fw = null;
    String mfileName;

    JCOBridgeInstance(String fileName) throws IOException {
        mfileName = fileName;
        fw = new FileWriter(mfileName);
        bw = new BufferedWriter(fw);
    }

    /**
     * Invoked when a fusion event happens.
     * 
     * @param msg The message associated
     */
    public void FusionLog(String msg) {
        synchronized (synchObj) {
            if (!_isLogging)
                return;
        }

        try {
            bw.write(msg);
            bw.newLine();
        } catch (IOException ioe) {
            // nothing can do
        }
    }

    /**
     * Invoked when an event happens.
     * 
     * @param msg The message associated
     */
    public void EventLog(String msg) {
        synchronized (synchObj) {
            if (!_isLogging)
                return;
        }

        try {
            bw.write(msg);
            bw.newLine();
        } catch (IOException ioe) {
            // nothing can do
        }
    }

    /**
     * Get UseFullAssemblyName state
     * 
     * @return the UseFullAssemblyName state
     */
    public static boolean getUseFullAssemblyName() {
        return _useFullname;
    }

    /**
     * Set UseFullAssemblyName state
     * <p>
     * Set only on startup
     * 
     * @param useFullname the new UseFullAssemblyName state
     */
    public static void setUseFullAssemblyName(boolean useFullname) {
        if (initialized)
            return;
        _useFullname = useFullname;
    }

    /**
     * Get Debug state
     * 
     * @return the debug state
     */
    public static boolean getDebug() {
        return _isDebug;
    }

    /**
     * Set Debug state
     * 
     * @param isDebug the new debug state
     */
    public static void setDebug(boolean isDebug) {
        _isDebug = isDebug;
    }

    /**
     * Get Logging state
     * 
     * @return the debug state
     */
    public static boolean getLogging() {
        synchronized (synchObj) {
            return _isLogging;
        }
    }

    /**
     * Set Logging state
     * <p>
     * 
     * @param isLogging the new logging state
     */
    public static void setLogging(boolean isLogging) {
        synchronized (synchObj) {
            _isLogging = isLogging;
        }
    }

    /**
     * Get Logging filename
     * 
     * @return the log filename
     */
    public static String getLogFilename() {
        synchronized (synchObj) {
            return _loggingFilename;
        }
    }

    /**
     * Set Logging filename
     * <p>
     * If the logging operations are started on a {@link JCOBridge} instance, it is
     * not possible to change the name during runtime.
     * 
     * @param loggingFilename the new log filename
     */
    public static void setLogFilename(String loggingFilename) {
        synchronized (synchObj) {
            _loggingFilename = loggingFilename;
        }
    }

    /**
     * Get InstanceByAssembly state
     * 
     * @return the {@link JCOBridge} state
     */
    public static boolean getInstanceByAssembly() {
        return _isMultiInstance;
    }

    /**
     * Set {@link JCOBridge} instance by assembly state
     * <p>
     * It can be applied only before any operation
     * 
     * @param isMultiInstance the new InstanceByAssembly state
     */
    public static void setInstanceByAssembly(boolean isMultiInstance) {
        if (initialized)
            return;
        _isMultiInstance = isMultiInstance;
    }

     /**
     * Set command-line arguments
     * <p>
     * It can be applied only before any operation
     * 
     * @param args the command-line arguments
     */
    public static void setCommandLineArgs(String[] args) {
        if (initialized)
            return;
        _commandLineArgs = args;
    }

    /**
     * Returns the {@link JCOBridge} instance associated to the assmebly.
     * <p>
     * Until now a single global instance is created
     * 
     * @param assemblyName The name of the assembly to bind the instance
     * @return An {@link JCOBridge} instance
     */
    public static JCOBridge getInstance(String assemblyName) {
        synchronized (synchObj) {
            if (!initialized) {
                try {
                    try {
                        JCOBridge.Initialize(_commandLineArgs);
                    } catch (JCNativeException e) {
                        if (!e.getCLRType().contains("FallbackInTrialModeException")) {
                            if (_isDebug)
                                e.printStackTrace();
                            System.exit(1);
                        }
                    } finally {
                        initialized = true;
                    }
                } catch (IOException | JCException e) {
                    if (_isDebug)
                        e.printStackTrace();
                    System.exit(1);
                }
            }

            JCOBridge theBridgeInstance = null;
            if (_isMultiInstance) {
                if (bridgeInstances.containsKey(assemblyName)) {
                    theBridgeInstance = bridgeInstances.get(assemblyName);
                } else {
                    try {
                        theBridgeInstance = JCOBridge.CreateNew();
                        try {
                            _logger = new JCOBridgeInstance(_loggingFilename);
                            theBridgeInstance.RegisterEventLog(_logger);
                        } catch (Throwable t) {
                            if (_isDebug)
                                t.printStackTrace();
                        }
                        bridgeInstances.put(assemblyName, theBridgeInstance);
                    } catch (JCException e) {
                        if (_isDebug)
                            e.printStackTrace();
                    }
                }
            } else {
                if (bridgeInstance == null) {
                    try {
                        bridgeInstance = JCOBridge.CreateNew();
                        try {
                            _logger = new JCOBridgeInstance(_loggingFilename);
                            bridgeInstance.RegisterEventLog(_logger);
                        } catch (Throwable t) {
                            if (_isDebug)
                                t.printStackTrace();
                        }
                    } catch (JCException e) {
                        if (_isDebug)
                            e.printStackTrace();
                    }
                }
                theBridgeInstance = bridgeInstance;
            }
            return theBridgeInstance;
        }
    }

    public static <T extends IJCOBridgeReflected> Object toObjectFromArray(T[] input) {
        if (input == null)
            return new Object[0];
        Object[] returnArray = new Object[input.length];
        ArrayList<Object> lst = new ArrayList<Object>();
        for (T t : input) {
            IJCOBridgeReflected obj = (IJCOBridgeReflected) t;
            lst.add(obj.getJCOInstance());
        }
        return lst.toArray();
    }

    public static Throwable translateException(JCNativeException ne) throws Throwable {
        if (ne == null)
            throw new IllegalArgumentException();
        String clrEx = ne.getCLRType();
        int index = clrEx.lastIndexOf('.');
        String nameSpace = clrEx.substring(0, index).toLowerCase();
        clrEx = nameSpace + clrEx.substring(index, clrEx.length());
        if (clrEx != null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(clrEx);
            } catch (ClassNotFoundException cnfe) {
                return ne;
            }
            Throwable obj = (Throwable) clazz.getDeclaredConstructor(Object.class).newInstance(ne);
            return obj;
            /*
             * if (obj instanceof NetException) { NetException netEx = (NetException) obj;
             * netEx.setJCNativeException(ne); return netEx; }
             */
        }
        return ne;
    }
}