package com.hillel.fmishchenko_practice.homeWork_6_Task_2;

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
