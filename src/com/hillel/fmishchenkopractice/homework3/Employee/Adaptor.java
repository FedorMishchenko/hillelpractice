package com.hillel.fmishchenkopractice.homework3.Employee;

public class Adaptor implements Employee{
    private Engineer engineer;

    public Adaptor(Engineer engineer){
        this.engineer = engineer;
    }

    @Override
    public void print() {
        this.engineer.print();
    }
}
