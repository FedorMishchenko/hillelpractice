package com.hillel.fmishchenkopractice.homework2.candy;

public interface CandyFactory<T>{
    T create(String name,String color,boolean sugar,int price);
}
