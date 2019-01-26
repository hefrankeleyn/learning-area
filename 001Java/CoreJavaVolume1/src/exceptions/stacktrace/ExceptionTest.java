package exceptions.stacktrace;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * ExceptionTest
 */
public class ExceptionTest {

    public static void main(String[] args) {
        
    }

    public void scannerTest(){

        try {
            try (InputStream input = new FileInputStream("name")){
                
            }
            
        } catch (Exception e) {
        }

        // try (Scanner in =new Scanner(input, "UTF-8")){

        // }
    }

    public void sourceTry(){

       try (Scanner in = new Scanner(""))
       {
            while (in.hasNext()){
                System.out.println(in.next());
            }
       }
    }
    /**
     * 
     */
    public void mateExcption() {
        File f = new File("aaa");
        try {
            InputStream in =new FileInputStream(f);
            in.read();
        } catch(IOException e){
        }

    }
}