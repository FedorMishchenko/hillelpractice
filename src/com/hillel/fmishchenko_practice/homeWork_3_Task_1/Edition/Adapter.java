package com.hillel.fmishchenko_practice.homeWork_3_Task_1.Edition;

public class Adapter implements Edition {
    private Book adapter;

    public Adapter(Book adapter){
        this.adapter = adapter;
    }

    @Override
    public void print() {
        this.adapter.print();
    }
}