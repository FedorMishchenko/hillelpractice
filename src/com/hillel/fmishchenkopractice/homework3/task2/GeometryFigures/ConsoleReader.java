package com.hillel.fmishchenkopractice.homework3.task2.GeometryFigures;

import java.util.Scanner;

class ConsoleReader {
    private static ConsoleReader instance;

    private ConsoleReader() {

    }

    static ConsoleReader getInstance() {
        if (instance == null)
            synchronized (ConsoleReader.class) {
                if (instance == null)
                    instance = new ConsoleReader();
            }
        return instance;
    }

    void consoleRead() {
        while (true) {
            input();
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switchCommand(command);
        }
    }

    private void switchCommand(String command) {
        switch (command) {
            case "tr":
                System.out.println(new Triangle(8).toString()+ '\n');
                break;
            case "sq":
                System.out.println(new Square(15).toString()+ '\n');
                break;
            case "rh":
                System.out.println(new Rhombus(6).toString()+ '\n');
                break;
            case "rec":
                System.out.println(new Rectangle(11).toString()+ '\n');
                break;
            case "rou":
                System.out.println(new Round(60).toString() + '\n');
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println("Illegal argument: " + command + '\n');
                break;
        }
    }

    private void input() {
        System.out.println("Input command:" + '\n' +
                "tr: triangle" + '\n' +
                "sq: square" + '\n' +
                "rh: rhombus" + '\n' +
                "rec: rectangle" + '\n' +
                "rou: round" + '\n' +
                "exit: to program exit");
    }
}
