package com.fireowls.harearswarriors.harearspluginloader.exceptions;

/**
 * Call when the PluginParser try to parse a jar when a bad hwpl.xml file
 */
public class HWPLFileNotCorrectException extends Exception {

    public HWPLFileNotCorrectException(String jarName) {
        super("The jar "+jarName+" have a bad hwpl.xml file in source...");
    }

}
