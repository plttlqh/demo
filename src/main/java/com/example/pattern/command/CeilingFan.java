package com.example.pattern.command;

public class CeilingFan {
    private String location;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high(){
        speed = HIGH;
        System.out.println(this.toString());
    }

    public void medium(){
        speed = MEDIUM;
        System.out.println(this.toString());
    }

    public void low(){
        speed = LOW;
        System.out.println(this.toString());
    }

    public void off() {
        speed = OFF;
        this.toString();
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "CeilingFan{" +
                "location='" + location + '\'' +
                ", speed=" + speed +
                '}';
    }
}
