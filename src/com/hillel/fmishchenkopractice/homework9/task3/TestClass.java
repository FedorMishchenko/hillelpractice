package com.hillel.fmishchenkopractice.homework9.task3;

import com.hillel.fmishchenkopractice.homework9.task1.domparser.DomParser2;
import com.hillel.fmishchenkopractice.homework9.task2.User;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


public class TestClass {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        User user;
        DomParser2 parser = new DomParser2();
        user = parser.parseXMLToBin("obama.xml");
        System.out.println(user.toString());
    }

}
