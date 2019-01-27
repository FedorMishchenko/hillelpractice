package exersices.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {
    public void demo(String[] args) {
        List<String> list = Arrays.asList("oneeeee","two","three");
        Collections.sort(list, (String a,String b) ->{
            return b.compareTo(a);
        });
        /*Можно так*/
        Collections.sort(list, (String a, String b) -> b.compareTo(a));
        /*Можно и так*/
    }
}



