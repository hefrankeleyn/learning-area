package swing.button;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * ButtonFrameTest
 */
public class ButtonFrameTest {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
            //JFrame frame = new ButtonFrame();
            //JFrame frame = new ButtonFrameLambda();
            JFrame frame = new ButtonFrameSource();
            
            frame.setTitle("ButtonFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}