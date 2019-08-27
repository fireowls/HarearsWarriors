package com.fireowls.harearswarriors.testharearspluginloader;

import com.fireowls.harearswarriors.gameapi.GameApi;
import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;
import com.fireowls.harearswarriors.harearspluginloader.HarearsPluginLoader;
import com.fireowls.harearswarriors.harearspluginloader.PluginParser;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.HWPLFileNotCorrectException;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.HWPLFileNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;

import static org.junit.Assert.assertEquals;

public class TestPluginParser {

    private HarearsPluginLoader loader;

    @Before
    public final void initTests() {
        loader = new HarearsPluginLoader(new GameApi(), new File("jars"));
    }

    @Test
    public final void testParser() {
        PluginParser parser = new PluginParser();

        try {
            File file = new File("assets/jars/HarearsWarriors-1.0.jar");
            HWPlugin plugin = parser.parse(new GameApi(), new JarFile(file), file);

            assertEquals(plugin.getName(), "Test HarearsWarriors");
            assertEquals(plugin.getVersion(), "1.0");
            assertEquals(plugin.getGroups().size(), 1);
            assertEquals(plugin.getGroups().get(0), "fireowls team");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (HWPLFileNotCorrectException e) {
            e.printStackTrace();
        } catch (HWPLFileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
