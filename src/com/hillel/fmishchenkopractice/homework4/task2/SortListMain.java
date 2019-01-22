package com.hillel.fmishchenkopractice.homework4.task2;

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
