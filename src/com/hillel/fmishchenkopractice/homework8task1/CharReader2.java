package com.hillel.fmishchenkopractice.homework8task1;

import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class CharReader2 extends Reader {
    Dictionary dictionary = Dictionary.getInstance();
    StringBuilder builder = new StringBuilder();
    InputStreamReader reader;

    {
        try {
            reader = new InputStreamReader(in, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    String command;
    String strE;
    String strR;

    void read(){

        while (true) {
            input();
            switch (command) {
                case "add":
                    add();
                    break;
                case "tr":
                    translate();
                    break;
                case "exit":
                    exit();
                default:
                    out.println("Illegal argument: " + command
                            + '\n' +
                            "Try input again.");
                    break;
            }
        }

    }

    private void exit(){
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void input() {
        builder.delete(0, builder.length());
        int b;
        out.println("Input command:  add, tr, exit ");
        try {
            while ((b = reader.read()) != 10) {
                builder.append((char) b);
            }
            command = new String(builder);
        } catch (IOException e) {
            out.println("error while input command:");
            e.printStackTrace();
        }
    }

    void add() {
        strE = null;
        strR = null;
        int b;
        if (reader != null) {
            out.println("Input eng word: ");
            readEnglishWord();
            readRussianWord();
        }
        dictionary.put(strE, strR);
        out.println();
    }

    private void readRussianWord() {
        int b;
        try {
            builder.delete(0, builder.length());
            while ((b = reader.read()) != 10) {
                builder.append((char) b);
            }
            strR = new String(builder);
        } catch (IOException e) {
            out.println("error input rus word");
            e.printStackTrace();
        }
    }

    private void readEnglishWord() {
        int b;
        try {
            builder.delete(0, builder.length());
            while ((b = reader.read()) != 10) {
                builder.append((char) b);
            }
            strE = new String(builder);
        } catch (IOException e) {
            out.println("error input eng word");
            e.printStackTrace();
        }
        out.println("Input rus word: ");
    }

    private void translate() {
        String str = inputStringToTranslate();
        if (str != null) {
            out.println(dictionary.toString(str));
        } else {
            out.println("Illegal argument: " + command
                    + '\n' +
                    "Try input again.");
        }
        out.println();
    }

    private String inputStringToTranslate() {
        String str = null;
        out.println("Input word: ");
        try {
            int b;
            builder.delete(0, builder.length());
            while ((b = reader.read()) != 10) {
                builder.append((char) b);
            }
            str = (new String(builder));
        } catch (IOException e) {
            out.println("Exception in input word");
            e.printStackTrace();
        }
        return str;
    }

}
