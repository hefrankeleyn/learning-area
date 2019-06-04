package com.hef.design05.command;

import com.hef.design05.Command;
import com.hef.design05.store.Light;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.off();
    }

    @Override
    public void undo() {
        this.light.on();
    }
}
