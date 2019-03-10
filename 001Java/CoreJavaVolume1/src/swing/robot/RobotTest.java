package swing.robot;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import swing.button.ButtonFrame;

/**
 * RobotTest
 */
public class RobotTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        // attach a robot to the screen device
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screen = environment.getDefaultScreenDevice();

        try {
            final Robot robot = new Robot(screen);
            robot.waitForIdle();
            new Thread(){
                public void run(){
                    runTest(robot);
                }
            }.start();
        } catch (AWTException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void runTest(Robot robot){
        // simulate a space bar press
        robot.keyPress(' ');
        robot.keyRelease(' ');

        // simulate a tab key followed by a space
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(' ');
        robot.keyRelease(' ');

        // simulate a mouse click over the rightmost button
        robot.delay(2000);
        robot.mouseMove(220, 40);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        // capture the screen and show the resulting image
        robot.delay(2000);
        BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, 400, 300));

        ImageFrame frame = new ImageFrame(image);
        frame.setVisible(true);
    }
}

/**
 * A frame to display a captured image
 */
class ImageFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    public ImageFrame(Image image){
        setTitle("Capture");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel label = new JLabel(new ImageIcon(image));
        add(label);
    }


}