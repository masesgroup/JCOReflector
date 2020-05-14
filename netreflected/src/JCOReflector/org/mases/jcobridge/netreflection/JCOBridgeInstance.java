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
public final class JCOBridgeInstance {
    static boolean _useFullname = false;
    static boolean _isDebug = false;
    static boolean _isLogging = false;
    static boolean _isMultiInstance = false;
    static boolean initialized = false;
    static Object synchObj = new Object();
    static HashMap<String, JCOBridge> bridgeInstances = new HashMap<String, JCOBridge>();
    static JCOBridge bridgeInstance = null;

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
     * If the logging operations are started on a {@link JCOBridge} instance, it is
     * not possible to stop them during runtime. The reset does not impact newly
     * created {@link JCOBridge} instances
     * 
     * @param isLogging the new logging state
     */
    public static void setLogging(boolean isLogging) {
        synchronized (synchObj) {
            _isLogging = isLogging;
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
     * Returns the {@link JCOBridge} instance associated to the assmebly.
     * <p>
     * Until now a single global instance is created
     * 
     * @return An {@link JCOBridge} instance
     */
    public static JCOBridge getInstance(String assemblyName) {
        synchronized (synchObj) {
            if (!initialized) {
                try {
                    try {
                        JCOBridge.Initialize();
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
}