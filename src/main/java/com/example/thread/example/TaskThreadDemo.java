package com.example.thread.example;

public class TaskThreadDemo {
    public static void main(String[] args) {
        //Create tasks
        Runnable printA = new PrintChar('a', 10000);
        Runnable printB = new PrintChar('B', 10000);
        Runnable print100 = new PrintNum(10000);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
