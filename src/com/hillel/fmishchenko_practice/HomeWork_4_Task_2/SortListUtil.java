package com.hillel.fmishchenko_practice.HomeWork_4_Task_2;

import java.awt.*;
import java.util.LinkedList;

public class SortListUtil extends LinkedList {
    int number;


    LinkedList<Integer> list = new LinkedList<>();

    public void setNums() {
        for (int i = 0; i < 20; i++) {
            list.add(i, (int) (Math.random() * 100));
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public void reset() {
        int a, b;
        number = list.get(list.size() / 2);
        System.out.println("x = " + number);
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.size() - 1; j > i; j--) {
                a = list.get(i);
                b = list.get(j);
                if (a > b) {
                    list.set(j, a);
                    list.set(i, b);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < number) continue;
            else {
                list.remove(i);
                list.add(i, number);
                break;
            }
        }
    }
    public void print(){
        System.out.println("List sorted: ");
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
    public void printlastNumBefore() {
        for (int i = 0; list.get(i) < number; i++){
            System.out.print(list.get(i) + " ");
        }


    }
    public void printlastNumAfter() {
        LinkedList tmp = new LinkedList();
        for (int i = list.size() - 1; number < list.get(i); i--) {
            tmp.add(list.get(i));

          }
        for(int i = tmp.size() - 1; i > 0; i--){
            System.out.print(tmp.get(i) + " ");
        }
    }


    }


