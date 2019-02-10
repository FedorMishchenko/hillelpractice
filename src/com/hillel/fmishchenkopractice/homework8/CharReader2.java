package com.hillel.fmishchenkopractice.homework8;

import java.io.*;

public class CharReader2 extends Reader {
    Dictionary dictionary = Dictionary.getInstance();
    StringBuilder builder = new StringBuilder();
    InputStreamReader reader;

    {
        reader = new InputStreamReader(System.in);
    }

    String command;
    String strE;
    String strR;

    void process() {
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
                    errorMassege();
                    break;
            }
        }
    }

    private void errorMassege() {
        print("Illegal argument: " + command
                + '\n' +
                "Try input again.");
    }

    private void exit() {
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
        print("Input command:  add, tr, exit ");
        try {
            while ((b = reader.read()) != 10) {
                builder.append((char) b);
            }
            command = new String(builder);
        } catch (IOException e) {
            print("error while input command:");
            e.printStackTrace();
        }
    }

    private void add() {
        if (reader != null) {
            strE = readWord("eng");
            strR = readWord("rus");
        }
        dictionary.put(strE, strR);
        print("");
    }

    private String readWord(String s) {
        print("input " + s + " word:");
        String str = "";
        try {
            readChar();
            str = new String(builder);
        } catch (IOException e) {
            print("error input" + s + " word");
            e.printStackTrace();
        }
        return str;
    }

    private void readChar() throws IOException {
        int b;
        builder.delete(0, builder.length());
        while ((b = reader.read()) != 10) {
            builder.append((char) b);
        }
    }

    private void translate() {
        String str = inputStringToTranslate();
        if (str != null) {
            print(dictionary.toString(str));
        } else {
            errorMassege();
        }
        print("");
    }

    private String inputStringToTranslate() {
        String str = null;
        print("Input word: ");
        try {
            readChar();
            str = (new String(builder));
        } catch (IOException e) {
            print("Exception in input word");
            e.printStackTrace();
        }
        return str;
    }

    private void print(String s) {
        System.out.println(s);
    }

}
