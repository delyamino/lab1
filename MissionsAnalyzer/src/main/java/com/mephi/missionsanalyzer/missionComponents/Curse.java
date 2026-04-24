/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mephi.missionsanalyzer.enums.ThreatLevel;

/**
 *
 * @author panda
 */
public class Curse {
    @JsonProperty("n")
    @JsonAlias({"name"})
    private String name;
    private ThreatLevel threatLevel;
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setThreatLevel(String threatLevel) {
        this.threatLevel=CheckForValue.parseEnum(ThreatLevel.class, threatLevel);
    }
    
    public String getName() {
        return name;
    }
    
    public ThreatLevel getThreatLevel() {
        return threatLevel;
    }
    
    @Override
    public String toString() {
        return "Проклятие: " + CheckForValue.checkForNull(name) + ", угроза: " + CheckForValue.checkForNull(threatLevel) + "\n";
    }
}
