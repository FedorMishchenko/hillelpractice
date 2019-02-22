package com.hillel.fmishchenkopractice.homework9.task4;

class DBCheckedException extends IllegalArgumentException {
    void getMassage(int massage){
        System.out.println("Illegal argument: " + massage);
    }
}
