package com.hillel.fmishchenkopractice.homework12.cafe.UI;

import java.util.Scanner;
import java.util.logging.Logger;


public class Login {
    private static final Logger logger = Logger.getLogger(Login.class.getName());
    public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.printf("%-11s","Login:" + '\n');
        System.out.printf("%-12s","1: User" + '\n');
        System.out.printf("%-14s","2: Waiter" + '\n');
        System.out.printf("%-16s","3: Admin" + '\n');
        String login = scanner.nextLine();
        switch (login) {
            case "1":
                new User().login();
                break;
            case "2":
                new Admin().login();
                break;
            case "3":
                new Waiter().options();
                break;
            default:
                logger.info("Please login");
                login();
                break;
        }
    }

}


