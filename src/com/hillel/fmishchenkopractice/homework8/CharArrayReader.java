package com.hillel.fmishchenkopractice.homework8;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class CharArrayReader extends Reader {
    private Dictionary dictionary = Dictionary.getInstance();
    private BufferedReader reader;
    private DataOutputStream writer;

    {
        reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        writer = new DataOutputStream(System.out);
    }

    private String command;

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
                    errorMassage("Invalid input: ");
                    break;
            }
        }

    }

    private void errorMassage(String s) {
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
        String strE = "";
        String strR = "";
        if (reader != null) {
            strE = inputWord("eng");
            strR = inputWord("rus");
        }
        dictionary.put(strE, strR);
        print("");
    }

    private String inputWord(String s) {
        print("input " + s + " word:");
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            print("Invalid argument: " + str);
        }
        return str;
    }

    private void translate() {
        String str = null;
        print("Input word: ");
        str = inputStringToTranslate(str);

        if (str != null) {
            print(dictionary.toString(str));
        } else {
            errorMassage("Illegal argument: ");
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
