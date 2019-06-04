package com.hef.design05;

import com.hef.design05.command.LightOnCommand;
import com.hef.design05.remote.SimpleRemoteControl;
import com.hef.design05.store.Light;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class RemoteController {

    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);

        remoteControl.setCommand(lightOn);

        remoteControl.buttonWasPressed();
    }
}
