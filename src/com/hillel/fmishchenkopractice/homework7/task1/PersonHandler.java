package com.hillel.fmishchenkopractice.homework7.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PersonHandler {
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    ArrayList<Person> list = new ArrayList<>();
    static StringBuffer buffer;
    String domen;
    Person person;

    public void read() throws IOException {
        dataInput();
    }

    private void dataInput() throws IOException {
        person = new Person();
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

    public String convert(Person person) {
        return
                convertInputToString1(person) + space() +
                convertInputToString2(person) + space() +
                convertInputToString3(person) + space() +
                convertInputToString4(person) + space();

    }

    public String space() {
        return '\n' + "-----------------------------" + '\n' ;
    }

    private void exit() throws IOException {
        reader.close();
    }

    public static String convertInputToString1(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getLogin() + " ==> "
                + person.getEmail());

        return buffer.toString();
    }

    public static String convertInputToString2(Person person) {
        buffer = new StringBuffer();
        buffer.append(person.getName() + " " +
                "(email: " + person.getEmail() + " )");

        return buffer.toString();
    }

    public String convertInputToString3(Person person) {
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

    public String convertInputToString4(Person person) {
        buffer = new StringBuffer();
        buffer.append("Login; Name; Email; Password" + '\n');
        buffer.append(person.getLogin() + ", " +
                person.getName() + "," +
                person.getEmail() + ", " + randomPassword());
        return buffer.toString();
    }

    int randomPassword() {
        int a = 0;
        int b = 10000;
        int num = a + (int) (Math.random() * b);
        return num;
    }

}
