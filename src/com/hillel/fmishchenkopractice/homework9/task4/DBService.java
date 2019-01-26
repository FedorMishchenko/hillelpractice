package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.ArrayList;

public class DBService {
    public ArrayList list = new ArrayList();

    public void create(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "create = ");
            add(randomint);
        } else {
            throw new DBCheckedException();

        }
    }

    public void find(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "find = ");
            add(randomint);
        } else {
            throw new DBCheckedException();
        }

    }

    public void update(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "update = ");
            add(randomint);
        } else {
            throw new DBCheckedException();
        }

    }

    public void delete(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "delete = ");
            add(randomint);
        } else {
            throw new DBCheckedException();
        }
    }

    private void print(int randomint, String s) {
        System.out.println(s + randomint);
    }

    private void add(int randomint) {
        list.add(randomint);
    }

}

