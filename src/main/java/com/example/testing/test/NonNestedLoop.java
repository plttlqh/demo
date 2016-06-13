package com.example.testing.test;

import java.util.HashSet;
import java.util.Set;

public class NonNestedLoop {
    private static String[] strArray = {"Cat", "Dog", "Tiger", "Lion", "Lion"};

    public static boolean isThereDuplicateUsingCollection() {
        boolean duplicateFound = false;
        int loopCounter = 0;
        Set setValues = new HashSet(10); // create a set
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            if(setValues.contains(str)) { // check if already has this value
                duplicateFound = true;
                System.out.println("duplicate found for " + str);
            }
            setValues.add(str); // add the value to the set
            loopCounter++;
            if(duplicateFound) {
                break;
            }
        } // end of for loop
        System.out.println("looped " + loopCounter + " times");
        return duplicateFound;
    }

    public static void main(String[] args) {
        isThereDuplicateUsingCollection();
    }

}