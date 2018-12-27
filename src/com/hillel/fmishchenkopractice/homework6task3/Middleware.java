package com.hillel.fmishchenkopractice.homework6task3;

public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email, Person person);

    protected boolean checkNext(String email, Person person) {
        if (next == null) {
            return true;
        }
        return next.check(email, person);
    }
}
