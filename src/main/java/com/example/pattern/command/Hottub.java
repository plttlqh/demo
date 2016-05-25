package com.example.pattern.command;

public class Hottub implements Electronic {
    private String place;

    public Hottub(String place) {
        this.place = place;
    }

    public Hottub() {
    }

    @Override
    public void on() {
        System.out.println("Hottub on in " + place);
    }

    @Override
    public void off(){
        System.out.println("Hottub off" + place);
    }

}
