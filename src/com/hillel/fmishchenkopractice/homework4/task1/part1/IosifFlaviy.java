package com.hillel.fmishchenkopractice.homework4.task1.part1;

import com.hillel.fmishchenkopractice.homework4.task1.part3.LinkedList;

public class IosifFlaviy {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        int n = 10;
        int k = 3;
        for (int i = 0; i<n; i++){
            list1.add(i+1);
        }
        int pos =0;
        while (list1.getSize()!=1)
        {
            pos = (pos+k-1)%list1.getSize();
            System.out.println(pos);
            list1.remove(pos);
        }
        System.out.print("Last number = " + list1.get(0));
    }
    }

