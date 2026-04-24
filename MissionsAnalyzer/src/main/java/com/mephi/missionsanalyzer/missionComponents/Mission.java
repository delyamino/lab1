/*
 * Click nbf://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.Outcome;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author panda
 */
public class Mission {
    private String missionId;
    private String date;
    private String location;
    private Outcome outcome;
    private int damageCost;
    private String comment;
    private String note;
    
    private List<Sorcerer> sorcerers = new ArrayList<>();
    private List<Technique> techniques = new ArrayList<>();
    private Curse curse;
    private EconomicAssessment economicAssessment;
    private CivilianImpact civilianImpact;
    private EnemyActivity enemyActivity;
    private EnvironmentConditions environmentConditions;
    private List<OperationTimeline> operationTimelines = new ArrayList<>();
    private HashMap<String, ArrayList<String>> extraInfo;

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
        this.outcome=Outcome.valueOf(outcome);
    }
    
    public void setDamageCost(String damageCost) {
        this.damageCost = Integer.parseInt(damageCost);
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
    
    public HashMap<String, ArrayList<String>> getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(HashMap<String, ArrayList<String>> otherInfo) {
        this.extraInfo = otherInfo;
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
        if (extraInfo != null) {
            extraInfo.forEach((k, v) -> sb.append(k).append(": ").append(String.join(", ", v)).append("\n"));
        }
        return sb.toString();
    }
}
