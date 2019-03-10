package swing.filechooser;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * ImageViewerFrameTest
 */
public class ImageViewerFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Image Viewer Frame");
        });
    }
}