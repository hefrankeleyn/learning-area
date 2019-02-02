package swing.button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A frame with a button panel
 */
public class ButtonFrameSource extends JFrame implements ActionListener{

    private static final Logger logger = Logger.getLogger("swing.button");
    private JPanel buttonPanel;
    private JButton yellowButton;
    private JButton blueButton;
    private JButton redButton;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String ICON = "F:\\upgradeGo\\workplace\\learning-area\\001Java\\03CoreJavaVolume\\source\\icon.gif";

    public ButtonFrameSource(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        // add panel to frame
        add(buttonPanel);
        // create button, add button to panel , create button actions, associate action to button
        yellowButton = new JButton("yellow", new ImageIcon(ICON));
        blueButton = new JButton("Blue", new ImageIcon(ICON));
        redButton = new JButton("Red", new ImageIcon(ICON));

        yellowButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        //logger.info(source.getClass()+"");
        System.out.println(source);
        if (source == yellowButton){
            buttonPanel.setBackground(Color.YELLOW);
        }else if (source == blueButton){
            buttonPanel.setBackground(Color.BLUE);
        }else if (source == redButton){
            buttonPanel.setBackground(Color.RED);
        }else{
            buttonPanel.setBackground(Color.WHITE);
        }
    }
}