package com.hef.design05;

import com.hef.design05.command.*;
import com.hef.design05.remote.RemoteControl;
import com.hef.design05.remote.RemoteControlWithUndo;
import com.hef.design05.store.CeilingFan;
import com.hef.design05.store.Light;
import com.hef.design05.store.Stereo;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class RemoteLoader {

    public static void main(String[] args) {
//        RemoteControl remoteControl = new RemoteControl();
        RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();

//        testButton01(remoteControl);
        testCeilingFan(remoteControl);

    }


    private static void testCeilingFan(RemoteControlWithUndo remoteControlWith){
        CeilingFan ceilingFan = new CeilingFan("Living Room");

        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControlWith.setCommand(0, ceilingFanHighCommand,ceilingFanOffCommand);

        remoteControlWith.onButtonWasPushed(0);
        remoteControlWith.offButtonWasPushed(0);
    }
    private static void testButton01(RemoteControlWithUndo remoteControl){
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        Stereo stereo = new Stereo("Living Room");

        LightOnCommand lightRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightRoomLightOff = new LightOffCommand(livingRoomLight);

        StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, lightRoomLightOn, lightRoomLightOff);
        remoteControl.setCommand(1, stereoOnWithCD, stereoOffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
    }
}
