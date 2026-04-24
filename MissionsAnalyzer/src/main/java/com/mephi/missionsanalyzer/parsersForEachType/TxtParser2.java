/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.parsersForEachType;

import com.mephi.missionsanalyzer.missionComponents.CivilianImpact;
import com.mephi.missionsanalyzer.missionComponents.Curse;
import com.mephi.missionsanalyzer.missionComponents.EconomicAssessment;
import com.mephi.missionsanalyzer.missionComponents.EnemyActivity;
import com.mephi.missionsanalyzer.missionComponents.EnvironmentConditions;
import com.mephi.missionsanalyzer.missionComponents.Mission;
import com.mephi.missionsanalyzer.missionComponents.MissionBuilder;
import com.mephi.missionsanalyzer.missionComponents.OperationTimeline;
import com.mephi.missionsanalyzer.missionComponents.Sorcerer;
import com.mephi.missionsanalyzer.missionComponents.Technique;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        MissionBuilder builder = new MissionBuilder();
        Curse curse = new Curse();
        List<Sorcerer> sorcerers = new ArrayList<>();
        List<Technique> techniques = new ArrayList<>();
        EconomicAssessment economicAssessment = new EconomicAssessment();
        CivilianImpact civilianImpact = new CivilianImpact();
        EnemyActivity enemyActivity = new EnemyActivity();
        EnvironmentConditions environmentConditions = new EnvironmentConditions();
        List<OperationTimeline> operationTimelines = new ArrayList<>();
        HashMap<String, ArrayList<String>> extras = new HashMap<>();
        ArrayList<String> operationTags = new ArrayList<>();
        ArrayList<String> supportUnits = new ArrayList<>();
        ArrayList<String> recommendations = new ArrayList<>();
        ArrayList<String> notes = new ArrayList<>();
        ArrayList<String> artifactsRecovered = new ArrayList<>();
        ArrayList<String> evacuationZones = new ArrayList<>();
        ArrayList<String> statusEffects = new ArrayList<>();
        
        
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
                if (currentOperationTimeline != null) {
                    operationTimelines.add(currentOperationTimeline);
                    currentOperationTimeline = null;
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
            
            
            switch (sectionName) {
                case "MISSION":
                    switch (key) {
                        case "missionId" -> builder.missionId(value);
                        case "date" -> builder.date(value);
                        case "location" -> builder.location(value);
                        case "outcome" -> builder.outcome(value);
                        case "damageCost" -> builder.damageCost(value);
                        default -> {
                        }
                    }   break;
                case "CURSE":
                    if (key.equals("name")) {
                        curse.setName(value);
                    }
                    else if (key.equals("threatLevel")) {
                        curse.setThreatLevel(value);
                    }   break;
                case "SORCERERS":
                    if (key.equals("name")) {
                        currentSorcerer.setName(value);
                    }
                    else if (key.equals("rank")) {
                        currentSorcerer.setRank(value);
                    }   break;
                case "TECHNIQUES":
                    switch (key) {
                        case "name" -> currentTechnique.setName(value);
                        case "type" -> currentTechnique.setType(value);
                        case "owner" -> currentTechnique.setOwner(value);
                        case "damage" -> currentTechnique.setDamage(value);
                        default -> {
                        }
                    }   break;
                case "ECONOMIC ASSESSMENT":
                    switch (key) {
                        case "totalDamageCost" -> economicAssessment.setTotalDamageCost(value);
                        case "infrastructureDamage" -> economicAssessment.setInfrastructureDamage(value);
                        case "commercialDamage" -> economicAssessment.setCommercialDamage(value);
                        case "transportDamage" -> economicAssessment.setTransportDamage(value);
                        case "recoveryEstimateDays" -> economicAssessment.setRecoveryEstimateDays(value);
                        case "insuranceCovered" -> economicAssessment.setInsuranceCovered(value);
                        default -> {
                        }
                    }   break;
                case "CIVILIAN IMPACT":
                    switch (key) {
                        case "evacuated" -> civilianImpact.setEvacuated(value);
                        case "injured" -> civilianImpact.setInjured(value);
                        case "missing" -> civilianImpact.setMissing(value);
                        case "publicExposureRisk" -> civilianImpact.setPublicExposureRisk(value);
                        default -> {
                        }
                    }   break;
                case "ENEMY ACTIVITY":
                    switch (key) {
                        case "behaviorType" -> enemyActivity.setBehaviorType(value);
                        case "targetPriority" -> enemyActivity.addTargetPriority(value);
                        case "attackPatterns" -> enemyActivity.addAttackPattern(value);
                        case "mobility" -> enemyActivity.setMobility(value);
                        case "escalationRisk" -> enemyActivity.setEscalationRisk(value);
                        default -> {
                        }
                    }   break;
                case "ENVIRONMENT CONDITIONS":
                    switch (key) {
                        case "weather" -> environmentConditions.setWeather(value);
                        case "timeOfDay" -> environmentConditions.setTimeOfDay(value);
                        case "visibility" -> environmentConditions.setVisibility(value);
                        case "cursedEnergyDensity" -> environmentConditions.setCursedEnergyDensity(value);
                        default -> {
                        }
                    }   break;
                case "OPERATION TIMELINE":
                    switch (key) {
                        case "timestamp" -> currentOperationTimeline.setTimestamp(value);
                        case "type" -> currentOperationTimeline.setType(value);
                        case "description" -> currentOperationTimeline.setDescription(value);
                        default -> {
                        }
                    }   break;
                default:
                    break;
            }
            switch (key) {
                case "operationTags":
                    operationTags.add(value);
                    break;
                case "supportUnits":
                    supportUnits.add(value);
                    break;
                case "recommendations":
                    recommendations.add(value);
                    break;
                case "notes":
                    notes.add(value);
                    break;
                case "artifactsRecovered":
                    artifactsRecovered.add(value);
                    break;
                case "evacuationZones":
                    evacuationZones.add(value);
                    break;
                case "statusEffects":
                    statusEffects.add(value);
                    break;
                default:
                    break;
            }
        }
        if (!operationTags.isEmpty()) {
            extras.put("Operation tags", operationTags);
        }
        if (!supportUnits.isEmpty()) {
            extras.put("Support units", supportUnits);
        }
        if (!recommendations.isEmpty()) {
            extras.put("Recommendations", recommendations);
        }
        if (!notes.isEmpty()) {
            extras.put("Notes", notes);
        }
        if (!artifactsRecovered.isEmpty()) {
            extras.put("Artifacts recovered", artifactsRecovered);
        }
        if (!evacuationZones.isEmpty()) {
            extras.put("Evacuation zones", evacuationZones);
        }
        if (!statusEffects.isEmpty()) {
            extras.put("Status effects", statusEffects);
        }

        if (currentSorcerer != null) {
            sorcerers.add(currentSorcerer);
        }
        if (currentTechnique != null) {
            techniques.add(currentTechnique);
        }

        reader.close();
        return builder
            .curse(curse)
            .sorcerers(sorcerers)
            .techniques(techniques)
            .economicAssessment(economicAssessment)
            .civilianImpact(civilianImpact)
            .enemyActivity(enemyActivity)
            .environmentConditions(environmentConditions)
            .operationTimelines(operationTimelines)
            .extraInfo(extras)
            .build();
    }
}
