package com.hillel.fmishchenkopractice.homework9.task3;

import com.hillel.fmishchenkopractice.homework9.task1.domparser.DomParser2;
import com.hillel.fmishchenkopractice.homework9.task2.Person;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class Demo {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Person person;
        DomParser2 parser = new DomParser2();
        person = parser.parseXMLToBin("obama.xml");
        System.out.println(person.toString());
    }

}
