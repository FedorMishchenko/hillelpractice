package com.hillel.fmishchenkopractice.homework6.task3;

public class EmailValidation extends Middleware {
    private Person person;

    public EmailValidation(Person person) {
        this.person = person;
        check(person);
    }

    @Override
    public boolean check(Person person) {
        if(!person.getEmail().contains("@")){
            System.out.println("Not valid email: " + person.getEmail());
            return false;
        }
        else return checkNext(person);
    }
}
