package com.fireowls.harearswarriors.testgameapi.utils.xml;

import com.fireowls.harearswarriors.gameapi.utils.xml.XMLDocument;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLNode;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestXMLParser {

    private File xmlParserTest1;
    private String code;

    @Before
    public final void initTest() {
        xmlParserTest1 = new File("assets/xml/parser-test.xml");
        code = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<plugin>\n" +
                "    <name>Test HarearsWarriors</name>\n" +
                "    <version>1.0</version>\n" +
                "    <main>com.fireowls.harearswarriors.HarearsWarriors</main>\n" +
                "    <authors>\n" +
                "        <author>fireowls team</author>\n" +
                "    </authors>\n" +
                "</plugin>";

    }

    @Test
    public final void testFileExist() {
        assertTrue(xmlParserTest1.exists());
    }

    @Test
    public final void testXmlParser() {
        XMLParser xmlParser = new XMLParser(xmlParserTest1);
        XMLDocument document = xmlParser.parse();

        assertEquals(document.getRootName(), "root");

        XMLNode root = document.getRoot();
        assertEquals(root.getChildes().size(), 2);
    }

    @Test
    public final void testXmlParserString() {
        XMLParser parser = new XMLParser(code);

        XMLDocument document = parser.parse();

        assertNotNull(document);
        assertEquals(document.getNodesByPath("plugin/version").get(0).getContent(), "1.0");
    }

    @Test
    public final void textXmlParserNoArg() {

        XMLParser xmlParser = new XMLParser();
        XMLDocument document = xmlParser.parse(xmlParserTest1);

        assertEquals(document.getRootName(), "root");

        XMLNode root = document.getRoot();
        assertEquals(root.getChildes().size(), 2);

    }

    @Test
    public final void textXmlParserNoArg2() {
        XMLParser xmlParser = new XMLParser();
        XMLDocument document = xmlParser.parse(code);

        assertEquals(document.getRootName(), "plugin");
    }

}
