package swing.toolbar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * ToolBarFrame
 */
public class ToolBarFrame extends JFrame{

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;
    private static final String CUT_PATH = "/Users/lifei/Documents/workspace/learning-area/001Java/CoreJavaVolume1/source/photos/cut.gif";
    private static final String COPY_PATH = "/Users/lifei/Documents/workspace/learning-area/001Java/CoreJavaVolume1/source/photos/copy.gif";
    private static final String PASTE_PATH = "/Users/lifei/Documents/workspace/learning-area/001Java/CoreJavaVolume1/source/photos/paste.gif";
    

    public ToolBarFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // add a panel for color change
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        // set up actions
        Action blueAction = new ColorAction("Blue", new ImageIcon(CUT_PATH), Color.BLUE);
        Action yellowAction = new ColorAction("Yellow", new ImageIcon(COPY_PATH), Color.YELLOW);
        Action redAction = new ColorAction("Red", new ImageIcon(PASTE_PATH), Color.RED);

        Action exitAction = new AbstractAction("Exit"){
        
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");

        // populate toolbar

        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.addSeparator();
        bar.add(exitAction);

        add(bar, BorderLayout.NORTH);

        // populate menu
        JMenu menu = new JMenu("Color");
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    /**
     * The color action sets the background of the frame to a given color.
     */
    class ColorAction extends AbstractAction{
        
        public ColorAction(String name, Icon icon, Color color){
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + " background");
            putValue("Color", color);
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            Color c = (Color)getValue("Color");
            panel.setBackground(c);
        }
    }
}