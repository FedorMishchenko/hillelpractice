package com.hillel.fmishchenkopractice.homework6.task1;


public class Demo {
    public static void main(String[] args) {
        Integer[] arr  = new Integer[]{1, 4, 7, 2, 13};
        List<Integer> list = new List<>();
        System.out.print("[ ");
        for (Integer num: arr){
            System.out.print(num + ", ");
        }
        System.out.println("]");
        String[] languages = new String[]{
                "Java","C++","Python","Scala","C"
        };
        List<String> strings = new List<>(languages);
        for (String str: strings){
            System.out.println(str);
        }

    }
}
