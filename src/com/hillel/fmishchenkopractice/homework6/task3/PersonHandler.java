package com.hillel.fmishchenkopractice.homework6.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonHandler {
    private DataBase base = new DataBase();
    private Person person;

    public void read() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                setPersonValue(reader);
                register();
                showAndExit(reader);
            }
        }
    }

    private void register() {
        if(check(person)){
            base.register(person.getEmail(),person);
        }
    }

    private void showAndExit(BufferedReader reader) throws IOException {
        print("exit press: e , show persons press: s, continue press: Enter");
        String str = reader.readLine();
        if(str.equals("e")){
            System.exit(0);
        }else if(str.equals("s")){
            base.server.entrySet()
                    .stream().sorted()
                    .forEach(System.out::println);
        }
    }

    private void setPersonValue(BufferedReader reader) throws IOException {
        person = new Person();
        print("set email:");
        person.setEmail(reader.readLine());
        print("set profession:");
        person.setProfession(reader.readLine());
        print("set age:");
        person.setAge(Integer.parseInt(reader.readLine()));
    }

    private boolean check(Person person) {
        try {
            new EmailValidation(person).linkWith(new AgeValidation(person))
                    .linkWith(new ProfessionValidation(person));
        }catch (IllegalArgumentException e){
            print(e.getMessage());
            return false;
        }
        return true;
    }

    public void print(String s) {
        System.out.println(s);
    }
}
