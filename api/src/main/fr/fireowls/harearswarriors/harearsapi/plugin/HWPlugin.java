package fr.fireowls.harearswarriors.harearsapi.plugin;

import fr.fireowls.harearswarriors.harearsapi.GameApi;

import java.util.List;

/**
 * The plugin plugin class is the main class for a plugin.
 */
public abstract class HWPlugin {

    /**
     * define the name
     */
    protected String name;
    /**
     * define the version
     */
    protected String version;
    /**
     * define the groups
     */
    protected List<String> groups;

    /**
     * function call when the plugin is loaded
     * @param gameApi The instance of gameApi loaded by the launcher
     */
    public abstract void onLoad(GameApi gameApi);

    /**
     * function call when the plugin is started.
     */
    public abstract void onStart();

    /**
     * function call when the plugin si stoped
     */
    public abstract void onStop();

    /**
     * Set name
     * @param name Name of the plugin
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set version
     * @param version Version of the plugin
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Set group
     * @param groups Group of the plugin
     */
    public void setGroup(List<String> groups) {
        this.groups = groups;
    }

    /**
     * @return plugin name
     */
    public String getName() {
        return name;
    }

    /**
     * @return plugin version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @return plugin group
     */
    public List<String> getGroups() {
        return groups;
    }

}
