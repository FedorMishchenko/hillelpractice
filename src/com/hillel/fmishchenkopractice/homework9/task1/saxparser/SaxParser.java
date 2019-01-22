package com.hillel.fmishchenkopractice.homework9.task1.saxparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParser {

    /**
     * main method
     */
    public void parseSax(String path) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            DefaultHandler defaultHandler = new DefaultHandler() {
                boolean aIndex = false;
                boolean bIndex = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Start element: " + qName);
                    if (qName.equalsIgnoreCase("Country")) {
                        aIndex = true;
                    }
                    if (qName.equalsIgnoreCase("Name")) {
                        bIndex = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("End element: " + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (aIndex) {
                        System.out.println("country: " + new String(ch, start, length));
                        bIndex = false;
                    }
                    if (bIndex) {
                        System.out.println("name: " + new String(ch, start, length));
                        bIndex = false;
                    }
                }
            };
            String s = ClassLoader.getSystemClassLoader().getResource("usa.xml").getFile();
            File xmlFile = new File(s);
            saxParser.parse(xmlFile, defaultHandler);
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
        }
    }
}