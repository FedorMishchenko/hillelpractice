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
        server.register(person.email,person);
        System.out.println(server.contains(person.email));
        boolean success;
                do {
                    Middleware middleware = new PersonExistMiddleware(server)
                            .linkWith(new IsAgeValidMiddleware(server))
                            .linkWith(new IsVocationAvailable(server));
                    success = true;
                }while (!success);
        server.users.entrySet().stream()
                .sorted(HashMap.Entry.<String,Person>comparingByValue())
                .forEach(System.out::println);
    }

    String command;

    public void readData(){
        System.out.println("Input command:");
        System.out.println("1.'register' = register person");
        System.out.println("2.'update' = convert map to list");
        System.out.println("3.'add' = add vocation");
        System.out.println("4.'show' = show available vocations");
        System.out.println("5.'exit' = exit from programm");
        if ((command = scanner.nextLine()).equals("register")) {
            init();
            readData();
        }else if((command = scanner.nextLine()).equals("update")){
            update(server.users);
            readData();
        }else if((command = scanner.nextLine()).equals("add")){
            System.out.println("Input vocation:");
            String vocation = scanner.nextLine();
            addVocation(vocation);
            readData();
        }else if((command = scanner.nextLine()).equals("show")){
            showVocations();
            readData();
        }else if ((command = scanner.nextLine()).equals("exit")){
            scanner.close();
        }else readData();
    }
    public ArrayList<Set<Map.Entry<String, Person>>> update(HashMap<String,Person> map){
        list.add(map.entrySet());
        return list;
    }
    public void addVocation(String vocation){
        vocations.add(vocation);
    }
    public void showVocations(){
        for (String vocation: vocations){
            System.out.println(vocation);
        }
    }
}
