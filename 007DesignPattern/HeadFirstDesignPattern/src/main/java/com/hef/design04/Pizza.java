package com.hef.design04;

import java.util.ArrayList;
import java.util.List;

/**
 * pizza entery
 * @Date 2019-06-02
 * @Author lifei
 */
public abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();

    // 重做pizza
    public abstract void prepare();

/*    public void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println("   " + toppings.get(i));
        }
        System.out.println("New Pizza prepare something....");
    }*/

    public void bake(){
        System.out.println("Pizza bake....");
    }

    public void cut(){
        System.out.println("Pizza cut...");
    }

    public void box(){
        System.out.println("Pizza box...");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
