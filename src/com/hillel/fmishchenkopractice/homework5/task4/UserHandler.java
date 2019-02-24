package com.hillel.fmishchenkopractice.homework5.task4;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserHandler {
    private Data data = new DataBase();
    private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public void process(){
        try {
            while (true) {
                info();
                crud(reader.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
            process();
        }
    }

    private void crud(@NotNull String args) throws IOException {
        switch (args) {
            case "1":
                create();
                break;
            case "2":
                read();
                break;
            case "3":
                update();
                break;
            case "4":
                delete();
                break;
            case "5":
                readAll();
                break;
            case "6":
                sort();
                break;
            case "0":
                exit();
                break;
            default:
                break;
        }
    }

    private void readAll() {
        if(!isEmpty()) {
            for (User x : data.getAll()) {
                print(x.toString());
                print("___________________");
            }
        }
    }

    private void update() throws IOException {
        if(!isEmpty()) {
            print("Input key to update:");
            Integer key = Integer.parseInt(reader.readLine());
            User x = data.get(key);
            print("Input field to update:");
            print("Switch 1: name," + '\n' +
                    "       2: email," + '\n' +
                    "       3: age," + '\n' +
                    "       4: update all.");
            switch (reader.readLine()) {
                case "1":
                    print("input name:");
                    x.name(reader.readLine());
                    break;
                case "2":
                    print("input email:");
                    x.email(reader.readLine());
                    break;
                case "3":
                    print("input age:");
                    x.age(Integer.parseInt(reader.readLine()));
                    break;
                case "4":
                    print("input name:");
                    x.name(reader.readLine());
                    print("input email:");
                    x.email(reader.readLine());
                    print("input age:");
                    x.age(Integer.parseInt(reader.readLine()));
                    break;
            }
            data.put(key, x);
        }
    }

    private void exit() throws IOException {
        reader.close();
        System.exit(0);
    }

    private void sort() throws IOException {
        if(!isEmpty()) {
            print("Input:" + '\n'
                    + "1 = sort, 2 = sort from age to age," +
                    " 3 = sort by name startWith.");
            switch (reader.readLine()) {
                case "1":
                    for (User x : data.sort()) {
                        print(x.toString());
                        print("___________________");
                    }
                    break;
                case "2":
                    print("Input form:");
                    Integer arg1 = Integer.parseInt(reader.readLine());
                    print("Input to:");
                    Integer arg2 = Integer.parseInt(reader.readLine());
                    for (User x : data.sort(arg1, arg2)) {
                        print(x.toString());
                        print("___________________");
                    }
                    break;
                case "3":
                    print("Input Name startWith:");
                    for (User x : data.sort(reader.readLine())) {
                        print(x.toString());
                        print("___________________");
                    }
                    break;
            }
        }
    }

    private void delete() throws IOException {
        if (!isEmpty()){
            print("Input id for delete:");
            data.delete(Integer.parseInt(reader.readLine()));
        }
    }

    private boolean isEmpty() {
        if (data.size() == 0) {
            print("Is empty.");
            return true;
        }
        return false;
    }

    private User initialize() throws IOException {
        print("Input name:");
        String name = reader.readLine();
        print("Input email:");
        String email = reader.readLine();
        print("Input age:");
        String age = reader.readLine();
        return new User().name(name).email(email)
                .age(Integer.parseInt(age));
    }

    private void read() throws IOException {
        if(!isEmpty()){
            print("Input key:");
            String key = reader.readLine();
            print(data.get(Integer.parseInt(key)).toString());
        }
    }

    private void create() throws IOException {
        print("Input key:");
        data.put(Integer.parseInt(reader.readLine()), initialize());
    }

    @NotNull
    private void info() {
        print("Input: " + '\n' +
                "1 = create, 2 = read, 3 = update," +
                " 4 = delete, 5 = read all 6 = sort" + '\n' +
                "0 = exit.");
    }

    private void print(String s) {
        System.out.println(s);
    }
}
