package com.hillel.fmishchenkopractice.homework6.task3;

public class AgeValidation extends Middleware {

    AgeValidation(Person person) {
        check(person);
    }

    @Override
    public boolean check(Person person) {
        if((person.getAge() < 20 | person.getAge() > 55)){
            throw new IllegalArgumentException("Not valid age: " + person.getAge());
        }
        else return checkNext(person);
    }
}
