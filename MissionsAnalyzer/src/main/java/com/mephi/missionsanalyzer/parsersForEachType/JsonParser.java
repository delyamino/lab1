 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;

import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.io.IOException;

/**
 *
 * @author panda
 */
public class JsonParser {
    private String filePath;

    public JsonParser(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Mission parse() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(filePath), Mission.class);
    }
}
}
