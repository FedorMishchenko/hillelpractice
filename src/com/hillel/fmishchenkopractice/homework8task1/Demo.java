package com.hillel.fmishchenkopractice.homework8task1;


import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        System.setProperty("console.encoding", "UTF-8");
        new ReaderManager(new CharReader()).read();
    }
}
