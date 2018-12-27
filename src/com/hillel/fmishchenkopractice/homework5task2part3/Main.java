package com.hillel.fmishchenkopractice.homework5task2part3;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        user1.setName("A");
        user1.setAge(45);
        user1.setEmail("equals@gmail");

        user2.setName("A");
        user2.setAge(15);
        user2.setEmail("equals@gmail");

        TreeSet<User> set = new TreeSet<>();
        set.add(user1);
        set.add(user2);

        if ((user2.compareTo(user1)) > 0)
            System.out.println(user2.toString());
        else System.out.println(user1.toString());


    }
}
