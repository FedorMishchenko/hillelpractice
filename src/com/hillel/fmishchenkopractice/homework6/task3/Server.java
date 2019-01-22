package com.hillel.fmishchenkopractice.homework6.task3;

import java.util.ArrayList;
import java.util.HashMap;

public class Server{
    public HashMap<String, Person> users = new HashMap<>();
    private Middleware middleware;


    public boolean contains(String email){
        if(users.containsKey(email)){
            return true;
        }
        return false;
    }
    public ArrayList<Person> getAll(){
        ArrayList<Person> list = new ArrayList(users.entrySet());
        return list;
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
