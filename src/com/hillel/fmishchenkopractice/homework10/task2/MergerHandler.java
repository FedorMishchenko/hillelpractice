package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.concurrent.ThreadLocalRandom;

public class MergerHandler {

    public static void main(String[] args) {
        handler(1_000_000);

    }

    private static void handler(int size){

        int[] unsorted = new int[size];
        long startTime, endTime;
        for (int i = 0; i < size; i++) {
            unsorted[i] = ThreadLocalRandom.current().nextInt(1000);
        }

        startTime = System.currentTimeMillis();
        Merger sorter = new Merger(unsorted);
        sorter.sort();
        endTime = System.currentTimeMillis();
        printTime("Simple", startTime, endTime);
        int[] sorted = sorter.getSorted();

        startTime = System.currentTimeMillis();
        MultiMerger multiSorter = new MultiMerger(unsorted);
        for (int i = 0; i < size; i++) {
            unsorted[i] = ThreadLocalRandom.current().nextInt(1000);
        }
        multiSorter.start();
        try {
            multiSorter.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        endTime = System.currentTimeMillis();
        printTime("Multi thread", startTime, endTime);
        int[] sortedMulti = multiSorter.getSorted();
    }


    private static void printTime(String type, long startTime, long endTime){
        StringBuilder loggerMulti = new StringBuilder(type + " sort : ");
        loggerMulti.append( (double) (endTime - startTime) / 1000 );
        loggerMulti.append(" seconds");
        System.out.println(loggerMulti.toString());
    }
}
