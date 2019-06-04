package com.hef.design05.command;

import com.hef.design05.Command;
import com.hef.design05.store.Light;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
