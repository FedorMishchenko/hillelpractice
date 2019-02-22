package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.ArrayList;

public class DBService {
    public ArrayList<java.io.Serializable> list = new ArrayList<>();

    public void create(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(Thread.currentThread().getName()+ ": ", randomint, "create = ");
            add(randomint);
        } else {
            throw new DBCheckedException();

        }
    }

    void find(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(Thread.currentThread().getName() + ": ",randomint, "find = ");
            add(randomint);
        } else {
            throw new DBCheckedException();
        }

    }

    void update(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(Thread.currentThread().getName()+ ": ", randomint, "update = ");
            add(randomint);
        } else {
            throw new DBCheckedException();
        }

    }

    void delete(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(Thread.currentThread().getName()+ ": ", randomint, "delete = ");
            add(randomint);
        } else {
            throw new DBCheckedException();
        }
    }

    private void print(String name, int randomint, String s) {
        System.out.println(name + s + randomint);
    }

    private void add(int randomint) {
        list.add(randomint);
    }

}

