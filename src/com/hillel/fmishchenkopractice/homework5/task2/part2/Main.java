package com.hillel.fmishchenkopractice.homework5.task2.part2;

import java.util.*;

public class Main {
    private class Sort implements Comparator<String>{

        @Override
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
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

    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();
        List<String> lines = Arrays.asList(SONNET.split("\n"));
        set.addAll(lines);
        String [] line = lines.toArray(new String[lines.size()]);
        System.out.println('\n');
        Arrays.sort(line, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(line));
        System.out.println("---------------------------------------");
        Collections.sort(lines, Comparator.comparingInt(String::length));
        lines.forEach(System.out::println);
        System.out.println("---------------------------------------");
        set.forEach(System.out::println);
    }
}

