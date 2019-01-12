package com.hillel.fmishchenkopractice.homework8task1;


import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class CharArrayReader extends Reader {
    Dictionary dictionary = Dictionary.getInstance();
    BufferedReader reader = null;
    DataOutputStream writer = new DataOutputStream(out);

    {
        try {
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            out.println("encoding exception");
        }
    }

    String command;

    void read() {

        while (true) {
            out.println("Input command: ");
            try {
                command = reader.readLine();
            } catch (IOException e) {
                out.println("error while input command " + e);
            }
            switch (command) {
                case "add":
                    addE();
                    addR();
                    break;
                case "translate":
                    translate();
                    break;
                case "exit":
                    closeQuietly(reader);
                    closeAndFlushQuietly(writer);
                    System.exit(0);
                default:
                    out.println("Invalid input: " + command
                            + '\n' +
                            "Try input again.");
                    break;
            }
        }

    }

    private void addR() {
        String strRus;
        out.println("Input rus word: ");
        if(reader != null){
            try {
                strRus = reader.readLine();
                out.print(strRus);
            } catch (IOException e) {
                out.println("error input rus word");
                e.printStackTrace();
            }
        } out.println();
    }

    private void addE() {
        String strEng;
        out.println("Input eng word: ");
        if(reader != null){
            try {
                strEng = reader.readLine();
                out.print(strEng);
            } catch (IOException e) {
                out.println("error input eng word");
                e.printStackTrace();
            }
        }out.println();

    }
    void translate() {

    }

    private void closeAndFlushQuietly(DataOutputStream writer) {
        try {
            writer.flush();
        } catch (IOException ignore) {
            /*NOP*/
        }
        try {
            writer.close();
        } catch (IOException ignore) {
            /*NOP*/
        }
    }

    void closeQuietly(BufferedReader in) {
        try {
            in.close();
        } catch (IOException ignore) {
            /*NOP*/
        }
    }
}
