package com.hillel.fmishchenkopractice.homework6.task3;

public class EmailValidation extends Middleware {

    EmailValidation(Person person) {
        check(person);
    }

    @Override
    public boolean check(Person person) {
        if(!person.getEmail().contains("@")){
            throw new IllegalArgumentException("Not valid email: " + person.getEmail());
        }
        else return checkNext(person);
    }
}
