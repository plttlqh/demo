package com.example.codility;

class Solution1 {
    public static int solution(String E, String L) {
        // write your code in Java SE 8
        int fee = 2;
        int hours = calHours(E, L);
        if(hours <= 1){
            return fee += 3;
        } else {
            fee = fee + 3 + ((hours - 1) * 4);
        }
        return fee;
    }

    private static int calHours(String e, String l) {
        int hours = 0;
        String[] enterHours = e.split(":");
        String[] endHours = l.split(":");
        hours = Integer.parseInt(endHours[0]) - Integer.parseInt(enterHours[0]);
        int minute = Integer.parseInt(endHours[1]) - Integer.parseInt(enterHours[1]);
        if (minute >0 && minute <=60){
            hours +=1;
        }
        return hours;
    }

    public static void main(String[] args) {
        System.out.println(calHours("10:00", "13:21"));
        System.out.println(calHours("09:42", "11:42"));
        System.out.println(calHours("00:42", "11:42"));

        System.out.println(solution("10:00", "13:21"));
        System.out.println(solution("09:42", "11:42"));
        System.out.println(solution("00:42", "11:42"));
    }
}
