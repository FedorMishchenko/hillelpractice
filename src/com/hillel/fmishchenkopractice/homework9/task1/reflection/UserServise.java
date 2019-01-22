package com.hillel.fmishchenkopractice.homework9.task1.reflection;

public class UserServise {
    Class clazz;
    Object object;
        private void getClazz() {
        try {
            clazz = Class.forName("User");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + clazz.getName());
        }
    }
        private void getInstance() {
        try {
            object = clazz.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("InstantiationException in class: " + clazz.getName());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Illegal access to class: " + clazz.getName());
        }
    }
    public void createUser(){
            getClazz();
            getInstance();
    }

}
