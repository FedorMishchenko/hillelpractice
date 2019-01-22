package com.hillel.fmishchenkopractice.homework9.task1.reflection;

public class UserBuilder {
    Class aClass;

    {
        try {
            aClass = Class.forName("User");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + aClass.getName());
        }
    }

    Object object;

    {
        try {
            object = aClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("InstantiationException in class: " + aClass.getName());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Illegal access to class: " + aClass.getName());
        }
    }

}
