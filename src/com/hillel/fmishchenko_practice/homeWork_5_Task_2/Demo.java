package com.hillel.fmishchenko_practice.homeWork_5_Task_2;

import java.io.*;



    public class Demo {

        public static void main(String[] args) {

            File input = new File("E:/in.txt");
            File output = new File("E:/out.txt");

            List list = new List();
            list.showList();
            System.out.println();

            String str;

            try (BufferedReader br = new BufferedReader(new FileReader(input))) {

                str = br.readLine();

                if (str == null) {
                    System.out.println("Файл пуст!");
                } else {
                    while (str != null) {
                        list.pushBack(str);
                        str = br.readLine();
                    }
                }
            } catch (IOException exc) {
                System.out.println("I/O Error: " + exc);
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
                    System.out.println("I/O Error: " + exc);
                }
                System.out.println();
                System.out.println("Данные успешно записаны!");
                list.showList();
            }
        }
    }

