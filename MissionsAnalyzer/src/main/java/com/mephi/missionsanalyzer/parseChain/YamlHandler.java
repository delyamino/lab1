/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parseChain;
import com.mephi.missionsanalyzer.parsersForEachType.Parser;
import com.mephi.missionsanalyzer.parsersForEachType.YamlParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author panda
 */
public class YamlHandler extends BaseParserHandler {
    @Override
    protected boolean canParse(String filePath) {
        ReadFirstLine rfl = new ReadFirstLine();
        String firstLine = rfl.getFirstNonEmptyLine(filePath);
        if (firstLine == null) return false; 
        if (!firstLine.trim().startsWith("missionId")) {
            return false;
        }
        else {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().startsWith("- ")) {
                        return true;
                    }
                }
            } catch (IOException e) {
                return false;
            }
        }
        return false;
        
    }   

    @Override
    protected Parser createParser(String path) {
        return new YamlParser(path);
    }
}
