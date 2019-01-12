package exersice.epam.exersice1.Ex_6;

import java.util.Date;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        System.out.println("Input developer name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Date getTime = new Date();
        Date passTime;
        System.out.println(name.toUpperCase() + " get the task : " + getTime.toString());

        System.out.println("For pass the task input PASS");
        boolean flag = true;
        while(flag) {
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("pass")) {
                flag = false;
                passTime = new Date();
            } else continue;
            System.out.println(name.toUpperCase() + " pass the task : " + passTime.toString());
        }

    }
}
