package com.hillel.fmishchenkopractice.homework2.flowers;

import java.util.HashMap;

public class FlowerUtils {
    HashMap<String,Flower> bouquet = new HashMap<>();

    public HashMap add(String name,Flower flower){
        bouquet.put(name,flower);
        return bouquet;
    }

}
