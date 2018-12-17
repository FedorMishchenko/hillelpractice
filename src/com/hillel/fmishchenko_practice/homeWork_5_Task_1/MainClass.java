package com.hillel.fmishchenko_practice.homeWork_5_Task_1;

import com.hillel.fmishchenko_practice.homeWork_2_Auto.*;


public class MainClass {
    public static void main(String[] args) {

        ListImplGenerics<Auto> list = new ListImplGenerics<>();

        list.addObject(new AutoHatch());
        list.addObject(new AutoSedan());
        list.addObject(new Auto4x4());
        // list.addObject(new Object());  // Can't be applied
        System.out.println("List size = " + list.size);
        System.out.println("List is empty? = " + list.isEmpty());

    }
}
