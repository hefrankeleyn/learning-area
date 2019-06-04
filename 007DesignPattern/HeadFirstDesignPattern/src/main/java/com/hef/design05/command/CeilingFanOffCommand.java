package com.hef.design05.command;

import com.hef.design05.Command;
import com.hef.design05.store.CeilingFan;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class CeilingFanOffCommand implements Command {

    private CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.getSpeed();
    }
}
