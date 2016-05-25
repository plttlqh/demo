package com.example.pattern.command;

public class RemoteLoaderWithMarco {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        TV tv = new TV("Living Room");
        Stereo stereo = new Stereo("Living Room");
        Hottub hottub = new Hottub("Living Room");

        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        TVOnCommand tvOn = new TVOnCommand(tv);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
        Command[] partyOff = {lightOff, stereoOffCommand};
        MacroCommand partyOnMarcro = new MacroCommand(partyOn);
        MacroCommand partyOffMarcro = new MacroCommand(partyOff);

        remoteControl.setCommand(0, partyOnMarcro, partyOffMarcro);

        System.out.println(remoteControl);
        System.out.println("---- Pushing Macro On ----");
        remoteControl.onButtonWasPushed(0);
        System.out.println("---- Pushing Macro Off ----");
        remoteControl.offButtonWasPushed(0);
    }
}
