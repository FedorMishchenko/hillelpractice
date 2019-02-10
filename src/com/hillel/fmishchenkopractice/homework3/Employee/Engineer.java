package com.hillel.fmishchenkopractice.homework3.Employee;

abstract class Engineer implements Employee{
    int id;
    protected String name;
    int salary;
    String position;

    public String getPosition() {
        return position;
    }

    void setPosition() {
        this.position = "руководитель отдела";
    }

    public int getSalary() {
        return salary;
    }

    void setSalary() {
        this.salary = 1000;
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
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
