package exersices.testpacage.strings;

import java.util.Optional;
import java.util.stream.Stream;

public class Test {


    public static void main(String[] args) {
        Optional<Object>op = Optional.ofNullable(null);
        System.out.println(op);

       /* Stream.of(1,2).peek(System.out::println)
                .filter(i -> i > 1).peek(System.out::println)
                .filter(i -> i > 2).peek(System.out::println)
                .forEach(System.out::println);*/

        /*String str = "abc";
        byte[] data = str.getBytes();
        System.out.println(data.length);*/

    }
}
