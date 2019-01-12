package exersice.epam.testpacage.sort;

public class Recursion2 {
    public static int f(int x) {
        if (x < 2)
            return abc(x);
        else return a(x) + f(x - 2) + b(x) + f(x - 1) + c(x);
    }

    private static int a(int x) {
        System.out.print("(");
        return 0;
    }

    private static int b(int x) {
        System.out.print("");
        return 0;
    }

    private static int c(int x) {
        System.out.print(")");
        return 0;
    }

    private static int abc(int x) {
        if (x == 0)
            System.out.print("0 + 1");
        else if (x == 1)
            System.out.print(" +");
        return x;
    }
}
