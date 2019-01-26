package interface_lambda_innerclass.innerclass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * This program demonstrate anonymous inner classes
 * @version 1.0 2019-01-20
 * @author Li Fei
 */
public class InnerClassTest03{
    public static void main(String[] args) {
        TalkingClock03 clock = new TalkingClock03();
        clock.start(1000, true);

        // keep program running until user selects "ok"
        JOptionPane.showMessageDialog(null, "Quite program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals
 */
class TalkingClock03{

    /**
     * Starts the clock
     * @param interval the interval between message (in milliseconds)
     * @param beep true if the clock should beep
     */
    public void start(int interval, boolean beep){
        ActionListener listener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event) {
                
                System.out.println("At the tone, the time is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
        
    }
}