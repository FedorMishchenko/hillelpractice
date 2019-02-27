package com.hillel.fmishchenkopractice.homework12.cafe.UI;

import java.util.Scanner;
import java.util.logging.Logger;

public class Admin {
    private static final Logger logger = Logger.getAnonymousLogger();
    private final String password = "www";
    public void login(){
        Scanner scanner = new Scanner(System.in);
        logger.info("Enter password:");
        if(password.equals(scanner.nextLine())){
            options();
        }else {
            logger.info("invalid password");
            new Login().login();
        }
    }
    public void options() {

    }
}
