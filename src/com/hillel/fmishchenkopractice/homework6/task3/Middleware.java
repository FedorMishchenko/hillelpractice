package com.hillel.fmishchenkopractice.homework6.task3;

public abstract class Middleware {
    private final ThreadLocal<Middleware> next = new ThreadLocal<>();
    Middleware linkWith(Middleware next) {
        this.next.set(next);
        return next;
    }
    public abstract boolean check(Person person);

    boolean checkNext(Person person) {
        if (next.get() == null) {
            return true;
        }
        return next.get().check(person);
    }
}
