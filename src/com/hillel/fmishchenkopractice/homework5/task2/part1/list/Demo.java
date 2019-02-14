package com.hillel.fmishchenkopractice.homework5.task2.part1.list;

import java.io.*;



    public class Demo {

        public static void main(String[] args) {

            File input = new File("E:/in.txt");
            File output = new File("E:/out.txt");

            List list = new List();
            list.showList();
            print("");

            String str;

            try (BufferedReader br = new BufferedReader(new FileReader(input))) {

                str = br.readLine();

                if (str == null) {
                    print("Файл пуст!");
                } else {
                    while (str != null) {
                        list.pushBack(str);
                        str = br.readLine();
                    }
                }
            } catch (IOException exc) {
                print("I/O Error: " + exc);
            }
            list.showList();
            if (List.getSize() != 0) {
                try (FileWriter fw = new FileWriter(output)) {

                    do {
                        str = list.popBack();

                        if (str.compareTo("Список пуст!") == 0) break;

                        str += "\r\n";
                        fw.write(str);

                    } while (str.compareTo("Список пуст!") != 0);
                } catch (IOException exc) {
                    print("I/O Error: " + exc);
                }
                print("");
                print("Данные успешно записаны!");
                list.showList();
            }
        }

        public static void print(String s) {
            System.out.println(s);
        }
    }

