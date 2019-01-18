package exersices.exersice1.Ex_5;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input 5 : ");
        int[] num = new int[5];
        int sum = 0;
        int product = 1;
        for (int i = 0; i < num.length; i++) {
            int tmp = sc.nextInt();
            num[i] = tmp;
            sum += tmp;
            product *= tmp;
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
        System.out.println("Sum  of  = " + sum);
        System.out.println("Product of  = " + product);

    }
}

