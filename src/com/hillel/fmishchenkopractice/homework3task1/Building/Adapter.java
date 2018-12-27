package com.hillel.fmishchenkopractice.homework3task1.Building;

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
