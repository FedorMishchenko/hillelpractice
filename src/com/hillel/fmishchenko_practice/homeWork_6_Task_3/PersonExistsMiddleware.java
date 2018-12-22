package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

public class PersonExistsMiddleware extends Middleware {
    private Server server;

    public PersonExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, Person person) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        return checkNext(email, person);
    }
}
