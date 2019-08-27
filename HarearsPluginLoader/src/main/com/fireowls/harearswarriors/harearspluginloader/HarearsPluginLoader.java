package com.fireowls.harearswarriors.harearspluginloader;

import com.fireowls.harearswarriors.gameapi.GameApi;
import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.HWPLFileNotCorrectException;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.HWPLFileNotFoundException;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.JarNotDefineException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.jar.JarFile;

/**
 * Search and Load all plugins inside
 * a folder.
 */
public class HarearsPluginLoader {

    private File apisPath;
    private JarLoader jarLoader;
    private GameApi game;
    private ArrayList<HWPlugin> plugins;
    /**
     * Define the plugins folder to
     * surch all Plugins.
     * @param apisPath plugins source file.
     * @param game instance of the game
     */
    public HarearsPluginLoader(GameApi game, File apisPath) {
        this.apisPath = apisPath;
        this.jarLoader = new JarLoader(apisPath);
        this.game = game;

        plugins = new ArrayList<HWPlugin>();
    }

    /**
     * Load all plugins find inside the plugin file
     * @return a list of all plugin loaded
     */
    public List<HWPlugin> loadPlugins() {
        jarLoader.loadPluginJars();
        Iterator<JarFile> it = jarLoader.getPlugins().keySet().iterator();
        while (it.hasNext()) {
            JarFile jar = it.next();
            File file = jarLoader.getPlugins().get(jar);
            try {
                plugins.add(new PluginParser(game, jar, file).parse());
            } catch (JarNotDefineException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (HWPLFileNotCorrectException e) {
                e.printStackTrace();
            } catch (HWPLFileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return getPlugins();
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