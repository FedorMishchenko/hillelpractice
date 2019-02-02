package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.Arrays;

public class MultiMerger extends Thread {
    private volatile int[] unsorted;
    private volatile int i;
    private static int[] sorted;
    static final int MAX_THREADS_COUNT = 10;
    private int start;
    private int end;

    public MultiMerger(int[] unsorted, int start, int end){
        this.unsorted = unsorted;
        this.start = start;
        this.end = end;
    }

    public MultiMerger(int[] unsorted) {
        this.unsorted = unsorted;
    }

    @Override
    public void run(){
        int mid;
        if(unsorted.length <= 1) {
            sorted = unsorted;
        }else {
            mid = unsorted.length / MAX_THREADS_COUNT;
            if(activeCount() < MAX_THREADS_COUNT){
                for (i = 0; i < MAX_THREADS_COUNT; i++){
                    start = mid * i;
                    end = start + mid;
                    Arrays.sort(unsorted,start,end);
                    new MultiMerger(unsorted, start, end);
                }

            }
        }
        print(Arrays.toString(unsorted));
        print("Array size =  " + unsorted.length);
    }

    public void print(String s) {
        System.out.println(s);
    }

}
