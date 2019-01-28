package exersices.java8.function;

import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        Function<String,Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("10");
        System.out.println(integer + 10);
    }
    private static Integer parse(String s){
        return Integer.parseInt(s);
    }

}
