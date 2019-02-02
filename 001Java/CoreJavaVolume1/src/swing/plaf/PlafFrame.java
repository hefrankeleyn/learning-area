package swing.plaf;

import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * PlafFrame
 */
public class PlafFrame extends JFrame{

    private JPanel buttonPanel;
    private static final Logger logger = Logger.getLogger("swing.plaf");
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    public PlafFrame(){
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            logger.info(info.getName()+","+info.getClassName());
            makeButton(info.getName(), info.getClassName());
        }
        add(buttonPanel);
        
        pack();
    }

    /**
     * Makes a button to change the pluggable look-and-feel
     */
    private void makeButton(String name, String className){
        // add button to panel
        JButton button = new JButton(name);
        buttonPanel.add(button);

        // set button action
        button.addActionListener(even -> {
            // button action: switch to the new look-and-fell
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
                //pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}