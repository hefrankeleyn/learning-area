package com.hef.spittr.jmx;

/**
 * 通过定义接口限制暴露的操作和属性
 */
public interface SpittleControllerManagedOperations {

    int getSpittlesPerPage();
    void setSpittlesPerPage(int spittlesPerPage);
}
