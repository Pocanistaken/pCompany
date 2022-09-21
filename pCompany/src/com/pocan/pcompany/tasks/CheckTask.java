/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pocan.pcompany.tasks;

import com.pocan.pcompany.modules.TrayIconDemo;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Pocan
 */
public class CheckTask extends TimerTask{

    @Override
    public void run() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        if (String.valueOf(dateFormat.format(new Date())).contains("00:00")) {
            TrayIconDemo td = new TrayIconDemo();
            td.displayTray("Merhaba,, RunHeaven", "Şirketinin günlük istatistik bilgilerini göndermeyi unutma.");
            Toolkit.getDefaultToolkit().beep();
   
        }
        
    }
    
    
    
}
