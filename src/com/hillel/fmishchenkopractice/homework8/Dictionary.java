package com.hillel.fmishchenkopractice.homework8;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Dictionary {
    private static Dictionary instance;
    private Dictionary(){
    }
    public static Dictionary getInstance(){
        if(instance == null){
            instance = new Dictionary();
        }
        return instance;
    }
    private HashMap<String,String> dictionary = new HashMap<>();

    public void put(String key,String value){
        dictionary.put(key,value);
    }

    public String get(String key){
        return dictionary.get(key);
    }

    public void remove(String key){
        dictionary.remove(key);
    }

    public Set<String> keySet(){
        return dictionary.keySet();
    }

    public Collection<String> values(){
        return dictionary.values();
    }

    public int size(){
        return dictionary.size();
    }

    public String toString(String key){
        String en = key;
        String ru = dictionary.get(key);
        if(ru == null || en == null){
            System.out.print("No such element");
            return "";
        }
        return "EN:  " + en + " ==> " + " RU: " + ru;
    }





























}
