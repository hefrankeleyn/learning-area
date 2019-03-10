package swing.toolbar;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * ToolBarFrameTest
 */
public class ToolBarFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ToolBarFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Tool Bar Frame");
            frame.pack();
        });
    }
}