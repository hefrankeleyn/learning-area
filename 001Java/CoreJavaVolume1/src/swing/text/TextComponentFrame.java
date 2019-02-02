package swing.text;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * TextComponentFrame
 */
public class TextComponentFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 400;

    private static final int TEXTAREA_ROWS = 8;
    private static final int TEXTAREA_COLUMNS = 20;
    public TextComponentFrame(){
        JTextField textField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("User name:", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password", SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        // add button to append text into the text area
        JPanel southPanel = new JPanel();

        JButton insertButton = new JButton("Insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(event -> {
            textArea.append("User name:" + textField.getText() + "\nPassword:" + new String(passwordField.getPassword()) + "\n");
        });

        add(southPanel, BorderLayout.SOUTH);
        pack();

    }
    @Override
    public Dimension preferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}