package com.example.thread.example;

public class PrintChar implements Runnable {
    private char charToString;
    private int times;

    public PrintChar(char c, int t) {
        charToString = c;
        times = t;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(charToString);
        }
    }
}
