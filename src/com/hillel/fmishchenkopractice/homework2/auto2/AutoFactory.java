package com.hillel.fmishchenkopractice.homework2.auto2;

public interface AutoFactory <T>{
    T create(String model,
             String body,String color,
             int year,int price);
}
