/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.EscalationRisk;
import com.mephi.missionsanalyzer.enums.Mobility;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author panda
 */
@Entity
public class EnemyActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String behaviorType;
    
    @ElementCollection
    private List<String> targetPriorities = new ArrayList<>();
    
    @ElementCollection
    private List<String> attackPatterns = new ArrayList<>();
    
    private String attackPattern;
    
    private String targetPriority;
    
    @Enumerated(EnumType.STRING)
    private Mobility mobility;
    
    @Enumerated(EnumType.STRING)
    private EscalationRisk escalationRisk;

    
    public Long getId() {
        return id;
    }
    
    public String getTargetPriority() {
        return targetPriority;
    }

    public void setTargetPriority(String targetPriority) {
        this.targetPriority = targetPriority;
    }

    public void addTargetPriority(String targetPriority) {
        targetPriorities.add(targetPriority);
    }
    
    public String getAttackPattern() {
        return attackPattern;
    }

    public void setAttackPattern(String attackPattern) {
        this.attackPattern = attackPattern;
    }
    
    public void addAttackPattern(String attackPattern) {
        attackPatterns.add(attackPattern);
    }

    public String getBehaviorType() {
        return behaviorType;
    }

    public void setBehaviorType(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    public List<String> getTargetPriorities() {
        return targetPriorities;
    }

    public void setTargetPriorities(ArrayList<String> targetPriorities) {
        this.targetPriorities = targetPriorities;
    }

    public List<String> getAttackPatterns() {
        return attackPatterns;
    }

    public void setAttackPatterns(ArrayList<String> attackPatterns) {
        this.attackPatterns = attackPatterns;
    }

    public Mobility getMobility() {
        return mobility;
    }

    public void setMobility(String mobility) {
        this.mobility = CheckForValue.parseEnum(Mobility.class, mobility);
    }

    public EscalationRisk getEscalationRisk() {
        return escalationRisk;
    }

    public void setEscalationRisk(String escalationRisk) {
        this.escalationRisk = CheckForValue.parseEnum(EscalationRisk.class, escalationRisk);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Активность противника: ");

        boolean hasData = false;

        if (behaviorType != null) {
            sb.append("тип поведения: ").append(behaviorType).append(", ");
            hasData = true;
        }

        if (targetPriority != null) {
            sb.append("приоритет целей: ").append(targetPriority).append(", ");
            hasData = true;
        }

        if (mobility != null) {
            sb.append("мобильность: ").append(mobility).append(", ");
            hasData = true;
        }

        if (escalationRisk != null) {
            sb.append("риск эскалации: ").append(escalationRisk).append(", ");
            hasData = true;
        }

        if (attackPatterns != null && !attackPatterns.isEmpty()) {
            sb.append("паттерны атак: ").append(attackPatterns);
            hasData = true;
        }

        return hasData ? sb.append("\n").toString() : "";
    }
    }
