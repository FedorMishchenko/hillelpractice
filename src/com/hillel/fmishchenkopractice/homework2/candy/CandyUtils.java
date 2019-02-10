package com.hillel.fmishchenkopractice.homework2.candy;

import java.util.ArrayList;
import java.util.List;

class CandyUtils {
    private static final int MAX = 100;
    private static final int MIN = 50;

    static List<Candy> checkForCandy(List<Candy> list){
       List<Candy> tmp = new ArrayList<>();
       for(Candy candy: list){
           if(candy.getPrice() < MAX && candy.getPrice() > MIN){
               tmp.add(candy);
           }
       }
       return tmp;
    }
}
