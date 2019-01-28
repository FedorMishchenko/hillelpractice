package exersices.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class RefToMethod {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);

        Function<String,Integer> toInteger = RefToMethod::parse;
        System.out.println(333 + toInteger.apply("222"));


    }
    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}
