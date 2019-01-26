package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UserService {
    private DBService dbService;
    private ArrayList arrayList = new ArrayList();
    int min = 0;
    int max = 5;
    int index = 0;
    @Transactional
    public void createUser() {

        dbService = new DBService();
        int randomint = 0;
        for (int i = 0; i < 5; i++) {
            index = 0;
            try {
                randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
                dbService.create(randomint);
                add(randomint);

                randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
                dbService.find(randomint);
                add(randomint);

                randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
                dbService.update(randomint);
                add(randomint);

                randomint = ThreadLocalRandom.current().nextInt(min, max + 2);
                dbService.delete(randomint);
                add(randomint);
                System.out.println("-----------------------------");
            } catch (DBCheckedException e) {
                e.getMassege(randomint);
                rollback();
                System.out.println("-----------------------------");
            }
        }
        System.out.println("List final values: " + arrayList);
    }

    private void add(int randomint) {
        if (randomint >= 0 && randomint < 6) {
            arrayList.add(randomint);
            index++;
        }
    }

    private void rollback(){
        while (index != 0){
            arrayList.remove(arrayList.size() - 1);
            index--;
        }
    }
}

