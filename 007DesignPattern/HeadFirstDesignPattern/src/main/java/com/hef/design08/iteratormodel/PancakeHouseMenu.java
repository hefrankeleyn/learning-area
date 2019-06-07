package com.hef.design08.iteratormodel;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Date 2019-06-07
 * @Author lifei
 */
public class PancakeHouseMenu {

    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<>();
        addItem("Tea", "Chinese drink", false, 23.5);
        addItem("Coffee", "foreign drink", false, 25.3);
        addItem("Bai Jiu", "good drink", false, 23.8);
    }

    public Iterator createIterator(){
        return menuItems.iterator();
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }
}
