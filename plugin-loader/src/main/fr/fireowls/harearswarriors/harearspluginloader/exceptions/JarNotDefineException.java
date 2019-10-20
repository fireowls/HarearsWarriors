package fr.fireowls.harearswarriors.harearspluginloader.exceptions;

import fr.fireowls.harearswarriors.harearspluginloader.PluginParser;

/**
 * Call when the PluginParser try to parse a null jar
 */
public class JarNotDefineException extends Exception {

    public JarNotDefineException(PluginParser parser) {
        super("They are no jar to parse in the PluginParser: "+parser);
    }

}
