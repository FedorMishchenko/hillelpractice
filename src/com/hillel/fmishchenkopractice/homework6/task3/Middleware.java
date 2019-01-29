package com.hillel.fmishchenkopractice.homework6.task3;

public abstract class Middleware {
    private Middleware next;
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }
    public abstract boolean check(Person person);

    protected boolean checkNext(Person person) {
        if (next == null) {
            return true;
        }
        return next.check(person);
    }
}
