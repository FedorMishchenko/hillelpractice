package com.hillel.fmishchenkopractice.homework3.Edition;

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
