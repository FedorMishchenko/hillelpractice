package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.Arrays;

public class MultiMerger2 extends Thread {
    private volatile int[] unsorted;
    private int[] sorted;
    static final int MAX_THREADS_COUNT = 10;
    private int start;
    private int end;

    public MultiMerger2(int[] unsorted,int start,int end){
        this.unsorted = unsorted;
        this.start = start;
        this.end = end;
    }

    public MultiMerger2(int[] unsorted) {
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
                for (int i = 0; i < MAX_THREADS_COUNT; i++){
                    start = mid * i;
                    end = start + mid;
                    Arrays.sort(unsorted,start,end);
                    new MultiMerger2(unsorted,start,end).run();
                }

            }
        }
        sorted = unsorted;
        System.out.println("finish sort");
    }
    public int[] getSorted() {
        return sorted;
    }
}
