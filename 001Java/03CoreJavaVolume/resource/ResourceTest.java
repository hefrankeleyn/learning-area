package resource;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * ResourceTest
 */
public class ResourceTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ResourceTestFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("ResourceTest");
        });
    }
}

class ResourceTestFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public ResourceTestFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        URL aboutURL = getClass().getResource("icon.gif");
        Image img = new ImageIcon(aboutURL).getImage();
        setIconImage(img);

        JTextArea textArea = new JTextArea();
        InputStream stream = getClass().getResourceAsStream("about.txt");
        try (Scanner in = new Scanner(stream, "UTF-8")){
            while (in.hasNext()) {
                textArea.append(in.nextLine() + "\n");
            }
            add(textArea);
        }
        
    }
}