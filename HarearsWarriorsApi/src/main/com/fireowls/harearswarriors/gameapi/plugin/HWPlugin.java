package com.fireowls.harearswarriors.gameapi.plugin;

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
     * define the group
     */
    protected String group;

    /**
     * methode call when the plugin is stated.
     */
    public abstract void onStart();

    /**
     * methode call when the plugin si stoped
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
     * @param group Group of the plugin
     */
    public void setGroup(String group) {
        this.group = group;
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
    public String getGroup() {
        return group;
    }

}
