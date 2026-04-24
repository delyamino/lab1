/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
/**
 *
 * @author panda
 */

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;

public class YamlParser implements Parser {
    private String filePath;

    public YamlParser(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Mission parse() throws IOException {
        YAMLMapper mapper = new YAMLMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(filePath), Mission.class);
    }
}
