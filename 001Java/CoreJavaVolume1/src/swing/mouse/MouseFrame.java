package swing.mouse;

import javax.swing.JFrame;

/**
 * MouseFrame
 */
public class MouseFrame extends JFrame{

    public MouseFrame(){
        add(new MouseComponent());
        pack();
    }
}