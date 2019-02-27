package com.hillel.fmishchenkopractice.homework12.cafe.UI;

import java.util.Scanner;
import java.util.logging.Logger;

public class User {
    private static final Logger logger = Logger.getAnonymousLogger();
    public void login(){
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter 1 or 2");
        System.out.printf("%-11s","1: Sign in");
        System.out.printf("%-12s","2: Log in");
        String str = scanner.nextLine();
        if(str.equals("1")) {
            //todo: create user in Database
            options();
        }else if(str.equals("2")){
            //todo: check user exist in Database?
            if(true) options(); //todo: realize check
            else login();
        }else {
            logger.info("Invalid enter " + str);
            login();
        }

    }
    public void options() {

    }
}
