package com.fireowls.harearswarriors.testharearspluginloader;

import java.io.File;

import com.fireowls.harearswarriors.harearspluginloader.HWPLLoader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestHWPLLoader {

    private HWPLLoader loader;
    private File source;

    @Before
    public final void initTest() {
        source = new File("assets/jars");
        loader = new HWPLLoader(source);
    }

    @Test
    public final void testHWPLLoader() {
        assertTrue(source.exists());
        loader.loadPlugins();
        assertEquals(loader.getPlugins().size(), 1);
    }
}
