package swing.image;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * ImageTest
 */
public class ImageTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageFrame extends JFrame{
    public ImageFrame(){
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private static final String IMAGE_PATH = "/Users/lifei/Documents/workspace/learning-area/001Java/CoreJavaVolume1/source/photos/icon.gif";
    private Image image;

    public ImageComponent(){
        image = new ImageIcon(IMAGE_PATH).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (image == null) return;
        // argument: an object waiting for the image to be loaded.
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // draw the image in upper-left corner.
        g.drawImage(image, 0, 0, null);

        
        // tile the 
        for (int i = 0; i * imageWidth <= getWidth(); i++) {
            for (int j = 0; j * imageHeight <= getHeight() ; j++) {
                if (i + j > 0){
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}