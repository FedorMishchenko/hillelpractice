package com.hillel.fmishchenkopractice.homework9.task2;

import java.io.*;

public class DemoReflection {
    public DemoReflection(){

    }
    private static String className;
    public void getClassNameFromXML() throws IllegalAccessException,
            InstantiationException, ClassNotFoundException {

        String s = ClassLoader.getSystemClassLoader().getResource("resources.properties").getFile();
        File f = new File(s);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        className = null;
        try {
            className = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(className);

        getInstanceByReflection(className);

    }

    private  Person getInstanceByReflection(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {

            Class cl = Class.forName(className);
            Builder builder = new Builder();
            Person person = builder.createInstance(cl.newInstance());
            person = buildObject(person);
            return person;

    }

    private Person buildObject(Person person) {
        person.setName("Senya");
        person.setEmail("Gorbunkov@com");
        person.setAdress("Bobrovka");
        person.setAge("50");
        person.setProfession("Contrabandist");
        return person;


    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        DemoReflection demo = new DemoReflection();
        demo.getClassNameFromXML();
        Person p = demo.getInstanceByReflection(className);
        System.out.println(p.toString());
    }

}
