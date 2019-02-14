package exersices.testpacage.testexample;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SortUniqueStream {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,1,2,2,2,2,3,3,3,3,3,3};
        System.out.println(Arrays.toString(new SortUniqueStream().distinct(arr)));

    }
    private Integer[] distinct(int[] arr){
        Set<Integer> unique = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        Integer[] res = new Integer[unique.size()];
        return unique.toArray(res);
    }

}
