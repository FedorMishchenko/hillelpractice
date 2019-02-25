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
                log.warning("Illegal argument");
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
            print("Enter key to update:");
            Integer key = Integer.parseInt(reader.readLine());
            User x = data.get(key);
            print("Enter field to update:");
            format("%-15s", "1: Name", "2: Email", "3: Age", "4: Update all");
            switch (reader.readLine()) {
                case "1":
                    print("Enter name:");
                    x.name(reader.readLine());
                    break;
                case "2":
                    print("Enter email:");
                    x.email(reader.readLine());
                    break;
                case "3":
                    print("Enter age:");
                    x.age(Integer.parseInt(reader.readLine()));
                    break;
                case "4":
                    print("Enter name:");
                    x.name(reader.readLine());
                    print("Enter email:");
                    x.email(reader.readLine());
                    print("Enter age:");
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
                    print("Enter form:");
                    Integer arg1 = Integer.parseInt(reader.readLine());
                    print("Enter to:");
                    Integer arg2 = Integer.parseInt(reader.readLine());
                    printf();
                    for (User x : data.sort(arg1, arg2)) {
                        printf(x);
                    }
                    break;
                case "3":
                    print("Enter Name startWith:");
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
            print("Enter id for delete:");
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
        print("Enter name:");
        String name = reader.readLine();
        print("Enter email:");
        String email = reader.readLine();
        print("Enter age:");
        String age = reader.readLine();
        return new User().name(name).email(email)
                .age(Integer.parseInt(age)).id(id);
    }

    private void read() throws IOException {
        if (!isEmpty()) {
            print("Enter key:");
            String key = reader.readLine();
            printf();
            printf(data.get(Integer.parseInt(key)));
        }
    }

    private void create() throws IOException {
        print("Enter key:");
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

    private void format(String s, String s2, String s3, String s4, String s5) {
        System.out.printf(s, s2);
        System.out.printf("%-15s", s3);
        System.out.printf("%-15s", s4);
        System.out.printf("%-15s", s5);
    }

    private void printf(@NotNull User x) {
        System.out.printf("%-5s",x.getId());
        System.out.printf("%-15s",x.getName());
        System.out.printf("%-15s",x.getEmail());
        System.out.printf("%-15s",x.getAge());
        print("");
    }

    private void printf() {
        format("%-5s", "ID", "Name", "Email", "Age");
        print("");
    }


    private void print(String s) {
        System.out.println(s);
    }
}
