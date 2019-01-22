package com.hillel.fmishchenkopractice.homework9.task1.reflection;

import java.lang.reflect.Method;

public class UserServise {
    private Class clazz;
    private Object object;
    private Method[] methods;
    private Method enclosingMethod;

        private void getClazz(String className) {
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found: " + clazz.getName());
        }
    }
        private void getInstance() {
        try {
            object = clazz.newInstance();
            methods = object.getClass().getMethods();
            enclosingMethod = object.getClass().getEnclosingMethod();
        } catch (InstantiationException e) {
            throw new RuntimeException("InstantiationException in class: " + clazz.getName());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Illegal access to class: " + clazz.getName());
        }
    }
    public void createInstance(String className){
            getClazz(className);
            getInstance();
    }


}
