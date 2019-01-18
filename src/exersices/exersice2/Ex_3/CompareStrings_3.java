package exersices.exersice2.Ex_3;

import java.util.*;

public class CompareStrings_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of strings = ");
        int lenght = 0;
        OUT:while (true) {
            try {
                lenght = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("You input not number");
                break OUT;
            }
        }
        System.out.println('\n' + "Input " + lenght + " strings:");

        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            list.add(scanner.next());
        }
        Collections.sort(list,comparator);
        String tmp = "";
        for (int i = 0; i < lenght/2; i++ ){
                tmp = list.get(i);
                System.out.println(tmp + " :lenght = " + tmp.length() );
        }

    }
}
