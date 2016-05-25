package com.example.pattern.command;

public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public SimpleRemoteControl(Command slot) {
        this.slot = slot;
    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
