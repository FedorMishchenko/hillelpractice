package com.hillel.fmishchenkopractice.homework9.task3;

import com.hillel.fmishchenkopractice.homework9.task1.domparser.DomParser;
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

import java.util.HashMap;
import java.util.Map;

@Service(name = "Service",
        lazyLoad = false)
public class UserService {
    Class<?> clazz = Class.forName("com.hillel.fmishchenkopractice.homework9.task2.Person");
    Person person;
    String fileName = "obama.xml";
    Map<String,String> valueFromXML = new HashMap<>();
    Map<String,Object> entities = new HashMap<>();

    public UserService() throws ClassNotFoundException {
    }

    @Init(suppressException = true)
    public void initService() throws IOException,
            SAXException, ParserConfigurationException {
        System.out.println("initService");
        Document doc = getDocument(fileName);
        Node root = doc.getElementsByTagName("Person").item(0);
        NodeList userAttributes = root.getChildNodes();
        fillMap(userAttributes, valueFromXML);
    }
    @InitObject
    public void initObject() throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        Object object = clazz.newInstance();
        person = (Person) object;
        person.setName(valueFromXML.get("name"));
        person.setEmail(valueFromXML.get("email"));
        person.setAddress(valueFromXML.get("address"));
        person.setAge(valueFromXML.get("age"));
        person.setProfession(valueFromXML.get("profession"));
        entities.put(clazz.getName(),person);
        System.out.println("initObject");
        System.out.println("put in map: " + entities.get(clazz.getName()).toString());
    }

    private void fillMap(NodeList userAttributes, Map<String, String> map) {
        for (int i = 0; i < userAttributes.getLength(); i++) {
            Node node = userAttributes.item(i);
            if ("name".equals(node.getNodeName())) {
                map.put(("name"),node.getTextContent());
                continue;
            }
            if ("email".equals(node.getNodeName())) {
                map.put(("email"),node.getTextContent());
                continue;
            }
            if ("address".equals(node.getNodeName())) {
                map.put(("address"),node.getTextContent());
                continue;
            }
            if ("profession".equals(node.getNodeName())) {
                map.put(("profession"),node.getTextContent());
                continue;
            }
            if ("age".equals(node.getNodeName())) {
                map.put(("age"),node.getTextContent());
                continue;
            }
        }
        System.out.println("fillMap");

    }
    
    private Document getDocument(String fileName) throws ParserConfigurationException,
            SAXException, IOException {
        String s = ClassLoader.getSystemClassLoader().getResource(fileName).getFile();
        File xmlFile = new File(s);

        System.out.println("getDocument");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();
        DomParser domParser = new DomParser();
        domParser.parse(doc);
        return doc;
    }
}
