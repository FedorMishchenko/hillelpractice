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
            out.println("Input command: add, tr, exit: ");
            try {
                command = reader.readLine();
            } catch (IOException e) {
                out.println("error while input command " + e);
            }
            switch (command) {
                case "add":
                    add();
                    break;
                case "tr":
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

    private void add() {
        String strE = null;
        String strR = null;
        out.println("Input eng word: ");
        if (reader != null) {
            try {
                strE = reader.readLine();
                out.println(strE);
            } catch (IOException e) {
                out.println("error input rus word");
                e.printStackTrace();
            }
            out.println("Input rus word: ");
            try {
                strR = reader.readLine();
                out.println(strR);
            } catch (IOException e) {
                out.println("error input eng word");
                e.printStackTrace();
            }
        }
        dictionary.put(strE, strR);
        out.println();
    }

    void translate() {
        String str = null;
        out.println("Input word: ");
            try {
                str = reader.readLine();
            } catch (IOException e1) {
                out.println("exception read in translate method");
            }

        if (str != null) {
            out.println(dictionary.toString(str));
        } else {
            out.println("Illegal argument: " + command
                    + '\n' +
                    "Try input again.");
        }
        out.println();
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
