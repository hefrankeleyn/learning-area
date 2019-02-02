package swing.text;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * TextComponentFrameTest
 */
public class TextComponentFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new TextComponentFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("text component");
            frame.pack();
            frame.setVisible(true);
        });
    }
}