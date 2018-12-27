package com.hillel.fmishchenko_practice.homeWork_3_Task_1.Employee;

abstract class Engineer implements Employee{
    protected int id;
    protected String name;
    protected int salary;
    protected String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("employee name = " + name + '\n' + "employee id = " + id  +
                '\n' + "employee salary = " + salary + '\n' + "employee position = " + position + '\n');
    }
}
