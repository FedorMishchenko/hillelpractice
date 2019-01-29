package com.hillel.fmishchenkopractice.homework6.task3;

import java.util.Objects;

public class Person {
    private String email;
    private String profession;
    private int age;

    public Person(String email,String profession,int age) {
        this.email = email;
        this.profession = profession;
        this.age = age;
    }

    public Person() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getEmail(), person.getEmail()) &&
                Objects.equals(getProfession(), person.getProfession());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getProfession(), getAge());
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", profession='" + profession + '\'' +
                ", age=" + age +
                '}';
    }
}
