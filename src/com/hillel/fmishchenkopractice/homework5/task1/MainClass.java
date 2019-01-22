package com.hillel.fmishchenkopractice.homework5.task1;

import com.hillel.fmishchenkopractice.homework2.homework2Auto.Auto;
import com.hillel.fmishchenkopractice.homework2.homework2Auto.Auto4x4;
import com.hillel.fmishchenkopractice.homework2.homework2Auto.AutoHatch;
import com.hillel.fmishchenkopractice.homework2.homework2Auto.AutoSedan;


public class MainClass {
    public static void main(String[] args) {
        ListImplGenerics<Auto> list = new ListImplGenerics<>();
        AutoHatch hatch = new AutoHatch("Reno");
        hatch.setColor("Blue");
        list.addObject(hatch);
        list.addObject(new AutoSedan("Bmw"));
        list.addObject(new Auto4x4("Dodge"));
        System.out.println("List size = " + list.size);
        System.out.println("List is empty? = " + list.isEmpty());
        System.out.println(list.contains(hatch));
        System.out.println(list.getObjectByIndex(0));

    }
}
