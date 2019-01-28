package com.hillel.fmishchenkopractice.homework9.task4;

public interface TransactionManager<T> {
    void process(T service);
}
