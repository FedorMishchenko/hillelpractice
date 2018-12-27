package com.hillel.fmishchenkopractice.homework8task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderCharBuff implements Reader {

    Dictionary dictionary = new Dictionary();

    BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    String command = "";
    String en,ru;
    @Override
    public void read() {
        System.out.println("Input command: ");
        try {
            command = reader.readLine();
        } catch (IOException e) {
            System.out.println("Error input");
        }
        if(command.equals("put")){
            System.out.println("Input english word:");
            try {
                en = reader.readLine();
            } catch (IOException e) {
                System.out.println("Errror input english word");
            }
            try {
                ru = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error input russian word");
            }
            dictionary.put(en,ru);
        }
        else if(command.equals("ru")){
            System.out.println("Input rus word to translate:");
            String key = null;
            try {
                key = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error input");
            }
            System.out.println(dictionary.getEn(key));
        }else if(command.equals("en")){
            System.out.println("Input eng word to translate:");
            String key = null;
            try {
                key = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error input");
            }
            System.out.println(dictionary.getRu(key));
        }
        else if(command.equals("exit")){
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error stream close");
            }
            System.exit(0);
        }
        read();

    }
}
