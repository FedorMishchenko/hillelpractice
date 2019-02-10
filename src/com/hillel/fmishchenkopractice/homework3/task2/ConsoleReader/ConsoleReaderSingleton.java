package com.hillel.fmishchenkopractice.homework3.task2.ConsoleReader;

import java.util.Scanner;

class ConsoleReaderSingleton {
    private static ConsoleReaderSingleton instance;

    static ConsoleReaderSingleton getInstance() {
        if (instance == null)
            synchronized (ConsoleReaderSingleton.class) {
                if (instance == null)
                    instance = new ConsoleReaderSingleton();
            }
        return instance;
    }
    void consoleRead(){
        String read;
             while(true) {
                 Scanner scanner = new Scanner(System.in);
                 read = scanner.nextLine();
                 System.out.println(read);
             }
    }
}
