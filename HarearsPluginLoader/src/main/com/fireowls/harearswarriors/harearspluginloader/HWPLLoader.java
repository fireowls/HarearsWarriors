package com.fireowls.harearswarriors.harearspluginloader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

/**
 * HWPLLoader load all jar in a file
 */
public class HWPLLoader {

    private List<JarFile> jars;
    private File file;

    /**
     * Create a new HWPLLoader
     * @param file file contains all jar
     */
    public HWPLLoader(File file) {
        if (file.isDirectory())
            this.file = file;
        else
            this.file = file.getParentFile();
        jars = new ArrayList<>();
    }

    /**
     * Load all plugins
     */
    public void loadPlugins() {
        for (File child : file.listFiles()) {
            if (child.getName().endsWith(".jar")) {
                try {
                    JarFile jar = new JarFile(child);
                    if (jarIsPlugin(jar)) {
                        jars.add(jar);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
    public List<JarFile> getPlugins() {
        return jars;
    }


}
