package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.concurrent.ThreadLocalRandom;

public class UserService {
    private DBService dbService;
    int min = 0;
    int max = 6;


    public void createUser(){
        dbService = new DBService();
        try {
            int randomint = ThreadLocalRandom.current().nextInt(min, max + 1);
            System.out.println(randomint);
            dbService.create(randomint);

            randomint = ThreadLocalRandom.current().nextInt(min, max + 1);
            System.out.println(randomint);
            dbService.find(randomint);

            randomint = ThreadLocalRandom.current().nextInt(min, max + 1);
            System.out.println(randomint);
            dbService.update(randomint);

            randomint = ThreadLocalRandom.current().nextInt(min, max + 1);
            System.out.println(randomint);
            dbService.delete(randomint);
        }catch (Exception e){
            System.out.println("Exception in: " + e);
        }
    }
}
