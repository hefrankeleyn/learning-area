package preferences;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * A program to test preference settings. The program remembers the frame
 */
public class PreferencesTest {

    public static void main(String[] args) {
        runPreferencesFrame();
        // testPreference();

    }

    private static void testPreference() {
        Preferences root = Preferences.userRoot();
        System.out.println(root);
        Preferences node = root.node("/com/horstmann/corejava");
        System.out.println(node);
    }

    private static void runPreferencesFrame() {
        EventQueue.invokeLater(() -> {
            JFrame frame = new PreferencesFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}

/**
 * A frame that restores position and size from user preferences and updates the
 * preferences upon exit.
 */
class PreferencesFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Preferences root = Preferences.userRoot();
    private Preferences node = root.node("/com/horstmann/corejava");

    public PreferencesFrame() {
        // get position, size, title, from preference
        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);
        int width = node.getInt("width", DEFAULT_WIDTH);
        int height = node.getInt("height", DEFAULT_HEIGHT);
        setBounds(left, top, width, height);

        // if no title given, ask user
        String title = node.get("title", "");
        if (title.equals("")) {
            title = JOptionPane.showInputDialog("Please supply a frame title:");
        }
        if (title == null) {
            title = "";
        }
        setTitle(title);

        // set up file chooser that shows XML files
        final JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        chooser.setFileFilter(new FileNameExtensionFilter("XML files", "xml"));

        // set up menus
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem exportItem = new JMenuItem("Export preferences");
        menu.add(exportItem);

        exportItem.addActionListener(event -> {
            if (chooser.showSaveDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
                try (OutputStream out = new FileOutputStream(chooser.getSelectedFile())) {
                    savePreferences();
                    node.exportSubtree(out);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BackingStoreException e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem importItem = new JMenuItem("Import preferences");
        menu.add(importItem);
        importItem.addActionListener(event -> {
            if (chooser.showOpenDialog(PreferencesFrame.this) == JFileChooser.APPROVE_OPTION) {
                try (InputStream in = new FileInputStream(chooser.getSelectedFile())) {
                    Preferences.importPreferences(in);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidPreferencesFormatException e) {
                    e.printStackTrace();
                }
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        menu.add(exitItem);
        exitItem.addActionListener(event -> {
            savePreferences();
            System.exit(0);
        });
    }

    public void savePreferences(){
        node.putInt("left", getX());
        node.putInt("top", getY());
        node.putInt("width", getWidth());
        node.putInt("height", getHeight());
        node.put("title", getTitle());
    }
}