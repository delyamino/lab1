/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mephi.missionsanalyzer.missionComponents;

import com.mephi.missionsanalyzer.enums.Rank;

/**
 *
 * @author panda
 */
public class Sourcerers {
    private String name;
    private Rank rank;
    
    public void setName(String name) {
        this.name=name;
    }
    
    public void setRank(String rank) {
        this.rank=Rank.valueOf(rank);
    }
    
    public String getName() {
        return name;
    }
    
    public Rank getRank() {
        return rank;
    }
}
