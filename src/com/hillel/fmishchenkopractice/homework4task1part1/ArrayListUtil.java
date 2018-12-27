package com.hillel.fmishchenkopractice.homework4task1part1;

import java.util.ArrayList;

public class ArrayListUtil extends ArrayList {
    ArrayList arrayList = new ArrayList();


    public void setNums() {
        for (int i = 0; i < 20000; i++) {
            arrayList.add(i, (int) (Math.random() * 100));

           // System.out.print(arrayList.get(i) + " ");
        }

    }

    public ArrayList getLastNum() {
        while (arrayList.size() > 1) {
            for (int i = 0; i < arrayList.size(); i += 2) {
                arrayList.remove(i);
            }
        }
        return arrayList;

    }

    public void printLastNum(ArrayList list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.print("Number = " + list.get(i) + " ");

        }

    }

}
