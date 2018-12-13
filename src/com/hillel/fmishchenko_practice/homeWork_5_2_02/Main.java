package com.hillel.fmishchenko_practice.homeWork_5_2_02;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
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

    private static final Comparator<String> LINE_LENGTH_COMPARATOR = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    };
    public static void main(String[] args) {
        List<String> lines = Arrays.asList(SONNET.split("\n"));
        System.out.println(lines );
        System.out.println('\n');

        Collections.sort(lines, LINE_LENGTH_COMPARATOR);
        System.out.println(lines);
    }
    }

