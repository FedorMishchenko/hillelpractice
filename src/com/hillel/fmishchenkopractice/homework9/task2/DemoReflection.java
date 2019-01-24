package com.hillel.fmishchenkopractice.homework9.task2;

import java.io.*;
import java.lang.reflect.Field;

public class DemoReflection {
    private static Person person;


    public static String getClassNameFromXML() {

        String s = ClassLoader.getSystemClassLoader().getResource("resources.properties").getFile();
        File f = new File(s);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String className = null;
        try {
            className = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return className;
    }

    private Person createInstanceByReflection(String className) {
        try {
            Class clazz = Class.forName(className);
            person = (Person) clazz.newInstance();
            Field name, email, address, profession, age;
            try {
                name = person.getClass().getDeclaredField("name");
                name.setAccessible(true);

                email = person.getClass().getDeclaredField("email");
                email.setAccessible(true);

                address = person.getClass().getDeclaredField("address");
                address.setAccessible(true);

                profession = person.getClass().getDeclaredField("profession");
                profession.setAccessible(true);

                age = person.getClass().getDeclaredField("age");
                age.setAccessible(true);

                name.set(person, "Semen Semenich");
                email.set(person, "gorbunkov@com");
                address.set(person, "Dubrovka");
                profession.set(person, "contrabandist");
                age.set(person, Integer.parseInt("50"));


            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

        } catch (
                ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return person;
    }


    public static void main(String[] args) {
        person = new DemoReflection().createInstanceByReflection(getClassNameFromXML());
        System.out.println(person.toString());
    }


}
