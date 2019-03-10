package concurrency.swing;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This program demostrates the a thread that runs in parallel with the event dispath thread
 * can cause errors in Swing components
 */
public class SwingThreadTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new SwingThreadFrame();
            frame.setTitle("SwingThreadTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SwingThreadFrame extends JFrame {

    public SwingThreadFrame() {
        final JComboBox<Integer> combo = new JComboBox<>();
        combo.insertItemAt(Integer.MAX_VALUE, 0);
        combo.setPrototypeDisplayValue(combo.getItemAt(0));
        combo.setSelectedIndex(0);

        JPanel panel = new JPanel();

        JButton goodButton = new JButton("Good");
        goodButton.addActionListener(event -> {
            new Thread(new GoodWorkerRunnable(combo)).start();
        });
        panel.add(goodButton);
        JButton badButton = new JButton("Bad");
        badButton.addActionListener(event -> new Thread(new BadWorkRunnable(combo)).start());
        panel.add(badButton);

        panel.add(combo);
        add(panel);
        pack();
    }
}

class BadWorkRunnable implements Runnable {

    private JComboBox<Integer> combo;
    private Random generator;

    public BadWorkRunnable(JComboBox<Integer> aCombo) {
        combo = aCombo;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            int i = Math.abs(generator.nextInt());
            if (i % 2 == 0) {
                combo.insertItemAt(i, 0);
            } else if (combo.getItemCount() > 0) {
                combo.removeItemAt(i % combo.getItemCount());
            }
            Thread.sleep(1);  
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * This runnable modifies a combo box by randomly adding and removing numbers.
 * In order to ensure that combo is not corrupted, the editing operatings are
 * forworded to the event dispatch thread.
 */
class GoodWorkerRunnable implements Runnable {

    private JComboBox<Integer> combo;
    private Random generator;

    public GoodWorkerRunnable(JComboBox<Integer> aComboBox) {
        combo = aComboBox;
        generator = new Random();
    }

    @Override
    public void run() {
        try {
            EventQueue.invokeLater(() -> {
                int i = Math.abs(generator.nextInt());
                if (i % 2 == 0) {
                    combo.insertItemAt(i, 0);
                } else if (combo.getItemCount() > 0) {
                    combo.removeItemAt(i % combo.getItemCount());
                }
            });
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}