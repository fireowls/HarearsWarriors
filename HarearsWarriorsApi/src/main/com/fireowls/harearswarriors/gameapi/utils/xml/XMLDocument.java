package com.fireowls.harearswarriors.gameapi.utils.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * XMLDocument represent a XML document with some nodes, ect...
 * You can access to all of then by the path of the node.
 */
public class XMLDocument {

    private String rootName;
    private XMLNode root;

    /**
     * Create a new XMLDocument
     * @param root The root node of the document
     */
    public XMLDocument(XMLNode root) {
        rootName = root.getNodeName();
        this.root = root;
    }

    /**
     * Get all nodes matched by the path
     * @param path The paths of nodes
     * @return List of nodes with the right path
     */
    public List<XMLNode> getNodesByPath(String path) {
        ArrayList<XMLNode> list = new ArrayList<XMLNode>();
        root.addChildesByPathInList(list, path+"/");
        return list;
    }

    public XMLNode getFirstIterationNodeByPath(String path) throws PathNotCorrectException {
        List<XMLNode> list = getNodesByPath(path);
        if (list.size() == 0)
            throw new PathNotCorrectException(path, root.getDocumentSource());
        return list.get(0);
    }

    /**
     * Get the root node name
     * @return String contain the root node name
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * Get the root node
     * @return XMLNode object
     */
    public XMLNode getRoot() {
        return root;
    }

}
