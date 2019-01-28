package com.hillel.fmishchenkopractice.homework2.electricapps;

public interface ElectricAppsFactory<E> {
    E create(String name,int power,int price);
}
