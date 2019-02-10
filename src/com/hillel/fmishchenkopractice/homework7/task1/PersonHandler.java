package com.hillel.fmishchenkopractice.homework7.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PersonHandler {
    private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private ArrayList<Person> list = new ArrayList<>();
    private static StringBuffer buffer;

    public void read() throws IOException {
        dataInput();
    }

    private void dataInput() throws IOException {
        Person person = new Person();
        print("exit - system.exit");
        print("press enter - to input");
        String command = reader.readLine();
        if (exit(command)) return;
        header(person);
        list.add(person);
        print(convert(person));
        dataInput();
    }

    private boolean exit(String command) throws IOException {
        if (command.equals("exit")) {
            exit();
            return true;
        }
        return false;
    }

    private void header(Person person) throws IOException {
        print("Login:");
        person.setLogin(reader.readLine());
        print("Name:");
        person.setName(reader.readLine());
        print("Email:");
        person.setEmail(reader.readLine());
    }

    private void print(String s) {
        System.out.println(s);
    }

    private String convert(Person person) {
        return
                convertInputToString1(person) + space() +
                convertInputToString2(person) + space() +
                convertInputToString3(person) + space() +
                convertInputToString4(person) + space();

    }

    private String space() {
        return '\n' + "-----------------------------" + '\n' ;
    }

    private void exit() throws IOException {
        reader.close();
    }

    private static String convertInputToString1(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getLogin()).append(" ==> ").append(person.getEmail());

        return buffer.toString();
    }

    private static String convertInputToString2(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getName()).append(" ")
                .append("(email: ").append(person.getEmail()).append(" )");

        return buffer.toString();
    }

    private String convertInputToString3(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getEmail());
        int index = buffer.indexOf("@");
        String domain = buffer.substring(index);
        buffer.delete(0, buffer.length());
        buffer.append(domain).append(" ==> ");
        buffer.append(person.getLogin()).append(", ");
        for (Person tmp : list) {
            if (person.compareTo(tmp) == 0) {
                buffer.append(tmp.getLogin()).append(", ");
            }
        }
        return buffer.toString();
    }

    private String convertInputToString4(Person person) {
        buffer = new StringBuffer();
        buffer.append("Login; Name; Email; Password" + '\n');
        buffer.append(person.getLogin()).append(", ")
                .append(person.getName()).append(",")
                .append(person.getEmail()).append(", ")
                .append(randomPassword());
        return buffer.toString();
    }

    private int randomPassword() {
        int a = 0;
        int b = 10000;
        return a + (int) (Math.random() * b);
    }

}
