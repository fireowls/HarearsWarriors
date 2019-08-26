package com.fireowls.harearswarriors.harearspluginloader;

import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;
import com.fireowls.harearswarriors.gameapi.utils.xml.PathNotCorrectException;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLDocument;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLParser;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.JarNotDefineException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/**
 * PluginParser class take one JarFile and return an
 * HWPlugin if the jar is compatible
 */
public class PluginParser {

    private JarFile jar;

    /**
     * Create a new PluginParser
     */
    public PluginParser() {
        this.jar = null;
    }

    /**
     * Create a new PluginParser
     * @param jar the JarFile to parse
     */
    public PluginParser(JarFile jar) {
        this.jar = jar;
    }

    /**
     * Parse the JarFile to a HWPlugin
     * if is posible
     * @return The jar parsed to plugin
     * @exception JarNotDefineException
     */
    public HWPlugin parse() throws JarNotDefineException, IOException {
        if (jar != null)
            return parse(jar);
        throw new JarNotDefineException(this);
    }

    /**
     * Parse the JarFile to a HWPlugin
     * @param jar The jar to parse
     * @return The jar parsed to plugin
     */
    public HWPlugin parse(JarFile jar) throws IOException {
        JarEntry entry = jar.getJarEntry("hwpl.xml");
        String hwplContent = readInputStream(jar.getInputStream(entry));

        XMLDocument document = new XMLParser(hwplContent).parse();

        try {
            String name = document.getFirstIterationNodeByPath("plugin/name").getContent();
            String version = document.getFirstIterationNodeByPath("plugin/version").getContent();
            String main = document.getFirstIterationNodeByPath("plugin/main").getContent();
            List<String> author = document.getNodesByPath("plugin/authors/author").stream()
                    .map(x -> x.getContent()).collect(Collectors.toList());

        } catch (PathNotCorrectException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Read the content of an InputStream
     * @param inputStream The InputStream to read
     * @return the content of the inputStream
     */
    private String readInputStream(InputStream inputStream) throws IOException {
        String content = "";
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            content+=scanner.nextLine();
        }
        inputStream.close();
        return content;
    }



}
