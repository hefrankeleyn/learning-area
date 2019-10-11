package com.hef.basepro;

import java.util.ArrayList;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        lambdaTest01();
    }

    public static void lambdaTest01(){

        ArrayList<String> al = new ArrayList<String>();
        al.add(null);
        al.add("aaa");
        al.add("bbb");
        al.add(null);
        al.add("ccc");
        for (String var : al) {
            System.out.println(var);
        }

        al.removeIf(e->e==null);
        System.out.println("*************");
        for (String var : al) {
            System.out.println(var);
        }
    }
}
