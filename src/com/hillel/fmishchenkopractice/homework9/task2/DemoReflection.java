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

    private Object createInstanceByReflection(String className) {
        try {
            Class clazz = Class.forName(className);
            object = clazz.newInstance();
            try {
                setDataToPrivateFields("Semen Semenich","gorbunkov@com",
                        "Dubrovka","contrabandist","50");
                getMethod();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                e.getMessage();
            }

        } catch (
                ClassNotFoundException | IllegalAccessException |
                InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
            e.getMessage();
        }
        return object;
    }

    private void getMethod() throws NoSuchMethodException {
        method = object.getClass().getDeclaredMethod("isValidUser");
        method.setAccessible(true);
    }

    private void setDataToPrivateFields(String aName,String aEmail,
                                       String aAddress,String aProfession,
                                       String aAge) throws NoSuchFieldException, IllegalAccessException {
        Field name;
        Field email;
        Field address;
        Field profession;
        Field age;
        name = object.getClass().getDeclaredField("name");
        name.setAccessible(true);
        name.set(object, aName);

        email = object.getClass().getDeclaredField("email");
        email.setAccessible(true);
        email.set(object, aEmail);

        address = object.getClass().getDeclaredField("address");
        address.setAccessible(true);
        address.set(object, aAddress);

        profession = object.getClass().getDeclaredField("profession");
        profession.setAccessible(true);
        profession.set(object, aProfession);

        age = object.getClass().getDeclaredField("age");
        age.setAccessible(true);
        age.set(object, Integer.parseInt(aAge));
    }


    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        object = new DemoReflection().createInstanceByReflection(getClassNameFromXML());
        System.out.println(object.toString());
        System.out.println(method.invoke(object));
    }


}
