package exersices.exersice1.Ex_4;

import java.util.Scanner;

public class PasswordCheck {
    public static void main(String[] args) {
        String password = "password";
        System.out.println("Input password:");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        while(!password.equals(str)){
            System.out.println("wrong password." + '\n' + "Input password:");
            in = new Scanner(System.in);
            str = in.nextLine();
        }
            System.out.println("Password accepted.");

    }
}
