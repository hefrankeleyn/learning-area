package swing.mouse;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * MouseFrameTest
 */
public class MouseFrameTest {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
            JFrame frame = new MouseFrame();
            frame.setTitle("mouse frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}