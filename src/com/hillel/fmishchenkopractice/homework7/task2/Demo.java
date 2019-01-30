package com.hillel.fmishchenkopractice.homework7.task2;


import java.io.IOException;

/**
 * Output min/max
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        TextHandler handler = new TextHandler();
        handler.process();
        System.out.println();
        System.out.println(handler.list.toString());
        System.out.println();
        new OutputMinMax().wordsMinMax(handler.text);
    }
}
