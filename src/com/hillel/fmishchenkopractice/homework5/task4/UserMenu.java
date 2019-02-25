package com.hillel.fmishchenkopractice.homework5.task4;

import com.hillel.fmishchenkopractice.homework5.crud.DatabaseManager;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class UserMenu implements DatabaseManager {
    private static final Logger log = Logger.getLogger(UserMenu.class.getName());
    private DataImpl data = new DataImpl();
    private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
   @Override
    public void displayMenu() {
        try {
            while (true) {
                menu();
                options(reader.readLine());
            }
        } catch (IOException e) {
            log.info(e.getMessage());
            displayMenu();
        }
    }

    private void options(@NotNull String args) throws IOException {
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
        if (!isEmpty()) {
                printf();
            for (User x : data.getAll()) {
                printf(x);
            }
        }
    }

    private void update() throws IOException {
        if (!isEmpty()) {
            print("Input key to update:");
            Integer key = Integer.parseInt(reader.readLine());
            User x = data.get(key);
            print("Input field to update:");
            print("       1: Name," + '\n' +
                  "       2: Email," + '\n' +
                  "       3: Age," + '\n' +
                  "       4: Update all.");
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
        if (!isEmpty()) {
            info();
            switch (reader.readLine()) {
                case "1":
                    printf();
                    for (User x : data.sort()) {
                        printf(x);
                    }
                    break;
                case "2":
                    print("Input form:");
                    Integer arg1 = Integer.parseInt(reader.readLine());
                    print("Input to:");
                    Integer arg2 = Integer.parseInt(reader.readLine());
                    printf();
                    for (User x : data.sort(arg1, arg2)) {
                        printf(x);
                    }
                    break;
                case "3":
                    print("Input Name startWith:");
                    printf();
                    for (User x : data.sort(reader.readLine())) {
                        printf(x);
                    }
                    break;
            }
        }
    }

    private void info() {
        print("         Enter:");
        print("         1: Sort");
        print("         2: Sort form age to age");
        print("         3: Sort by Name startWith");
    }

    private void delete() throws IOException {
        if (!isEmpty()) {
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

    private User initialize(Integer id) throws IOException {
        print("Input name:");
        String name = reader.readLine();
        print("Input email:");
        String email = reader.readLine();
        print("Input age:");
        String age = reader.readLine();
        return new User().name(name).email(email)
                .age(Integer.parseInt(age)).id(id);
    }

    private void read() throws IOException {
        if (!isEmpty()) {
            print("Input key:");
            String key = reader.readLine();
            printf();
            printf(data.get(Integer.parseInt(key)));
        }
    }

    private void create() throws IOException {
        print("Input key:");
        Integer id = Integer.parseInt(reader.readLine());
        data.put(id, initialize(id));
    }

    private void menu() {
        print("____________________________________________");
        print("         CRUD Options: ");
        print("         1: Create Database Records");
        print("         2: Read Database Record");
        print("         3: Update Database Records");
        print("         4: Delete Database Records");
        print("         5: Read All Database Records");
        print("         6: Sort Records");
        print("         0: Exit");
        print("         SELECT Option:");
    }

    private void printf(@NotNull User x) {
        System.out.printf("%-5s",x.getId());
        System.out.printf("%-15s",x.getName());
        System.out.printf("%-15s",x.getEmail());
        System.out.printf("%-15s",x.getAge());
        print("");
    }

    private void printf() {
        System.out.printf("%-5s","ID");
        System.out.printf("%-15s","Name");
        System.out.printf("%-15s","Email");
        System.out.printf("%-15s","Age");
        print("");
    }


    private void print(String s) {
        System.out.println(s);
    }
}
