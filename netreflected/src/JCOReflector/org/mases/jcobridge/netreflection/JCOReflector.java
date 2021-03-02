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

    private static void unzip(String zipFilePath, String destDirectory) throws IOException {
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

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        final int BUFFER_SIZE = 4096;
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] bytesIn = new byte[BUFFER_SIZE];
            int read = 0;
            while ((read = zipIn.read(bytesIn)) != -1) {
                bos.write(bytesIn, 0, read);
            }
        }
    }

    private static String extractAndReturnPath(Path pathToJar) {
        final String containerFileName = "JCOBridge.zip";
        try {
            Path tmpPath = (pathToJar == null) ? Files.createTempDirectory(JCOReflector.class.getName()) : pathToJar;
            String targetFolder = tmpPath.toString();
            writeLog(String.format("Destination folder is %s", targetFolder));
            File extractedLibFile = new File(targetFolder, containerFileName);
            // Extract file into the current directory
            try (InputStream reader = JCOReflector.class.getResourceAsStream(containerFileName);
                    FileOutputStream writer = new FileOutputStream(extractedLibFile);) {
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
                return singleLoader("org.mases.jcobridge.IJCEventLog", loader)
                        && singleLoader("org.mases.jcobridge.JCException", loader);
            }
        } catch (Exception e) {
            writeLog(e.toString());
            return false;
        }
    }

    /**
     * Invoke this method to initialize JCOBridge runtime to a temporary folder
     * 
     * @return true if the runtime was initialized, otherwise see JCOReflector.log
     *         to check possible error conditions
     */
    public static boolean initialize() {
        // try extract from resources
        String path = extractAndReturnPath(null);
        if (path != null)
            return addToClasspath(new File(path, "JCOBridge.jar"));
        return false;
    }

    /**
     * Invoke this method to initialize JCOBridge runtime to a user defined folder
     * 
     * @param pathToUse The user defined path used for JCOBridge runtime
     * 
     * @return true if the runtime was initialized, otherwise see JCOReflector.log
     *         to check possible error conditions
     */
    public static boolean initialize(String pathToUse) {
        Path pathToJar = Paths.get(pathToUse);
        // try extract from resources
        String path = extractAndReturnPath(pathToJar);
        if (path != null)
            return addToClasspath(new File(path, "JCOBridge.jar"));
        return false;
    }
}
