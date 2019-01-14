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

    void read() {

        while (true) {
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
            switch (command) {
                case "add":
                    add();
                    break;
                case "tr":
                    translate();
                    break;
                case "exit":
                    closeQuietly(reader);
                    System.exit(0);
                default:
                    out.println("Illegal argument: " + command
                            + '\n' +
                            "Try input again.");
                    break;
            }
        }

    }

    void add() {
        strE = null;
        strR = null;
        if (reader != null) {
            out.println("Input eng word: ");
            try {
                int b;
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
            try {
                int b;
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
        dictionary.put(strE, strR);
        out.println();
    }

    private void translate() {
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
        if (str != null) {
            out.println(dictionary.toString(str));
        } else {
            out.println("Illegal argument: " + command
                    + '\n' +
                    "Try input again.");
        }
        out.println();
    }

    void closeQuietly(InputStreamReader in) {
        try {
            in.close();
        } catch (IOException ignore) {
            /*NOP*/
        }
    }
}
