package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.service.Options;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class UserMenu {
    private static final Logger logger = Logger.getAnonymousLogger();
    private Menu menu = new Menu();

    public void displayMenu(){
        menu.format("USER MENU:","1: Log In",
                "2: Read order","3: Update Order",
                "3: Delete Order",
                "4: Create User","5: Menu",
                "6: CAFE MENU","0: Exit");
        options();
    }
    private void options(){
        try {
            Scanner scanner = new Scanner(System.in);
            Options option = new Options();
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        new Menu().displayMenu();
                        break;
                    case 6:

                        break;
                    case 0:
                        exit(0);
                    default:
                        logger.warning("Illegal argument");
                        displayMenu();
                }
            }
        }catch (InputMismatchException e){
            logger.warning("Number format expected");
            displayMenu();
        }

    }
}
