package com.hillel.fmishchenkopractice.homework8task1;

import java.io.IOException;
import java.util.Scanner;

public class DictionaryUtils {
    Dictionary dictionary = new Dictionary();
    ReadByte rb = new ReadByte();
    Scanner scanner = new Scanner(System.in);
    String command;

    String enStr;
    String ruStr;

    public void fill()throws IOException {
        System.out.println("Available commands: put,getR, getE");
        System.out.println("Input command: ");
        command = scanner.nextLine();
        if(command != null){
            switch (command){
                case "put":
                {
                    System.out.println("Input english word: ");
                    enStr = rb.read();
                    System.out.println("input russian translate: ");
                    ruStr = rb.read();
                    dictionary.put(enStr,ruStr);
                    break;
                }
                case "getR":
                {
                    System.out.println("input russian translate: ");
                    ruStr = rb.read();
                    System.out.println(dictionary.getEn(ruStr));
                    break;
                }
                case "getE":
                {
                    System.out.println("Input english word: ");
                    enStr = rb.read();
                    System.out.println(dictionary.getRu(enStr));
                    break;
                }

            }
            fill();
        }

    }
}
