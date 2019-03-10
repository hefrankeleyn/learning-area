package swing.text;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * ComboBoxFrameTest
 */
public class ComboBoxFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ComboBoxFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("ComboBox Frame");
        });
    }
}