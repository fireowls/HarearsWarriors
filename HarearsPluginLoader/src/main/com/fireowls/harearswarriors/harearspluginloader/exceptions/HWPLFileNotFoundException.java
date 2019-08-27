package com.fireowls.harearswarriors.harearspluginloader.exceptions;

import java.util.jar.JarFile;

/**
 * Call when The PluginParser try to parse a plugin with no hwpl.xml file
 */
public class HWPLFileNotFoundException extends Exception {

    public HWPLFileNotFoundException(JarFile jar) {
        super("No hwpl.xml file find in "+jar.getName()+"...");
    }

}
