package com.hillel.fmishchenkopractice.homework5.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkingHandler {

    public void process() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            print("Input parking size: ");
            String command = reader.readLine();
            Parking parking = new Parking(Integer.parseInt(command));

            while (true) {
                print("1 - auto2 arrival");
                print("2 - auto2 departure");
                print("3 - parking info");
                command = reader.readLine();
                switch (command) {
                    case "1":
                        print("Input auto2's id:");
                        String num = reader.readLine();
                        parking.arrivalAuto(num);
                        break;
                    case "2":
                        print("Input number auto2 to departure: ");
                        String name = reader.readLine();
                        parking.departureAuto(name);
                        break;
                    case "3":
                        parking.print();
                        break;
                    default:
                }
            }
        }
    }


    public void print(String s) {
        System.out.println(s);
    }

}
