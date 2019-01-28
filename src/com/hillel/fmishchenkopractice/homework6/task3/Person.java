package com.hillel.fmishchenkopractice.homework6.task3;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String email;
    /*private*/ String vocation;
    private Integer age;

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
        return getEmail().compareTo(person.getEmail());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getEmail(), person.getEmail()) &&
                Objects.equals(getVocation(), person.getVocation()) &&
                Objects.equals(getAge(), person.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getVocation(), getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                ", vocation='" + vocation + '\'' +
                ", age=" + age +
                '}';
    }

}
