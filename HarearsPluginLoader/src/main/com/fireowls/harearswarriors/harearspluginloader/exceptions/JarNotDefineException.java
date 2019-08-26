package com.fireowls.harearswarriors.harearspluginloader.exceptions;

import com.fireowls.harearswarriors.harearspluginloader.PluginParser;

public class JarNotDefineException extends Exception {

    public JarNotDefineException(PluginParser parser) {
        super("They are no jar to parse in the PluginParser: "+parser);
    }

}
