package com.hillel.fmishchenkopractice.homework8task1;


import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class CharArrayReader extends Reader {
    Dictionary dictionary = Dictionary.getInstance();
    BufferedReader reader;
    DataOutputStream writer;

    {
        try {
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            writer = new DataOutputStream(out);
        } catch (UnsupportedEncodingException e) {
            out.println("encoding exception");
        }
    }

    String command;

    void read() {

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
                    errorMassege("Invalid input: ");
                    break;
            }
        }

    }

    private void errorMassege(String s) {
        out.println(s + command
                + '\n' +
                "Try input again.");
    }

    private void exit() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void input() {
        out.println("Input command: add, tr, exit: ");
        try {
            command = reader.readLine();
        } catch (IOException e) {
            out.println("error while input command " + e);
        }
    }

    private void add() {
        String strE = null;
        String strR = null;
        out.println("Input eng word: ");
        if (reader != null) {
            strE = inputEnglishWord(strE, "error input rus word");
            out.println("Input rus word: ");
            strR = inputRussianWord(strR, "error input eng word");
        }
        dictionary.put(strE, strR);
        out.println();
    }

    private String inputRussianWord(String strR, String s) {
        try {
            strR = reader.readLine();
            out.println(strR);
        } catch (IOException e) {
            out.println(s);
        }
        return strR;
    }

    private String inputEnglishWord(String strE, String s) {
        try {
            strE = reader.readLine();
            out.println(strE);
        } catch (IOException e) {
            out.println(s);
        }
        return strE;
    }

    void translate() {
        String str = null;
        out.println("Input word: ");
        str = inputStringToTranslate(str);

        if (str != null) {
            out.println(dictionary.toString(str));
        } else {
            errorMassege("Illegal argument: ");
        }
        out.println();
    }

    private String inputStringToTranslate(String str) {
        try {
            str = reader.readLine();
        } catch (IOException e1) {
            out.println("exception read in translate method");
        }
        return str;
    }

}
