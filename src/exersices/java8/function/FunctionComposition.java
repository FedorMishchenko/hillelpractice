package exersices.java8.function;

import java.util.function.Function;

public class FunctionComposition {
    public static void main(String[] args) {
        Function<String, String> trim = String::trim;
        System.out.println(trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" HELLO WORLD "));

    }
}
