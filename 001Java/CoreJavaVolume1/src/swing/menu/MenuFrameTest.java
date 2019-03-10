package swing.menu;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * MenuFrameTest
 */
public class MenuFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MenuFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Menu Frame");
            frame.setVisible(true);
            frame.pack();
        });
    }
}