package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.concurrent.ThreadLocalRandom;

public class UserService {
    private DBService dbService;
    int min = 0;
    int max = 5;

    @Transactional
    public void createUser() {
        dbService = new DBService();
        try {
            int randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
            dbService.create(randomint);

            randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
            dbService.find(randomint);

            randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
            dbService.update(randomint);

            randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
            dbService.delete(randomint);
        } catch (RuntimeException e) {
            System.out.println("Exception in method " + e.getMessage() + ": rollback()");
        }
    }
}
