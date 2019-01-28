package com.hillel.fmishchenkopractice.homework2.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutputText {
    static String header;
    static String text;

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Input header:");
            header = reader.readLine();
            System.out.println("Input text: ");
            text = reader.readLine();
        }

        TextFactory factory = Text::new;
        Text txt = (Text) factory.create(header,text);
        txt.setHeadline(header);
        txt.outText(text);



    }
}
