package com.example.thread.example;

public class PrintNum implements Runnable {
    private int lastNum;

    public PrintNum(int lastNum) {
        this.lastNum = lastNum;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < lastNum; i++) {
                System.out.println(i + " ");
                if(i> 50){
                    Thread.sleep(1);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
