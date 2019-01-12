package exersice.epam.testpacage.sort;

public class MergeSort {
    public static int[] sort(int[] arr, int from, int len) {
        int[] left;
        int[] right;
        if (len == 0) {
            return new int[0];
        } else if (len == 1) {
            return new int[]{arr[from]};
        } else if (len == 2) {
            if (arr[from] < arr[from + 1]) {
                return new int[]{arr[from], arr[from + 1]};
            } else {
                return new int[]{arr[from + 1], arr[from]};
            }
        } else {
            left = sort(arr, from, len / 2);
            right = sort(arr, from + (len / 2),
                    len - (len / 2));
        }
        return Merger.merge(left, right);
    }
}
