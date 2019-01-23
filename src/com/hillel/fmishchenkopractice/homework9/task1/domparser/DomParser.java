package com.hillel.fmishchenkopractice.homework9.task1.domparser;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;


/**
 * DOM Parser realisation
 */
public class DomParser {

    public String parse(Document input) {
        return parseNode(input.getDocumentElement());
    }

    private String parseNode(Node node) {

        if (node.getNodeName().equals("#text"))
            return "";

        StringBuffer result = new StringBuffer();

        result.append("Element name = '" + node.getNodeName() + "'\n");

        NamedNodeMap nodeMap = node.getAttributes();

        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                result.append("Attribute name = '" + nodeMap.item(i).getNodeName()
                        + "'; Attribute value = '" + nodeMap.item(i).getNodeValue() + "'\n");
            }
        }

        if (getElementContent(node) != null && !(getElementContent(node).equals("")))
            result.append("Element content = '" + getElementContent(node) + "'\n");

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            result.append(parseNode(nodeList.item(i)));
        }

        result.append("Element closed, name = '" + node.getNodeName() + "'\n");

        return result.toString();
    }

    private String getElementContent(Node node) {

        Node contentNode = node.getFirstChild();
        if (contentNode != null)

            if (contentNode.getNodeName().equals("#text")) {
                String value = contentNode.getNodeValue();
                if (value != null)
                    return value.trim();
            }
        return null;
    }

    /**
     * main method
     */
    public void parseXML(String fileName) {
        fileName = "eng.xml";
        String s = ClassLoader.getSystemClassLoader().getResource(fileName).getFile();
        File xmlFile = new File(s);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            DomParser domParser = new DomParser();
            System.out.println("DOM parser result:\n" + domParser.parse(doc));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
