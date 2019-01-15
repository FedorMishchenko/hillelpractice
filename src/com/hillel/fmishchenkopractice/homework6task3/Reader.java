package com.hillel.fmishchenkopractice.homework6task3;

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
        System.out.println("reg: (registerPerson)");
        System.out.println("set: (setVocation)");
        System.out.println("show: (showVocations)");
        System.out.println("exit: (system.exit)");
        System.out.println("per: (showPersons)");
        dataInput();

    }

    public void dataInput() {
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
            System.out.println(vocation);
        }
    }

    public void checkAll() {
        Middleware middleware = new PersonExistMiddleware(server)
                .linkWith(new IsAgeValidMiddleware(server))
                .linkWith(new IsVocationAvailable(server));
    }

}
