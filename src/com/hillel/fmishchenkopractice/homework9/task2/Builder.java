package com.hillel.fmishchenkopractice.homework9.task2;

public class Builder extends Person {
    private Person person;
    public Person createInstance(Object ob){
        this.person = (Person) ob;
        return person;
    }
}
