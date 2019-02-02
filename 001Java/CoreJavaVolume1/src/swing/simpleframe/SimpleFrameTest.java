package swing.simpleframe;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 2019-01-27
 * @author Li Fei
 */
public class SimpleFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 关闭所有框架装饰
            //frame.setUndecorated(true);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public SimpleFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}