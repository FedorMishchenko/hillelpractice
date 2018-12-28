package com.hillel.fmishchenkopractice.homework5task2part3;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void compareTo() {
        User user = new User();
        user.setName("Name");
        user.setEmail("email@com");
        user.setAge(30);

        User user2 = new User();
        user2.setName("Name");
        user2.setEmail("email@com");
        user2.setAge(30);

        assertEquals(0,user.compareTo(user2));
    }
}