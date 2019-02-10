package com.hillel.fmishchenkopractice.homework8;

import java.io.*;

public class CharReader extends Reader {
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

    private void print(String s) {
        System.out.println(s);
    }


    private String command;
    private String strE;
    private String strR;

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
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void input() {
        print("Input command:  add, tr, exit ");
        try {
            command = reader.readLine();
        } catch (IOException e) {
            print("error while input command:");
            e.printStackTrace();
        }
    }

    private void add() {
        strE = null;
        strR = null;
        int index = 0;
        char[] arrE = new char[25];
        char[] arrR = new char[25];
        if (reader != null) {
            readEnglishWord(index, arrE);
            readRussianWord(arrR);
        }
        dictionary.put(strE, strR);
        print("");
    }

    private void readRussianWord(char[] arrR) {
        print("Input rus word: ");
        int index;
        index = 0;
        try {
            int b;
            while ((b = reader.read()) != 10) {
                System.out.print((char) b);
                arrR[index] = (char) b;
                index++;
            }
            print("");
            strR = new String(arrR);
        } catch (IOException e) {
            print("error input rus word");
            e.printStackTrace();
        }
    }

    private void readEnglishWord(int index, char[] arrE) {
        print("Input eng word: ");
        try {
            int b;
            while ((b = reader.read()) != 10) {
                writer.writeChar(b);
                arrE[index] = (char) b;
                index++;
            }
            print("");
            strE = new String(arrE);
        } catch (IOException e) {
            print("error input eng word");
            e.printStackTrace();
        }
    }

    private void translate() {
        String str = null;
        char[] arr = new char[25];
        int index = 0;
        print("Input word: ");
        str = inputStringToTranslate(str, arr, index);
        if (str != null) {
            print(dictionary.toString(str));
        } else {
            errorMassege();
        }
        print("");
    }

    private String inputStringToTranslate(String str, char[] arr, int index) {
        try {
            int b;
            while ((b = reader.read()) != 10) {
                arr[index] = (char) b;
                index++;
            }
            str = (new String(arr));
        } catch (IOException e) {
            print("Exception in input word");
            e.printStackTrace();
        }
        return str;
    }

}