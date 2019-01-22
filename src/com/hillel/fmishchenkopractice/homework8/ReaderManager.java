package com.hillel.fmishchenkopractice.homework8;

import java.io.IOException;

public class ReaderManager {
    public Reader reader;

    public ReaderManager(Reader source) {
        this.reader = source;
    }

    public void read() {
        try {
            this.reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
