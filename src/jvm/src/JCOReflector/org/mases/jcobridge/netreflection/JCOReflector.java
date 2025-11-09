/*
 *  MIT License
 *
 *  Copyright (c) 2020-2025 MASES s.r.l.
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

import org.mases.jcobridge.JCOBridge;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.lang.reflect.*;

/**
 * Main class to manage {@link JCOReflector} features
 */
public class JCOReflector {
    static boolean _fallbackOnNativeParse = false;
    static String _scopeOn = "JCOReflector";
    static String _scopeOnVersion = "1.16.0.0";
    static String _runtimeFolder = null;
    static boolean _isLogging = false;
    static String _loggingFilename = "JCOBridge.log";
    static boolean _useFullname = false;
    static boolean _isDebug = false;
    static boolean _isConsoleLog = false;
    static boolean _isMultiInstance = false;
    static boolean _initialized = false;
    static String[] _commandLineArgs = new String[0];
    static Object global_bw_lock = new Object();
    static BufferedWriter global_bw = getWriter();

    static BufferedWriter getWriter() {
        try {
            return new BufferedWriter(new FileWriter("JCOReflector.log"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    /**
     * Return the FallbackOnNativeParse value
     * 
     * @return the FallbackOnNativeParse value
     */
    public static synchronized boolean getFallbackOnNativeParse() {
        return _fallbackOnNativeParse;
    }

    /**
     * Set the FallbackOnNativeParse value
     * 
     * @param fallbackOnNative set the FallbackOnNativeParse value
     */
    public static synchronized void setFallbackOnNativeParse(boolean fallbackOnNativeParse) {
        _fallbackOnNativeParse = fallbackOnNativeParse;
    }

    /**
     * Return the ScopeOn value
     * 
     * @return the ScopeOn value
     */
    public static synchronized String getScopeOn() {
        return _scopeOn;
    }

    /**
     * Set the ScopeOn value
     * 
     * @param scopeOn the ScopeOn value
     */
    public static synchronized void setScopeOn(String scopeOn) {
        _scopeOn = scopeOn;
    }

    /**
     * Return the ScopeOnVersion value
     * 
     * @return the ScopeOnVersion value
     */
    public static synchronized String getScopeOnVersion() {
        return _scopeOnVersion;
    }

    /**
     * Set the ScopeOnVersion value
     * 
     * @param scopeOnVersion the ScopeOnVersion value
     */
    public static synchronized void setScopeOnVersion(String scopeOnVersion) {
        _scopeOnVersion = scopeOnVersion;
    }

    /**
     * Return if {@link JCOReflector} is initialized
     * 
     * @return true if {@link JCOReflector} is initialized
     */
    public static synchronized boolean getInitialized() {
        return _initialized;
    }

    static synchronized void setInitialized(boolean initialized) {
        _initialized = initialized;
    }

    /**
     * Get Logging state
     * 
     * @return the logging state
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
        writeLog("Set Logging to %s", isLogging ? "true" : "false");
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
        writeLog("Set LogFilename to %s", loggingFilename);
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
        writeLog("Set UseFullAssemblyName to %s", useFullname ? "true" : "false");
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
        writeLog("Set debug to %s", isDebug ? "true" : "false");
        _isDebug = isDebug;
    }

    /**
     * Get console log
     * 
     * @return the console log state
     */
    public static boolean getConsoleLog() {
        return _isConsoleLog;
    }

    /**
     * Set console log
     * 
     * @param isConsoleLog the new console log state
     */
    public static void setConsoleLog(boolean isConsoleLog) {
        writeLog("Set debug to %s", isConsoleLog ? "true" : "false");
        _isConsoleLog = isConsoleLog;
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
        writeLog("Set InstanceByAssembly to %s", isMultiInstance ? "true" : "false");
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
     * Register search path within the engine
     * <p>
     * It can be applied only before any operation
     * 
     * @param path the path to register
     */
    public static void registerPath(String path) {
        if (getInitialized())
            return;
        JCOBridgeInstance.registerPath(path);
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
        for (StackTraceElement ste : t.getStackTrace()) {
            sb.append(ste.toString());
            sb.append(System.getProperty("line.separator"));
        }
        writeLog(sb.toString());
    }

    /**
     * Write a log to JCOReflector log
     * 
     * @param format format {@link String} to log
     * @param args   format arguments
     */
    public static void writeLog(String format, Object... args) {
        try {
            writeLog(String.format(format, args));
        } catch (Throwable t) {
            writeLog(t);
        }
    }

    /**
     * Write a string to JCOReflector log
     * 
     * @param msg message to log
     */
    public static void writeLog(String msg) {
        if (getConsoleLog())
            System.out.println(msg);

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

    static void unzip(String zipFilePath, String destDirectory) throws IOException {
        writeLog(String.format("Extracting %s", zipFilePath));
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDirectory + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                    if (!System.getProperty("os.name").contains("Windows")) {
                        try {
                            Runtime.getRuntime().exec(new String[] { "chmod", "755", filePath }).waitFor();
                        } catch (Throwable e) {
                            writeLog(e);
                        }
                    }
                } else {
                    File dir = new File(filePath);
                    dir.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        final int BUFFER_SIZE = 4096;
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    static String extractAndReturnPath(String pathToJar) {
        final String containerFileName = "JCOBridge.zip";
        try {
            Path tmpPath = (pathToJar == null) ? Files.createTempDirectory(JCOReflector.class.getName())
                    : Paths.get(pathToJar);
            String targetFolder = tmpPath.toString();
            writeLog(String.format("Destination folder is %s", targetFolder));
            File extractedLibFile = new File(targetFolder, containerFileName);
            // Extract file into the current directory
            try (InputStream reader = JCOReflector.class.getResourceAsStream(containerFileName);
                    FileOutputStream writer = new FileOutputStream(extractedLibFile);) {
                if (reader == null) {
                    writeLog("Missing embedded JCOBridge resource. "
                            + "If available will be used the JCOBridge.jar in the classpath."
                            + "If not available the application will fail with some exceptions.");
                    return null;
                }
                byte[] buffer = new byte[1024];
                int bytesRead = 0;
                while ((bytesRead = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, bytesRead);
                }
            }
            unzip(extractedLibFile.toString(), targetFolder);
            return targetFolder;
        } catch (IOException e) {
            writeLog(e.toString());
            return null;
        }
    }

    static boolean singleLoader(String className, ClassLoader loader) throws ClassNotFoundException {
        Class clazz = Class.forName(className, true, loader);
        if (clazz == null) {
            writeLog(String.format("Unable to find %s in %s", className, loader.toString()));
        } else {
            String loadPath = clazz.getClassLoader().getResource(className.replace(".", "/") + ".class").getFile();
            writeLog(String.format("%s loaded from %s", className, loadPath));
        }
        return true;
    }

    static boolean addToClasspath(File jarFile) {
        try {
            writeLog(String.format("Adding %s to classpath resolution.", jarFile.toString()));
            String version = System.getProperty("java.version");
            if (version == null)
                version = System.getProperty("java.runtime.version");

            writeLog(String.format("Runtime version is %s.", (version != null) ? version : "No version identified"));

            URL url = jarFile.toURI().toURL();
            if (Integer.parseInt(version.substring(0, version.indexOf('.', 0))) < 9) {
                URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
                Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                method.setAccessible(true);
                method.invoke(classLoader, url);
                return true;
            } else {
                URL[] urls = new URL[1];
                urls[0] = url;
                ClassLoader loader = new URLClassLoader(urls);
                return singleLoader("org.mases.jcobridge.JCException", loader);
            }
        } catch (Exception e) {
            writeLog(e.toString());
            return false;
        }
    }

    static String getRTFolder() {
        return _runtimeFolder;
    }

    /**
     * Initialize {@link JCOReflector} runtime
     * 
     * @param args command-line arguments
     */
    public static void init(String[] args) {
        setCommandLineArgs(args);
        for (int index = 0; index < args.length; index++) {
            String string = args[index];
            if (string.toLowerCase() == "-debug") {
                setDebug(true);
            } else if (string.toLowerCase() == "-logging") {
                setLogging(true);
            } else if (string.toLowerCase() == "-instancebyassembly") {
                setInstanceByAssembly(true);
            } else if (string.toLowerCase() == "-logfilename") {
                setLogFilename(args[index++]);
            } else if (string.toLowerCase() == "-initrt") {
                initRT(args[index++]);
            } else if (string.toLowerCase() == "-inittemprt") {
                initTempRT();
            } else if (string.toLowerCase() == "-path") {
                registerPath(args[index++]);
            } else if (string.toLowerCase() == "-scopeon") {
                setScopeOn(args[index++]);
            } else if (string.toLowerCase() == "-scopeonversion") {
                setScopeOnVersion(args[index++]);
            }
        }
    }

    /**
     * Invoke this method to initialize JCOBridge runtime to a temporary folder
     * 
     * @return true if the runtime was initialized, otherwise see JCOReflector.log
     *         to check possible error conditions
     */
    public static boolean initTempRT() {
        return initRT(null);
    }

    /**
     * Invoke this method to initialize JCOBridge runtime to a user defined folder
     * 
     * @param pathToUse The user defined path used for JCOBridge runtime
     * 
     * @return true if the runtime was initialized, otherwise see JCOReflector.log
     *         to check possible error conditions
     */
    public static boolean initRT(String pathToUse) {
        writeLog("Initialize RT to %s", pathToUse != null ? pathToUse : "Temporary folder");
        // try extract from resources
        _runtimeFolder = extractAndReturnPath(pathToUse);
        if (JCOReflector.getRTFolder() != null && JCOReflector.getRTFolder() != "") {
            writeLog("Setting RT folder to %s", _runtimeFolder);
            org.mases.jcobridge.JCOBridge.setNativePath(_runtimeFolder);
        }
        return _runtimeFolder != null;
    }
}
