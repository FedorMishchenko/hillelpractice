package com.hillel.fmishchenkopractice.homework8task1;


import java.io.*;



public class Demo {
    public static void main(String[] args) throws IOException {


        String s = ClassLoader.getSystemClassLoader().getResource("resources.properties").getFile();
        File f = new File(s);
        BufferedReader reader = new BufferedReader(new FileReader(s));
        System.out.println(reader.readLine());


        /* new ReaderManager(new CharReader2()).read();*/

    }


}

