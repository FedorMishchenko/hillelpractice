package com.hillel.fmishchenkopractice.homework5.crud.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface ProcessorManager {
    void create(String name,String email, Integer age);
    void read();
    void update(String id) throws IOException;
    void delete(String id) throws IOException;
}
