package com.hef.design08.componentmodel;

/**
 * @Date 2019-06-07
 * @Author lifei
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }
}
