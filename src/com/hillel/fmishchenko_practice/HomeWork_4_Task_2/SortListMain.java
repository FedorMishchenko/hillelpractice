package com.hillel.fmishchenko_practice.HomeWork_4_Task_2;

import com.hillel.fmishchenko_practice.HomeWork_4_Task_1_02.LinkedListUtil;

import java.util.LinkedList;

public class SortListMain {
    public static void main(String[] args) {
        SortListUtil list = new SortListUtil();
        list.setNums();
        list.reset();
        list.print();
        System.out.println("Before x: ");
        list.printlastNumBefore();
        System.out.println('\n' + "After x: ");
        list.printlastNumAfter();
    }
}
