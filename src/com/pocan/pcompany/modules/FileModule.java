/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pocan.pcompany.modules;

import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileModule {

    public FileModule() {
    }
    
    public void createFolder() {
        String path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Heaven";
        File customDir = new File(path);
        if (customDir.exists()) {
            System.out.println(customDir + " already exists");
        } else if (customDir.mkdirs()) {
            System.out.println(customDir + " was created");
        } else {
            System.out.println(customDir + " was not created");
        }
    }
    
/*    public void writeFile() {
        Path path = Paths.get(System.getProperty("user.home" + File.separator + "Documents" + File.separator + "Heaven"));
        File file = new File("user.home" + File.separator + "Documents" + File.separator + "Heaven" + File.separator + "runheaven.png");
        URL image = System.class.getResource("/com/pocan/pcompany/icon/runheaven.png");
   
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
*/
   
}
