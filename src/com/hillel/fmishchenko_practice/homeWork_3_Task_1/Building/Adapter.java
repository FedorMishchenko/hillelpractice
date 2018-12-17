package com.hillel.fmishchenko_practice.homeWork_3_Task_1.Building;

public class Adapter implements Building {
    private PublicBuilding adapter;

    public Adapter(PublicBuilding adapter){
        this.adapter = adapter;
    }

    @Override
    public void print() {
        this.adapter.print();
    }
}
