package com.hillel.fmishchenkopractice.homework6.task3;

import java.util.HashMap;

public class DataBase {
    public HashMap<String, Person> server = new HashMap<>();
    private Middleware middleWare;

    public void register(String email,Person person){
        server.put(email,person);
    }
}
