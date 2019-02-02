package swing.mvc.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * BorderLayoutTest
 */
public class BorderLayoutTest {

    public static void main(String[] args) {
        
        runMain01();
        runMain02();
    }



    public static void runMain02(){
        EventQueue.invokeLater(()->{
            JFrame frame = new ButtonLayout();
            frame.setTitle("button test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
        });
    }
    public static void runMain01(){
        EventQueue.invokeLater(()->{
            JFrame frame = new JFrame();
            frame.setSize(300, 200);
            JButton button01 = new JButton("yello");
            JButton button02 = new JButton("blue");
            frame.add(button01, BorderLayout.SOUTH);
            frame.add(button02, BorderLayout.SOUTH);
            frame.setTitle("button test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ButtonLayout extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;
    private static final String ICON = "F:\\upgradeGo\\workplace\\learning-area\\001Java\\03CoreJavaVolume\\source\\icon.gif";

    public ButtonLayout(){
        buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        
        JButton button01 = new JButton("Yellow", new ImageIcon(ICON));
        JButton button02 = new JButton("blue", new ImageIcon(ICON));
        buttonPanel.add(button01);
        buttonPanel.add(button02);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
