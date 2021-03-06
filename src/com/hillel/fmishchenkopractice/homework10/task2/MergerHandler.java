package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergerHandler {

    public static void main(String[] args) {
        handler();

    }

    private static void handler(){

        int[] unsorted = new int[1_000_000];
        long startTime, endTime;
        for (int i = 0; i < 1_000_000; i++) {
            unsorted[i] = ThreadLocalRandom.current().nextInt(100);
        }
        /*print(unsorted, "unsorted: ");*/
        startTime = System.currentTimeMillis();
        Merger sorter = new Merger(unsorted);
        sorter.sort();
        /*print(sorter.getSorted(), "sorted: ");*/
        endTime = System.currentTimeMillis();
        printTime("Simple", startTime, endTime);
        print();
        startTime = System.currentTimeMillis();
        MultiMerger multiSorter = new MultiMerger(unsorted);
        /*print(unsorted, "unsorted: ");*/
        multiSorter.start();
        try {
            multiSorter.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       /* print(multiSorter.getSorted(), "sorted: ");*/
        endTime = System.currentTimeMillis();
        printTime("Multi thread", startTime, endTime);
    }

    private static void print() {
        System.out.println();
    }

    private static void print(int[] unsorted, String s) {
        System.out.println(s + Arrays.toString(unsorted));
    }


    private static void printTime(String type, long startTime, long endTime){
        String str = type + " sort : " + (double) (endTime - startTime) / 1000 +
                " seconds";
        System.out.println(str);
    }
}
