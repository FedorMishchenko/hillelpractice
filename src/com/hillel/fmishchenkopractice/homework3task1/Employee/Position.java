package com.hillel.fmishchenkopractice.homework3task1.Employee;

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
