package com.hillel.fmishchenkopractice.homework5.task2.part2;

import java.util.*;

import static java.util.Comparator.*;

public class Main {

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>(comparingInt(String::length));
        List<String> lines = Arrays.asList(SONNET.split("\n"));
        set.addAll(lines);
        String[] line = lines.toArray(new String[0]);
        System.out.println('\n');
        Arrays.sort(line, comparingInt(String::length));
        print(Arrays.toString(line));
        printLine();
        lines.sort(comparingInt(String::length));
        lines.forEach(System.out::println);
        printLine();
        set.forEach(System.out::println);
    }

    private static final String SONNET =

            "From fairest creatures we desire increase," + '\n' +
                    "That thereby beauty's rose might never die," + '\n' +
                    "But as the riper should by time decease," + '\n' +
                    "His tender heir might bear his memory:" + '\n' +

                    "But thou, contracted to thine own bright eyes," + '\n' +
                    "Feed'st thy light'st flame with self-substantial fuel," + '\n' +
                    "Making a famine where abundance lies," + '\n' +
                    "Thyself thy foe, to thy sweet self too cruel." + '\n' +

                    "Thou that art now the world's fresh ornament" + '\n' +
                    "And only herald to the gaudy spring," + '\n' +
                    "Within thine own bud buriest thy content" + '\n' +
                    "And, tender churl, makest waste in niggarding." + '\n' +

                    "Pity the world, or else this glutton be," + '\n' +
                    "To eat the world's due, by the grave and thee";


    public static void printLine() {
        print("---------------------------------------");
    }

    public static void print(String s) {
        System.out.println(s);
    }
}

