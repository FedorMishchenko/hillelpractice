package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.ItemDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.service.Service;
import com.hillel.fmishchenkopractice.homework12.restaurant.dao.OrderDAO;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class.getName());

    public void displayMenu() {
        format("MENU:", "1: Create order",
                "2: Read order", "3: Update order",
                "3: Update order", "4: Delete order",
                "5: Admin Menu", "6: User Menu",
                "7: CAFE MENU", "0: Exit","SELECT OPTION:");
        options();
    }

    private void options() {
        try {
            Scanner scanner = new Scanner(System.in);
            Service service = new Service();
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        service.create(new OrderDAO());
                        break;
                    case 2:
                        service.read(new OrderDAO());
                        break;
                    case 3:
                        service.update(new OrderDAO());
                        break;
                    case 4:
                        service.delete(new OrderDAO());
                        break;
                    case 5:
                        new AdminMenu().check();
                        break;
                    case 6:
                        new UserMenu().displayMenu();
                    case 7:
                        new Service().read(new ItemDAO());
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
