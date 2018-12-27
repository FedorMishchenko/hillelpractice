package com.hillel.fmishchenkopractice.homework2;

import java.util.Scanner;

public class TextTest {
    public static void main(String[] args)  {

        //TO DO refactoring outText


        Scanner sc = new Scanner(System.in);
        Text paragraph = new Paragraph();
        System.out.println("Input headline: ");
        paragraph.setHeadline(sc.next());
        System.out.println("Input text: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        paragraph.addText(str);
        System.out.println();
        paragraph.outText(str);


    }
}
