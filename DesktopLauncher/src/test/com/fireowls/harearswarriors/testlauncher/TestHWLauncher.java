package com.fireowls.harearswarriors.testlauncher;

import com.fireowls.harearswarriors.launcher.HWLauncher;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestHWLauncher {

    @Test
    public final void testTitleApp() {
        HWLauncher launcher = new HWLauncher();
        assertEquals(launcher.TITLE, "HarearsWarriors");
    }

}
