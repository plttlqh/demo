package com.example.codility;

import org.apache.commons.lang3.StringUtils;

class Solution {

    public static int solution(int A, int B) {
        // write your code in Java SE 8
        int decimal = 0;
        boolean loop = true;
        int countLoop = 0;
        while (loop) {
            if(A > 10){
                if(countLoop>0){
                    if(getFirstDigitAndTheRest(B)[0] == 0){
                        decimal = (decimal * 10) + getFirstDigitAndTheRest(A)[0] + getFirstDigitAndTheRest(B)[0];
                    } else {
                        decimal = (decimal * 100) + getFirstDigitAndTheRest(A)[0] * 10 + getFirstDigitAndTheRest(B)[0];
                    }
                } else {
                    decimal = getFirstDigitAndTheRest(A)[0] * 10 + getFirstDigitAndTheRest(B)[0];
                }
                A = getFirstDigitAndTheRest(A)[1];
                B = getFirstDigitAndTheRest(B)[1];
                countLoop ++;
            } else {
                if(B == 0){
                    decimal = (decimal * 10) + getFirstDigitAndTheRest(A)[0] + getFirstDigitAndTheRest(B)[0];
                } else if(B > 10){
                    if(A==0){
                        decimal = (decimal * 10) + getFirstDigitAndTheRest(B)[0];
                        B = getFirstDigitAndTheRest(B)[1];
                    }else {
                        decimal = (decimal * 100) + getFirstDigitAndTheRest(A)[0] * 10 + getFirstDigitAndTheRest(B)[0];
                        B = getFirstDigitAndTheRest(B)[1];
                        A = 0;
                    }
                } else {
                    decimal = (decimal * 100) + getFirstDigitAndTheRest(A)[0] * 10 + getFirstDigitAndTheRest(B)[0];
                }
                if(A < 10 && B < 10){
                    loop = false;
                }
            }
        }

        return decimal;
    }

    private static int[] getFirstDigitAndTheRest(int number){
        String rest = "";
        while (number >= 10){
            rest+= (number%10);
            number = number / 10;

        }
        if(StringUtils.isBlank(rest)){
            rest = "0";
        }
        return new int[]{number, Integer.parseInt(StringUtils.reverse(rest))};
    }

    public static void main(String[] args) {
        System.out.println(solution(12,56));
        System.out.println(solution(56,12));
        System.out.println(solution(12345,678));
        System.out.println(solution(123,67890));
        System.out.println(solution(1234,0));

//        System.out.println((int)Math.floor(Math.log10(12) + 1));
    }
}
