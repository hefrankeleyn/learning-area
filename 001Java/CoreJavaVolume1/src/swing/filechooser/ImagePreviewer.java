package swing.filechooser;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 * ImagePreviewer
 */
public class ImagePreviewer extends JLabel{

    public ImagePreviewer(JFileChooser chooser){
        setPreferredSize(new Dimension(100, 100));
        setBorder(BorderFactory.createEtchedBorder());

        chooser.addPropertyChangeListener(event -> {
            if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
                // the user has selected a new file
                File f = (File) event.getNewValue();
                if (f == null){
                    setIcon(null);
                    return;
                }

                // read the image into an icon
                ImageIcon icon = new ImageIcon(f.getParent());

                // if the icon is too large to fit, scale it
                if (icon.getIconWidth() > getWidth()){
                    icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));

                    setIcon(icon);
                }
            }
        });
    }
}