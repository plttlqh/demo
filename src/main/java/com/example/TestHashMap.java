package com.example;

import java.util.HashMap;
import java.util.Hashtable;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap  = new HashMap<>();
//        Hashtable<Integer, Integer> hashMap  = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i);
        }
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, i+10);
        }
        for (Integer integer : hashMap.keySet()) {
            System.out.println(integer);
        }
        System.out.println();
    }
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
