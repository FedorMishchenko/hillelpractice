package com.hillel.fmishchenko_practice.HomeWork_3_Task_2.ConsoleReader;

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

}
