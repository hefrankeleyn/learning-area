package swing.dataexchange;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * DataExchangeFrameText
 */
public class DataExchangeFrameText {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DataExchangeFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Data Exchange Frame");
        });
    }
}