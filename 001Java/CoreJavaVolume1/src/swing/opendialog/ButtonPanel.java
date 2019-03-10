package swing.opendialog;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * A panel with radio buttons inside a titled border.
 */
public class ButtonPanel extends JPanel{

    private ButtonGroup group;
    /**
     * Constructs a button panel.
     * @param title title the title shown in the border
     * @param options options an array of radio button labels
     */
    public ButtonPanel(String title, String... options){
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        group = new ButtonGroup();

        // make one radio button for each option
        for (String option : options) {
            JRadioButton b = new JRadioButton(option);
            b.setActionCommand(option);
            add(b);
            group.add(b);
            b.setSelected(option == options[0]);
        }
    }
    /**
     * Gets the currently selected option
     * @return the label of the currentlhy selected radio button.
     */
    public String getSelection(){
        return group.getSelection().getActionCommand();
    }
}