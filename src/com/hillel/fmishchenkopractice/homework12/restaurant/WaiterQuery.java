package com.hillel.fmishchenkopractice.homework12.restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

public class WaiterQuery implements Query{
    private static final Logger logger = Logger.getLogger(WaiterQuery.class.getName());
    public String create(BufferedReader reader) throws IOException {

        return null;
    }

    public String read() {
        return "SELECT ";
    }
    public String update(String id){

        return null;
    }

    public String delete(String id){

        return null;
    }
}
