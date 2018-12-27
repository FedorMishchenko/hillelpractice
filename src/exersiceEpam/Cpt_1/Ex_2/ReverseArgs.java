package exersiceEpam.Cpt_1.Ex_2;

import java.util.Scanner;

public class ReverseArgs {
    public static void main(String[] args) {
        System.out.println("Input string: ");
        Scanner inn = new Scanner(System.in);
        String str = inn.nextLine();
        System.out.println("String =          " + str);
        String reverse = new StringBuffer(str).reverse().toString();
        System.out.println("Reverse string =  " + reverse);
    }
}
