package com.hillel.fmishchenkopractice.homework5.task2.part1.stack;

import com.hillel.fmishchenkopractice.homework6.task2.Stack;
import com.hillel.fmishchenkopractice.homework6.task2.StackImpl;

import java.io.*;


public class FileInputAndReverseOutput {
        public static void main(String[] args) throws IOException {
        File file = new File("E:/text.txt");
        File file2 = new File("E:/textReverse.txt");
        Stack stack = new StackImpl<>();

        try (FileReader in = new FileReader(file);
             FileWriter out = new FileWriter(file2)) {
            int count;
            while ((count = in.read()) != -1) {
                stack.add((char) count);
            }
            int size = stack.size();
            while (size != 0) {
                out.write((char) stack.get());
                size--;
            }

        }
    }
}
