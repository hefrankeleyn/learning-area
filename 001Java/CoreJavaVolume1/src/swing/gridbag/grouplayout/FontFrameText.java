package swing.gridbag.grouplayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * FontFrameText
 */
public class FontFrameText {

    public static void main(String[] args) {
       EventQueue.invokeLater(() -> {
           JFrame frame = new FontFrame();
           frame.setVisible(true);
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setTitle("FontFrame");
           
       });
    }
}