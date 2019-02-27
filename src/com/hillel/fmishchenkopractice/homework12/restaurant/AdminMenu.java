package com.hillel.fmishchenkopractice.homework12.restaurant;


import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class AdminMenu {
    private static final Logger logger = Logger.getLogger(AdminMenu.class.getName());
    public void displayMenu(){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            menu();
            options(reader);
        }catch (IOException e){
            logger.warning(e.toString());
        }
    }
    private void options(@NotNull BufferedReader reader)throws IOException {
        Options option = new Options();
        while (true){
            switch (reader.readLine()){
                case "1":
                    option.create(new QueryManager());
                    break;
                case "2":
                    option.read(new QueryManager());
                    break;
                case "3":
                    option.update(new QueryManager());
                    break;
                case "4":
                    option.delete(new QueryManager());
                    break;
                case "5":
                    new Menu().displayMenu();
                    break;
                case "0":
                    exit(0);
                    default:
                        logger.warning("Illegal argument");
            }
        }
    }
    public void menu(){
        print("ADMIN MENU:");
        print("1: Create item");
        print("2: Read menu");
        print("3: Update item");
        print("4: Delete item");
        print("5: MENU");
        print("0: Exit");
    }
    public void check(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            print("Enter password:");
            if((reader.readLine()).equals("www")) {
                displayMenu();
            } else {
                logger.info("Invalid password");
                new Menu().displayMenu();
            }
        }catch (IOException e){
            logger.warning(e.getMessage());
        }
    }

    private void print(String s) {
        System.out.println("         " + s);
    }

}
