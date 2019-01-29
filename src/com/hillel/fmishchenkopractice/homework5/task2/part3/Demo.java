package com.hillel.fmishchenkopractice.homework5.task2.part3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<User> set = new TreeSet<>(Comparator.naturalOrder());
        ArrayList<User> list = new ArrayList<>();
        UserFactory<User> factory = User::new;
        set.add(factory.create("Ivan","ivan@com",30));
        set.add(factory.create("Peter","peter@com",28));
        set.add(factory.create("Jorge","jorge@com",37));
        list.addAll(set);
        set.forEach(System.out::println);
        System.out.println("------------------------");
        list.forEach(System.out::println);





    }
}
