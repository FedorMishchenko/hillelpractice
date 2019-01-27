package exersices.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class LambdaTest {

    @Test
    public void demo() {
        List<String> list = Arrays.asList("oneeeee","two","three");
        Collections.sort(list, (String a, String b) -> b.compareTo(a));
        System.out.println(list);
    }
}