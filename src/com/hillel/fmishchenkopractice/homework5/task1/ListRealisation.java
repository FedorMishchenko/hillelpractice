package com.hillel.fmishchenkopractice.homework5.task1;

import com.hillel.fmishchenkopractice.homework4.part3.LinkedList;

import java.util.concurrent.ThreadLocalRandom;

public class ListRealisation {
    private final static int MIN = 0;
    private final static int MAX = 100;
        public static void main(String[] args) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < 10; i++){
                list.add(ThreadLocalRandom.current().nextInt(MIN,MAX));
            }
            System.out.println("size = " + list.getSize());
            for (int i = 0; i < list.getSize(); i++){
                System.out.print(list.get(i) + ", ");
            }


    }
}
