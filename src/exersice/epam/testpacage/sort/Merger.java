package exersice.epam.testpacage.sort;

public class Merger {

    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

            while ((aIndex + bIndex) < result.length) {
                if (aIndex < a.length && bIndex < b.length) {
                    if (a[aIndex] < b[bIndex]) {
                        result[aIndex + bIndex] = a[aIndex++];
                    } else {
                        result[aIndex + bIndex] = b[bIndex++];
                    }
                }else if(aIndex != a.length){
                    System.arraycopy(a,aIndex,result,(aIndex + bIndex),
                            result.length - (aIndex + bIndex));
                    return result;
                }else {
                    System.arraycopy(b,bIndex,result,(aIndex + bIndex),
                            result.length - (aIndex + bIndex));
                    return result;

                }
            }


        return result;
    }


}
