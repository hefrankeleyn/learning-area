package interface_lambda_innerclass.innerclass;

import java.util.ArrayList;

/**
 * DoubleBraceInitialization
 */
public class DoubleBraceInitialization {

    public static void main(String[] args) {
        ArrayList<String> a = doubleBrace();
        for (String var : a) {
            System.out.println(var);
        }
    }

    public static ArrayList<String> doubleBrace(){
        ArrayList<String> a;
        a = new ArrayList<String>(){{add("aaa");add("bbb");}};
        return a;
    }

}