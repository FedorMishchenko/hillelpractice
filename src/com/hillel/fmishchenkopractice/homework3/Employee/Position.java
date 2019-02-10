package com.hillel.fmishchenkopractice.homework3.Employee;

class Position extends Engineer implements Employee {
    Position(){

    }
    Position(int id, String name, String position, int salary){
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

}
