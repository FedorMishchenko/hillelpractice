package com.hillel.fmishchenkopractice.homework8task1;

import java.io.*;


import static java.lang.System.in;
import static java.lang.System.out;

public class CharReader extends Reader {
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
    String strE;
    String strR;

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
                    closeAndFlushQuietly(writer);
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
        int index = 0;
        char[] arrE = new char[25];
        char[] arrR = new char[25];
        if (reader != null) {
            out.println("Input eng word: ");
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
            out.println("Input rus word: ");
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
        dictionary.put(strE, strR);
        out.println(dictionary.toString(strE));   //Проверка сохранения элементов успешна
    }

    private void translate() {
        String str = null;
        char[] arr = new char[25];
        int index = 0;
        out.println("Input word: ");
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
        if (str != null) {
            out.println(dictionary.toString(str)); //TO DO: переделать реализацию dictionary
        } else {
            out.println("Illegal argument: " + command
                    + '\n' +
                    "Try input again.");
        }

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
