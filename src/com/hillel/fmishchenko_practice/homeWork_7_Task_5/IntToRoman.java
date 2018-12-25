package com.hillel.fmishchenko_practice.homeWork_7_Task_5;

public class IntToRoman {

        public  String convert(int n) {
            int tmp = n;
            String[] a = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
            int[] b = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
            StringBuilder s = new StringBuilder();
            for (int i = a.length - 1; i >= 0; i--) {
                while (n >= b[i]) {
                    s.append(a[i]);
                    n -= b[i];
                }
            }
            return tmp + " ===> " + s.toString();
        }

}
