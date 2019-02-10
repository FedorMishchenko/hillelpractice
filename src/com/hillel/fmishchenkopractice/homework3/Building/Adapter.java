package com.hillel.fmishchenkopractice.homework3.Building;

public class Adapter implements Building {
    private PublicBuilding adapter;

    Adapter(PublicBuilding adapter){
        this.adapter = adapter;
    }

    @Override
    public void print() {
        this.adapter.print();
    }
}
