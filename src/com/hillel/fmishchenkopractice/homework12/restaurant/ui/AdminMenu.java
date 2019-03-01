package com.hillel.fmishchenkopractice.homework12.restaurant.ui;


import com.hillel.fmishchenkopractice.homework12.restaurant.dao.ItemDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class AdminMenu {
    private static final Logger logger = Logger.getLogger(AdminMenu.class.getName());
    private final String password = "www";
    private Menu menu = new Menu();

    public void displayMenu() {
        menu.format("ADMIN MENU:", "1: Create item",
                "2: Update item",
                "3: Delete item", "4: Order menu",
                "5: CAFE MENU",
                "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        try {
            Scanner scanner = new Scanner(System.in);
            Service service = new Service();
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        service.create(new ItemDAO());
                        break;
                    case 2:
                        service.update(new ItemDAO());
                        break;
                    case 3:
                        service.delete(new ItemDAO());
                        break;
                    case 4:
                        new Menu().displayMenu();
                        break;
                    case 5:
                        service.read(new ItemDAO());
                        break;
                    case 0:
                        exit(0);
                    default:
                        logger.warning("Illegal argument");
                        displayMenu();
                }
            }
        } catch (InputMismatchException e) {
            logger.warning("Number format expected");
            displayMenu();
        }
    }


        public void check () {
            Scanner scanner = new Scanner(System.in);
                menu.format("Enter password:");
                if ((scanner.nextLine()).equals(password)) {
                    displayMenu();
                } else {
                    logger.info("Invalid password");
                    new Menu().displayMenu();
                }
            }
        }


