package exersice.epam.testpacage.io;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.in;

public class Readertest {
    public static void main(String[] args) throws IOException {
        Reader reader = new BufferedReader(
                (new InputStreamReader(in, "UTF-8")));
        int b;
        while ((b = reader.read()) != -1){
            System.out.print((char)b);
        }

    }
}
