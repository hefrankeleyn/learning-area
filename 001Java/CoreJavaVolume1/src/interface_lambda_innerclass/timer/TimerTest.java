package interface_lambda_innerclass.timer;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * TimerTest
 * @version 1.0 2019-01-19
 * @author Li Fei
 */
public class TimerTest {

    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();
        // construct a timer that calls the listener
        // once every 10 seconds
        Timer t = new Timer(10000, listener);
        t.start();
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}

class TimePrinter implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent event) {
        System.out.println("At the tone, the time is " + new Date());
        // 发出声响
        Toolkit.getDefaultToolkit().beep();
    }
}