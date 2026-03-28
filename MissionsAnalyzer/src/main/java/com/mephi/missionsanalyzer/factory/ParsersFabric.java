/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.factory;

import com.mephi.missionsanalyzer.parsersForEachType.JsonParser;
import com.mephi.missionsanalyzer.parsersForEachType.TxtParser;
import com.mephi.missionsanalyzer.parsersForEachType.XMLParser;
import com.mephi.missionsanalyzer.factory.FileLoad;
import java.io.IOException;

/**
 *
 * @author panda
 */
public class ParsersFabric {
    public Parser getParser(FileLoad fl) throws IOException {
        String format = fl.formatRecongnise();
        String filePath = fl.getFilePath();
        
        if (format.equals("txt")) {
            return new TxtParser(filePath);
        }
        else if (format.equals("xml")) {
            return new XMLParser(filePath);
        }
        else if (format.equals("json")) {
            return new JsonParser(filePath);
        }
        else {
            throw new IllegalArgumentException("Неизвестный формат файла");
        }
     }
}
