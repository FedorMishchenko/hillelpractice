package com.hillel.fmishchenkopractice.homework9.task2;

import java.io.*;

public class DemoReflection {


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
        String className = null;
        try {
            className = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(className);

        getInstanceByReflection(className);

    }

    private  void getInstanceByReflection(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {

            Class cl = Class.forName(className);
            Person person = (Person) cl.newInstance();
            builder(person);
    }

    private void builder(Person person) {
        person.setName("Senya");
        person.setEmail("Gorbunkov@com");
        person.setAdress("Bobrovka");
        person.setAge("50");
        person.setProfession("Contrabandist");
    }


}
