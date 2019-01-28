package com.hillel.fmishchenkopractice.homework2.auto;

public interface AutoFactory <T>{
    T create(String model,
             String body,String color,
             int year,int price);
}
