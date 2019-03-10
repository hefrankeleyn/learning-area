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
            JFrame jframe = new ButtonFrameSource();
            
            jframe.setTitle("ButtonFrame");
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jframe.setVisible(true);
        });
    }

    private static void priStr(){
        pro();
    }

    private static void pro() {
        String x = "Hello world.";
        System.out.println(x);
    }
}