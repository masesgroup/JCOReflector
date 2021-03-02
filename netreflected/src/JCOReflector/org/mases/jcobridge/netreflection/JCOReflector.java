package org.mases.jcobridge.netreflection;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.lang.reflect.*;

public class JCOReflector {
    static boolean _isLogging = false;
    static String _loggingFilename = "JCOBridge.log";
    static boolean _useFullname = false;
    static boolean _isDebug = false;
    static boolean _isMultiInstance = false;
    static boolean _initialized = false;
    static String[] _commandLineArgs = new String[0];
    static BufferedWriter global_bw = null;

    public static synchronized boolean getInitialized() {
        return _initialized;
    }

    public static synchronized void setInitialized(boolean initialized) {
        _initialized = initialized;
    }

    /**
     * Get Logging state
     * 
     * @return the debug state
     */
    public static synchronized boolean getLogging() {
        return _isLogging;
    }

    /**
     * Set Logging state
     * <p>
     * 
     * @param isLogging the new logging state
     */
    public static synchronized void setLogging(boolean isLogging) {
        _isLogging = isLogging;
    }

    /**
     * Get Logging filename
     * 
     * @return the log filename
     */
    public static synchronized String getLogFilename() {
        return _loggingFilename;
    }

    /**
     * Set Logging filename
     * <p>
     * If the logging operations are started on a {@link JCOBridge} instance, it is
     * not possible to change the name during runtime.
     * 
     * @param loggingFilename the new log filename
     */
    public static synchronized void setLogFilename(String loggingFilename) {
        if (!getInitialized())
            return;
        _loggingFilename = loggingFilename;
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
        if (getInitialized())
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
        if (getInitialized())
            return;
        _isMultiInstance = isMultiInstance;
    }

    /**
     * Get command-line arguments
     * <p>
     * 
     * @return the command-line arguments
     */
    public static String[] getCommandLineArgs() {
        return _commandLineArgs;
    }

    /**
     * Set command-line arguments
     * <p>
     * It can be applied only before any operation
     * 
     * @param args the command-line arguments
     */
    public static void setCommandLineArgs(String[] args) {
        if (getInitialized())
            return;
        _commandLineArgs = args;
    }

    /**
     * Write exception to JCOReflector log
     * 
     * @param t {@link Throwable} to log
     */
    public static void writeLog(Throwable t) {
        StringBuilder sb = new StringBuilder();
        sb.append(t.getMessage());
        sb.append(System.getProperty("line.separator"));
        sb.append(t.getStackTrace());
        sb.append(System.getProperty("line.separator"));
        writeLog(sb.toString());
    }

    /**
     * Write a string to JCOReflector log
     * 
     * @param msg message to log
     */
    public static synchronized void writeLog(String msg) {
        if (global_bw == null) {
            try {
                global_bw = new BufferedWriter(new FileWriter("JCOReflector.log"));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        writeLog(global_bw, msg);
    }

    static void writeLog(BufferedWriter bw, String msg) {
        try {
            bw.write(msg);
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            // nothing can be done
            ioe.printStackTrace();
        }
    }
}
