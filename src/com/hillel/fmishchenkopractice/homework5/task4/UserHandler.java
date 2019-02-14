package com.hillel.fmishchenkopractice.homework5.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class UserHandler {

    private BufferedReader buffer =
            new BufferedReader(new InputStreamReader(System.in));
    private Scanner scanner = new Scanner(System.in);

    private HashMap<Integer, User> base = new HashMap<>();

    UserHandler() {
    }

    public void process() {
        {
            String command = inputCommand();
            try {
                command = buffer.readLine();
            } catch (IOException e) {
                print("Input error");
            }
            crud(command);
            process();

        }

    }

    private void crud(String command) {
        switch (command) {
            case "create":
                base = createUser();
                process();
                break;
            case "read":
                if (base.isEmpty()) print("Empty");
                else {
                    readData();
                }
                process();
                break;
            case "update":
                base = updateUser();
                process();
                break;
            case "all":
                getAll();
                break;
            case "sort":
                try {
                    sort();
                } catch (IOException e) {
                    print("Sort failed");
                }
                break;
            case "delete":
                int key = scanner.nextInt();
                base = deleteUser(key);
                process();

                break;
            case "exit":
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            default:
                print("Invalid command. Input command - " +
                        "create, read, update, delete, all, sort: ");
                break;
        }
    }

    private String inputCommand() {
        String command = "";
        print("Input command: ");
        print("create, read, update, delete, all, sort: ");
        print("exit: to system.exit");
        return command;
    }

    private void sort() throws IOException {
        String choice = input();
        switch (choice) {
            case "name":
                name();
            case "email":
                email();
            case "age":
                age();
            default:
                print("Can't sort.Invalid input command.");
        }
    }

    private void print(String s) {
        System.out.println(s);
    }

    private void age() {
        ArrayList<User> compareAge = new ArrayList<User>(base.values());

        compareAge.sort(Comparator.comparingInt(User::getAge));

        for (User user : compareAge) {
            System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                    user.getAge());
        }
    }

    private void email() {
        ArrayList<User> compareEmail = new ArrayList<User>(base.values());

        compareEmail.sort((o1, o2) -> {
            if (o1.getEmail().equals(o2.getEmail())) {
                return 1;
            } else return -1;

        });
        for (User user : compareEmail) {
            System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                    user.getAge());
        }
    }

    private void name() {
        ArrayList<User> compareName = new ArrayList<User>(base.values());

        compareName.sort((o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                return 1;
            } else return -1;
        });

        for (User user : compareName) {
            System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                    user.getAge());
        }
    }

    private String input() throws IOException {
        print("Input user's field for sort base:" +
                " name, email, age");
        return buffer.readLine();
    }

    private void getAll() {
        if (!base.isEmpty()) {
            ArrayList<User> list = new ArrayList<>(base.values());
            for (User user : list) {
                print(user.toString());
            }
        }
    }

    private void readData() {
        print("Input user id " +
                "to read: ");
        int key = scanner.nextInt();
        System.out.println(base.containsKey(key));
        System.out.println(base.get(key));
        process();

    }

    private HashMap<Integer, User> createUser() {
        User user = new User();
        int key = user.hashCode();
        print("User id = " + key);
        base.put(key, user);
        updateUser();
        return base;

    }

    private HashMap<Integer, User> updateUser() {
        try {
            print("Input user id " +
                    "to update: ");
            int key = scanner.nextInt();
            User user = base.get(key);

            print("Set user name: ");
            user.setName(buffer.readLine());

            print("Set user email: ");
            user.setEmail(buffer.readLine());

            print("Set user age: ");
            user.setAge(scanner.nextInt());

            base.put(key, user);

        } catch (IOException e) {
            print("Update fail");
        }
        return base;
    }

    private HashMap<Integer, User> deleteUser(int key) {
        base.remove(key);
        return base;
    }
}

