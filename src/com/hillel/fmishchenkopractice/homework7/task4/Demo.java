package com.hillel.fmishchenkopractice.homework7.task4;

/**
 * Message digest
 */
public class Demo {
    public static void main(String[] args) {
        print("password", "MD5");
        print("password1", "SHA-256");
        print("password2", "SHA-512");

    }

    public static void print(String password, String md5) {
        System.out.println(new HashDigest().hash(password, md5));
    }
}
