package com.hillel.fmishchenkopractice.homework8task1;

import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class ByteReader extends Reader{
    Dictionary dictionary = Dictionary.getInstance();
    BufferedReader reader;
    String command;

    {
        try {
            reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    byte[] b = new byte[25];
    InputStream input = new ByteArrayInputStream(b);



    void read() {
        while (true) {
            out.println("Input command:  add, tr, exit ");
            try {
                command = reader.readLine();
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
                    /*closeAndFlushQuietly(writer);*/
                    System.exit(0);
                default:
                    out.println("Illegal argument: " + command
                            + '\n' +
                            "Try input again.");
                    break;
            }
        }
    }

    private void translate() {
    }

    private void add() {

    }
    private void closeAndFlushQuietly(DataOutputStream out) {
        try {
            out.flush();
        } catch (IOException ignore) {
            /*NOP*/     /*NoOperation*/
        }
        try {
            out.close();
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
