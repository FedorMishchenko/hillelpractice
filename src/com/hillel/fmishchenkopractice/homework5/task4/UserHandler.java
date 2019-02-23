package com.hillel.fmishchenkopractice.homework5.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class UserHandler {
    private BufferedReader buffer =
            new BufferedReader(new InputStreamReader(System.in));
    private Scanner scanner = new Scanner(System.in);
    private HashMap<Integer, User> base = new HashMap<>();

    public void process() {
            String command = inputCommand();
            try {
                command = buffer.readLine();
            } catch (IOException e) {
                print("Input error");
            }
            crud(command);
            process();
    }

    private void crud(String command) {
        switch (command) {
            case "1":
                createCase(createUser());
                break;
            case "2":
                readCase();
                break;
            case "3":
                createCase(updateUser());
                break;
            case "4":
                getAll();
                break;
            case "5":
                sorted();
                break;
            case "6":
                delete();
                break;
            case "0":
                exit();
            default:
                defaultCase();
                break;
        }
    }

    private void createCase(HashMap<Integer, User> user) {
        base = user;
        process();
    }

    private void readCase() {
        if (base.isEmpty()) print("Empty");
        else {
            readData();
        }
        process();
    }

    private void defaultCase() {
        print("Invalid command. Input command - " +
                "1:create, 2:read, 3:update, 4:all, 5:sort, 6:delete, 0:exit ");
    }

    private void exit() {
        try {
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void delete() {
        print("Insert user id:");
        int key = scanner.nextInt();
        createCase(deleteUser(key));
    }

    private void sorted() {
        try {
            sort();
        } catch (IOException e) {
            print("Sort failed");
        }
    }

    private String inputCommand() {
        String command = "";
        print("Input command: ");
        print("1 = create, 2 = read, 3 = update, 4 = all users, 5 = sort, 6 = delete ");
        print("0 = system.exit");
        return command;
    }

    private void sort() throws IOException {
        String choice = input();
        switch (choice) {
            case "name":
                name();
                break;
            case "email":
                email();
                break;
            case "age":
                age();
                break;
            default:
                printDefault();
        }
    }

    private void printDefault() {
        print("Can't sort.Invalid input command.");
    }

    private void print(String s) {
        System.out.println(s);
    }

    private void age() {
        ArrayList<User> compareAge = new ArrayList<>(base.values());
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
                print("________________");
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
        int key = ThreadLocalRandom.current().nextInt(1,100);
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

