package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Logger;

public class Options {
    private static final Logger log = Logger.getLogger(Options.class.getName());
    public void create(@NotNull ProcessorManager processor){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            print("Create record:");
            printName();
            String name = reader.readLine();
            printEmail();
            String email = reader.readLine();
            printAge();
            Integer age = Integer.parseInt(reader.readLine());
            processor.create(name,email,age);
            new Menu().displayMenu();
        }catch (IOException e){
            log.warning(e.toString());
        }
    }

    public void read(@NotNull ProcessorManager processor) {
        try {
            Objects.requireNonNull(processor).read();
        }finally {
            new Menu().displayMenu();
        }
    }
    public void update(@NotNull ProcessorManager processor) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            print("Update records:");
            print("Enter user id to update:");
            String id = reader.readLine();
            processor.update(reader, id);
            print("Record update successful");
            new Menu().displayMenu();
        } catch (IOException e) {
            log.warning(e.toString());
        }
    }
    public void delete(@NotNull ProcessorManager processor) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            print("Delete record");
            print("Enter id to delete: ");
            String id = reader.readLine();
            processor.delete(reader, id);
            new Menu().displayMenu();
        } catch (IOException e) {
            log.warning(e.toString());
        }
    }
    private void printAge() {
        print("Enter age:");
    }

    private void printEmail() {
        print("Enter email:");
    }

    private void printName() {
        print("Enter name:");
    }


    private void print(String s) {
        System.out.println(s);
    }
}
