/*
 * Click nbf://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.Outcome;
import java.util.ArrayList;
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
    
    private List<Sorcerer> sorcerer = new ArrayList<>();
    private List<Technique> technique = new ArrayList<>();
    private Curse curse;
    
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
    
    public void setSorcerers(List<Sorcerer> sourcerer) {
        this.sorcerer=sourcerer;
    }
    
    public void setTechniques(List<Technique> technique) {
        this.technique=technique;
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
        return sorcerer;
    }
    
    public List<Technique> getTechniques() {
        return technique;
    }
}
