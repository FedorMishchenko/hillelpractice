package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.io.BufferedReader;
import java.io.IOException;

public interface Query {
    String create(BufferedReader reader) throws IOException;
    String read();
    String update(String id);
    String delete(String id);
}
