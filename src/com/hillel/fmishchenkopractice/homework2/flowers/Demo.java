package com.hillel.fmishchenkopractice.homework2.flowers;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {

        Map<String,Flower> map = new HashMap<>();
        map.put("1",new Flower.Builder()
                .name("rose").color("red").age(10).price(10.55f).build());
        map.put("2",new Flower.Builder()
                .name("aster").color("yellow").age(8).price(12.5f).build());
        map.put("3",new Flower.Builder()
                .name("chamomile").color("white").age(3).price(3.25f).build());
        map.forEach((k,v) -> System.out.println(
                "Number=" + k + " : " + v.toString()));

    }
}
