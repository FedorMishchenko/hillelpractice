package com.hillel.fmishchenkopractice.homework6.task3;

public class ProfessionValidation extends Middleware {

    ProfessionValidation(Person person) {
        check(person);
    }

    @Override
    public boolean check(Person person) {
        if((person.getProfession().length() < 2)
                || (person.getProfession().length() > 20) ){
            throw new IllegalArgumentException("Not valid profession: " + person.getProfession());
        }
        else return checkNext(person);
    }
}
