/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer;

/**
 *
 * @author panda
 */
public class ParsersFabric {
    FileLoad fl = new FileLoad();
    public String format = fl.formatRecongnise();
    String filePath = fl.getFilePath();
    
    public Parser getParser(String format) {
        if (format == "txt") {
            Parser parser = new TxtParser(filePath);
        }
        if (format == "xml") {
            Parser parser = new XMLParser(filePath);
        }
        if (format == "json") {
            Parser parser = new JsonParser(filePath);
        }
    }
}
