package swing.text;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * BorderFrameTest
 */
public class BorderFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new BorderFrame();
            frame.setVisible(true);
            frame.setTitle("Border Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}