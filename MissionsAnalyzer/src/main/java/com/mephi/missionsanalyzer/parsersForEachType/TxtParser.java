/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;

import com.mephi.missionsanalyzer.factory.Parser;
import com.mephi.missionsanalyzer.factory.FileLoad;
import com.mephi.missionsanalyzer.missionComponents.Curse;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.missionComponents.Sorcerer;
import com.mephi.missionsanalyzer.missionComponents.Technique;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panda
 */
public class TxtParser implements Parser{
    private String filePath;
    
    public TxtParser(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public Mission parse() throws IOException {
        Mission mission=new Mission();
        Curse curse = new Curse();
        List<Sorcerer> sorcerers = new ArrayList<>();
        List<Technique> techniques = new ArrayList<>();
        
        String line;
        
        FileReader f = new FileReader(filePath);
        BufferedReader br = new BufferedReader(f);
        
        while ((line=br.readLine())!=null){
            if (line.trim().isEmpty()) {
                continue;
            }
            
            String key=line.split(":",2)[0];
            String value=line.split(":",2)[1].trim();
            if (key.equals("missionId")){
                mission.setMissionId(value);
            }
            else if (key.equals("date")) {
                mission.setDate(value);
            }
            else if (key.equals("location")) {
                mission.setLocation(value);
            }
            else if (key.equals("outcome")) {
                mission.setOutcome(value);
            }
            else if (key.equals("damageCost")) {
                mission.setDamageCost(value);
            }
            else if (key.equals("curse.name")) {
                curse.setName(value);
            }
            else if (key.equals("curse.threatLevel")) {
                curse.setThreatLevel(value);
            }
            else if (key.startsWith("sorcerer")) {
                int leftBracketInd = key.indexOf("[");
                int rightBracketInd = key.indexOf("]");
                int soursererInd = Integer.parseInt(key.substring(leftBracketInd+1, rightBracketInd));
                while (sorcerers.size()<=soursererInd) {
                    sorcerers.add(new Sorcerer());
                }
                if (key.trim().endsWith("name")) {
                    sorcerers.get(soursererInd).setName(value);
                }
                if (key.trim().endsWith("rank")) {
                    sorcerers.get(soursererInd).setRank(value);
                }
            }
            else if (key.startsWith("technique")) {
                int leftBracketInd = key.indexOf("[");
                int rightBracketInd = key.indexOf("]");
                int techniqueInd = Integer.parseInt(key.substring(leftBracketInd+1, rightBracketInd));
                while (techniques.size()<=techniqueInd) {
                    techniques.add(new Technique());
                }
                if (key.trim().endsWith("name")) {
                    techniques.get(techniqueInd).setName(value);
                }
                if (key.trim().endsWith("type")) {
                    techniques.get(techniqueInd).setType(value);
                }
                if (key.trim().endsWith("owner")) {
                    techniques.get(techniqueInd).setOwner(value);
                }
                if (key.trim().endsWith("damage")) {
                    techniques.get(techniqueInd).setDamage(value);
                }
            }
            else if (key.equals("note")) {
                mission.setNote(value);
            }
            else if (key.equals("comment")) {
                mission.setComment(value);
            } 
        }
        br.close();
        mission.setCurse(curse);
        mission.setTechniques(techniques);
        mission.setSorcerers(sorcerers);
        return mission;
    }
}
