package com.hillel.fmishchenkopractice.homework5.crud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

class Create {
    private static final Logger log = Logger.getLogger(Create.class.getName());
    Create(Processor processor){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))){
            print("Create record:");
            print("Enter name:");
            String name = reader.readLine();
            print("Enter email:");
            String email = reader.readLine();
            print("Enter age:");
            Integer age = Integer.parseInt(reader.readLine());
            processor.create(name,email,age);
            new Menu().displayMenu();
        }catch (IOException e){
            log.info(e.getMessage());
        }
    }

    private void print(String s) {
        System.out.println(s);
    }
}
