package com.example.testing.test;

public class NestedLoops {
    private static String[] strArray = {"Cat", "Dog", "Tiger", "Lion", "Lion"};
    public static boolean isThereDuplicateUsingLoop() {
        boolean duplicateFound = false;
        int loopCounter = 0;
        for (int i = 0; i < strArray.length; i++) {
            String str = strArray[i];
            int countDuplicate = 0;
            for (int j = 0; j < strArray.length; j++) {
                String str2 = strArray[j];
                if(str.equalsIgnoreCase(str2)) {
                    countDuplicate++;
                }
                if(countDuplicate > 1) {
                    duplicateFound = true;
                    System.out.println("duplicate found for " + str);
                }
                loopCounter++;
            }//end of inner nested for loop
            if(duplicateFound) {
                break;
            }
        }//end of outer for loop
        System.out.println("looped " + loopCounter + " times");
        return duplicateFound;
    }

    public static void main(String[] args) {
        isThereDuplicateUsingLoop();
    }
}
