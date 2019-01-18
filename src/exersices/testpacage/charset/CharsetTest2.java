package exersices.testpacage.charset;

import java.io.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class CharsetTest2 {
    public static void main(String[] args) {

        {
            BufferedReader br =
                    null;
            try {
                br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new OutputStreamWriter(out, "UTF-8"), true);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String s = "Это строка с русским текстом";
            out.println("System.out puts: " + s);
            pw.println("PrintWriter puts: " + s);

            int c = 0;
            pw.println("Посимвольный ввод:");

            if (br != null) {
                try {
                    while ((c = br.read()) != -1)
                        pw.println((char) c);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

/*            pw.println("Построчный ввод:");

            do {
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                pw.println(s);

            } while (!s.equals("q"));*/
        }
    }
}
