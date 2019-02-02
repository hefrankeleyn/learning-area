import javax.swing.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 * Greeter
 */
class Greeter {

    public void greet(ActionEvent event){
        System.out.println("Hello, world!");
    }
}

public class TimedGreeter extends Greeter{

    public static void main(String[] args){
        TimedGreeter tg = new TimedGreeter();
        tg.greet();
    }
    public void greet(){
        //Timer t = new Timer(1000, (even)->System.out.println(""));
        Timer t = new Timer(1000, super::greet);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);

    }
}