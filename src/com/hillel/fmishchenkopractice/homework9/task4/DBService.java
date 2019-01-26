package com.hillel.fmishchenkopractice.homework9.task4;

import java.util.ArrayList;

public class DBService {
    ArrayList list = new ArrayList();

    public void create(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "create = ");
            add(randomint);
        } else {
            rollback();
            throw new RuntimeException("create() invalid value = " + randomint);
        }
    }

    public void find(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "find = ");
            add(randomint);
        } else {
            rollback();
            throw new RuntimeException("find() invalid value = " + randomint);
        }

    }

    public void update(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "update = ");
            add(randomint);
        } else {
            rollback();
            throw new RuntimeException("update() invalid value = " + randomint);
        }

    }

    public void delete(int randomint) {
        if (randomint >= 0 & randomint <= 5) {
            print(randomint, "delete = ");
            add(randomint);
            printList();
        } else {
            rollback();
            throw new RuntimeException("delete() invalid value = " + randomint);
        }
    }

    private void print(int randomint, String s) {
        System.out.println(s + randomint);
    }

    private void add(int randomint) {
        list.add(randomint);
    }

    private void rollback() {
        list.clear();
    }

    private void printList() {
        System.out.print("List values { ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print("}");
    }
}

