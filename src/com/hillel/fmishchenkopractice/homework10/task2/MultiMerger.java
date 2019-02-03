package com.hillel.fmishchenkopractice.homework10.task2;

import java.util.Arrays;

public class MultiMerger extends Thread {
    private volatile int[] unsorted;
    private volatile int i;
    static final int MAX_THREADS_COUNT = 4;
    private int start;
    private int end;

    public MultiMerger(int[] unsorted) {
        this.unsorted = unsorted;
    }

    @Override
    public void run(){
        int mid;
        if(unsorted.length <= 1) {
        }else {
            mid = unsorted.length / MAX_THREADS_COUNT;
            if(activeCount() < MAX_THREADS_COUNT){
                for (i = 0; i < MAX_THREADS_COUNT; i++){
                    start = mid * i;
                    end = start + mid;
                    Arrays.sort(unsorted,start,end);
                    new MultiMerger(unsorted);
                }
            }
        }
        long startMerge = System.currentTimeMillis();
        merge(unsorted,0,unsorted.length - 1);
        System.out.println("Merge time: " + (System.currentTimeMillis() - startMerge));
        print(Arrays.toString(unsorted));
        print("Array size =  " + unsorted.length);
    }

    public void print(String s) {
        System.out.println(s);
    }
    private void merge(int[] arr, int start, int end) {

        if (end <= start)
            return;
        int mid = start + (end - start) / 2;
        merge(arr, start, mid);
        merge(arr, mid + 1, end);

        int[] buf = Arrays.copyOf(arr, arr.length);

        for (int k = start; k <= end; k++)
            buf[k] = arr[k];

        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++) {

            if (i > mid) {
                arr[k] = buf[j];
                j++;
            } else if (j > end) {
                arr[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                arr[k] = buf[j];
                j++;
            } else {
                arr[k] = buf[i];
                i++;
            }
        }
    }
}
