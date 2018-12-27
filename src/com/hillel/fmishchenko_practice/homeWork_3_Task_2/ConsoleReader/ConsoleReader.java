package com.hillel.fmishchenko_practice.homeWork_3_Task_2.ConsoleReader;

import java.util.Scanner;

public class ConsoleReader {
    private static ConsoleReader instance;

    private ConsoleReader() {

    }

    public static ConsoleReader getInstance() {
        if (instance == null)
            synchronized (ConsoleReader.class) {
                if (instance == null)
                    instance = new ConsoleReader();
            }
        return instance;
    }
    public void consoleRead(){
             while(true) {
                 Scanner scanner = new Scanner(System.in);
                 String read = scanner.nextLine();
                 System.out.println(read);
             }
    }
}
