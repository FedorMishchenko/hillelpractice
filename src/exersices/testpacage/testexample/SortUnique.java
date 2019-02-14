package exersices.testpacage.testexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SortUnique {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3};
        new SortUnique().distinct(arr);
        System.out.println(Arrays.toString(new SortUnique().distinct2(arr)));

    }


    private void distinct(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for (int i : arr) {
            unique.add(i);
        }
        unique.forEach(System.out::println);
    }

    private int[] distinct2(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(!list.contains(arr[i])){
                list.add(arr[i]);
            }
        }
        arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
