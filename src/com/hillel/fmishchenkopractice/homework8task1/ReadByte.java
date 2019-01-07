package com.hillel.fmishchenkopractice.homework8task1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadByte implements Reader {
    @Override
    public String read() throws IOException {
        String command;
        InputStream input = null;
        try {
            input = new BufferedInputStream(System.in);
            command = readBytes(input);
        } catch (IOException e) {
            throw new IOException();
        } finally {
            if (input != null)
                try {
                    input.close();
                } catch (IOException ignore) {
                    /* NOP*/
                }
        }
        return command;

    }

    private String readBytes(InputStream in) throws IOException {
        int oneByte;
        String command = "";
        while ((oneByte = in.read()) != -1) {
            command += ((char) oneByte);
        }
        return command;
    }
}
