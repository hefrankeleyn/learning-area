package swing.colorchooser;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * ColorChooserFrame
 */
public class ColorChooserFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.add(new ColorChooserPanel());
            frame.setTitle("ColorChooser");
            frame.setVisible(true);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}