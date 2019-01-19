package com.hillel.fmishchenkopractice.homework5task4;

public class User implements Comparable<User> {

    private int age;
    private String name;
    private String email;
    Integer id = this.hashCode();

    public User(String name,String email,int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public User() {

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
    public boolean equals(User u){
        if(this.email == u.email)return true;
        return false;
    }

}