package com.hef.design10.virtualproxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Logger;

/**
 * @Date 2019-06-10
 * @Author lifei
 */
public class ImageProxyTestDrive {

    private static final Logger logger = Logger.getLogger("com.hef.design10.virtualproxy.ImageProxyTestDrive");

    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("CD Cover Viewer");
    private JMenuBar menuBar;
    private JMenu menu;
    private Hashtable<String, String> cds = new Hashtable();

    public static void main(String[] args) {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive(){
        cds.put("lingdang","https://www.firefox.com.cn/media/img/logos/firefox/logo-quantum-high-res.cfd87a8f62ae.png");
        cds.put("baidu","https://www.baidu.com/img/bd_logo1.png");

        try {
            URL initialURL = new URL(cds.get("lingdang"));
            menuBar = new JMenuBar();
            menu = new JMenu("Favorite CDs");
            menuBar.add(menu);
            frame.setJMenuBar(menuBar);

            logger.info(initialURL.getPath());
            Icon icon = new ImageProxy(initialURL);
            imageComponent = new ImageComponent(icon);

            Enumeration<String> keys = cds.keys();
            for (; keys.hasMoreElements(); ){
                String name = keys.nextElement();
                JMenuItem menuItem = new JMenuItem(name);
                menu.add(menuItem);
                menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        imageComponent.setIcon(new ImageProxy(getCDURL(e.getActionCommand())));
                        frame.repaint();
                    }
                });
            }

            frame.getContentPane().add(imageComponent);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private URL getCDURL(String name){
        try {
            return new URL(cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }


}
