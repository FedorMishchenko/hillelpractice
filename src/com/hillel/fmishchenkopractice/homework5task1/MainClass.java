package com.hillel.fmishchenkopractice.homework5task1;

import com.hillel.fmishchenko_practice.homeWork_2_Auto.*;
import com.hillel.fmishchenkopractice.homework2Auto.Auto;
import com.hillel.fmishchenkopractice.homework2Auto.Auto4x4;
import com.hillel.fmishchenkopractice.homework2Auto.AutoHatch;
import com.hillel.fmishchenkopractice.homework2Auto.AutoSedan;


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
