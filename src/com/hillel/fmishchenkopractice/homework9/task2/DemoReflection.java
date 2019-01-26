package com.hillel.fmishchenkopractice.homework9.task2;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DemoReflection {
    private static Object object;
    private static Method method;

    private static String getClassNameFromXML() {

        String s = ClassLoader.getSystemClassLoader().getResource("resources.properties").getFile();
        File f = new File(s);
        try (BufferedReader reader = new BufferedReader(new FileReader(s))) {
            return reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private Object createInstanceByReflection(String className) {
        try {
            Class clazz = Class.forName(className);
            object = clazz.newInstance();
            try {
                setDataToPrivateFields("Semen Semenich", "gorbunkov@com",
                        "Dubrovka", "contrabandist", "50");
                getPrivateMethod();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                e.getMessage();
            }

        } catch (
                ClassNotFoundException | IllegalAccessException |
                        InstantiationException | NoSuchMethodException |
                        InvocationTargetException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return object;
    }

    private void getPrivateMethod() throws NoSuchMethodException {
        method = object.getClass().getDeclaredMethod("isValidUser");
        method.setAccessible(true);
    }

    private void setDataToPrivateFields(String aName, String aEmail,
                                        String aAddress, String aProfession,
                                        String aAge)
            throws NoSuchFieldException,
            IllegalAccessException, NoSuchMethodException,
            InvocationTargetException {
        Field name;
        Field email;
        Field address;
        Field profession;
        Field age;
        name = object.getClass().getDeclaredField("name");
        object.getClass().getMethod("setName", name.getType()).invoke(object,aName);

        email = object.getClass().getDeclaredField("email");
        object.getClass().getMethod("setEmail", email.getType()).invoke(object,aEmail);

        address = object.getClass().getDeclaredField("address");
        object.getClass().getMethod("setAddress", address.getType()).invoke(object,aAddress);

        profession = object.getClass().getDeclaredField("profession");
        object.getClass().getMethod("setProfession", profession.getType()).invoke(object,aProfession);

        age = object.getClass().getDeclaredField("age");
        object.getClass().getMethod("setAge", age.getType()).invoke(object,aAge);
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        object = new DemoReflection().createInstanceByReflection(getClassNameFromXML());
        System.out.println(object.toString());
        System.out.println(method.invoke(object));
    }


}
