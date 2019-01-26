package interface_lambda_innerclass.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * LambdaTest
 */
public class LambdaTest {

    public static void main(String[] args) {
        //sortLambdaTest();
        timerLambdaTest();
    }
    public static void ignoreCase(){
        Timer t = new Timer(1000, event -> System.out.println(event));
        // 等价于
        Timer t2 = new Timer(1000, System.out::println);

        String[] a = {"abc","aace","basec"};
        Arrays.sort(a, String::compareToIgnoreCase);
        // 等价于
        Arrays.sort(a, (x,y)->x.compareToIgnoreCase(y));
    }

    /**
     * 每隔一秒钟打印一个时间
     * 
     */
    public static void timerLambdaTest(){
        Timer t = new Timer(1000, event -> System.out.println("This time is " + new Date()));
        t.start();

        // keep program running until user selects "ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
    /**
     * 使用Lambda表示式对字符串数组进行排序
     */
    public static void sortLambdaTest(){
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
            "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) ->first.length() - second.length());
        System.out.println(Arrays.toString(planets));
    }
    public static void test01(){
        Comparator<String> comp =
        (String first, String second)
           -> first.length() - second.length();

        Comparator<String> comp02 = 
        (first, second)
            -> first.length() - second.length();
    }
}