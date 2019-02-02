package swing.button;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A frame with a button panel
 */
public class ButtonFrame extends JFrame{
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String ICON = "F:\\upgradeGo\\workplace\\learning-area\\001Java\\03CoreJavaVolume\\source\\icon.gif";

    public ButtonFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // create button
        JButton yellowButton = new JButton("Yellow", new ImageIcon(ICON));
        JButton blueButton = new JButton("Blue", new ImageIcon(ICON));
        JButton redButton = new JButton("Red", new ImageIcon(ICON));

        buttonPanel = new JPanel();

        // add button to panel
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        // add panel to frame
        add(buttonPanel);

        // create button actions
        ColorAction yellowAction = new ColorAction(Color.YELLOW);
        ColorAction blueAction = new ColorAction(Color.BLUE);
        ColorAction redAction = new ColorAction(Color.RED);

        // associate actions with buttons
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

    }
    /**
     * An action listener that sets the panel's background color
     */
    private class ColorAction implements ActionListener{
        private Color backgroundColor;

        public ColorAction(Color c){
            backgroundColor = c;
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
    
}