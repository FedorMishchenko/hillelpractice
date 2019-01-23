package com.hillel.fmishchenkopractice.homework9.task1.domparser;

import com.hillel.fmishchenkopractice.homework9.task2.User;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser2 {
    User user;

    public User parseXMLToBin(String fileName) throws IOException, SAXException, ParserConfigurationException {
        String s = ClassLoader.getSystemClassLoader().getResource(fileName).getFile();
        File xmlFile = new File(s);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        DomParser domParser = new DomParser();
        domParser.parse(doc);


        Node u = doc.getElementsByTagName("user").item(0);
        NodeList userAttributes = u.getChildNodes();
        User parsedUser = new User();

        for (int i = 0; i < userAttributes.getLength(); i++) {
            Node node = userAttributes.item(i);
            if ("name".equals(node.getNodeName())) {
                parsedUser.setName(node.getTextContent());
                continue;
            }
            if ("profession".equals(node.getNodeName())) {
                parsedUser.setProfession(node.getTextContent());
                continue;
            }
            if ("email".equals(node.getNodeName())) {
                parsedUser.setEmail(node.getTextContent());
                continue;
            }
            if ("adress".equals(node.getNodeName())) {
                parsedUser.setAdress(node.getTextContent());
                continue;
            }

        }
        return parsedUser;

    }
}
