/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author panda
 */
public class FileLoad {
    private String filePath = "";
    
    public String getFilePath(){
        return filePath;
    }
    
    public void setFile(String filePath) throws FileNotFoundException {
        this.filePath=filePath;
    }
    
    public String getFile(){
        return filePath;
    }
    
    public String formatRecongnise() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String firstLine = reader.readLine();
        reader.close();
        if (filePath.endsWith(".txt")&&(firstLine.trim().startsWith("mission"))){
            return "txt";
        }
        else if (filePath.endsWith(".json")&&(firstLine.trim().startsWith("{"))){
            return "json";
        }
        else if (filePath.endsWith(".xml")&&(firstLine.trim().startsWith("<"))){
            return "xml";
        }
        else{
            throw new IllegalArgumentException("Неизвестный формат файла");
        }
    }
}
