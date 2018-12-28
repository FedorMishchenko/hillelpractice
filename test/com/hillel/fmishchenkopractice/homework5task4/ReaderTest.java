package com.hillel.fmishchenkopractice.homework5task4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ReaderTest {
    HashMap<Integer, User> base;

    @Test
    public void createUser(){
        base = new HashMap<>();
        User user = new User();
        int key = user.hashCode();
        base.put(key, user);
        assertEquals(user,base.get(key));

    }
    @Test
    public void updateUser(){
        base = new HashMap<>();
        User user = new User();
        int key = user.hashCode();
        user.setName("name");
        user.setEmail("email.com");
        user.setAge(20);
        base.put(key, user);

        assertEquals("name",base.get(key).getName());
        assertEquals("email.com",base.get(key).getEmail());
        assertEquals(20,base.get(key).getAge());

    }
    @Test
    public void deleteUser(){
        base = new HashMap<>();
        User user = new User();
        int key = user.hashCode();
        base.put(key, user);
        base.remove(key);
        assertTrue(base.isEmpty());
    }
    @Test
    public void getAll(){
        base = new HashMap<>();
        User user = new User();
        int key = user.hashCode();
        user.setName("name");
        user.setEmail("email.com");
        user.setAge(20);
        base.put(key, user);

        User user2 = new User();
        int key2 = user2.hashCode();
        user2.setName("name2");
        user2.setEmail("2email.com");
        user2.setAge(30);
        base.put(key2,user2);

        assertTrue(!base.isEmpty());
        System.out.println("user contains = " + base.containsValue(user));
        System.out.println("user2 contains = " + base.containsValue(user2));
        System.out.println();

        if(!base.isEmpty()) {
            ArrayList<User> list = new ArrayList<>(base.values());
            for (User u:list){
                System.out.println(u.toString());
                System.out.println();
            }
        }
    }

}