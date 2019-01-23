package com.hillel.fmishchenkopractice.homework9.task1.domparser;

import com.hillel.fmishchenkopractice.homework9.task2.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParserToBean {
    private Person person;

    public Person parseXMLToBin(String fileName) throws IOException, SAXException, ParserConfigurationException {
        String s = ClassLoader.getSystemClassLoader().getResource(fileName).getFile();
        File xmlFile = new File(s);

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        DomParser domParser = new DomParser();
        domParser.parse(doc);


        Node root = doc.getElementsByTagName("Person").item(0);
        NodeList userAttributes = root.getChildNodes();
        Person parsedPerson = new Person();

        for (int i = 0; i < userAttributes.getLength(); i++) {
            Node node = userAttributes.item(i);
            if ("name".equals(node.getNodeName())) {
                parsedPerson.setName(node.getTextContent());
                continue;
            }
            if ("profession".equals(node.getNodeName())) {
                parsedPerson.setProfession(node.getTextContent());
                continue;
            }
            if ("email".equals(node.getNodeName())) {
                parsedPerson.setEmail(node.getTextContent());
                continue;
            }
            if ("address".equals(node.getNodeName())) {
                parsedPerson.setAdress(node.getTextContent());
                continue;
            }
            if ("age".equals(node.getNodeName())) {
                parsedPerson.setAge(node.getTextContent());
                continue;
            }

        }
        return parsedPerson;

    }
}
