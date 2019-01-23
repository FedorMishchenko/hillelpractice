package com.hillel.fmishchenkopractice.homework8;


import java.io.*;


/**
 * Dictionary realisation
 */
public class Demo {
    public static void main(String[] args) throws IOException {


        String s = ClassLoader.getSystemClassLoader().getResource("resources_en.properties").getFile();
        File f = new File(s);
        BufferedReader reader = new BufferedReader(new FileReader(s));
        System.out.println(reader.readLine());


        /* new ReaderManager(new CharReader2()).read();*/

    }


}

