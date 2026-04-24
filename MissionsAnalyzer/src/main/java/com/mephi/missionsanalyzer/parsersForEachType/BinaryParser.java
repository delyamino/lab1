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
public class BinaryParser implements Parser {
    private String filePath;

    public BinaryParser(String filePath) {
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
        ArrayList<String> artifactsRecovered = new ArrayList<>();
        ArrayList<String> evacuationZones = new ArrayList<>();
        ArrayList<String> statusEffects = new ArrayList<>();

        boolean hasCurse = false;
        boolean hasEconomic = false;
        boolean hasCivilian = false;
        boolean hasEnemy = false;
        boolean hasEnvironment = false;

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\|");
            String type = parts[0];

            switch (type) {
                case "MISSION_CREATED":
                    builder.missionId(parts[1]);
                    builder.date(parts[2]);
                    builder.location(parts[3]);
                    break;

                case "CURSE_DETECTED":
                    curse.setName(parts[1]);
                    curse.setThreatLevel(parts[2]);
                    hasCurse = true;
                    break;

                case "SORCERER_ASSIGNED":
                    Sorcerer s = new Sorcerer();
                    s.setName(parts[1]);
                    s.setRank(parts[2]);
                    sorcerers.add(s);
                    break;

                case "TECHNIQUE_USED":
                    Technique t = new Technique();
                    t.setName(parts[1]);
                    t.setType(parts[2]);
                    t.setOwner(parts[3]);
                    if (parts.length > 4) t.setDamage(parts[4]);
                    techniques.add(t);
                    break;

                case "MISSION_RESULT":
                    builder.outcome(parts[1]);
                    if (parts.length > 2) {
                        builder.damageCost(parts[2].split("=")[1]);
                    }
                    break;

                case "TIMELINE_EVENT":
                    OperationTimeline ot = new OperationTimeline();
                    ot.setTimestamp(parts[1]);
                    ot.setType(parts[2]);
                    if (parts.length > 3) ot.setDescription(parts[3]);
                    operationTimelines.add(ot);
                    break;

                case "ENEMY_ACTION":
                    if (parts.length > 1) enemyActivity.setBehaviorType(parts[1]);
                    if (parts.length > 2) enemyActivity.addAttackPattern(parts[2]);
                    hasEnemy = true;
                    break;

                case "CIVILIAN_IMPACT":
                    for (int i = 1; i < parts.length; i++) {
                        String[] kv = parts[i].split("=");
                        if (kv.length < 2) continue;
                        switch (kv[0].trim()) {
                            case "evacuated" -> civilianImpact.setEvacuated(kv[1]);
                            case "injured"   -> civilianImpact.setInjured(kv[1]);
                            case "missing"   -> civilianImpact.setMissing(kv[1]);
                        }
                    }
                    hasCivilian = true;
                    break;

                case "ECONOMIC_ASSESSMENT":
                    for (int i = 1; i < parts.length; i++) {
                        String[] kv = parts[i].split("=");
                        if (kv.length < 2) continue;
                        switch (kv[0].trim()) {
                            case "totalDamageCost"      -> economicAssessment.setTotalDamageCost(kv[1]);
                            case "infrastructureDamage" -> economicAssessment.setInfrastructureDamage(kv[1]);
                            case "commercialDamage"     -> economicAssessment.setCommercialDamage(kv[1]);
                            case "transportDamage"      -> economicAssessment.setTransportDamage(kv[1]);
                            case "recoveryEstimateDays" -> economicAssessment.setRecoveryEstimateDays(kv[1]);
                            case "insuranceCovered"     -> economicAssessment.setInsuranceCovered(kv[1]);
                        }
                    }
                    hasEconomic = true;
                    break;

                case "ENVIRONMENT":
                    for (int i = 1; i < parts.length; i++) {
                        String[] kv = parts[i].split("=");
                        if (kv.length < 2) continue;
                        switch (kv[0].trim()) {
                            case "weather"              -> environmentConditions.setWeather(kv[1]);
                            case "timeOfDay"            -> environmentConditions.setTimeOfDay(kv[1]);
                            case "visibility"           -> environmentConditions.setVisibility(kv[1]);
                            case "cursedEnergyDensity"  -> environmentConditions.setCursedEnergyDensity(kv[1]);
                        }
                    }
                    hasEnvironment = true;
                    break;

                case "OPERATION_TAG":
                    if (parts.length > 1) operationTags.add(parts[1]);
                    break;
                case "SUPPORT_UNIT":
                    if (parts.length > 1) supportUnits.add(parts[1]);
                    break;
                case "RECOMMENDATION":
                    if (parts.length > 1) recommendations.add(parts[1]);
                    break;
                case "ARTIFACT_RECOVERED":
                    if (parts.length > 1) artifactsRecovered.add(parts[1]);
                    break;
                case "EVACUATION_ZONE":
                    if (parts.length > 1) evacuationZones.add(parts[1]);
                    break;
                case "STATUS_EFFECT":
                    if (parts.length > 1) statusEffects.add(parts[1]);
                    break;
            }
        }

        reader.close();

        if (!operationTags.isEmpty()) {
            extras.put("Operation tags", operationTags);
        }
        if (!supportUnits.isEmpty()) {
            extras.put("Support units", supportUnits);
        }
        if (!recommendations.isEmpty()) {
            extras.put("Recommendations", recommendations);
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

        return builder
            .curse(hasCurse ? curse : null)
            .sorcerers(sorcerers)
            .techniques(techniques)
            .operationTimelines(operationTimelines)
            .economicAssessment(hasEconomic ? economicAssessment : null)
            .civilianImpact(hasCivilian ? civilianImpact : null)
            .enemyActivity(hasEnemy ? enemyActivity : null)
            .environmentConditions(hasEnvironment ? environmentConditions : null)
            .extraInfo(extras.isEmpty() ? null : extras)
            .build();
    }
}