package exersices.testpacage.strings;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class TestWrappers {
    public static void main(String[] args) {
        int []arr = {111,34,23,12,5,97,42};

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        long sum = Arrays.stream(arr).summaryStatistics().getSum();
        OptionalDouble avg = Arrays.stream(arr).average();

        print(max, "max = ");
        print(min, "min = ");
        print(sum,"sum = ");
        print(avg.getAsDouble(),"avg = ");
        System.out.println("__________________" + '\n');

        double[] arrs = {1.1,1.2,1.0,1.5,1.4};

        double dMin = DoubleStream.of(arrs).min().getAsDouble();
        double dMax = DoubleStream.of(arrs).max().getAsDouble();
        double dSum = DoubleStream.of(arrs).sum();
        OptionalDouble dAvg = DoubleStream.of(arrs).average();

        print(dMin, "dMin = ");
        print(dMax, "dMax = ");
        print(dSum,"dSum = ");
        print(dAvg.getAsDouble(),"dAvg = ");

    }

    public static void print(double dMin, String s) {
        System.out.println(s + dMin);
    }
}
