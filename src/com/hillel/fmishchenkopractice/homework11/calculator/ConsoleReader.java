package com.hillel.fmishchenkopractice.homework11.calculator;

import java.util.Scanner;

public class ConsoleReader {
    Scanner scanner;
    private int result;
    private int num1;
    private int num2;
    private String operation;

    public int process(){
        scanner = new Scanner(System.in) ;
            while(true) {
                num1 = scanner.nextInt();
                operation = scanner.next();
                num2 = scanner.nextInt();
                switch (operation) {
                    case "+":
                        Addition add = (x, y) -> x + y;
                        print(add.add(num1, num2));
                        break;
                    case "-":
                        Subtraction sub = (x, y) -> x - y;
                        print(sub.subtract(num1,num2));
                        break;
                    case "*":
                        Multiplication mult = (x, y) -> x * y;
                        print(mult.multiply(num1,num2));
                        break;
                    case "/":
                        Division div = (x, y) -> x / y;
                        print(div.divide(num1,num2));
                        break;
                    case "sqr":
                        SquareRoot sqr = (x) -> (int)Math.sqrt(x);
                        print(sqr.sqrt(num1));
                        break;
                        default:
                            print("Unsupported operation: " + operation);
                            break;
                }

            }
        }

    public void print(String s) {
        System.out.println(s);
    }


    public void print(int i) {
        System.out.println(i);
    }
}
