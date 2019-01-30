package com.hillel.fmishchenkopractice.homework8;


/**
 * Dictionary realisation
 */
public class Demo {
    public static void main(String[] args){


    /*    String s = ClassLoader.getSystemClassLoader().getResource("resources_en.properties").getFile();
        File f = new File(s);
        BufferedReader reader = new BufferedReader(new FileReader(s));
        System.out.println(reader.readLine());*/
        new ReaderManager(new CharReader2()).process();

    }


}

