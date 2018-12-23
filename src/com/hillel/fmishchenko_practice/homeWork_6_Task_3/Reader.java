package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

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
        System.out.println("Input email:");
        person.setEmail(scanner.nextLine());
        System.out.println("Input vocation:");
        person.setVocation(scanner.nextLine());
        System.out.println("Input age");
        person.setAge(scanner.nextInt());
        server.register(person.email, person);
        System.out.println(server.contains(person.email));
        checkAll();
    }

    String command;

    public void readData() {
        System.out.println("Input command:");
        System.out.println("1.reg (registerPerson)");
        System.out.println("2.set (setVocation)");
        System.out.println("3.show (showVocations)");
        System.out.println("4.exit (system.exit)");
        System.out.println("5.per (showPersons)");
        loop();

    }

    public void loop() {
        switch (scanner.nextLine()) {
            case "reg":
                init();
                break;
            case "set":
                System.out.println("Input vocation:");
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
        loop();
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
            System.out.println(vocation);
        }
    }

    public void checkAll() {
        Middleware middleware = new PersonExistMiddleware(server)
                .linkWith(new IsAgeValidMiddleware(server))
                .linkWith(new IsVocationAvailable(server));
    }

}
