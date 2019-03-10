package swing.gridbag;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * FontFrameText
 */
public class FontFrameText {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setTitle("Font Frame");
        });
    }
}