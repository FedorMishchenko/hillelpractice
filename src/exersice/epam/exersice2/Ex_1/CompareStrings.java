package exersice.epam.exersice2.Ex_1;

import java.util.*;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of strings = ");
        int lenght = 0;
        boolean flag = true;
        while (flag) {
            try {
                lenght = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.err.println("You input not number");
                flag = false;
            }
        }
        System.out.println('\n' + "Input " + lenght + " strings:");

        Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < lenght; i++) {
            list.add(scanner.next());
        }
        Collections.sort(list,comparator);
        System.out.println("Short string = " + list.get(0) +
                '\n' + "Long string = " + list.get(lenght - 1));

    }


}
