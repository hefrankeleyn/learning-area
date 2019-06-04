package com.hef.design05.remote;

import com.hef.design05.Command;
import com.hef.design05.command.NoCommand;

/**
 * @Date 2019-06-04
 * @Author lifei
 */
public class RemoteControl {

    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /**
     *
     * @param slot   插槽的位置
     * @param onCommand 开的命令
     * @param offCommand  关的命令
     */
    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }

    public void offButtonWasPushed(int slot){
        offCommands[slot].execute();
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n---- Remote Control -------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + " ]" + onCommands[i].getClass().getName() + "  " + offCommands[i].getClass().getName() + "\n");
        }
        return sb.toString();
    }
}
