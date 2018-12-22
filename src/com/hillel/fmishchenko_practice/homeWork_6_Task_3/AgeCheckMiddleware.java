package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

public class AgeCheckMiddleware extends Middleware{
    private Server server;

    @Override
    public boolean check(String email, Person person) {
        if(server.hasEmail(email)){
            Integer age = person.age;
            if(age < 18 || age > 55)
                return false;
        }
        return checkNext(email,person);
    }
}
