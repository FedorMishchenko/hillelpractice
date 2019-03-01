package com.hillel.fmishchenkopractice.homework5.task2.part3;

public class User implements Comparable<User> {

    private int age;
    private String name;
    private String email;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

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
                "UserDTO name= " + this.name + '\n' +
                        "user email= " +
                        this.email + '\n' +
                        "user age= " +
                        this.age;
    }

    @Override
    public int compareTo(User user) {
        return Integer.compare(age, user.age);
    }

    public boolean equals(User u) {
        if (this.email == u.email) return true;
        return false;
    }

}

