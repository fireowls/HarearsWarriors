package com.fireowls.harearswarriors.testgameapi.utils.xml;

import com.fireowls.harearswarriors.gameapi.utils.xml.PathNotCorrectException;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLDocument;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLNode;
import com.fireowls.harearswarriors.gameapi.utils.xml.XMLParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestXMLDocument {

    private File file;

    @Before
    public final void initXml() {
        file = new File("assets/xml/parser-test.xml");
    }

    @Test
    public final void testXmlDocument() {
        XMLParser xmlParser = new XMLParser(file);
        XMLDocument document = xmlParser.parse();

        assertEquals(document.getNodesByPath("root/elem/sub-elem").get(0).getContent(), "I'm a sub Elem");

    }

}
