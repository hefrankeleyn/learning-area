package com.hef.design10.virtualproxy;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.logging.Logger;

/**
 * @Date 2019-06-10
 * @Author lifei
 */
public class ImageProxy implements Icon {
    private static final Logger logger = Logger.getLogger("com.hef.design10.virtualproxy.ImageProxy");
    private ImageIcon imageIcon;
    private URL imageURL;
    private Thread retrievalThread;
    private boolean retrieving = false;

    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if(imageIcon!=null){
            // 如果已经有icon， 就告诉它画出自己
            imageIcon.paintIcon(c, g, x, y);
        } else {
            // 否则显示，加载中
            g.drawString("CD 加载中，请稍后。。。", x + 300, y+190);
            if(!retrieving){
                retrieving = true;
                retrievalThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        imageIcon = new ImageIcon(imageURL, "CD Cover");
                        logger.info(imageIcon.getIconHeight() + ", " + imageIcon.getIconWidth());
                        c.repaint();
                    }
                });
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if(imageIcon != null){
            return imageIcon.getIconWidth();
        }
        return 800;
    }

    @Override
    public int getIconHeight() {
        if(imageIcon != null){
            return imageIcon.getIconHeight();
        }
        return 600;
    }
}
