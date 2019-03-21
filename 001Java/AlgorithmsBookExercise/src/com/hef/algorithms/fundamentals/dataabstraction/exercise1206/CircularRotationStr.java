package com.hef.algorithms.fundamentals.dataabstraction.exercise1206;

import java.util.logging.Logger;

/**
 * 回环变位： 将字符串收尾相连进行移动
 */
public class CircularRotationStr {

    private static final Logger log = Logger.getLogger("CircularRotationStr");
    public static void main(String[] args) {
        String s = "ACTGACG";
        String t = "TGACGAC";
        boolean r = verifyCircularRotation(s, t);
        System.out.println(r);
    }

    public static boolean verifyCircularRotation(String s, String t){

        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.substring(i+1,s.length())+s.substring(0,i+1)).equals(t)){
                return true;
            }
        }


        return false;
    }

    /**
     * Hint: The solution is a one-liner with indexOf(), length(), and string concatenation
     */

    public static boolean solation(String s, String t){
        return s.length()==t.length() && s.concat(s).indexOf(t)>0;
    }
}
