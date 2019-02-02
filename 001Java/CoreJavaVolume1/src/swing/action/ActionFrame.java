package swing.action;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * A frame with a panel that demonstrates color change actions.
 */
public class ActionFrame extends JFrame{

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String FILENAME = "F:\\upgradeGo\\workplace\\learning-area\\001Java\\03CoreJavaVolume\\source\\icon.gif";

    public ActionFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        buttonPanel = new JPanel();
        // add panel to frame
        add(buttonPanel);

        // define actions
        Action yellowAction = new ColorAction("Yellow", new ImageIcon(FILENAME), Color.YELLOW);
        Action blueAction = new ColorAction("Blue", new ImageIcon(FILENAME), Color.BLUE);
        Action redAction = new ColorAction("Red", new ImageIcon(FILENAME), Color.RED);

        // associate action with button
        JButton yellowButton = new JButton(yellowAction);
        JButton blueButton = new JButton(blueAction);
        JButton redButton = new JButton(redAction);

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        // get input map
        // when_ancestor_of_focused_component
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        // associate the Y, B, and R keys with names
        imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");

        // associate the names with actions
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
    }


    public class ColorAction extends AbstractAction{
        /**
         * Constructs a color action.
         * @param name the name to show on the button
         * @param icon icon the icon to dispaly on the button
         * @param c the background color
         */
        public ColorAction(String name, Icon icon, Color c){
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue("color", c);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
        }
        @Override
        public void actionPerformed(ActionEvent event) {
            Color c = (Color)getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
