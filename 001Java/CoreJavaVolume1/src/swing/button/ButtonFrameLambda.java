package swing.button;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A frame with a button panel
 */
public class ButtonFrameLambda extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String ICON = "F:\\upgradeGo\\workplace\\learning-area\\001Java\\03CoreJavaVolume\\source\\icon.gif";

    public ButtonFrameLambda(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        // add panel to frame
        add(buttonPanel);
        // create button, add button to panel , create button actions, associate action to button
        makeButton("Yellow", new ImageIcon(ICON), Color.YELLOW);
        makeButton("Blue", new ImageIcon(ICON), Color.BLUE);
        makeButton("Red", new ImageIcon(ICON), Color.RED);
    }

    private void makeButton(String name,  Icon icon, Color backgroundColor){
        JButton button = new JButton(name, icon);
        buttonPanel.add(button);
        button.addActionListener(even -> buttonPanel.setBackground(backgroundColor));
    }
    
}