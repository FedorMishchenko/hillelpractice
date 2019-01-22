package com.hillel.fmishchenkopractice.homework6.task2;

public interface Stack<T> {

    void add(T value);

    void set();

    T get();

    void remove();

    void clear();

    int size();

    T getStart();

    T getEnd();
}
