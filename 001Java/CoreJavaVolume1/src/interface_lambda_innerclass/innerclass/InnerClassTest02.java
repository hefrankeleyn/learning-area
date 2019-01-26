package interface_lambda_innerclass.innerclass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * InnerClasssTest02
 */
public class InnerClassTest02 {
    
    public static void main(String[] args) {
        TalkingClock02 clock = new TalkingClock02();
        clock.start(1000, true);
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}

class TalkingClock02{
    public void start(int interval, boolean beep){
        class TimePrinter implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }
}