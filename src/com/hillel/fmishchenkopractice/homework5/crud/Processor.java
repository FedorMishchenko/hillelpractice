package com.hillel.fmishchenkopractice.homework5.crud;

import java.io.BufferedReader;
import java.io.IOException;

public interface Processor {
    void create(String name,String email, Integer age);
    void read();
    void update(BufferedReader reader, String id) throws IOException;
    void delete(BufferedReader reader, String id) throws IOException;
}
