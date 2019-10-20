package com.fireowls.harearswarriors.testgameapi.utils.xml;

import com.fireowls.harearswarriors.harearsapi.utils.xml.XMLDocument;
import com.fireowls.harearswarriors.harearsapi.utils.xml.XMLNode;
import com.fireowls.harearswarriors.harearsapi.utils.xml.XMLParser;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestXMLNode {

    private File xmlParserTest1;
    private XMLDocument document;

    @Before
    public final void initTests() {
        xmlParserTest1 = new File("assets/xml/parser-test.xml");
        document = new XMLParser(xmlParserTest1).parse();
    }

    @Test
    public final void testXMLNodeRoot() {
        XMLNode root = document.getRoot();
        XMLNode pathRoot = document.getNodesByPath("root").get(0);

        assertEquals(root.getNodeName(), "root");
        assertEquals(root.getNodeName(), pathRoot.getNodeName());
        assertEquals(root.getChildes(), pathRoot.getChildes());
        assertEquals(root.getContent(), pathRoot.getContent());
        assertEquals(root.getDocumentSource(), pathRoot.getDocumentSource());
        assertEquals(root.getPath(), pathRoot.getPath());
        assertEquals(root, pathRoot);

        System.out.println(root);
    }

    @Test
    public final void testAddChildesByPathInList() {
        List<XMLNode> testedList = new ArrayList<>();
        XMLNode root = document.getRoot();
        root.addChildesByPathInList(testedList, "root/elem/sub-elem/");
        assertEquals(testedList.size(), 2);
    }

}
