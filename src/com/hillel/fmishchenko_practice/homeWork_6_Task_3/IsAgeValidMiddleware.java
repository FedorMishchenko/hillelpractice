package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

public class IsAgeValidMiddleware extends Middleware {

    private Server server;

    public IsAgeValidMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, Person person) {
        if(person.age < 20 || person.age > 50){
            System.out.println("Not valid age");
            return false;
        }
        return true;
    }
}
