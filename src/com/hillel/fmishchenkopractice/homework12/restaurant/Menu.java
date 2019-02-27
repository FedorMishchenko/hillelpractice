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
        while (true){
            switch (reader.readLine()){
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    new AdminMenu().check();
                    break;
                case "6":
                    new Options().read();
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
        print("6: Restaurant MENU");
        print("0: Exit");
    }
    private static void print(String s) {
        System.out.println("         " + s);
    }
}
