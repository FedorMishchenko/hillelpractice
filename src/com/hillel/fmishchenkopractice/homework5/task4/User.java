package com.hillel.fmishchenkopractice.homework5.task4;

import java.util.Objects;

public class User implements Comparable<User> {

    private int age;
    private String name;
    private String email;
    private Integer id = this.hashCode();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return
                "User name = " + this.name + '\n' +
                        "User email = " +
                        this.email + '\n' +
                        "User age = " +
                        this.age;
    }

    @Override
    public int compareTo(User user) {
        if (!getName().equals(user.getName())) {
            if (getName().compareTo(user.name) > 0) return 1;
            else return -1;
        }
        if (!getEmail().equals(user.getEmail())) {
            if (getEmail().compareTo(user.email) > 0) return 1;
            else return -1;
        }
        return Integer.compare(age, user.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                getName().equals(user.getName()) &&
                getEmail().equals(user.getEmail()) &&
                id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getEmail(), id);
    }
}