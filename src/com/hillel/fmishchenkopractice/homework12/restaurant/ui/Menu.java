package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class.getName());
    private Scanner scanner = new Scanner(System.in);
    private Service service = new Service();

    public void displayMenu() {
        format("MENU:",
                "1: Admin Menu", "2: User Menu",
                "3: Accounts",
                "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        new AdminMenu().check();
                    case 2:
                        new UserMenu().displayMenu();
                    case 3:
                        new Accounts().displayMenu();
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
