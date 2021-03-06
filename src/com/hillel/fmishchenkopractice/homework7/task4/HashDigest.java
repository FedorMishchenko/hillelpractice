package com.hillel.fmishchenkopractice.homework7.task4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

class HashDigest {


    String hash(String password, String hashName) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance(hashName);
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        }
        BigInteger num = new BigInteger(1,digest);
        StringBuilder md5Hex = new StringBuilder(num.toString(16));

        while( md5Hex.length() < 32 ){
            md5Hex.insert(0, "0");
        }
        System.out.println("Algorithm: " + hashName);
        System.out.println(Arrays.toString(digest));
        return md5Hex.toString();
    }
}
