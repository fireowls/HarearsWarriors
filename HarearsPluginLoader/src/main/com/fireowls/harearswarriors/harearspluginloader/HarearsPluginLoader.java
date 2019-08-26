package com.fireowls.harearswarriors.harearspluginloader;

import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Surch and Load all plugins inside
 * a folder.
 */
public class HarearsPluginLoader {

    private File apisPath;
    private HWPLLoader hwplLoader;
    private ArrayList<HWPlugin> plugins;
    /**
     * Define the plugins folder to
     * surch all Plugins.
     * @param apisPath plugins source file.
     */
    public HarearsPluginLoader(File apisPath) {
        this.apisPath = apisPath;
        this.hwplLoader = new HWPLLoader(apisPath);

        plugins = new ArrayList<HWPlugin>();
    }

    public List<HWPlugin> loadPlugins() {
        return null;
    }

    /**
     * Define the plugins sources file.
     * @param apisPath plugins source file.
     */
    public void setApisPath(File apisPath) {
        this.apisPath = apisPath;
    }

    /**
     * Get the plugins source file.
     * @return plugins source file.
     */
    public File getApisPath() {
        return apisPath;
    }

    /**
     * Get the list of plugins find by the launcher
     * @return plugins list
     */
    public List<HWPlugin> getPlugins() {
        return plugins;
    }

}