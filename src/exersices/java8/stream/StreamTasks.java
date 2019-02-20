package exersices.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTasks {
    public static void main(String[] args) {

  /*      Stream.iterate(2, x -> x + 6)
                .limit(10)
                .forEach(System.out::println);

      Stream.concat(
              Stream.of(1,2,3),
              Stream.of(4,5,6)
      ).forEach(System.out::println);

        IntStream.range(0, 10)
                .forEach(System.out::println);
        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);

        Stream.Builder<Integer> builder = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            builder.accept(i);
        }
        builder
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Integer> res = new ArrayList<>();
        numbers.forEach(integer -> {
            if(integer > 4){
                res.add(integer);
            }
        });
        res.forEach(System.out::println);

        Stream.of("1","2","3")
                .map(Integer::parseInt)
                .map(integer -> integer + 10)
                .forEach(System.out::println);

        Stream.of("11","10","101")
                .map(integer -> Integer.parseInt(integer,2))
                .forEach(System.out::println);*/

        Stream.of(1,3,22,12,99,2,8)
                .sorted()
                .map(x -> x + 6)
                .forEachOrdered(x -> System.out.print(x + ", "));

        String str = Stream.of(1,2,3)
                .map(String::valueOf)
                .collect(Collectors.joining("-",
                "<",">"));
        System.out.println('\n' + str );

        List<String> list = Stream.of("a","b","c","d")
                .collect(ArrayList::new,
                         ArrayList::add,
                         ArrayList::addAll);
        System.out.println(list);

        String[] elem = Stream.of("e","f","g","h")
                .toArray(String[]::new);
        for (String s:elem) {
            System.out.print(s + " ");
        }
    }
}
