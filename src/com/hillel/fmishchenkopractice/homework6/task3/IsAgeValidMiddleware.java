package com.hillel.fmishchenkopractice.homework6.task3;

public class IsAgeValidMiddleware extends Middleware {

    private Server server;

    public IsAgeValidMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, Person person) {
        if((person.getAge() < 20 )) {
            System.out.println("Too young");
            return false;
        }else if((person.getAge() > 55)){
            System.out.println("Too old");
            return false;
        }
        else
        return checkNext(email,person);
    }
}
