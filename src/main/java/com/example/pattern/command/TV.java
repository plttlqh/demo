package com.example.pattern.command;

public class TV implements Electronic {
    private String place;

    public TV(String place) {
        this.place = place;
    }

    public TV() {
    }

    @Override
    public void on() {
        System.out.println("TV on in " + place);
    }

    @Override
    public void off(){
        System.out.println("TV off" + place);
    }

}
