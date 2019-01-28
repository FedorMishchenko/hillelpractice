package com.hillel.fmishchenkopractice.homework2.flowers;

public interface FlowerFactory {
    Flower create(String name,String color,
                  Integer age,Integer price);
}
