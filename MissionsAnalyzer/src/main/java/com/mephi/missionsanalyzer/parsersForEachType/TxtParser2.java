/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;

import com.mephi.missionsanalyzer.factory.Parser;
import com.mephi.missionsanalyzer.missionComponents.CivilianImpact;
import com.mephi.missionsanalyzer.missionComponents.Curse;
import com.mephi.missionsanalyzer.missionComponents.EconomicAssessment;
import com.mephi.missionsanalyzer.missionComponents.EnemyActivity;
import com.mephi.missionsanalyzer.missionComponents.EnvironmentConditions;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.missionComponents.OperationTimeline;
import com.mephi.missionsanalyzer.missionComponents.Sorcerer;
import com.mephi.missionsanalyzer.missionComponents.Technique;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panda
 */
public class TxtParser2 implements Parser {
    private String filePath;

    public TxtParser2(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Mission parse() throws IOException {
        Mission mission = new Mission();
        Curse curse = new Curse();
        List<Sorcerer> sorcerers = new ArrayList<>();
        List<Technique> techniques = new ArrayList<>();
        EconomicAssessment economicAssessment = new EconomicAssessment();
        CivilianImpact civilianImpact = new CivilianImpact();
        EnemyActivity enemyActivity = new EnemyActivity();
        EnvironmentConditions environmentConditions = new EnvironmentConditions();
        List<OperationTimeline> operationTimelines = new ArrayList<>();
        
        String sectionName = "";
        Sorcerer currentSorcerer = null;
        Technique currentTechnique = null;
        OperationTimeline currentOperationTimeline = null;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("[")) {
                if (currentSorcerer != null) {
                    sorcerers.add(currentSorcerer);
                    currentSorcerer = null;
                }
                if (currentTechnique != null) {
                    techniques.add(currentTechnique);
                    currentTechnique = null;
                }
                sectionName = line.substring(line.indexOf("[")+1, line.indexOf("]"));
                if (sectionName.equals("SORCERER")) {
                    currentSorcerer = new Sorcerer();
                }
                if (sectionName.equals("TECHNIQUE")) {
                    currentTechnique = new Technique();
                }
                if (sectionName.equals("OPERATION TIMELINE")) {
                    currentOperationTimeline = new OperationTimeline();
                }
                continue;
            }

            String[] parts = line.split("=", 2);
            if (parts.length < 2) continue;
            String key = parts[0].trim();
            String value = parts[1].trim();

            if (sectionName.equals("MISSION")) {
                switch (key) {
                    case "missionId" -> mission.setMissionId(value);
                    case "date" -> mission.setDate(value);
                    case "location" -> mission.setLocation(value);
                    case "outcome" -> mission.setOutcome(value);
                    case "damageCost" -> mission.setDamageCost(value);
                    default -> {
                    }
                }
                break;
            }
            
            if (sectionName.equals("CURSE")) {
                if (key.equals("name")) {
                    curse.setName(value);
                }
                else if (key.equals("threatLevel")) {
                    curse.setThreatLevel(value);
                }
                break;
            }
            
            if (sectionName.equals("SORCERERS")) {
                if (key.equals("name")) {
                    currentSorcerer.setName(value);
                }
                else if (key.equals("rank")) {
                    currentSorcerer.setRank(value);
                }
                break;
            }
            
            if (sectionName.equals("TECHNIQUES")) {
                switch (key) {
                    case "name" -> currentTechnique.setName(value);
                    case "type" -> currentTechnique.setType(value);
                    case "owner" -> currentTechnique.setOwner(value);
                    case "damage" -> currentTechnique.setDamage(value);
                    default -> {
                    }
                }
                break;
            }
            
            if (sectionName.equals("ECONOMIC ASSESSMENT")) {
                switch (key) {
                    case "totalDamageCost" -> economicAssessment.setTotalDamageCost(value);
                    case "infrastructureDamage" -> economicAssessment.setInfrastructureDamage(value);
                    case "commercialDamage" -> economicAssessment.setCommercialDamage(value);
                    case "transportDamage" -> economicAssessment.setTransportDamage(value);
                    case "recoveryEstimateDays" -> economicAssessment.setRecoveryEstimateDays(value);
                    case "insuranceCovered" -> economicAssessment.setInsuranceCovered(value);
                    default -> {
                    }
                }
                break;
            }
            
            if (sectionName.equals("CIVILIAN IMPACT")) {
                switch (key) {
                    case "evacuated" -> civilianImpact.setEvacuated(value);
                    case "injured" -> civilianImpact.setInjured(value);
                    case "missing" -> civilianImpact.setMissing(value);
                    case "publicExposureRisk" -> civilianImpact.setPublicExposureRisk(value);
                    default -> {
                    }
                }
                break;
            }
            
            if (sectionName.equals("ENEMY ACTIVITY")) {
                switch (key) {
                    case "behaviorType" -> enemyActivity.setBehaviorType(value);
                    case "targetPriority" -> enemyActivity.setTargetPriority(value);
                    case "attackPatterns" -> enemyActivity.setAttackPatterns(value);
                    case "mobility" -> enemyActivity.setMobility(value);
                    case "escalationRisk" -> enemyActivity.setEscalationRisk(value);
                    default -> {
                    }
                }
                break;
            }
            
            if (sectionName.equals("ENVIRONMENT CONDITIONS")) {
                switch (key) {
                    case "weather" -> environmentConditions.setWeather(value);
                    case "timeOfDay" -> environmentConditions.setTimeOfDay(value);
                    case "visibility" -> environmentConditions.setVisibility(value);
                    case "cursedEnergyDensity" -> environmentConditions.setCursedEnergyDensity(value);
                    default -> {
                    }
                }
                break;
            }
            
            if (sectionName.equals("OPERATION TIMELINE")) {
                switch (key) {
                    case "timestamp" -> currentOperationTimeline.setTimestamp(value);
                    case "type" -> currentOperationTimeline.setType(value);
                    case "description" -> currentOperationTimeline.setDescription(value);
                    default -> {
                    }
                }
                break;
            }
        }

        if (currentSorcerer != null) sorcerers.add(currentSorcerer);
        if (currentTechnique != null) techniques.add(currentTechnique);

        reader.close();
        mission.setCurse(curse);
        mission.setSorcerers(sorcerers);
        mission.setTechniques(techniques);
        return mission;
    }
}
