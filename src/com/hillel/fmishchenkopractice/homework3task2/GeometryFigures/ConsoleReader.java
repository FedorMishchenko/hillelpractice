package com.hillel.fmishchenkopractice.homework3task2.GeometryFigures;

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
            if(read.equals("triangle")){
                Triangle tr = new Triangle(8);
                System.out.println(tr.toString());
            } else if(read.equals("square")){
                Square sq = new Square(15);
                System.out.println(sq.toString());
            } else if(read.equals("rhombus")){
                Rhombus r = new Rhombus(6);
                System.out.println(r.toString());
            }else if(read.equals("rectangle")){
                Rectangle rec = new Rectangle(11);
                System.out.println(rec.toString());
            }else if(read.equals("round")) {
                Round rnd = new Round(60);
                System.out.println(rnd.toString());
            }else if(read.equals("close")){
                System.out.print("Scanner close.");
                scanner.close();
                break;
            }
            else continue;

        }
    }
}
