package com.hillel.fmishchenkopractice.homework7task2;


import java.io.IOException;

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
