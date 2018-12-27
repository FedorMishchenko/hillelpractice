package com.hillel.fmishchenkopractice.homework4task1part1;

import java.util.ArrayList;

public class RealisatlonArraylistMain {
    public static void main(String[] args) {
        int start ;
        int finish ;
        start = ((int) System.currentTimeMillis());
        ArrayListUtil arrayList = new ArrayListUtil();
        arrayList.setNums();
        ArrayList res = arrayList.getLastNum();
        arrayList.printLastNum(res);
        finish = ((int) System.currentTimeMillis());
        System.out.println();
        System.out.println("Timer = " + (finish - start));
    }
}
