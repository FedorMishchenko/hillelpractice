package com.hillel.fmishchenkopractice.homework8;
import java.io.*;


public class CharArrayReader extends Reader {
    Dictionary dictionary = Dictionary.getInstance();
    BufferedReader reader;
    DataOutputStream writer;

    {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
            writer = new DataOutputStream(System.out);
        } catch (UnsupportedEncodingException e) {
            print("encoding exception");
        }
    }

    String command;

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
                    errorMassege("Invalid input: ");
                    break;
            }
        }

    }

    private void errorMassege(String s) {
       print(s + command
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
        print("Input command: add, tr, exit: ");
        try {
            command = reader.readLine();
        } catch (IOException e) {
            print("error while input command " + e);
        }
    }

    private void add() {
        String strE = new String();
        String strR = new String();
        if (reader != null) {
            strE = inputWord("eng");
            strR = inputWord("rus");
        }
        dictionary.put(strE, strR);
        print("");
    }

    private String inputWord(String s) {
        print("input " + s + " word:");
        String str = new String();
        try {
            str = reader.readLine();
        } catch (IOException e) {
            print("Invalid argument: " + str);
        }
        return str;
    }

    void translate() {
        String str = null;
        print("Input word: ");
        str = inputStringToTranslate(str);

        if (str != null) {
            print(dictionary.toString(str));
        } else {
            errorMassege("Illegal argument: ");
        }
        print("");
    }

    private String inputStringToTranslate(String str) {
        try {
            str = reader.readLine();
        } catch (IOException e1) {
            print("exception read in translate method");
        }
        return str;
    }

    private void print(String s) {
        System.out.println(s);
    }

}
