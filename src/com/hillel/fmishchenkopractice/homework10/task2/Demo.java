package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        int size = 10_000_000;
        int[] unsorted = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            unsorted[i] = random.nextInt(10_000);
        }
        long start = System.currentTimeMillis();
        new Merger(unsorted).sort();
        long end = System.currentTimeMillis();
        print("Merger time: ", end - start + '\n');

        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            unsorted[i] = random.nextInt(10_000);
        }
        MultiMerger merger = new MultiMerger(unsorted);
        merger.start();
        try {
            merger.join();
        } catch ( Exception e ) {
                /*NOP*/
        }
        end = System.currentTimeMillis();
        print("MultiMerger time: ", end - start);
        print("Threads count: ", MultiMerger.MAX_THREADS_COUNT);
    }

    public static void print(String s, long l) {
        System.out.println(s + (l));
    }
}
