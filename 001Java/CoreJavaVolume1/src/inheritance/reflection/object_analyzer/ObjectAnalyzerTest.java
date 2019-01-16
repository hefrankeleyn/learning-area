package inheritance.reflection.object_analyzer;

import java.util.ArrayList;
/**
 * 测试ObjectAnalyzer类的方法
 * @version 1.0 2019-01-16
 * @author Li Fei
 */
public class ObjectAnalyzerTest{

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        //ArrayList<> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            squares.add(i*i);
        }
        System.out.println(new ObjectAnalyzer().toString(squares));
    }

    
}