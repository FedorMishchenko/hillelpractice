package com.hillel.fmishchenkopractice.homework7.task4;

/**
 * Message digest
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(new HashDigest().hash("password", "MD5"));
        System.out.println(new HashDigest().hash("password1", "SHA-256"));
        System.out.println(new HashDigest().hash("password2", "SHA-512"));

    }
}