package com.hef.wiring.automic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer{

    private CompactDisc cd;
    /*
    自动装配
    如果没有匹配到bean，那么在应用上下文创建的时候，Spring会抛出一个异常。为了避免异常出现，可以将@Autowired的required属性设置为false
    将required属性设置为false时，Spring 会尝试执行自动装配，如果没有匹配到bean，spring将bean处于未装配状态，
    但此时未装配状态的属性有可能会出现NullPointerException
     */
    @Autowired(required = false)
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }
    @Override
    public void play() {
        cd.play();
    }
    /*
    自动装配
     */
    @Autowired
    public void setCompactDisc(CompactDisc cd){
        this.cd = cd;
    }

    /*
    自动装配
     */
    @Autowired
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }
}
