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
    public synchronized void createUser() {
        for (int i = 0; i < 10; i++) {
            dbService = new DBService();
            int randomint = 0;
            /*threadsPool();*/
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
                print("-----------------------------");
            } catch (DBCheckedException e) {
                e.getMassege(randomint);
                rollback();
                print("-----------------------------");
            }

            print(Thread.currentThread().getName() + ": " + "List save values: " + arrayList);

        }
    }

    public void threadsPool() {
        Thread thread = new Thread(() -> {
            createUser();
            dbService.list.add(arrayList);
        });
        thread.start();
    }


    private void print(String s) {
        System.out.println(s);
    }

    private void add(int randomint) {
        if (randomint >= 0 && randomint < 6) {
            arrayList.add(randomint);
            index++;
        }
    }

    private void rollback() {
        while (index != 0) {
            arrayList.remove(arrayList.size() - 1);
            index--;
        }
    }
}

