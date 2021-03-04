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

package org.mases.jcobridge.netreflection;

import org.mases.jcobridge.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.lang.reflect.*;

/**
 * Manages all instances of {@link JCOBridge}
 * 
 */
public final class JCOBridgeInstance implements IJCEventLog {
    static IJCEventLog _logger = null;
    static Object synchObj = new Object();
    static HashMap<String, JCOBridge> bridgeInstances = new HashMap<String, JCOBridge>();
    static JCOBridge bridgeInstance = null;

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
            if (!JCOReflector.getLogging())
                return;
        }

        JCOReflector.writeLog(bw, msg);
    }

    /**
     * Invoked when an event happens.
     * 
     * @param msg The message associated
     */
    public void EventLog(String msg) {
        synchronized (synchObj) {
            if (!JCOReflector.getLogging())
                return;
        }

        JCOReflector.writeLog(bw, msg);
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
            if (!JCOReflector.getInitialized()) {
                try {
                    try {
                        JCOBridge.Initialize(JCOReflector.getCommandLineArgs());
                    } catch (JCNativeException e) {
                        if (!e.getCLRType().contains("FallbackInTrialModeException")) {
                            JCOReflector.writeLog(e);
                            System.exit(1);
                        }
                    } finally {
                        JCOReflector.setInitialized(true);
                    }
                } catch (IOException | JCException e) {
                    JCOReflector.writeLog(e);
                    System.exit(1);
                }
            }

            JCOBridge theBridgeInstance = null;
            if (JCOReflector.getInstanceByAssembly()) {
                if (bridgeInstances.containsKey(assemblyName)) {
                    theBridgeInstance = bridgeInstances.get(assemblyName);
                } else {
                    try {
                        theBridgeInstance = JCOBridge.CreateNew();
                        try {
                            _logger = new JCOBridgeInstance(JCOReflector.getLogFilename());
                            theBridgeInstance.RegisterEventLog(_logger);
                            JCOReflector.setLogging(true);
                        } catch (Throwable t) {
                            JCOReflector.writeLog(t);
                        }
                        bridgeInstances.put(assemblyName, theBridgeInstance);
                    } catch (JCException e) {
                        JCOReflector.writeLog(e);
                    }
                }
            } else {
                if (bridgeInstance == null) {
                    try {
                        bridgeInstance = JCOBridge.CreateNew();
                        try {
                            _logger = new JCOBridgeInstance(JCOReflector.getLogFilename());
                            bridgeInstance.RegisterEventLog(_logger);
                            JCOReflector.setLogging(true);
                        } catch (Throwable t) {
                            JCOReflector.writeLog(t);
                        }
                    } catch (JCException e) {
                        JCOReflector.writeLog(e);
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