package com.hef.design08.componentmodel;

/**
 * @Date 2019-06-07
 * @Author lifei
 */
public class MenuTestDrive {

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("aa", "brackfast");
        MenuComponent drinkMenu = new Menu("bb", "Lunch");
        MenuComponent cafeMenu = new Menu("cc", "Dinner");
        MenuComponent dessertMenu = new Menu("dd", "chick");

        MenuComponent allMenus = new Menu("aa", "dd");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(drinkMenu);
        allMenus.add(cafeMenu);
        allMenus.add(dessertMenu);

        drinkMenu.add(new MenuItem("a1", "good", false, 23.5));
        drinkMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("d1", "good", true, 23.1));

        Waitress waitress = new Waitress(allMenus);
//        waitress.printMenu();
        waitress.printVegetarianMenu();
    }
}
