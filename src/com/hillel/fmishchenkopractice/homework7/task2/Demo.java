package com.hillel.fmishchenkopractice.homework7.task2;


import java.io.IOException;

/**
 * Output min/max
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        reader.read();
        System.out.println();
        System.out.println(reader.list.toString());
        System.out.println();
        new OutputMinMax().wordsMinMax(reader.text);
    }
}