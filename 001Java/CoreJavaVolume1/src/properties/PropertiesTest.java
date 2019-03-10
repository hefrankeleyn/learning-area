package properties;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * PropertiesTest
 */
public class PropertiesTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new PropertiesFrame();
            frame.setVisible(true);
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        });
    }
}

class PropertiesFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private File propertiesFile;
    private Properties settings;

    public PropertiesFrame(){
        // get position, size, title from properties
        /*
         * 要找出用户的主目录，可以调用System.getProperties 方法
         */
        // /Users/lifei
        //String userDir = System.getProperty("user.home");

        
        propertiesFile = new File("properties/program.properties");

        Properties defaultSettings = new Properties();
        defaultSettings.setProperty("left", "0");
        defaultSettings.setProperty("top", "0");
        defaultSettings.setProperty("width", "" + DEFAULT_WIDTH);
        defaultSettings.setProperty("height", "" + DEFAULT_HEIGHT);
        defaultSettings.setProperty("title", "");

        settings = new Properties(defaultSettings);

        if (propertiesFile.exists()){
            try (InputStream in = new FileInputStream(propertiesFile)){
                settings.load(in);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        int left = Integer.parseInt(settings.getProperty("left"));
        int top = Integer.parseInt(settings.getProperty("top"));
        int width = Integer.parseInt(settings.getProperty("width"));
        int height = Integer.parseInt(settings.getProperty("height"));
        setBounds(left, top, width, height);

        // if no title given, ask user
        String title = settings.getProperty("title");
        if (title.equals("")){
            title = JOptionPane.showInputDialog("Please supply a frame title:");
        }
        if (title == null) title = "";
        setTitle(title);

        addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent event) {
                settings.setProperty("left", "" + getX());
                settings.setProperty("top", "" + getY());
                settings.setProperty("width", "" + getWidth());
                settings.setProperty("height", "" + getHeight());
                settings.setProperty("title", "" + getTitle());

                try (OutputStream out = new FileOutputStream(propertiesFile)){
                    settings.store(out, "Properties");
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    private static void readPropertiesFile(){
        //InputStream in = PropertiesTest.class.getResourceAsStream("/properties/PropertiesTest.java");
        File file = new File("properties/program.properties");
        System.out.println(file.isFile());
        //InputStream in = null;
        byte[] b = new byte[1024];
        int i = 0;
        try {
            try(InputStream in = new FileInputStream(file)) {
                while ((i = in.read(b, 0, 1024)) != -1) {
                    System.out.println(new String(b, 0, i));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}