/*
 * Click nbf://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.Outcome;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author panda
 */

@Entity
@Table(name = "missions")
public class Mission {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String missionId;
    private String date;
    private String location;
    private Outcome outcome;
    private int damageCost;
    private String comment;
    private String note;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sorcerer> sorcerers = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Technique> techniques = new ArrayList<>();
    
    @OneToOne(cascade = CascadeType.ALL)
    private Curse curse;
    
    @OneToOne(cascade = CascadeType.ALL)
    private EconomicAssessment economicAssessment;
    
    @OneToOne(cascade = CascadeType.ALL)
    private CivilianImpact civilianImpact;
    
    @OneToOne(cascade = CascadeType.ALL)
    private EnemyActivity enemyActivity;
    
    @OneToOne(cascade = CascadeType.ALL)
    private EnvironmentConditions environmentConditions;
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<OperationTimeline> operationTimelines = new ArrayList<>();
    
    @ElementCollection
    private List<String> operationTags = new ArrayList<>();

    @ElementCollection
    private List<String> supportUnits = new ArrayList<>();

    @ElementCollection
    private List<String> recommendations = new ArrayList<>();

    @ElementCollection
    private List<String> artifactsRecovered = new ArrayList<>();

    @ElementCollection
    private List<String> evacuationZones = new ArrayList<>();

    @ElementCollection
    private List<String> statusEffects = new ArrayList<>();

    
    public Long getId() {
        return id;
    }
    
    public EconomicAssessment getEconomicAssessment() {
        return economicAssessment;
    }

    public void setEconomicAssessment(EconomicAssessment economicAssessment) {
        this.economicAssessment = economicAssessment;
    }

    public CivilianImpact getCivilianImpact() {
        return civilianImpact;
    }

    public void setCivilianImpact(CivilianImpact civilianImpact) {
        this.civilianImpact = civilianImpact;
    }

    public EnemyActivity getEnemyActivity() {
        return enemyActivity;
    }

    public void setEnemyActivity(EnemyActivity enemyActivity) {
        this.enemyActivity = enemyActivity;
    }

    public EnvironmentConditions getEnvironmentConditions() {
        return environmentConditions;
    }

    public void setEnvironmentConditions(EnvironmentConditions environmentConditions) {
        this.environmentConditions = environmentConditions;
    }

    public List<OperationTimeline> getOperationTimelines() {
        return operationTimelines;
    }

    public void setOperationTimelines(List<OperationTimeline> operationTimelines) {
        this.operationTimelines = operationTimelines;
    }
    
    public void setMissionId(String missionId) {
        this.missionId=missionId;
    }
    
    public void setDate (String date) {
        this.date=date;
    }
    
    public void setLocation(String location) {
        this.location=location;
    }
    
    public void setOutcome(String outcome) {
         this.outcome = CheckForValue.parseEnum(Outcome.class, outcome);
    }
    
    public void setDamageCost(String damageCost) {
        this.damageCost = CheckForValue.parseInt("damageCost",damageCost);
    }
    
    public void setComment(String comment) {
        this.comment=comment;
    }
    
    public void setNote(String note) {
        this.note=note;
    }
    
    public void setCurse(Curse curse) {
        this.curse=curse;
    }
    
    public void setSorcerers(List<Sorcerer> sourcerers) {
        this.sorcerers=sourcerers;
    }
    
    public void setTechniques(List<Technique> techniques) {
        this.techniques=techniques;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public void setDamageCost(int damageCost) {
        this.damageCost = damageCost;
    }

    public void setOperationTags(List<String> operationTags) {
        this.operationTags = operationTags;
    }

    public void setSupportUnits(List<String> supportUnits) {
        this.supportUnits = supportUnits;
    }

    public void setRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
    }

    public void setArtifactsRecovered(List<String> artifactsRecovered) {
        this.artifactsRecovered = artifactsRecovered;
    }

    public void setEvacuationZones(List<String> evacuationZones) {
        this.evacuationZones = evacuationZones;
    }

    public void setStatusEffects(List<String> statusEffects) {
        this.statusEffects = statusEffects;
    }
    
    public void setExtraInfo(HashMap<String, ArrayList<String>> extraInfo) {
        if (extraInfo == null) {
            return;
        }
        else {
            extraInfo.forEach((key, values) -> {
                switch (key) {
                    case "Operation tags" -> this.operationTags = values;
                    case "Support units" -> this.supportUnits = values;
                    case "Recommendations" -> this.recommendations = values;
                    case "Artifacts recovered" -> this.artifactsRecovered = values;
                    case "Evacuation zones" -> this.evacuationZones = values;
                    case "Status effects" -> this.statusEffects = values;
                }
            });
        }
    }
    
    public String getMissionId() {
        return missionId;
    }
    
    public String getDate() {
        return date;
    }
    
    public String getLocation() {
        return location;
    }
    
    public Outcome getOutcome() {
        return outcome;
    }
    
    public int getDamageCost() {
        return damageCost;
    }
    
    public String getComment() {
        return comment;
    }
    
    public String getNote() {
        return note;
    }
    
    public Curse getCurse() {
        return curse;
    }
    
    public List<Sorcerer> getSorcerers() {
        return sorcerers;
    }
    
    public List<Technique> getTechniques() {
        return techniques;
    }

    public List<String> getOperationTags() {
        return operationTags;
    }

    public List<String> getSupportUnits() {
        return supportUnits;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public List<String> getArtifactsRecovered() {
        return artifactsRecovered;
    }

    public List<String> getEvacuationZones() {
        return evacuationZones;
    }

    public List<String> getStatusEffects() {
        return statusEffects;
    }
    
    public HashMap<String, ArrayList<String>> getExtraInfo() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        if (!operationTags.isEmpty()) {
            map.put("Operation tags", new ArrayList<>(operationTags));
        }
        if (!supportUnits.isEmpty()) {
            map.put("Support units", new ArrayList<>(supportUnits));
        }
        if (!recommendations.isEmpty()) {
            map.put("Recommendations", new ArrayList<>(recommendations));
        }
        if (!artifactsRecovered.isEmpty()) {
            map.put("Artifacts recovered", new ArrayList<>(artifactsRecovered));
        }
        if (!evacuationZones.isEmpty()) {
            map.put("Evacuation zones", new ArrayList<>(evacuationZones));
        }
        if (!statusEffects.isEmpty()) {
            map.put("Status effects", new ArrayList<>(statusEffects));
        }
        if (map.isEmpty()==true){
            return null;
        }
        else {
            return map;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(CheckForValue.checkForNull(missionId)).append("\n");
        sb.append("Дата: ").append(CheckForValue.checkForNull(date)).append("\n");
        sb.append("Локация: ").append(CheckForValue.checkForNull(location)).append("\n");
        sb.append("Исход: ").append(CheckForValue.checkForNull(outcome)).append("\n");
        if (damageCost != 0) {
            sb.append("Ущерб: ").append(damageCost).append(" ¥\n");
        }
        if (curse != null) {
            sb.append(curse);
        }
        if (sorcerers != null) {
            for (Sorcerer s : sorcerers) {
                sb.append(s);
            }
        }
        if (techniques != null) {
            for (Technique t : techniques) {
                sb.append(t);
            }
        }
        if (economicAssessment != null) {
            sb.append(economicAssessment);
        }
        if (civilianImpact != null) {
            sb.append(civilianImpact);
        }
        if (enemyActivity != null) {
            sb.append(enemyActivity);
        }
        if (environmentConditions != null) {
            sb.append(environmentConditions);
        }
        if (operationTimelines != null) {
            sb.append("Хронология:\n");
            for (OperationTimeline ot : operationTimelines) {
                sb.append(ot);
            }
        }
        if (note != null) {
            sb.append("Примечание: ").append(note).append("\n");
        }
        if (comment != null) {
            sb.append("Комментарий: ").append(comment).append("\n");
        }
        sb.append("Теги").append(operationTags);
        sb.append("Подразделения").append(supportUnits);
        sb.append("Рекомендации").append(recommendations);
        sb.append("Артефакты").append(artifactsRecovered);
        sb.append("Зоны эвакуации").append(evacuationZones);
        sb.append("Статус-эффекты").append(statusEffects);
        return sb.toString();
    }
}
