package fr.fireowls.harearswarriors.harearsapi.utils.xml;

import java.io.File;
import java.util.List;

/**
 * XMLNode represente a Node of a XML document.
 * the node is represent by:
 * <ul>
 *     <li>a name</li>
 *     <li>a path</li>
 *     <li>a content</li>
 *     <li>some childes</li>
 * </ul>
 */
public class XMLNode {

    private File documentSource;

    private String nodeName;
    private String path;
    private String stringContent;
    private List<XMLNode> childes;

    /**
     * Create a new XMLNode
     * <strong>You don't need to create a new XMLNode in your project !</strong>
     * You can use the <code>XMLParser</code> class for convert a xml file,
     * or a String with xml code inside.
     * @param nodeName The name of the node
     * @param stringContent The content of the node
     * @param path The path of the node in the document
     * @param childes The childes of the node
     * @param documentSource The file with the xml code <span style="font-style: italic">(If the node is parsed by the <code>XMLParser</code> class with a String parameter, a temp file is created.</span>
     */
    public XMLNode(String nodeName, String stringContent, String path, List<XMLNode> childes, File documentSource) {
        this.nodeName = nodeName;
        this.stringContent = stringContent;
        this.path = path;
        this.childes = childes;
        this.documentSource = documentSource;
    }

    /**
     * This function is use by the <code>XMLDocument</code> class.<br>
     * <strong>Please use the <code>getNodesByPath(String)</code> function !</strong>
     * <hr>
     * The function add this XMLNode in the list passed in parameters if the path passed
     * in parameters match with the path of this node.<br>
     * And finally, the function call the same function for all childes of the node.
     * @param listNode the list to complete
     * @param path The path of wanted nodes
     */
    public void addChildesByPathInList(List<XMLNode> listNode, String path) {
        if (path.equals(this.path)) {
            listNode.add(this);
        }
        for (XMLNode node : childes) {
            node.addChildesByPathInList(listNode, path);
        }
    }

    /**
     * Get the name of the node
     * @return node name
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Get the content of the node
     * @return node content
     */
    public String getContent() {
        return stringContent;
    }

    /**
     * Get all childes of the node
     * @return a list the all childes
     */
    public List<XMLNode> getChildes() {
        return childes;
    }

    /**
     * Get the path of node inside the document
     * @return The node path
     */
    public String getPath() {
        return path;
    }

    /**
     * Check if the node have a child
     * @return true if the node have child(es)
     */
    public boolean haveChild() {
        return childes.size() > 0;
    }

    /**
     * Get the File when provide the node.
     * <span class="text-style: italic">If the node come from a String content,
     * the document source should be a <strong>temporary file</strong>
     * and risk to be <strong>deleted</strong>.</span>
     * @return the XML file
     */
    public File getDocumentSource() {
        return documentSource;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof XMLNode
                && ((XMLNode) obj).getDocumentSource().equals(documentSource)
                && ((XMLNode) obj).getNodeName().equals(nodeName)
                && ((XMLNode) obj).getPath().equals(path)
                && ((XMLNode) obj).getChildes().equals(childes);
    }

    /**
     * Convert the XMLNode to XML code
     * @return String code
     */
    @Override
    public String toString() {
        String toString = "<"+nodeName+">"+((!haveChild()) ? stringContent : "");
        for (XMLNode child : childes) {
            toString+=child.toString();
        }
        toString+="</"+nodeName+">";
        return toString;
    }

}
