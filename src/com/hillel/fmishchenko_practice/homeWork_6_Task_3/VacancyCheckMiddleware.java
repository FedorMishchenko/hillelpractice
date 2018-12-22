package com.hillel.fmishchenko_practice.homeWork_6_Task_3;

public class VacancyCheckMiddleware extends Middleware {
    private Server server;
    private Vacancy vacancies;

    @Override
    public boolean check(String email, Person person) {
        if (!server.hasEmail(email)){
            String vocation = person.vocation;
            if(vocation.equals(vacancies.getVacancy(vocation)))
                return false;
        }
        return checkNext(email,person);
    }
}
