package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergerHandler {

    public static void main(String[] args) {
        handler(100_000);

    }

    private static void handler(int size){

        int[] unsorted = new int[size];
        long startTime, endTime;
        for (int i = 0; i < size; i++) {
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
        StringBuilder loggerMulti = new StringBuilder(type + " sort : ");
        loggerMulti.append( (double) (endTime - startTime) / 1000 );
        loggerMulti.append(" seconds");
        System.out.println(loggerMulti.toString());
    }
}
