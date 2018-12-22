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
        System.out.println("Input command: ");
        System.out.println("1.register");
        System.out.println("2.check");
        System.out.println("3.exit");

        if(reader.readLine().equals("register")){
            System.out.println("input person data: 1.email");
            Person person = new Person();
            person.setEmail(reader.readLine());
            String email = person.email;
            System.out.println("2.vocation");
            person.setVocation(reader.readLine());
            System.out.println("3.age");
            person.setAge(reader.read());
            server.register(email,person);
            if(server.hasEmail(person.email)){
                System.out.println("person already exists");
                System.out.println("Input command: ");
                reader.readLine();
            }else server.register(person.email,person);
            System.out.println("Input command: ");
            reader.readLine();

        }else if(reader.readLine().equals("check")){
            System.out.println("Input email");
            String email = reader.readLine();
            if(server.hasEmail(email)){
                Person person = server.getBase().get(email);
//TO DO checks
            }else if(reader.readLine().equals("exit")) reader.close();
        }else readInfo();
       }
    }

