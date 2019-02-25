package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

class Update {
    private static final Logger log = Logger.getLogger(Update.class.getName());
    Update(@NotNull ProcessorManager processor) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            print("Update records:");
            print("Enter user id to update:");
            String id = reader.readLine();
            processor.update(reader, id);
            print("Record update successful");
            new Menu().displayMenu();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
    private void print(String s) {
        System.out.println(s);
    }
}
