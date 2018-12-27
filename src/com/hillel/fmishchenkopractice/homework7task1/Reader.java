package com.hillel.fmishchenkopractice.homework7task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reader {
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    ArrayList<Person> list = new ArrayList<>();
    static StringBuffer buffer;
    String domen;
    Person person;

    public void read() throws IOException {
        loop();
    }

    private void loop() throws IOException {
        Person person = new Person();
        System.out.println();
        System.out.println("exit - system.exit");
        System.out.println("press enter - to input");
        String command = reader.readLine();
        if (command.equals("exit")) {
            exit();
            return;
        }
        System.out.println("Login:");
        person.setLogin(reader.readLine());
        System.out.println("Name:");
        person.setName(reader.readLine());
        System.out.println("Email:");
        person.setEmail(reader.readLine());
        list.add(person);
        convert(person);

        loop();
    }

    public void convert(Person person) {
        System.out.println(convert1(person));
        System.out.println(convert2(person));
        System.out.println(convert3(person));
        System.out.println(convert4(person));
    }

    private void exit() throws IOException {
        reader.close();
    }

    public static String convert1(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getLogin() + " ==> "
                + person.getEmail());

        return buffer.toString();
    }

    public static String convert2(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getName() + " " +
                "(email: " + person.getEmail() + " )");

        return buffer.toString();
    }

    public String convert3(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getEmail());
        int index = buffer.indexOf("@");
        domen = buffer.substring(index);
        buffer.delete(0, buffer.length());
        buffer.append(domen + " ==> ");
        buffer.append(person.getLogin() + ", ");
        for (int i = 0; i < list.size(); i++) {
            Person tmp = list.get(i);
            if (person.compareTo(tmp) == 0) {
                buffer.append(tmp.getLogin() + ", ");
            } else continue;
        }
        return buffer.toString();
    }
    public String convert4(Person person){
        buffer = new StringBuffer();
        buffer.append("Login; Name; Email; Password" + '\n');
        buffer.append(person.getLogin() + ", " +
                person.getName() + "," +
                person.getEmail() + ", " + randomPassword());
        return buffer.toString();
    }
    int randomPassword(){
        int a = 0;
        int b = 10000;
        int num = a + (int) (Math.random() * b);
        return num;
    }

}
