package com.hillel.fmishchenkopractice.homework5.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Reader {

    BufferedReader buffer =
            new BufferedReader(new InputStreamReader(System.in));
    Scanner scanner = new Scanner(System.in);

    HashMap<Integer, User> base = new HashMap<>();

    public Reader() {
    }

    public void read() {
        {
            String command = inputCommand();
            try {
                command = buffer.readLine();
            } catch (IOException e) {
                print("Input error");
            }
            crud(command);
            read();

        }

    }

    private void crud(String command) {
        if (command.equals("create")) {
            base = createUser();
            read();
        } else if (command.equals("read")) {
            if (base.isEmpty()) print("Empty");
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
            try {
                sort();
            } catch (IOException e) {
                print("Sort failed");
            }
        } else if (command.equals("delete")) {
            int key = scanner.nextInt();
            base = deleteUser(key);
            read();

        } else if (command.equals("exit")) {
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        } else print("Invalid command. Input command - " +
                "create, read, update, delete, all, sort: ");
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

        Collections.sort(compareAge, Comparator.comparingInt(User::getAge));

        for (User user : compareAge) {
            System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                    user.getAge());
        }
    }

    private void email() {
        ArrayList<User> compareEmail = new ArrayList<User>(base.values());

        Collections.sort(compareEmail, (o1, o2) -> {
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

        Collections.sort(compareName, (o1, o2) -> {
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
        read();

    }

    HashMap createUser() {
        User user = new User();
        int key = user.hashCode();
        print("User id = " + key);
        base.put(key, user);
        updateUser();
        return base;

    }

    private HashMap updateUser() {
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

    private HashMap deleteUser(int key) {
        base.remove(key);
        return base;
    }
}

