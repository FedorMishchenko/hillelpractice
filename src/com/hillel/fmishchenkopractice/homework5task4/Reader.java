package com.hillel.fmishchenkopractice.homework5task4;

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
                System.out.println("Input error");
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
             try {
                 sort();
             } catch (IOException e) {
                 System.out.println("Sort failed");
             }
         } else if (command.equals("delete")) {
             int key = scanner.nextInt();
             base = deleteUser(key);
             read();

         } else if (command.equals("exit")) {
             System.exit(0);
         } else System.out.println("Invalid command. Input command - " +
                 "create, read, update, delete, all, sort: ");
     }

     private String inputCommand() {
         String command = "";
         System.out.println("Input command: ");
         System.out.println("create, read, update, delete, all, sort: ");
         System.out.println("exit: to system.exit");
         return command;
     }

     private void sort() throws IOException {
        System.out.println("Input user's field for sort base:" +
                " name, email, age");
        String choice = buffer.readLine();
        if (choice.equals("name")) {
            ArrayList<User> compareName = new ArrayList<User>(base.values());

            Collections.sort(compareName, (o1, o2) -> {
                if(o1.getName().equals(o2.getName())){
                    return 1;
                }else return -1;
            });

            for (User user : compareName) {
                System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                        user.getAge());
            }

        } else if (choice.equals("email")) {
            ArrayList<User> compareEmail = new ArrayList<User>(base.values());

            Collections.sort(compareEmail, (o1, o2) -> {
                if(o1.getEmail().equals(o2.getEmail())){
                    return 1;
                }else return -1;

            });
            for (User user : compareEmail) {
                System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                        user.getAge());
            }

        } else if (choice.equals("age")) {

            ArrayList<User> compareAge = new ArrayList<User>(base.values());

            Collections.sort(compareAge, Comparator.comparingInt(User::getAge));

            for (User user : compareAge) {
                System.out.println(user.getName() + "\t" + user.getEmail() + "\t" +
                        user.getAge());
            }

        } else {
            System.out.println("Can't sort.Invalid input command.");
        }
    }

    private void getAll() {
        if(!base.isEmpty()) {
            ArrayList<User> list = new ArrayList<>(base.values());
            for (User user:list){
                System.out.println(user.toString());
            }
        }
    }

    private void readData() {
        System.out.println("Input user id " +
                "to read: ");
        int key = scanner.nextInt();
        System.out.println(base.containsKey(key));
        System.out.println(base.get(key));
        read();

    }

    HashMap createUser() {
        User user = new User();
        int key = user.hashCode();
        System.out.println("User id = " + key);
        base.put(key, user);
        updateUser();
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

