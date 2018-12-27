package com.hillel.fmishchenkopractice.homework7task2;



public class Demo {
    public static void main(String[] args) {
        Reader reader = new Reader();
        reader.read();
        System.out.println();
        System.out.println(reader.list.toString());
        System.out.println();
        new OutputMinMax().wordsMinMax(reader.text);
    }
}
