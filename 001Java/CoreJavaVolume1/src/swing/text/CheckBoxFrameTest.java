package swing.text;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * CheckBoxFrameTest
 */
public class CheckBoxFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new CheckBoxFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
            frame.setTitle("Check Box");
        });
    }
}