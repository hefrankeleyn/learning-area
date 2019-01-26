package interface_lambda_innerclass.lambda;

import javax.swing.Timer;

/**
 * TimedGreeter
 */
public class TimedGreeter extends Greeter{

    public static void main(String[] args){
        TimedGreeter tg = new TimedGreeter();
        tg.greet();
    }
    public void greet(){
        //Timer t = new Timer(1000, (even)->System.out.println(""));
        Timer t = new Timer(1000, super::greet);

    }
}