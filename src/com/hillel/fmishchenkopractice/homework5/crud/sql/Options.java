package com.hillel.fmishchenkopractice.homework5.crud.sql;

import com.hillel.fmishchenkopractice.homework5.crud.interfaces.ProcessorManager;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Logger;

public class Options {
    private static final Logger log = Logger.getLogger(Options.class.getName());
    private Scanner scanner = new Scanner(System.in);

    public void create(@NotNull ProcessorManager processor){
            print("Create record:");
            print("Enter name:");
            String name = scanner.nextLine();
            print("Enter email:");
            String email = scanner.nextLine();
            print("Enter age:");
            Integer age = scanner.nextInt();
            processor.create(name,email,age);
            new Menu().displayMenu();

    }

    public void read(@NotNull ProcessorManager processor) {
        try {
            Objects.requireNonNull(processor).read();
        }finally {
            new Menu().displayMenu();
        }
    }
    public void update(@NotNull ProcessorManager processor) {
            print("Update records:");
            print("Enter user id to update:");
            String id = scanner.nextLine();
        try {
            processor.update(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        print("Record update successful");
            new Menu().displayMenu();
    }
    public void delete(@NotNull ProcessorManager processor) {
            print("Delete record");
            print("Enter id to delete: ");
            String id = scanner.nextLine();
        try {
            processor.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Menu().displayMenu();
    }

    private void print(String s) {
        System.out.println(s);
    }
}
