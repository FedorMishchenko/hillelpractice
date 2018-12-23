package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

public class Person implements Comparable<Person> {
    String email;
    String vocation;
    Integer age;

    public Integer getAge() {
        return age;
    }

    public String getVocation() {
        return vocation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVocation(String vocation) {
        this.vocation = vocation;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.getEmail().compareTo(person.getEmail());
    }
}
