package com.hillel.fmishchenko_practice.HomeWork_2_Auto;

abstract class Auto {
    static int doors;
    static String drive;
    static int tank;
    String mark;

    protected Auto() {
    }

    public String getDrive() {   // Возвращает значения привода авто
        return drive;
    }

    public void setDrive(String drive) { // Устанавливает значение привода авто
        this.drive = drive;
    }

    public int getDoors() {  // Возвращает количество дверей
        return doors;
    }

    public void setDoors(int doors) { // Устанавливает количество дверей
        this.doors = doors;
    }

    public int getTank() { // Возвращает емкость бака
        return tank;
    }

    public void setTank(int tank) { // Устанавливает емкость бака
        this.tank = tank;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
