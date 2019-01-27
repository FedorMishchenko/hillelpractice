package com.hillel.fmishchenkopractice.homework9.task1.domparser;

import com.hillel.fmishchenkopractice.homework9.task2.Person;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class DOMParserDemo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Person person;
        Person person2;
        XMLDomParser parser = new XMLDomParser();
        person = parser.parseXML("obama.xml");
        person2 = parser.parseXML("bush.xml");
        System.out.println(person.toString());
        System.out.println(person2.toString());
    }

}
