package com.hillel.fmishchenko_practice.HomeWork_3_Task_1.Employee;

public class Position extends Engineer implements Employee {
    public Position(){

    }
    public Position(int id,String name,String position,int salary){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;

    }

}
