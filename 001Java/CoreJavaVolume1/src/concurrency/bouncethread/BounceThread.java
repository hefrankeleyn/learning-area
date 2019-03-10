package concurrency.bouncethread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import concurrency.bounce.Ball;
import concurrency.bounce.BallComponent;

/**
 * BounceThread
 */
public class BounceThread {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}

/**
 * The frame with panel and buttons
 */
class BounceFrame extends JFrame {

    private BallComponent comp;
    public static final int STEPS = 1000;
    public static final int DELAY = 5;

    /**
     * Constructs the frame with the component for showing the bounding ball 
     * and Start and Close buttons
     */
    public BounceFrame(){
        setTitle("BounceThread");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(buttonPanel, "Start", event -> addBall());
        addButton(buttonPanel, "Close", event -> System.exit(0));
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
    /**
     * Adds a button to a container
     * @param c the container
     * @param title the button title
     * @param listener the action listener for the button
     */
    public void addButton(Container c, String title, ActionListener listener){
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }
    /**
     * Adds a bouncing ball to the canvas and starts a thread to make it bounce
     */
    public void addBall(){
        Ball ball = new Ball();
        comp.add(ball);

        Runnable r = () -> {
            try {
                for (int i = 1; i <= STEPS; i++){
                    ball.move(comp.getBounds());
                    comp.repaint();
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        };

        Thread t = new Thread(r);
        t.start();
    }
}