package com.hillel.fmishchenkopractice.homework9.task4;

public class DBCheckedException extends IllegalArgumentException {
    public void getMassage(int massage){
        System.out.println("Illegal argument: " + massage);
    }
}
