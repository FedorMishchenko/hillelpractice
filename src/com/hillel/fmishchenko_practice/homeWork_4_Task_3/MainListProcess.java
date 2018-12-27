package com.hillel.fmishchenko_practice.homeWork_4_Task_3;

import com.hillel.fmishchenko_practice.homeWork_3_Task_2.GeometryFigures.*;

public class MainListProcess {
    public static void main(String[] args) {
        MyListImpl <Figure> myList = new MyListImpl();
        myList.addObject(new Rectangle(10));
        myList.addObject(new Rhombus(15));
        myList.addObject(new Square(25));

        System.out.println(myList.size);
        System.out.println(myList.isEmpty());

        System.out.println(myList.getObjectByIndex(2).toString());
    }
}

