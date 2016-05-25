package com.example.pattern.command;

public class Light implements Electronic {
    private String place;

    public Light(String place) {
        this.place = place;
    }

    public Light() {
    }

    @Override
    public void on() {
        System.out.println("Light on in " + place);
    }

    @Override
    public void off(){
        System.out.println("Light off" + place);
    }

}
