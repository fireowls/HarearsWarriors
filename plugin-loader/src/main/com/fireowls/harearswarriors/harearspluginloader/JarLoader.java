package com.fireowls.harearswarriors.harearspluginloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarFile;

/**
 * HWPLLoader load all jar in a file
 */
public class JarLoader {

    private HashMap jars;
    private File file;

    /**
     * Create a new HWPLLoader
     * @param file file contains all jar
     */
    public JarLoader(File file) {
        this.file = (file.isDirectory()) ? file : file.getParentFile();
        jars = new HashMap<JarFile, File>();
    }

    /**
     * Load all plugins
     * @return jars list
     */
    public Map<JarFile, File> loadPluginJars() {
        for (File child : file.listFiles()) {
            if (child.getName().endsWith(".jar")) {
                try {
                    JarFile jar = new JarFile(child);
                    if (jarIsPlugin(jar)) {
                        jars.put(jar, child);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jars;
    }

    private boolean jarIsPlugin(JarFile jar) {
        return jar.getJarEntry("hwpl.xml") != null;
    }

    /**
     * Get the source File
     * @return source file
     */
    public File getFile() {
        return file;
    }

    /**
     * Get the plugins find in the folder
     * @return plugins list
     */
    public HashMap<JarFile, File> getPlugins() {
        return jars;
    }


}
