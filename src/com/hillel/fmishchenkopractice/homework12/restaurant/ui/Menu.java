package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.ItemDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class.getName());

    public void displayMenu() {
        format("MENU:",
                "1: Admin Menu", "2: User Menu",
                "3: CAFE MENU","4: Users",
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
                        new AdminMenu().check();
                        break;
                    case 2:
                        new UserMenu().displayMenu();
                        break;
                    case 3:
                        service.read(new ItemDAO());
                        break;
                    case 4:
                        log.info("Not realized");
                        new Menu().displayMenu();
                    case 0:
                        exit(0);
                    default:
                        log.warning("Illegal argument");
                        displayMenu();
                }
            }
        } catch (InputMismatchException e) {
            log.warning("Number format expected");
            displayMenu();
        }
    }

    public void format(String... s) {
        System.out.printf("%9s%-20s%n"," ","----------------------------");
        for (String str : s) {
            System.out.printf("%15s%-20s%2s%n", "|     ",str,"|");
        }
        System.out.printf("%9s%-20s%n"," ","----------------------------");
    }
}
