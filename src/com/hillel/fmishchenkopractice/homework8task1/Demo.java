package com.hillel.fmishchenkopractice.homework8task1;


public class Demo {
    public static void main(String[] args) /*throws IOException*/ {
        System.setProperty("console.encoding","UTF-8");
        /*Reader reader = new CharReader();*/
        /*Reader reader = new CharArrayReader();*/
        Reader reader = new ByteReader();
        /*Reader reader = new ByteArrayReader();*/
        reader.read();
    }
}
