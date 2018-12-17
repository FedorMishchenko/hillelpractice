package com.hillel.fmishchenko_practice.flowersBouquet;

import java.util.Arrays;

public class FlowersBouquet {
    public static void main(String[] args) {
        Flowers aster = new Aster();          //Определение параметров цветов
        aster.setColor("Blue");
        aster.setAge(2);
        aster.setName("aster");
        aster.setPrice(15);

        Flowers orchid = new Orchid();
        orchid.setAge(3);
        orchid.setName("orchid");
        orchid.setPrice(40);

        Flowers rose = new Rose();
        rose.setAge(4);
        rose.setName("rose");
        rose.setPrice(25);

        Flowers[] bouquet = new Flowers[]{orchid, aster, rose};   //Создание букета цветов
        Arrays.sort(bouquet);

        for (Flowers f : bouquet)                                  //Сортировка по свежести
            System.out.println(f.getName() + ": " +
                    " days age = " + f.getAge() + ", price = " + f.getPrice());

        int price = 0;                                              //Общая стоимость букета
        for (Flowers f : bouquet) {
            int tmp = f.getPrice();
            price += tmp;
        }
        System.out.println("Bouquet price = " + price);

        for (Flowers f: bouquet){                                    //Поиск самого дешевого цветка в букете
            if(f.getPrice() <= 15)
                System.out.println("Cheapest flower = " + f.getName());
        }
    }
}
