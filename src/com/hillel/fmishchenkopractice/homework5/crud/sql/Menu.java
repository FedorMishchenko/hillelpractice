package com.hillel.fmishchenkopractice.homework5.crud.sql;

import com.hillel.fmishchenkopractice.homework5.crud.interfaces.DatabaseManager;
import com.hillel.fmishchenkopractice.homework5.crud.interfaces.ProcessorManager;
import com.hillel.fmishchenkopractice.homework5.crud.map.MapProcessor;
import org.jetbrains.annotations.Contract;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Menu implements DatabaseManager {
    private static final Logger log = Logger.getLogger(Menu.class.getName());
    private static final ProcessorManager processor = new MySQLProcessor();
    /*private static final ProcessorManager processor = new MapProcessor();*/
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        menu();
        options();
    }

    private void options() {
        Options option = new Options();
        while (true) {
            switch (scanner.nextLine()) {
                case "1":
                    option.create(Menu.processor);
                    break;
                case "2":
                    option.read(Menu.processor);
                    break;
                case "3":
                    option.update(Menu.processor);
                    break;
                case "4":
                    option.delete(Menu.processor);
                    break;
                case "0":
                    exit(0);
                default:
                    log.info("Illegal argument");
                    displayMenu();
            }
        }
    }

    private void menu() {
        print("____________________________________________");
        print("         CRUD Service: ");
        print("         1: Create Database Records");
        print("         2: Read Database Records");
        print("         3: Update Database Records");
        print("         4: Delete Database Records");
        print("         0: Exit");
        print("         SELECT Option:");
    }

    private void print(String s) {
        System.out.println(s);
    }
}
