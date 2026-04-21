/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.EscalationRisk;
import com.mephi.missionsanalyzer.enums.Mobility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panda
 */
public class EnemyActivity {
    private String behaviorType;
    private List<String> targetPriority;
    private List<String> attackPatterns;
    private Mobility mobility;
    private EscalationRisk escalationRisk;
    
    

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public List<String> getTargetPriority() {
        return targetPriority;
    }

    public void setTargetPriority(List<String> targetPriority) {
        this.targetPriority = targetPriority;
    }

    public List<String> getAttackPatterns() {
        return attackPatterns;
    }

    public void setAttackPatterns(List<String> attackPatterns) {
        this.attackPatterns = attackPatterns;
    }

    public Mobility getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = Mobility.valueOf(mobility);
    }

    public EscalationRisk getEscalationRisk() {
        return escalationRisk;
    }

    public void setEscalationRisk(String escalationRisk) {
        this.escalationRisk = EscalationRisk.valueOf(escalationRisk);
    }
}
