package com.hillel.fmishchenkopractice.homework3.task2.ConsoleReader;

import java.util.Scanner;

public class ConsoleReaderSingleton {
    private static ConsoleReaderSingleton instance;

    public static ConsoleReaderSingleton getInstance() {
        if (instance == null)
            synchronized (ConsoleReaderSingleton.class) {
                if (instance == null)
                    instance = new ConsoleReaderSingleton();
            }
        return instance;
    }
    public void consoleRead(){
        String read = new String();
             while(true) {
                 Scanner scanner = new Scanner(System.in);
                 read = scanner.nextLine();
                 System.out.println(read);
             }
    }
}
