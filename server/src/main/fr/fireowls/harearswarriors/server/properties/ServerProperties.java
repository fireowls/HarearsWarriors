package fr.fireowls.harearswarriors.server.properties;

import fr.fireowls.harearswarriors.harearsapi.utils.files.FileDocument;
import fr.fireowls.harearswarriors.harearsapi.utils.xml.PathNotCorrectException;
import fr.fireowls.harearswarriors.harearsapi.utils.xml.XMLDocument;
import fr.fireowls.harearswarriors.harearsapi.utils.xml.XMLParser;

import java.io.File;

public class ServerProperties {

    private String name;
    private String ip;

    public ServerProperties() {
        FileDocument file = new FileDocument("server.properties.xml");
        file.println(
                "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>",
                "<server>",
                "   <name>my-server</name>",
                "   <ip>localhost</ip>",
                "</server>"
        );
        file.close();
        parse(file.getFile());
    }

    public ServerProperties(File file) {
        parse(file);
    }

    private void parse(File file) {
        XMLDocument document = new XMLParser(file).parse();
        try {

            name = document.getFirstIterationNodeByPath("server/name").getContent();
            ip = document.getFirstIterationNodeByPath("server/ip").getContent();

        } catch (PathNotCorrectException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }
}
