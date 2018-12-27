package com.hillel.fmishchenkopractice.homework6task3;

public class IsVocationAvailable extends Middleware {

    private Server server;

    public IsVocationAvailable(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, Person person) {
        Reader reader = new Reader();
        for (int i = 0; i < reader.vocations.size(); i++) {
            int tmp;
            tmp = person.vocation.compareTo(new Person().vocation = reader.vocations.get(i));
            if(tmp != 0)
            return false;
        }
        return checkNext(email, person);
    }
}