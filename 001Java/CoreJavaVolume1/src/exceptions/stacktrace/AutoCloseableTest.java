package exceptions.stacktrace;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * AutoCloseableTest
 */
public class AutoCloseableTest {

    public static void main(String[] args) {
        String filePath = "F:\\upgradeGo\\workplace\\learning-area\\001Java\\CoreJavaVolume1\\src\\exceptions\\stacktrace\\AutoCloseableTest.java";
        String outFilePath = "F:\\upgradeGo\\autoCloseOut.txt";
        autoCloseTest01(filePath);

        autoCloseTest02(filePath, outFilePath);
    }

    public static void autoCloseTest02(String filePath,String outFilePath){
        try {
            try (Scanner in = new Scanner(new FileInputStream(filePath), "UTF-8");
                PrintWriter out = new PrintWriter(outFilePath))
            {
                while(in.hasNext()){
                    out.println(in.next().toUpperCase());
                }
            } 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void autoCloseTest01(String filePath){
        try {
            try (Scanner in = new Scanner(new FileInputStream(filePath), "UTF-8")){
                while(in.hasNext()){
                    System.out.println(in.next());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}