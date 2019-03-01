package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.ItemDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class AdminMenu {
    private static final Logger logger = Logger.getLogger(AdminMenu.class.getName());
    private final String password = "www";
    private Menu menu = new Menu();
    private Scanner scanner = new Scanner(System.in);
    private Service service = new Service();

    public void displayMenu() {
        menu.format("ADMIN MENU:", "1: Create Item",
                "2: Update Item",
                "3: Delete Item", "4: Order Menu",
                "5: Cafe Menu",
                "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        service.create(new ItemDAO());
                    case 2:
                        service.update(new ItemDAO());
                    case 3:
                        service.delete(new ItemDAO());
                    case 4:
                        new Menu().displayMenu();
                    case 5:
                        service.read(new ItemDAO());
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


