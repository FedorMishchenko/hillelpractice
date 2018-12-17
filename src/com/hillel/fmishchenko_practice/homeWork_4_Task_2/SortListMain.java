package com.hillel.fmishchenko_practice.homeWork_4_Task_2;

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
