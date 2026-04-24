/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parseChain;

import com.mephi.missionsanalyzer.parsersForEachType.Parser;
import com.mephi.missionsanalyzer.parsersForEachType.TxtParser;

/**
 *
 * @author panda
 */
public class TxtHandler extends BaseParserHandler {

    @Override
    protected boolean canParse(String filePath) {
        ReadFirstLine rfl = new ReadFirstLine();
        String firstLine = rfl.getFirstNonEmptyLine(filePath);
        if (firstLine == null) return false; 
        if (firstLine.trim().startsWith("missionId")) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected Parser createParser(String path) {
        return new TxtParser(path);
    }
}
