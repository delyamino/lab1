/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author panda
 */

public class MissionBuilder {
    private Mission mission = new Mission();

    public MissionBuilder missionId(String id) {
        mission.setMissionId(id);
        return this;
    }
    public MissionBuilder date(String date) {
        mission.setDate(date);
        return this;
    }
    public MissionBuilder location(String location) {
        mission.setLocation(location);
        return this;
    }
    public MissionBuilder outcome(String outcome) {
        mission.setOutcome(outcome);
        return this;
    }
    public MissionBuilder damageCost(String damageCost) {
        if (damageCost != null && !damageCost.isBlank()) {
            mission.setDamageCost(damageCost);
        }
        return this;
    }
    public MissionBuilder curse(Curse curse) {
        mission.setCurse(curse);
        return this;
    }
    public MissionBuilder sorcerers(List<Sorcerer> sorcerers) {
        mission.setSorcerers(sorcerers);
        return this;
    }
    public MissionBuilder techniques(List<Technique> techniques) {
        mission.setTechniques(techniques);
        return this;
    }
    public MissionBuilder economicAssessment(EconomicAssessment ea) {
        mission.setEconomicAssessment(ea);
        return this;
    }
    public MissionBuilder civilianImpact(CivilianImpact ci) {
        mission.setCivilianImpact(ci);
        return this;
    }
    public MissionBuilder enemyActivity(EnemyActivity ea) {
        mission.setEnemyActivity(ea);
        return this;
    }
    public MissionBuilder environmentConditions(EnvironmentConditions ec) {
        mission.setEnvironmentConditions(ec);
        return this;
    }
    public MissionBuilder operationTimelines(List<OperationTimeline> timelines) {
        mission.setOperationTimelines(timelines);
        return this;
    }
    public MissionBuilder extraInfo(HashMap<String, ArrayList<String>> extras) {
        mission.setExtraInfo(extras);
        return this;
    }
    public MissionBuilder note(String note) {
        mission.setNote(note);
        return this;
    }
    public MissionBuilder comment(String comment) {
        mission.setComment(comment);
        return this;
    }

    public Mission build() {
        if (mission.getMissionId() == null || mission.getMissionId().isBlank())
            mission.setMissionId("Не указано");
        if (mission.getDate() == null || mission.getDate().isBlank())
            mission.setDate("Не указано");
        if (mission.getLocation() == null || mission.getLocation().isBlank())
            mission.setLocation("Не указано");
       
        if (mission.getCurse() == null) {
            Curse emptyCurse = new Curse();
            emptyCurse.setName("Не указано");
            mission.setCurse(emptyCurse);
        } else {
            if (mission.getCurse().getName() == null || mission.getCurse().getName().isBlank())
                mission.getCurse().setName("Не указано");
        }
        
        if (mission.getSorcerers() == null)
            mission.setSorcerers(new ArrayList<>());
        if (mission.getTechniques() == null)
            mission.setTechniques(new ArrayList<>());
        if (mission.getOperationTimelines() == null)
            mission.setOperationTimelines(new ArrayList<>());

        return mission;
    }
}