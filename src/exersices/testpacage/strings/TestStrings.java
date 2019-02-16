package exersices.testpacage.strings;

public class TestStrings {
    public static void main(String[] args) {

        String input = "aaaab aa sdgfga a";
        int i = -1, count = 0;
        while( (i = input.indexOf( 'a', i + 1 ) ) != -1 ) count++;
        System.out.println("a=" + count);

        count = 0;
        while( (i = input.indexOf( 'b', i + 1 ) ) != -1 ) count++;
        System.out.println("b=" + count);
        System.out.println("---------------------------------");



        String str = "aaron ate apples upon a rock";
        count = 0;
        while ((i = str.indexOf("a", i + 1))!= -1) count++;
        System.out.println("a=" + count);
        count = 0;
        while ((i = str.indexOf("r",i + 1)) != -1) count++;
        System.out.println("r=" + count);
        count = 0;
        while ((i = str.indexOf("o", i + 1))!= -1) count++;
        System.out.println("o=" + count);
        count = 0;
        while ((i = str.indexOf("n", i + 1))!= -1) count++;
        System.out.println("n=" + count);


    }
}
