package com.hef.design08.componentmodel;

import java.util.Iterator;

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


    public void printVegetarianMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.println("\nvegetarian menu\n-----");
        while (iterator.hasNext()){
            MenuComponent menuComponent =
                    (MenuComponent) iterator.next();
            try{
                if(menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            }catch (UnsupportedOperationException e){

            }
        }
    }
}
