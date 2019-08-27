package com.fireowls.harearswarriors.harearspluginloader.exceptions;

/**
 * Call when the PluginParser try to parse a jar when a bad hwpl.xml file
 */
public class HWPLFileNotCorrectException extends Exception {

    public HWPLFileNotCorrectException(String jarName) {
        super("The jar "+jarName+" have a bad hwpl.xml file in source...\n" +
                "You should create a node for:\n" +
                "   - name\n" +
                "   - version\n" +
                "   - main\n" +
                "   - authors\n" +
                "Please check you code and fix it !");
    }

}
