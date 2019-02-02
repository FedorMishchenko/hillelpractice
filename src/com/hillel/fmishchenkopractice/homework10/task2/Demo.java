package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.concurrent.ThreadLocalRandom;

public class Demo {
    public static void main(String[] args) {
        final int size = 1_000_000;
        long start,end;
        int[] unsorted = new int[size];
        for (int i = 0; i < size; i++){
            unsorted[i] = ThreadLocalRandom.current().nextInt(0,10_000);
        }
        start = System.currentTimeMillis();
        new Merger(unsorted).sort();
        end = System.currentTimeMillis();
        print("Merger time: ", end - start + '\n');
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            unsorted[i] = ThreadLocalRandom.current().nextInt(0,10_000);
        }
        MultiMerger merger2 = new MultiMerger(unsorted);
        merger2.start();
        end = System.currentTimeMillis();
        print("MultiMerger time: ", end - start);
    }

    public static void print(String s, long l) {
        System.out.println(s + (l));
    }
}
