package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

public class IsAgeValidMiddleware extends Middleware {

    private Server server;

    public IsAgeValidMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, Person person) {
        if((person.age < 20 )) {
            System.out.println("Too young");
            return false;
        }else if((person.age > 55)){
            System.out.println("Too old");
            return false;
        }
        else
        return checkNext(email,person);
    }
}
