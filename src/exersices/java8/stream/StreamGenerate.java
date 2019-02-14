package exersices.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamGenerate {
    public static void main(String[] args) {
        Stream.generate(() -> new Random().nextInt(10))
                .limit(5)
                .forEach(System.out::println);

        Stream.of(1,2,3)
                .forEach(System.out::println);

        Stream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 200)
                .map(x -> x + 11)
                .limit(4)
                .forEach(System.out::println);

        String[] arr = {"a","b","ccc"};
        List<String> list = Arrays.stream(arr)
                .filter(x -> x.length() < 2)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
