package com.hillel.fmishchenkopractice.homework6.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    private DataBase base = new DataBase();
    private Person person;
    private String str;

    public void read() throws IOException {
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
                print("save person press: y, continue press: n, exit press: e ");
                str = reader.readLine();
                if(str.equals("y")){
                    base.register(person.getEmail(),person);
                }else if(str.equals("e")){
                    System.exit(0);
                }else continue;
                print("show base press: s, continue: n");
                str = reader.readLine();
                if(str.equals("s")) base.server.entrySet().stream()
                        .sorted().forEach(System.out::println);
            }
        }
    }
    private void check(Person person) {
        Middleware ware = new EmailValidation(person).linkWith(new AgeValidation(person));
    }

    public void print(String s) {
        System.out.println(s);
    }
}
