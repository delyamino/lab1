/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mephi.missionsanalyzer.enums.Rank;

/**
 *
 * @author panda
 */
public class Sorcerer {
    @JsonProperty("n")
    @JsonAlias({"name"})
    private String name;
    private Rank rank;
    
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setRank(String rank) {
        this.rank=CheckForValue.parseEnum(Rank.class, rank);
    }
    
    public String getName() {
        return name;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    @Override
    public String toString() {
        return "Имя мага: " + CheckForValue.checkForNull(name) + ", ранг: " + CheckForValue.checkForNull(rank) + "\n";
    }
}
