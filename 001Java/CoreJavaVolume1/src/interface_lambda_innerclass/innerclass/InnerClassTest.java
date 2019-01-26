package interface_lambda_innerclass.innerclass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * InnerClassTest
 */
public class InnerClassTest {

    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until user selects "ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

class TalkingClock{
    private int interval;
    private boolean beep;
    /**
     * Constructs a talking clock
     * @param interval the interval between messages (in milliseconds)
     * @param beep beep true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep){
        this.interval = interval;
        this.beep = beep;
    }

    public void start(){
        ActionListener listener = new TimePrinter();
        Timer t =new Timer(interval, listener);
        t.start();
    }

    public class TimePrinter implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {
            System.out.println("At the tone, the time is " + new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}