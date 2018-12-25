package com.hillel.fmishchenko_practice.homeWork_7_Task_4;

public class Demo {
    public static void main(String[] args) {
        System.out.println(new HashDigest().hash("password", "MD5"));
        System.out.println(new HashDigest().hash("password1", "SHA-256"));
        System.out.println(new HashDigest().hash("password2", "SHA-512"));

    }
}
