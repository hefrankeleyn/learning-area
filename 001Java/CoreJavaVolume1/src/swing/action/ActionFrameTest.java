package swing.action;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * ActionFrameTest
 */
public class ActionFrameTest {

    public static void main(String[] args) {
        
        EventQueue.invokeLater(()->{
            JFrame frame = new ActionFrame();
            frame.setTitle("action frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        
    }
}