package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);
    private static Server server;

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
        Middleware middleware = new PersonExistMiddleware(server)
                .linkWith(new IsAgeValidMiddleware(server));
        readData();
    }

    String command;

    public void readData(){
        System.out.println("Input command:");
        System.out.println("1.register");
        System.out.println("2.exit");
        if ((command = scanner.nextLine()).equals("register")) {
            init();
        }else if ((command = scanner.nextLine()).equals("exit")){
            scanner.close();
        }else readData();
    }
}
