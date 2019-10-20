package com.fireowls.harearswarriors.harearspluginloader;

import com.fireowls.harearswarriors.gameapi.GameApi;
import com.fireowls.harearswarriors.gameapi.plugin.HWPlugin;
import com.fireowls.harearswarriors.gameapi.utils.xml.PathNotCorrectException;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLDocument;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLParser;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.HWPLFileNotCorrectException;
import com.fireowls.harearswarriors.harearspluginloader.exceptions.HWPLFileNotFoundException;
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
    private File file;
    private GameApi game;

    /**
     * Create a new PluginParser
     */
    public PluginParser() {
        this.jar = null;
        this.file = null;
        this.game = null;
    }

    /**
     * Create a new PluginParser
     * @param jar the JarFile to parse
     * @param file the file path to the jar
     * @param game instance of GameApi
     */
    public PluginParser(GameApi game, JarFile jar, File file) {
        this.jar = jar;
        this.file = file;
        this.game = game;
    }

    /**
     * Parse the JarFile to a HWPlugin
     * if is posible
     * @throws IOException io excepetion
     * @throws HWPLFileNotCorrectException if the hwpl.xml file is not correct
     * @throws HWPLFileNotFoundException if the hwpl.xml file is not find
     * @exception JarNotDefineException if the jar or the file is not define
     * @return The jar parsed to plugin
     */
    public HWPlugin parse() throws JarNotDefineException, IOException, HWPLFileNotCorrectException, HWPLFileNotFoundException {
        if (jar != null && file != null)
            return parse(game, jar, file);
        throw new JarNotDefineException(this);
    }

    /**
     * Parse the JarFile to a HWPlugin
     * @param jar The jar to parse
     * @param file the file path to the jar
     * @param game instance of GameApi
     * @throws IOException io excepetion
     * @throws HWPLFileNotCorrectException if the hwpl.xml file is not correct
     * @throws HWPLFileNotFoundException if the hwpl.xml file is not find
     * @return The jar parsed to plugin
     */
    public HWPlugin parse(GameApi game, JarFile jar, File file) throws IOException, HWPLFileNotCorrectException, HWPLFileNotFoundException {
        JarEntry entry = jar.getJarEntry("hwpl.xml");
        if (entry == null) throw new HWPLFileNotFoundException(jar);
        String hwplContent = readInputStream(jar.getInputStream(entry));

        XMLDocument document = new XMLParser(hwplContent).parse();

        try {
            String name = document.getFirstIterationNodeByPath("plugin/name").getContent();
            String version = document.getFirstIterationNodeByPath("plugin/version").getContent();
            String main = document.getFirstIterationNodeByPath("plugin/main").getContent();
            List<String> author = document.getNodesByPath("plugin/authors/author").stream()
                    .map(x -> x.getContent()).collect(Collectors.toList());

            PluginLoader<HWPlugin> loader = new PluginLoader<HWPlugin>();
            HWPlugin plugin = loader.LoadClass(file.getParentFile().getAbsolutePath(), main, HWPlugin.class);

            plugin.setName(name);
            plugin.setVersion(version);
            plugin.setGroup(author);

            System.out.println("Load plugin "+plugin.getName());

            plugin.onLoad(game);

            return plugin;

        } catch (PathNotCorrectException | ClassNotFoundException  e) {
            e.printStackTrace();
        }

        throw new HWPLFileNotCorrectException(jar.getName());
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

    public HWPlugin getPlugin(String name) {
        return null;
    }



}
