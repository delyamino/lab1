/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;
import com.mephi.missionsanalyzer.enums.ThreatLevel;

/**
 *
 * @author panda
 */
public class Curse {
    private String name;
    private ThreatLevel threatLevel;
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setThreatLevel(String threatLevel) {
        this.threatLevel=ThreatLevel.valueOf(threatLevel);
    }
    
    public String getName() {
        return name;
    }
    
    public ThreatLevel getThreatLevel() {
        return threatLevel;
    }
}
