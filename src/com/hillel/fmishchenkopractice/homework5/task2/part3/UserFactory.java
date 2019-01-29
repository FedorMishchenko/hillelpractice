package com.hillel.fmishchenkopractice.homework5.task2.part3;

public interface UserFactory<T> {
    T create(String name,String email,int age);
}
