package com.hillel.fmishchenkopractice.homework6.task3;

public class PersonExistMiddleware extends Middleware {

    private Server server;

    public PersonExistMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, Person person) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        return checkNext(email, person);
    }
}
