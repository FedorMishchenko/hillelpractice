package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

class Delete {
    private static final Logger log = Logger.getLogger(Delete.class.getName());
    Delete(@NotNull Strategy strategy) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            print("Delete record");
            print("Enter id to delete: ");
            String id = reader.readLine();
            strategy.delete(reader, id);
            new Menu().displayMenu();
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }

    private void print(String s) {
        System.out.println(s);
    }
}
