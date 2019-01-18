package exersices.testpacage.charset;

import java.io.*;
/*import java.nio.charset.Charset;*/

public class CharsetTest {
    public static void main(String[] args) throws IOException {
        byte[] rawData = new byte[256];
        for (int i = 0; i < 256; i++) {
            rawData[i] = (byte)(i - 128);
        }


/*
        for (String name: Charset.availableCharsets().keySet()){
            System.out.println(new String(rawData,name));
            System.out.println("\n\n");*/
        InputStream is = new ByteArrayInputStream(rawData);
        Reader reader = new InputStreamReader(is/*,"UTF-8"*/);

        char[] buff = new char[16];
        int count;
        while ((count = reader.read())!= -1){
            System.out.print(new String(buff,0,count));
        }
    }
}
