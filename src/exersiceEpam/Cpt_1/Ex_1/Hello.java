package exersiceEpam.Cpt_1.Ex_1;

import java.io.IOException;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner inn = new Scanner(System.in);
        String str = inn.nextLine();
        if(str.isEmpty()) {try {
            throw new IOException();
        } catch (IOException e) {
            System.err.print("Input error");
           }
        }else
        System.out.println("Hello " + str.toUpperCase());

    }
}
