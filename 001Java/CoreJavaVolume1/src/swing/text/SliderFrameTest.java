package swing.text;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * SliderFrameTest
 */
public class SliderFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SliderFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("Slider Frmae");
        });
    }
}