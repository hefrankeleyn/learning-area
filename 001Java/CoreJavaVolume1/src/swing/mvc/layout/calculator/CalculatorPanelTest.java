package swing.mvc.layout.calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * CalculatorPanelTest
 */
public class CalculatorPanelTest {

    

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new JFrame();
            frame.add(new CalculatorPanel());
            //frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            frame.pack();
            frame.setTitle("calculator panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
