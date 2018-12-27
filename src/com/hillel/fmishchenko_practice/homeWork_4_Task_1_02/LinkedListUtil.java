package com.hillel.fmishchenko_practice.homeWork_4_Task_1_02;

import java.util.LinkedList;

public class LinkedListUtil extends LinkedList {
    LinkedList list;
    LinkedListUtil(){
        this.list = new LinkedList();
    }


    public void setNums(){
        for (int i = 0; i < 20000; i++){
            list.add(i,(int)(Math.random() * 100));
        }
    }

    public LinkedList getLastNum(){
        while (list.size() > 1){
            for (int i = 0; i < list.size(); i += 2){
                list.remove(i);
            }
        }
        return list;
    }

    public void printlastNum(LinkedList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Number = " + list.get(i));

        }
    }
}
