package com.hef.design08.iteratormodel;

import java.util.Iterator;

/**
 * @Date 2019-06-07
 * @Author lifei
 */
public class DinerMenu {

    private static final int MAX_ITEMS = 6;
    private int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("Vegetarian BLT", "aaa", false, 3.18);
        addItem("MEET", "ccc", true, 9.28);
        addItem("MITi", "bbb", false, 2.88);

    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if(numberOfItems >= MAX_ITEMS){
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    /**
     *
     * @return
     */
    public Iterator createIterator(){
        return new DinerMenuIterator(menuItems);
    }
}
