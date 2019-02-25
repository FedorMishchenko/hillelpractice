package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Menu implements DatabaseManager{
    private static final Logger log = Logger.getLogger(Menu.class.getName());
     private Processor processor;
     private Processor getProcessor(Processor processor){
         return this.processor = processor;
     }
     @Override
    public void displayMenu() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            processor = getProcessor(new MySQLProcessor());
            menu();
            options(reader, processor);
        }catch (IOException e){
            log.info(e.getMessage());
        }
    }

    private  void options(@NotNull BufferedReader reader, Processor processor) throws IOException{
        while (true) {
            switch (reader.readLine()) {
                case "1":
                    new Create(processor);
                    break;
                case "2":
                    new Read(processor);
                    break;
                case "3":
                    new Update(processor);
                    break;
                case "4":
                    new Delete(processor);
                    break;
                case "5":
                    exit();
                default:
                    printEx();
            }
        }
    }

    private void menu() {
        print("____________________________________________");
        print("         CRUD Options: ");
        print("         1: Create Database Records");
        print("         2: Read Database Records");
        print("         3: Update Database Records");
        print("         4: Delete Database Records");
        print("         5: Exit");
        print("         SELECT Option:");
    }
    @Contract(" -> fail")
    private void exit(){
        System.exit(0);
    }

    private void printEx() {
        log.info("Illegal argument");
    }

    private void print(String s) {
        System.out.println(s);
    }
}
