package fr.fireowls.harearswarriors.harearsapi.utils.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

/**
 * XMLParser can parse an XML file or a String content XMLCode
 * to a XMLDocument Object
 */
public class XMLParser {

    //TODO ajouter parseur par String

    private File file;
    private Document document;

    private String id = null;

    /**
     * Create a new XMLParser
     */
    public XMLParser() {
        file = null;
    }

    /**
     * Create a new XMLParser
     * @param file File containt a XML code
     */
    public XMLParser(File file) {
        this.file = file;
    }

    /**
     * Create a new XMLParser
     * @param xml XML code in String
     */
    public XMLParser(String xml) {
        new File(".xmlparser").mkdirs();
        id = "doc"+System.nanoTime();
        File temp = new File(".xmlparser/"+id+".xml");
        try {
            temp.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (
                FileOutputStream fos = new FileOutputStream(temp.getAbsoluteFile());
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                PrintWriter pw = new PrintWriter(bos);
        ) {
            pw.print(xml);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.file = temp;
    }

    /**
     * Parse the File or the String to a document
     * @return XMLDocoument parsed
     */
    public XMLDocument parse() {
        return parse(file);
    }

    /**
     * Parse xml code inside a String to a XMLDocument
     * @param xml the xml code to parse
     * @return a new XMLDocument
     */
    public XMLDocument parse(String xml) {
        return new XMLParser(xml).parse();
    }

    /**
     * Parse a file than contain XML code to a XMLDocument
     * @param file File that contain the code
     * @return a new XMLDocument
     */
    public XMLDocument parse(File file) {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element element = document.getDocumentElement();
        XMLDocument doc = new XMLDocument(parseNode(element, ""));
        if (id != null) new File(".xmlparser/"+id+".xml").deleteOnExit();
        return doc;
    }

    private XMLNode parseNode(Node node, String path) {
        NodeList nodeList = node.getChildNodes();
        ArrayList<XMLNode> nodes = new ArrayList<XMLNode>();
        path+=node.getNodeName()+"/";
        for (int i = 0 ; i < nodeList.getLength() ; i++) {
            if (!nodeList.item(i).getNodeName().startsWith("#"))
                nodes.add(parseNode(nodeList.item(i), path));
        }
        return new XMLNode(node.getNodeName(), node.getTextContent(), path, nodes, file);
    }

    /**
     * Get the file to parse
     * @return the File to parse
     */
    public File getFile() {
        return file;
    }

}
