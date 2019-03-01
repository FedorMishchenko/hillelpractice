package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.UserDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Accounts {
    private static final Logger logger = Logger.getAnonymousLogger();
    private Menu menu = new Menu();
    private Scanner scanner = new Scanner(System.in);
    private UserService service = new UserService();

    public void displayMenu(){
        menu.format("USERS:","1: Create User",
                "2: Users","3: Update User",
                "4: Delete User","5: Program Menu",
                "6: User Menu");
        options();
    }
    private void options(){
        try {
            while (true){
                switch (scanner.nextInt()){
                    case 1:
                        service.create(new UserDAO());
                    case 2:
                        service.read(new UserDAO());
                    case 3:
                        service.update(new UserDAO());
                    case 4:
                        service.delete(new UserDAO());
                    case 5:
                        new Menu().displayMenu();
                    case 6:
                        new UserMenu().displayMenu();
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
