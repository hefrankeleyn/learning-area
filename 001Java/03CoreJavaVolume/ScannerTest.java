import java.io.Console;
import java.util.Scanner;

public class ScannerTest{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        System.out.println("How old are you?");
        int age = in.nextInt();
        Console cons = System.console();
        char[] password = cons.readPassword("Password:");
        for(char ps:password){
            System.out.print(ps);
        }
        System.out.println();

        System.out.println("Hello, "+name+ ". Next year ,you'll be "+(age+1));
    }
}