package com.hillel.fmishchenkopractice.homework4task3;

import com.hillel.fmishchenko_practice.homeWork_3_Task_2.GeometryFigures.*;
import com.hillel.fmishchenkopractice.homework3task2.GeometryFigures.Figure;
import com.hillel.fmishchenkopractice.homework3task2.GeometryFigures.Rectangle;
import com.hillel.fmishchenkopractice.homework3task2.GeometryFigures.Rhombus;
import com.hillel.fmishchenkopractice.homework3task2.GeometryFigures.Square;

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

