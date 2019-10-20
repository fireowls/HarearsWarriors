package com.fireowls.harearswarriors.testharearspluginloader;

import com.fireowls.harearswarriors.gameapi.GameApi;
import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;
import com.fireowls.harearswarriors.harearspluginloader.HarearsPluginLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;

public class TestHarearsPluginLoader {

    private File sourcePlugins;

    @Before
    public final void initTests() {
        sourcePlugins = new File("assets/jars");
    }

    @Test
    public final void testHarearsLauncher() {
        HarearsPluginLoader loader = new HarearsPluginLoader(new GameApi(), sourcePlugins);
        loader.loadPlugins();

        assertEquals(loader.getPlugins().size(), 1);
        assertEquals(loader.getApisPath(), sourcePlugins);
    }
}
