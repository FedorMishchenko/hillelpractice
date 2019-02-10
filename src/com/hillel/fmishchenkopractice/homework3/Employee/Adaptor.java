package com.hillel.fmishchenkopractice.homework3.Employee;

public class Adaptor implements Employee{
    private Engineer engineer;

    Adaptor(Engineer engineer){
        this.engineer = engineer;
    }

    @Override
    public void print() {
        this.engineer.print();
    }
}
