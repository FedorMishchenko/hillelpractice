package com.hillel.fmishchenkopractice.homework10.task2;

public class Merger {
    private int[] unsorted;
    private int[] sorted;

    public Merger(int[] unsorted) {
        this.unsorted = unsorted;
    }

    public void sort() {
        int mid;
        int[] left;
        int[] right;
        if (unsorted.length <= 1) {
            sorted = unsorted;
        } else {
            mid = unsorted.length / 2;
            left = new int[mid];
            right = new int[unsorted.length - mid];
            copy(mid, left, 0);
            copy(unsorted.length - mid, right, mid);
            new Merger(left).sort();
            new Merger(right).sort();
            sorted = merge(left, right);
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int cursorL = 0, cursorR = 0, index = 0;
        int[] result = new int[left.length + right.length];
        while (cursorL < left.length && cursorR < right.length) {
            if (left[cursorL] <= right[cursorR]) {
                result[index] = left[cursorL];
                cursorL++;
            } else {
                result[index] = right[cursorR];
                cursorR++;
            }
            index++;
        }
        if (cursorL < left.length) {
            copy(left, cursorL, index, result, result.length - index);
        }
        if (cursorR < right.length) {
            copy(right, cursorR, index, result, result.length - index);
        }
        return result;
    }

    public void copy(int mid, int[] part, int i) {
        copy(unsorted, i, 0, part, mid);
    }

    public static void copy(int[] part, int cursor, int index, int[] result, int i) {
        System.arraycopy(part, cursor, result, index, i);
    }
    public int[] getSorted(){
        return sorted;
    }
}
