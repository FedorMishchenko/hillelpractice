package com.hillel.fmishchenkopractice.homework2.text;

public interface TextFactory <T>{
    T create(String headLine,String text);
}
