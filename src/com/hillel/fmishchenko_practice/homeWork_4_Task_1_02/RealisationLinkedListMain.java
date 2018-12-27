package com.hillel.fmishchenko_practice.homeWork_4_Task_1_02;

import java.util.LinkedList;

public class RealisationLinkedListMain {
    public static void main(String[] args) {
        int start ;
        int finish ;
        start = ((int) System.currentTimeMillis());
        LinkedListUtil list = new LinkedListUtil();
        list.setNums();
        LinkedList res = list.getLastNum();
        finish = ((int) System.currentTimeMillis());
        list.printlastNum(res);
        System.out.println("Timer = " + (finish - start));
    }
}
