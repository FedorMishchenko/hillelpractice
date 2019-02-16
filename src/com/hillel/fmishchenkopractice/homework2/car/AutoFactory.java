package com.hillel.fmishchenkopractice.homework2.car;

public interface AutoFactory<T>{
    T create(Auto.type T, String fuel, String drive);
}
