package com.hillel.fmishchenkopractice.homework6.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private DataBase base;
    private static Person person;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                person = new Person();
                print("set email:");
                person.setEmail(reader.readLine());
                print("set profession:");
                person.setProfession(reader.readLine());
                print("set age:");
                person.setAge(Integer.parseInt(reader.readLine()));
                check(person);
            }
        }
    }
    private static void check(Person person) {
        Middleware ware = new EmailValidation(person).linkWith(new AgeValidation(person));
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
