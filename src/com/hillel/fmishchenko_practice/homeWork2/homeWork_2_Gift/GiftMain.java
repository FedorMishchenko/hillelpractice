package com.hillel.fmishchenko_practice.homeWork2.homeWork_2_Gift;

public class GiftMain {
    public static void main(String[] args) {
        Chocolate roshen = new Roshen("roshen",55,100,84);
        Chocolate avk = new Avk("avk",48,110,88);
        Chocolate conti = new Conti("conti",52,90,67);

        Chocolate[] chocolates = new Chocolate[]{roshen,avk,conti};

        int weght = 0;
        for (Chocolate f : chocolates) {
            int tmp = f.getWeight();
            weght += tmp;
        }

        System.out.println("Gift weight = " + weght + " gramm");

        for (Chocolate f: chocolates){
            if(f.getSugar() < 50 && f.getSugar() > 45 ){
                System.out.println( f.getName() + " contains sugar =  = " + f.getSugar() );
            }

        }


    }
}
