package com.hillel.fmishchenkopractice.homework12.restaurant;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import static java.lang.System.exit;

public class Menu {
    private static final Logger log = Logger.getLogger(Menu.class.getName());
    public void displayMenu(){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            menu();
            options(reader);
        }catch (IOException e){
            log.warning(e.toString());
        }
    }
    private void options(@NotNull BufferedReader reader)throws IOException{
        Options option = new Options();
        while (true){
            switch (reader.readLine()){
                case "1":
                    option.create(new WaiterQuery());
                    break;
                case "2":
                    option.read(new WaiterQuery());
                    break;
                case "3":
                    option.update(new WaiterQuery());
                    break;
                case "4":
                    option.delete(new WaiterQuery());
                    break;
                case "5":
                    new AdminMenu().check();
                    break;
                case "6":
                    new Options().read(new AdminQuery());
                    break;
                case "0":
                   exit(0);
                    default:
                        log.warning("Illegal argument");
            }
        }
    }

    public static void menu(){
        print("MENU:");
        print("1: Create order");
        print("2: Update order");
        print("3: Read order");
        print("4: Delete order");
        print("5: Admin menu");
        print("6: Items");
        print("0: Exit");
    }
    private static void print(String s) {
        System.out.println("         " + s);
    }
}
