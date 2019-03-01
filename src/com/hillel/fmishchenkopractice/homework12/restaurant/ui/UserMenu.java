package com.hillel.fmishchenkopractice.homework12.restaurant.ui;

import com.hillel.fmishchenkopractice.homework12.restaurant.dao.ItemDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.dao.OrderDAO;
import com.hillel.fmishchenkopractice.homework12.restaurant.service.UserOrderService;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class UserMenu {
    private static final Logger logger = Logger.getAnonymousLogger();
    private Menu menu = new Menu();
    private Scanner scanner = new Scanner(System.in);
    private UserOrderService service = new UserOrderService();

    public void displayMenu(){
        menu.format("USER MENU:","1: Create Order",
                "2: Read Order","3: Update Order",
                "4: Delete Order",
                "5: Accounts","6: Program Menu",
                "7: Cafe Menu", "0: Exit",
                 "SELECT OPTION:");
        options();
    }
    private void options(){
        try {
            while (true) {
                switch (scanner.nextInt()) {
                    case 1:
                        service.create(new OrderDAO());
                    case 2:
                        service.read(new OrderDAO());
                    case 3:
                        service.update(new OrderDAO());
                    case 4:
                        service.delete(new OrderDAO());
                    case 5:
                        new Accounts().displayMenu();
                    case 6:
                        new Menu().displayMenu();
                    case 7:
                        service.read(new ItemDAO());
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
