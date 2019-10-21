package fr.fireowls.harearswarriors.server;

import fr.fireowls.harearswarriors.harearsapi.GameApi;
import fr.fireowls.harearswarriors.harearsapi.plugin.HWPlugin;
import fr.fireowls.harearswarriors.harearsapi.utils.GameApiUtils;
import fr.fireowls.harearswarriors.harearspluginloader.HarearsPluginLoader;
import fr.fireowls.harearswarriors.server.properties.ServerProperties;

import java.io.File;

public class HarearsWarriorsServer {

    public static final String PROPERTIES_PATH = GameApiUtils.HOME_DIR + "/server.properties.xml";

    public static GameApi api;
    public static ServerProperties properties;
    public static HarearsPluginLoader pluginLoader;

    public static void main(String[] args) {
        api = new GameApi();
        properties = new File(PROPERTIES_PATH).exists() ?
                new ServerProperties(new File(PROPERTIES_PATH)) :
                new ServerProperties();
        pluginLoader = new HarearsPluginLoader(api, new File(GameApiUtils.PLUGIN_DIR+"/"));
        pluginLoader.loadPlugins();

        pluginLoader.getPlugins().stream()
                .map(x -> x.getName()).forEach(System.out::println);

    }



}