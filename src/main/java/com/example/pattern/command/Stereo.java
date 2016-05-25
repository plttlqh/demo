package com.example.pattern.command;

public class Stereo{
    private String volume;

    public Stereo(String s) {

    }

    public void on(){
        System.out.println("Stereo on");
    }

    public void off(){
        System.out.println("Stereo off");
    }

    public void setCD(){
        System.out.println("Stereo set CD");
    }

    public void setVolume(String volume){
        this.volume = volume;
        System.out.println("Stereo set volume");
    }
}
