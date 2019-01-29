package com.hillel.fmishchenkopractice.homework6.task3;

import java.util.*;

public class Reader {
    Scanner scanner = new Scanner(System.in);
    private static Server server;
    ArrayList<String> vocations = new ArrayList<>();
    ArrayList<Set<Map.Entry<String, Person>>> list =
            new ArrayList<java.util.Set<java.util.Map.Entry<String, Person>>>();

    static {
        try {
            server = Server.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public void init() {
        Person person = new Person();
        print("Input email:");
        person.setEmail(scanner.nextLine());
        print("Input vocation:");
        person.setVocation(scanner.nextLine());
        print("Input age");
        person.setAge(scanner.nextInt());
        server.register(person.getEmail(), person);
        System.out.println(server.contains(person.getEmail()));
        checkAll();
    }

    String command;

    public void readData() {
        print("Input command:");
        print("reg: (registerPerson)");
        print("set: (setVocation)");
        print("show: (showVocations)");
        print("exit: (system.exit)");
        print("per: (showPersons)");
        dataInput();

    }

    public void print(String s) {
        System.out.println(s);
    }

    public void dataInput() {
        switch (scanner.nextLine()) {
            case "reg":
                init();
                break;
            case "set":
                print("Input vocation:");
                String vocation = scanner.nextLine();
                addVocation(vocation);
                break;
            case "show":
                showVocations();
                break;
            case "exit":
                exit();
            case "per":
                server.users.entrySet().stream()
                        .sorted(HashMap.Entry.<String, Person>comparingByValue())
                        .forEach(System.out::println);
            default:
                readData();
                break;
        }
        dataInput();
    }

    private void exit() {
        scanner.close();
        System.exit(0);
    }


    public void addVocation(String vocation) {
        vocations.add(vocation);
    }

    public void showVocations() {
        for (String vocation : vocations) {
            print(vocation);
        }
    }

    public void checkAll() {
        Middleware middleware = new PersonExistMiddleware(server)
                .linkWith(new IsAgeValidMiddleware(server))
                .linkWith(new IsVocationAvailable(server));
    }

}
