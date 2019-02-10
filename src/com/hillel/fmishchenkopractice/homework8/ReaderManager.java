package com.hillel.fmishchenkopractice.homework8;

public class ReaderManager {
    public Reader reader;

    ReaderManager(Reader source) {
        this.reader = source;
    }

    public void process() {
        this.reader.process();
    }

}
