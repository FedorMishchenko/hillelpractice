package com.hillel.fmishchenkopractice.homework3.Employee;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Position();
        ((Position) employee).setId(1);
        ((Position) employee).setName("Иванов");
        ((Position) employee).setPosition("руководитель отдела");
        ((Position) employee).setSalary(1000);

        Engineer departmentHead = new Position(2,"Петров","менеджер",900);
        employee.print();
        departmentHead.print();

        Engineer engineer = new Position(3,"Сидоров","зам.руководителя",800);
        Employee newEmployee = new Adaptor(engineer);
        newEmployee.print();
    }
}
