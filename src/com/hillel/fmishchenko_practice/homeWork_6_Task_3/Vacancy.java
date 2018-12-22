package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

import java.util.LinkedList;

public class Vacancy {



    LinkedList<String> vacancies = new LinkedList<>();

    public void addVacancy(String vacancy) {
        vacancies.add(vacancy);
    }

    public void removeVacancy(String vacancy) {
        vacancies.remove(vacancy);
    }

    public void showAllVacancies(){
        for (String vacancy: vacancies){
            System.out.println(vacancy);
        }
    }
    public boolean getVacancy(String vocation) {
        if (vacancies.contains(vocation)) {
            return true;
        }
        return false;
    }
}
