package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.concurrent.ThreadLocalRandom;

public class Demo {
    public static void main(String[] args) {
        final int size = 100_000;
        long start,end;
        int[] unsorted = new int[size];
        for (int i = 0; i < size; i++){
            unsorted[i] = ThreadLocalRandom.current().nextInt(0,1_000);
        }
        start = System.currentTimeMillis();
        new Merger(unsorted).sort();
        /*Arrays.sort(unsorted);*/
        end = System.currentTimeMillis();
        print("Merger time: ", end - start + '\n');
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++){
            unsorted[i] = ThreadLocalRandom.current().nextInt(0,1_000);
        }
        MultiMerger merger = new MultiMerger(unsorted);
        merger.start();
        end = System.currentTimeMillis();
        print("MultiMerger time: ", end - start);
    }

    public static void print(String s, long l) {
        System.out.println(s + (l));
    }
}
