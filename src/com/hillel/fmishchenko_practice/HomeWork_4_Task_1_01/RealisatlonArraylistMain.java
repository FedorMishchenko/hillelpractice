package com.hillel.fmishchenko_practice.HomeWork_4_Task_1_01;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

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
