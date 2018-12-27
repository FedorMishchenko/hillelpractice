package com.hillel.fmishchenkopractice.homework8task1;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ReaderByte implements Reader {

    Scanner scanner = new Scanner(System.in);

    Dictionary dictionary = new Dictionary();

    String command = "";
    String en,ru;


    @Override
    public void read() {
        System.out.println("Input command: ");
        command = scanner.nextLine();
        if(command.equals("put")) {
            int tmp1;
            byte[] engBytes = new byte[1024];
            System.out.println("Input english word:");
            try {
                tmp1 = System.in.read(engBytes);
                en = new String(Arrays.copyOf(engBytes, tmp1));
                System.out.println("You input: " + en);
            } catch (IOException e) {
                System.out.println("Input ERROR");
            }
            int tmp2;
            byte[] ruBytes = new byte[1024];
            System.out.println("Input russan word:");
            try {
                tmp2 = System.in.read(ruBytes);
                ru = new String(Arrays.copyOf(ruBytes, tmp2));
                System.out.println("You input: " + ru);
            } catch (IOException e) {
                System.out.println("Input ERROR");
            }
            dictionary.put(en,ru);
            System.out.println(dictionary.size());
        }
        else if(command.equals("ru")){
            System.out.println("Input rus word to translate:");
            String key = scanner.nextLine();
            System.out.println(dictionary.getEn(key));
        }else if(command.equals("en")){
            System.out.println("Input eng word to translate:");
            String key = scanner.nextLine();
            System.out.println(dictionary.getRu(key));
        }
        else if(command.equals("exit")){
            scanner.close();
            System.exit(0);
        }
        read();

    }


}

