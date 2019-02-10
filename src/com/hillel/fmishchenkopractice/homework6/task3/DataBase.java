package com.hillel.fmishchenkopractice.homework6.task3;

import java.util.HashMap;

class DataBase {
    HashMap<String, Person> server = new HashMap<>();
    private Middleware middleWare;

    void register(String email, Person person){
        server.put(email,person);
    }
}
