package com.hillel.fmishchenkopractice.homework8;

import java.io.*;


import static java.lang.System.in;
import static java.lang.System.out;

public class CharReader extends Reader {
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
    String strE;
    String strR;

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
                    errorMassege();
                    break;
            }
        }

    }

    private void errorMassege() {
        out.println("Illegal argument: " + command
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
        out.println("Input command:  add, tr, exit ");
        try {
            command = reader.readLine();
        } catch (IOException e) {
            out.println("error while input command:");
            e.printStackTrace();
        }
    }

    void add() {
        strE = null;
        strR = null;
        int index = 0;
        char[] arrE = new char[25];
        char[] arrR = new char[25];
        if (reader != null) {
            out.println("Input eng word: ");
            readEnglishWord(index, arrE);
            out.println("Input rus word: ");
            readRussianWord(arrR);
        }
        dictionary.put(strE, strR);
        out.println();
    }

    private void readRussianWord(char[] arrR) {
        int index;
        index = 0;
        try {
            int b;
            while ((b = reader.read()) != 10) {
                out.print((char) b);
                arrR[index] = (char) b;
                index++;
            }
            out.println();
            strR = new String(arrR);
        } catch (IOException e) {
            out.println("error input rus word");
            e.printStackTrace();
        }
    }

    private void readEnglishWord(int index, char[] arrE) {
        try {
            int b;
            while ((b = reader.read()) != 10) {
                writer.writeChar(b);
                arrE[index] = (char) b;
                index++;
            }
            out.println();
            strE = new String(arrE);
        } catch (IOException e) {
            out.println("error input eng word");
            e.printStackTrace();
        }
    }

    private void translate() {
        String str = null;
        char[] arr = new char[25];
        int index = 0;
        out.println("Input word: ");
        str = inputStringToTranslate(str, arr, index);
        if (str != null) {
            out.println(dictionary.toString(str));
        } else {
            errorMassege();
        }
        out.println();
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
            out.println("Exception in input word");
            e.printStackTrace();
        }
        return str;
    }

}
