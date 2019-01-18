package exersices.exersice1.Ex_3;

import java.util.Scanner;
public class TransferLine {
    public static void main(String[] args) {
        System.out.println("Input string: ");
        System.out.println("Input: END to output text");
        Scanner inn = new Scanner(System.in);
        String[] text = new String[10];

        while(!inn.next().equalsIgnoreCase("end")) {
            String str = inn.nextLine();
            System.out.print(str);
        }
    }
}
