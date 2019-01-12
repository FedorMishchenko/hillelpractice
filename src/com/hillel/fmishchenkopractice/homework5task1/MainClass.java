package com.hillel.fmishchenkopractice.homework5task1;

import com.hillel.fmishchenkopractice.homework2Auto.Auto;
import com.hillel.fmishchenkopractice.homework2Auto.Auto4x4;
import com.hillel.fmishchenkopractice.homework2Auto.AutoHatch;
import com.hillel.fmishchenkopractice.homework2Auto.AutoSedan;



public class MainClass {
    public static void main(String[] args) {
        ListImplGenerics<Auto> list = new ListImplGenerics<>();
        AutoHatch hatch = new AutoHatch();
        hatch.setColor("Blue");
        list.addObject(hatch);
        list.addObject(new AutoSedan());
        list.addObject(new Auto4x4());
        System.out.println("List size = " + list.size);
        System.out.println("List is empty? = " + list.isEmpty());
        System.out.println(list.contains(hatch));
        System.out.println(list.getObjectByIndex(0));

    }
}
