package exersices.testpacage.sort;

import java.util.Arrays;

public class SortTest {
    static void bubleSort(int[] arr) {

        int tmp = 0;
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (arr[index] > arr[index + 1]) {
                    tmp = arr[index];
                    arr[index] = arr[index + 1];
                    arr[index + 1] = tmp;
                }
            }
        }
        /*System.out.println(Arrays.toString(arr));*/
    }

    static void insertSort(int[] arr) {
        int tmp, j;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                tmp = arr[i + 1];
                arr[i + 1] = arr[i];
                j = i;
                while (j > 0 && tmp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = tmp;
            }
        }
        /*System.out.println(Arrays.toString(arr));*/
    }

    public static void main(String[] args) {

/*      int[] arr = new int[]{83, 25, 13, 11, 10, 7, 0, 2, 6, 77};
        int[] arr2 = new int[]{1,46,2,47,9};
        bubleSort(arr);
        bubleSort(arr2);
        insertSort(arr2);
        System.out.println("index = " + Arrays.binarySearch(arr,3));
        System.arraycopy(arr,2,arr,3,5);
        System.arraycopy(arr,2,arr2,3,5);*//*
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        System.out.println(Arrays.toString(Merger.merge(arr,arr2)));*/
        //Recursion.f(5);
       // Recursion2.f(5);
        int[] arr = new int[]{83, 25, 13, 11, 10, 7, 0, 2, 6, 77};
        int[] array = MergeSort.sort(arr,0,arr.length);
        System.out.println(Arrays.toString(array));
    }


}
