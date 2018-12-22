package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

import java.util.HashMap;

public class Server {
    private HashMap<String, Person> users = new HashMap<>();
    private Middleware middleware;

    public boolean contains(String email){
        if(users.containsKey(email)){
            return true;
        }
        return false;
    }

    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public void register(String email, Person person) {
        users.put(email, person);
    }

    public boolean hasEmail(String email) {
        return users.containsKey(email);
    }

}
