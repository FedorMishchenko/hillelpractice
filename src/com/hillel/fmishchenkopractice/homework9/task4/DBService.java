package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.ArrayList;

public class DBService {
    ArrayList list = new ArrayList();

    public void create(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            System.out.println("create = " + randomint);
            list.add(randomint);
        } else {
            list.clear();
            throw new RuntimeException("create: " + randomint);
        }
    }

    public void find(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            System.out.println("find = " + randomint);
            list.add(randomint);
        } else {
            list.clear();
            throw new RuntimeException("find: " + randomint);
        }

    }

    public void update(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            System.out.println("update = " + randomint);
            list.add(randomint);
        } else {
            list.clear();
            throw new RuntimeException("update: " + randomint);
        }

    }

    public void delete(int randomint) {
        if (randomint >= 0 & randomint <= 5){
            System.out.println("delete = " + randomint);
            list.add(randomint);
            System.out.print("List values: ");
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + ", ");
            }
        }
        else{
            list.clear();
            throw new RuntimeException("delete: " + randomint);
        }
    }
}

