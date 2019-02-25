package com.hillel.fmishchenkopractice.homework5.task4;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class User implements Comparable<User> {

    private int age;
    private String name;
    private String email;
    private Integer id;

    public User() {}

    public String getEmail() {
        return email;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public String getName() {
        return name;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User age(int age) {
        this.age = age;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public User id(Integer id) {
        this.id = id;
        return this;
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
    public int compareTo(@NotNull User user) {
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

    @Contract(value = "null -> false", pure = true)
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