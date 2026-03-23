/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer;

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
    private InputStream inputStream = null;
    private String format = "";
    
    public void setFile(String filePath) throws FileNotFoundException {
        File file=new File(filePath);
        this.inputStream=new FileInputStream(file);
    }
    
    public InputStream getFile(){
        return inputStream;
    }
    
    public String formatRecongnise() throws FileNotFoundException, IOException{
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String firstLine = reader.readLine();
        reader.close();
        if (filePath.endsWith(".txt")&&(firstLine.trim().startsWith("mission"))){
            return format = "txt";
        }
        else if (filePath.endsWith(".json")&&(firstLine.trim().startsWith("{"))){
            return format = "json";
        }
        else if (filePath.endsWith(".xml")&&(firstLine.trim().startsWith("<"))){
            return format = "xml";
        }
        else{
            return "Формат данных в файле не соответствует расширению файла";
        }
    }
}
