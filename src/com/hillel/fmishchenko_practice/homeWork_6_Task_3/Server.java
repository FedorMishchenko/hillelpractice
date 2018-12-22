package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

import java.util.HashMap;

public class Server {
    private HashMap<String, Person> base = new HashMap<>();
    private Middleware middleware;

    public HashMap<String, Person> getBase(){
        return this.base;
    }


    public void setMiddleware(Middleware middleware) {
        this.middleware = middleware;
    }

    public boolean logIn(String email, Person person) {
        if (middleware.check(email, person)) {
            System.out.println("Authorization have been successful!");
//_______________________________________________






 //_____________________________________________________
                      return true;
        }
        return false;
    }

    public void register(String email, Person person) {
        base.put(email, person);
    }

    public boolean hasEmail(String email) {
        return base.containsKey(email);
    }


    public Person getPerson(String email) {
        return base.get(email);
    }
}
