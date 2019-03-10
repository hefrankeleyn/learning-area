package swing.opendialog;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * OptionDialogFrameTest
 */
public class OptionDialogFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new OptionDialogFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("OptionDialogFrame");
            
        });
    }
}