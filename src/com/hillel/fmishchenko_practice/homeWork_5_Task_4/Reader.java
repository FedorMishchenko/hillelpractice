package com.hillel.fmishchenko_practice.homeWork_5_Task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Reader {

    BufferedReader buffer =
            new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);

    HashMap<Integer, User> base = new HashMap<>();

    public void read() {
        {
            String command = "";
            System.out.println("Input command: ");
            try {
                command = buffer.readLine();
            } catch (IOException e) {
                System.out.println("Input command fail");
            }
            if (command.equals("create")) {
                base = createUser();

                boolean check = base.isEmpty();
                System.out.println("base is empty= " + check);
                read();
            } else if (command.equals("read")) {
                if (base.isEmpty()) System.out.println("Empty");
                else {
                    readData();
                }
                read();
            } else if (command.equals("update")) {
                base = updateUser();
                read();
            } else if (command.equals("all")) {
                getAll();
            } else if (command.equals("sort")) {
                sort();
            } else if (command.equals("delete")) {
                int key = scanner.nextInt();
                base = deleteUser(key);
                read();

            } else if (command.equals("exit")) {
                System.exit(0);
            } else System.out.println("Invalid command: ");
            read();

        }

    }

    private void sort() {
        System.out.println("Input field of user to sort:" +
                " name, email, age");
        String choice = scanner.nextLine();
        if (choice.equals("name")) {

        } else if (choice.equals("email")) {

        } else if (choice.equals("age")) {

        } else {
            System.out.println("Can't sort.Invalid input command.");
        }
    }

    private void getAll() {
        while (!base.isEmpty()) {

        }
    }

    private void readData() {
        System.out.println("Input user id " +
                "to read: ");
        int key = scanner.nextInt();
        System.out.println(base.containsKey(key));
        System.out.println(base.get(key));
        System.out.println("Number of users= " + base.size());
        read();

    }

    HashMap createUser() {
        User user = new User();
        int key = user.hashCode();
        System.out.println("User id= " + key);
        base.put(key, user);
        System.out.println(base.containsValue(user));
        System.out.println("Number of users= " + base.size());
        return base;

    }

    private HashMap updateUser() {
        try {
            System.out.println("Input user id " +
                    "to update: ");
            int key = scanner.nextInt();
            User user = base.get(key);

            System.out.println("Set user name: ");
            user.setName(buffer.readLine());

            System.out.println("Set user email: ");
            user.setEmail(buffer.readLine());

            System.out.println("Set user age: ");
            user.setAge(scanner.nextInt());

            base.put(key, user);

        } catch (IOException e) {
            System.out.println("Update fail");
        }
        return base;
    }

    private HashMap deleteUser(int key) {
        base.remove(key);
        return base;
    }
}

