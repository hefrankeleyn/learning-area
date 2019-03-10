package swing.text;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * RadioButtonFrameTest
 */
public class RadioButtonFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new RadioButtonFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Radio Button");
        });
    }
}