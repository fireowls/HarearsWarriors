package fr.fireowls.harearswarriors.harearsapi.utils;

import fr.fireowls.harearswarriors.harearsapi.GameApi;

import java.io.File;

public class GameApiUtils {

    public static final String HOME_DIR = new File(GameApi.class.getProtectionDomain().getCodeSource().getLocation().getFile()).getParentFile().getParent();
    public static final String LIB_DIR = HOME_DIR + "/lib";
    public static final String PLUGIN_DIR = HOME_DIR + "/plugins";
    public static final String BIN_DIR = HOME_DIR + "/bin";

}
