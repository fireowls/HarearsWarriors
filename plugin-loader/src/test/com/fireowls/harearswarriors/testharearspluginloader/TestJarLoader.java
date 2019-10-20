package com.fireowls.harearswarriors.testharearspluginloader;

import java.io.File;

import com.fireowls.harearswarriors.harearspluginloader.JarLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestJarLoader {

    private JarLoader loader;
    private File source;

    @Before
    public final void initTest() {
        source = new File("assets/jars");
        loader = new JarLoader(source);
    }

    @Test
    public final void testHWPLLoader() {
        assertTrue(source.exists());
        loader.loadPluginJars();

        assertEquals(loader.getFile(), source);
        assertEquals(loader.getPlugins().size(), 1);
    }
}
