package exersices.testpacage.strings;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.stream.Stream;

public class Test {
    @Contract("_ -> this")
    private Test print(String s) {
        System.out.println(Double.parseDouble(s));
        return this;
    }

    @Contract("_ -> this")
    private Test print(Object s) {
        System.out.println("Object");
        return this;
    }

    @Contract(pure = true)
    private int sum(int x) {
        return x + 10;
    }

    @NotNull
    @Contract(pure = true)
    private Integer sum(Integer x) {
        return x * 5;
    }

    public static void main(String[] args) {
        Optional<Object> op = Optional.ofNullable(null);
        System.out.println(op);

        new Test().print(10.0f).print(new Object()).print("-0.22").print(new Test());

        System.out.println(new Test().sum(10));

       /* Stream.of(1,2).peek(System.out::println)
                .filter(i -> i > 1).peek(System.out::println)
                .filter(i -> i > 2).peek(System.out::println)
                .forEach(System.out::println);*/

        /*String str = "abc";
        byte[] data = str.getBytes();
        System.out.println(data.length);*/


    }
}
