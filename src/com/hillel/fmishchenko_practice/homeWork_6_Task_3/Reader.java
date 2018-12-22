package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));
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
    private static Vacancy vacancy;
    Middleware middleware;


    public void readInfo() throws IOException {
        System.out.println("1.register");
        System.out.println("2.check");
        System.out.println("3.exit");
        Person person = new Person();

        if (reader.readLine().equals("register")) {
            System.out.println("input data:" + '\n' + "1.email");
            person.setEmail(reader.readLine());
            String email = person.email;
            System.out.println("2.vocation");
            person.setVocation(reader.readLine());
            System.out.println("3.age");
            person.setAge(reader.read());
            if (server.hasEmail(email)) {
                System.out.println("Person already exists");
                readInfo();
            } else {
                System.out.println("Person registered");
                server.register(email,person);
                readInfo();
            }
             }
         else if (reader.readLine().equals("check")) {
            System.out.println("Input email");
            String email = reader.readLine();
            if (server.hasEmail(email)) {
                person = server.getPerson(email);
                middleware.check(person.email, person);
                readInfo();
            } else System.out.println("Person exists");
            readInfo();
        } else if (reader.readLine().equals("Exit")) {
            reader.close();
        } else readInfo();
      }
    }


