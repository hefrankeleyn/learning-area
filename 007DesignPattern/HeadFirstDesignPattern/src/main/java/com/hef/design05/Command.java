package com.hef.design05;

/**
 * 命令接口
 */
public interface Command {

    void execute();

    void undo();
}
