 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mephi.missionsanalyzer.factory.Parser;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author panda
 */
public class JsonParser implements Parser{
    private String filePath;

    public JsonParser(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Mission parse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        return mapper.readValue(file, Mission.class);
    }
}
