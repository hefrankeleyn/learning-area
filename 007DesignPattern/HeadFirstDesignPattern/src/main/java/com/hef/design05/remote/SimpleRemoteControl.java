package com.hef.design05.remote;

import com.hef.design05.Command;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
