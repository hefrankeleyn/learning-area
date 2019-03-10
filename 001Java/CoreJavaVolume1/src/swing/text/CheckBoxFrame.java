package swing.text;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A frame with a sample text label and check boxes for selecting font attributes.
 */
public class CheckBoxFrame extends JFrame{

    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame(){
        // add the sample text label
        
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        // this listener sets the font attribute of the label to the check box state
        ActionListener listener = event -> {
            int mode = 0;
            if (bold.isSelected()) mode += Font.BOLD;
            if (bold.isSelected()) mode += Font.ITALIC;

            label.setFont(new Font("Serif", mode, FONTSIZE));

        };
        // add the check boxes
        JPanel buttonPanel = new JPanel();

        bold = new JCheckBox("Box");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    @Override
    public Dimension preferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}