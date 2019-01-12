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
            out.println("Input command: ");
            try {
                command = reader.readLine();
            } catch (IOException e) {
                out.println("error while input command ");
                e.printStackTrace();
            }
            switch (command) {
                case "add":
                    add();
                    break;
                case "trans":
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
        out.println(dictionary.toString(strE));//Проверка сохранения элементов успешна
    }

    private void translate() {
        out.println("Input en for english / ru for russian: ");
        try {
            command = reader.readLine();
        } catch (IOException e) {
            out.println("Exception in input en / ru");
            e.printStackTrace();
        }
        if (command.equals("en")) {
            out.println("Input english word to translate: ");
            try {
                command = reader.readLine();
            } catch (IOException e) {
                out.println("Exception in read en word");
                e.printStackTrace();
            }
            out.println(dictionary.get(command));
            out.println(dictionary.toString(command));//Здесь элементы уже отсутствуют
        } else if (command.equals("ru")) {
            out.println("Input russian word to translate: ");
            try {
                command = reader.readLine();
            } catch (IOException e) {
                out.println("Exception in read ru word");
                e.printStackTrace();
            }
            out.println(dictionary.get(command));
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
