package com.hillel.fmishchenkopractice.homework8task1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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

    public String getEn(String key){
        return "EN:  " + dictionary.get(key);
    }
    public String getRu(String key){
        Set<Map.Entry<String,String>> entrySet = dictionary.entrySet();

        String getValue = key;
        for (Map.Entry<String,String> pair : entrySet) {
            if (getValue.equals(pair.getValue())) {
                return "RU:  " + pair.getKey();
            }
        }
        System.out.println("Key is not exists");
        return "";
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
        String ru = key;
        String en = dictionary.get(key);
        if(ru == null || en == null){
            System.out.print("No such element");
            return "";
        }
        return "RU:  " + ru + " ==> " + " EN: " + en;
    }





























}
