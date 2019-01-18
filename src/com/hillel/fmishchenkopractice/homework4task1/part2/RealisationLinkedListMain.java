package com.hillel.fmishchenkopractice.homework4task1.part2;

import com.hillel.fmishchenkopractice.homework4task1.part2.LinkedListUtil;

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
