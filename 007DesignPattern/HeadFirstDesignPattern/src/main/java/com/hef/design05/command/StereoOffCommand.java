package com.hef.design05.command;

import com.hef.design05.Command;
import com.hef.design05.store.Stereo;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
