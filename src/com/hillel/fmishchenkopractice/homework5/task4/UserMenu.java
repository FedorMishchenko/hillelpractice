package com.hillel.fmishchenkopractice.homework5.task4;

import com.hillel.fmishchenkopractice.homework5.crud.interfaces.DatabaseManager;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserMenu implements DatabaseManager {
    private static final Logger log = Logger.getLogger(UserMenu.class.getName());
    private DataImpl data = new DataImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        menu();
        options();

    }


    private void options() {
        switch (scanner.nextInt()) {
            case 1:
                create();
                break;
            case 2:
                read();
                break;
            case 3:
                update();
                break;
            case 4:
                delete();
                break;
            case 5:
                readAll();
                break;
            case 6:
                sort();
                break;
            case 0:
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

    private void update() {
        if (!isEmpty()) {
            print("Enter key to update:");
            Integer key = scanner.nextInt();
            User x = data.get(key);
            print("Enter field to update:");
            format("%-15s", "1: Name", "2: Email", "3: Age", "4: Update all");
            switch (scanner.nextInt()) {
                case 1:
                    print("Enter name:");
                    x.name(scanner.nextLine());
                    break;
                case 2:
                    print("Enter email:");
                    x.email(scanner.nextLine());
                    break;
                case 3:
                    print("Enter age:");
                    x.age(scanner.nextInt());
                    break;
                case 4:
                    print("Enter name:");
                    x.name(scanner.nextLine());
                    print("Enter email:");
                    x.email(scanner.nextLine());
                    print("Enter age:");
                    x.age(scanner.nextInt());
                    break;
            }
            data.put(key, x);
        }
    }

    private void exit() {
        System.exit(0);
    }

    private void sort() {
        if (!isEmpty()) {
            info();
            switch (scanner.nextInt()) {
                case 1:
                    printf();
                    for (User x : data.sort()) {
                        printf(x);
                    }
                    break;
                case 2:
                    print("Enter form:");
                    Integer arg1 = scanner.nextInt();
                    print("Enter to:");
                    Integer arg2 = scanner.nextInt();
                    printf();
                    for (User x : data.sort(arg1, arg2)) {
                        printf(x);
                    }
                    break;
                case 3:
                    print("Enter Name startWith:");
                    printf();
                    for (User x : data.sort(scanner.nextLine())) {
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

    private void delete() {
        if (!isEmpty()) {
            print("Enter id for delete:");
            data.delete(scanner.nextInt());
        }
    }

    private boolean isEmpty() {
        if (data.size() == 0) {
            print("Is empty.");
            return true;
        }
        return false;
    }

    private User initialize(Integer id) {
        print("Enter name:");
        String name = scanner.nextLine();
        print("Enter email:");
        String email = scanner.nextLine();
        print("Enter age:");
        String age = scanner.nextLine();
        return new User().name(name).email(email)
                .age(Integer.parseInt(age)).id(id);
    }

    private void read() {
        if (!isEmpty()) {
            print("Enter key:");
            Integer key = scanner.nextInt();
            printf();
            printf(data.get(key));
        }
    }

    private void create() {
        print("Enter key:");
        Integer id = scanner.nextInt();
        data.put(id, initialize(id));
    }

    private void menu() {
        print("____________________________________________");
        print("         CRUD Service: ");
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
        System.out.printf("%-5s", x.getId());
        System.out.printf("%-15s", x.getName());
        System.out.printf("%-15s", x.getEmail());
        System.out.printf("%-15s", x.getAge());
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
