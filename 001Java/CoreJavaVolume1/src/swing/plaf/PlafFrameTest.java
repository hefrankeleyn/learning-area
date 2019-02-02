package swing.plaf;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * PlafFrameTest
 */
public class PlafFrameTest {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
            JFrame frame = new PlafFrame();
            frame.setTitle("PlafFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}