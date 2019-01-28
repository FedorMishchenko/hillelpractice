package com.hillel.fmishchenkopractice.homework2.auto;

import java.util.List;

public class AutoUtils {
    static List<Auto> market;
    public void addAutoToMarket(Auto auto){
        market.add(auto);
    }
    public void removeAutoFromMarket(Auto auto){
        market.remove(auto);
    }
    public void showAllAuto(){
        market.forEach(System.out::println);
    }
}
