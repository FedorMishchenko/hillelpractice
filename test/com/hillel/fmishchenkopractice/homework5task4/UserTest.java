package com.hillel.fmishchenkopractice.homework5task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void compareTo() {
        User user1 = new User("Ivan","Ivan@com",12);
        User user2 = new User("Ivan","Ivan@com",12);

        int id = user1.id;
        int id2 = user2.id;

        assertEquals(0,user1.compareTo(user2));

        assertNotEquals(id,id2);

    }
}