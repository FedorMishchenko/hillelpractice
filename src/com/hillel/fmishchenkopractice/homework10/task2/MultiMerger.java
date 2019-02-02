package com.hillel.fmishchenkopractice.homework10.task2;

import static java.lang.Thread.activeCount;

public class MultiMerger extends Thread{
    private int[] unsorted;
    private int[] sorted;
    static final int MAX_THREADS_COUNT = 10;

    public MultiMerger(int[] unsorted){
        this.unsorted = unsorted;
    }

    @Override
    public void run() {
        int mid;
        int[] left;
        int[] right;

        if(unsorted.length <= 1){
            sorted = unsorted;
        }else {
            mid = unsorted.length / 2;
            left = new int[mid];
            right = new int[unsorted.length - mid];

            copy(mid, left, 0);
            copy(unsorted.length - mid, right, mid);

            if(activeCount() < MAX_THREADS_COUNT){
                MultiMerger leftMerger = new MultiMerger(left);
                MultiMerger rightMerger = new MultiMerger(right);
                leftMerger.run();
                rightMerger.run();
                try {
                    leftMerger.join();
                    rightMerger.join();
                    sorted = Merger.merge(leftMerger.getSorted(),rightMerger.getSorted());
                }catch (InterruptedException e){
                    /*NOP*/
                }
                Merger leftSort = new Merger( left );
                Merger rightSort = new Merger( right );

                leftSort.sort();
                rightSort.sort();

                sorted = Merger.merge( leftSort.getSorted(), rightSort.getSorted() );
            }
        }

    }
    public int[] getSorted() {
        return sorted;
    }

    public void copy(int mid, int[] part, int i) {
        System.arraycopy(unsorted, i, part, 0, mid);
    }
}
