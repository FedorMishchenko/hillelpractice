package com.hillel.fmishchenkopractice.homework4.part2;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int x = 28;
        int[] array = new int[]{3,55,43,19,x,99,10,63,17,22};
        array = sort(array);
        System.out.println(Arrays.toString(array));
    }

        private static int[] sort(int[] array){
            int length = array.length;
            boolean swapped;
            for (int i = 0; i < array.length; i++){
                swapped = false;
                for ( int j = 0; j < length - i - 1; j++){
                    if (array[j] > array[j + 1] ){
                        swapped = swap(array, j);
                    }
                }
                if (!swapped){
                    break;
                }
            }
            return array;
        }

    private static boolean swap(int[] array, int j) {
        int tmp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = tmp;
        return true;
    }

}
