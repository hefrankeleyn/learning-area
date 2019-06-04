package com.hef.design05.command;

import com.hef.design05.Command;
import com.hef.design05.store.Stereo;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class StereoOnWithCDCommand implements Command {

    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
