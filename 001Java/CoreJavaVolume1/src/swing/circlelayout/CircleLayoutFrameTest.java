package swing.circlelayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * CircleLayoutFrameTest
 */
public class CircleLayoutFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CircleLayoutFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Circle Layout Frame");
        });
    }
}