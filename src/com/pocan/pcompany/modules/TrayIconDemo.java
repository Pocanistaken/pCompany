
package com.pocan.pcompany.modules;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrayIconDemo {


    public void displayTray(String text, String text2) {
        if (SystemTray.isSupported()) {
            //Obtain only one instance of the SystemTray object
            SystemTray tray = SystemTray.getSystemTray();
            //URL url = System.class.getResource("/com/pocan/pcompany/icon/runheaven.png");
            //String file = "C:\\\\Users\\\\" + System.getProperty("user.name") + "\\Desktop\\" + "runheaven.png";

            //If the icon is a file
            Image image = Toolkit.getDefaultToolkit().getImage("./src/com/pocan/pcompany/icon/runheaven.png");

            MouseListener mouseListener = new MouseListener() {

                public void mouseClicked(MouseEvent e) {
                  //  System.out.println("Tray Icon - Mouse clicked!");                 
                }

                public void mouseEntered(MouseEvent e) {
                //    System.out.println("Tray Icon - Mouse entered!");                 
                }

                public void mouseExited(MouseEvent e) {
                 //   System.out.println("Tray Icon - Mouse exited!");                 
                }

                public void mousePressed(MouseEvent e) {
                 //   System.out.println("Tray Icon - Mouse pressed!");                 
                }

                public void mouseReleased(MouseEvent e) {
                 //   System.out.println("Tray Icon - Mouse released!");                 
                }
            };
            ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Çıkış yapılıyor... (Tray Icon)");
                    System.exit(0);
                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem("Çıkış yap");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);

            TrayIcon trayIcon = new TrayIcon(image, "Heaven", popup);
/*            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    trayIcon.displayMessage("Action Event", 
                        "An Action Event Has Been Performed!",
                        TrayIcon.MessageType.INFO);
                }
            };
*/
            
            //Let the system resize the image if needed
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Heaven");
  //          trayIcon.addActionListener(actionListener);
            trayIcon.addMouseListener(mouseListener);
            try {
                tray.add(trayIcon);
            } catch (AWTException ex) {
                Logger.getLogger(TrayIconDemo.class.getName()).log(Level.SEVERE, null, ex);
            }

            trayIcon.displayMessage(text, text2, MessageType.INFO);    
        }

    }
}
