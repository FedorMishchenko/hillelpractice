package com.hillel.fmishchenkopractice.homework12.restaurant.dao;

import java.io.BufferedReader;
import java.io.IOException;

public interface Query {
    String create();
    String read();
    String update(String id);
    String delete(String id);
}
