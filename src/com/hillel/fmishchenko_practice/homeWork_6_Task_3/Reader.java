package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private static BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));
    private static Server server;
    private static Vacancy vacancy;
    Middleware middleware;
    Person person;


    public void readInfo() throws IOException {
        System.out.println("1.register");
        System.out.println("2.check");
        System.out.println("3.exit");


        if (reader.readLine().equals("register")) {
            init();
            readInfo();

        } else if (reader.readLine().equals("check")) {
            middleware.linkWith(new PersonExistsMiddleware(server))
                    .linkWith(new VacancyCheckMiddleware(vacancy));
            readInfo();
        } else if (reader.readLine().equals("Exit")) {
            reader.close();
        } else readInfo();
    }

    private void init() throws IOException {
        server = new Server();
        person = new Person();
        vacancy = new Vacancy();

        System.out.println("input data:" + '\n' + "1.email");
        person.setEmail(reader.readLine());
        String email = person.email;
        System.out.println("2.vocation");
        person.setVocation(reader.readLine());
        System.out.println("3.age");
        person.setAge(reader.read());
        server.register(email, person);

    }
}


