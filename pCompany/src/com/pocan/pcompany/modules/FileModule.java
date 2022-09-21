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
import java.nio.file.Files;
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
    
    public void createFile(String filename) {
  
        try {
          File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Heaven" + File.separator + filename + ".txt");
          if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
          } else {
            System.out.println("File already exists.");
          }
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
  }
    
    public void writeFile(String filename, String writeData) {
        //Path path = Paths.get(System.getProperty("user.home" + File.separator + "Documents" + File.separator + "Heaven"));
        
        
        File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Heaven" + File.separator + filename + ".txt");
   
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(writeData);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(FileModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static String readFileAsString(String fileName) {
          String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;

        } catch (IOException ex) {
            Logger.getLogger(FileModule.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

   
}
