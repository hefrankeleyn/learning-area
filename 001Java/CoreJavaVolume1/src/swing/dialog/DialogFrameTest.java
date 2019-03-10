package swing.dialog;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * DialogFrameTest
 */
public class DialogFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DialogFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Dialog Frame");
        });
    }
}